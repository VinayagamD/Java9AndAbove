package com.vinaylogics.springboot.springmvccore.repositories.impl;

import com.vinaylogics.springboot.springmvccore.exceptions.NotFoundException;
import com.vinaylogics.springboot.springmvccore.models.Message;
import com.vinaylogics.springboot.springmvccore.repositories.MessageRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class MessageRepositoryImpl implements MessageRepository {

    private final JdbcTemplate template;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public MessageRepositoryImpl(JdbcTemplate template, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.template = template;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<Message> findAll() {
        return null;
    }

    @Override
    public Optional<Message> findById(Long id) {
        try {
           /* return template.queryForObject(Q_FIND_BY_ID, (rs,row) ->{
                Optional<Message> message = Optional.of(new Message());
                message.get().setId(rs.getLong(COL_ID));
                message.get().setName(rs.getString(COL_NAME));
                message.get().setMessage(rs.getString(COL_MESSAGE));
                message.get().setMessageTime(rs.getTimestamp(COL_MESSAGE_TIME).toLocalDateTime());
                return message;
            }, id);*/
            MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource();
            sqlParameterSource.addValue("id",id);
            return namedParameterJdbcTemplate.queryForObject(QN_FIND_BY_ID,
                    sqlParameterSource,
                    (rs,row) ->{
                        Optional<Message> message = Optional.of(new Message());
                        message.get().setId(rs.getLong(COL_ID));
                        message.get().setName(rs.getString(COL_NAME));
                        message.get().setMessage(rs.getString(COL_MESSAGE));
                        message.get().setMessageTime(rs.getTimestamp(COL_MESSAGE_TIME).toLocalDateTime());
                        return message;
                    });
        } catch (DataAccessException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Transactional
    @Override
    public Message save(Message message) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource();
        sqlParameterSource.addValue("name",message.getName());
        sqlParameterSource.addValue("message",message.getMessage());
        namedParameterJdbcTemplate.update(QN_SAVE, sqlParameterSource,keyHolder);
        /*template.update(con -> {
            PreparedStatement ps = con.prepareStatement(Q_SAVE, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, message.getName());
            ps.setString(2, message.getMessage());
            return ps;

        },keyHolder);*/

        return findById(Objects.requireNonNull(keyHolder.getKeyAs(BigInteger.class)).longValue()).orElseThrow(()-> new NotFoundException("Unable to save message"));
    }

    @Override
    public Message update(Long id, Message message) {
        return null;
    }

    @Override
    public void delete(Message message) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
