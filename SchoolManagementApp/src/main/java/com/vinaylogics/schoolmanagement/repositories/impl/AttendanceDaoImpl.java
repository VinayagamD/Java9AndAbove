package com.vinaylogics.schoolmanagement.repositories.impl;

import com.vinaylogics.schoolmanagement.models.Attendance;
import com.vinaylogics.schoolmanagement.repositories.AttendanceDao;
import com.vinaylogics.schoolmanagement.repositories.db.DatabaseManager;
import com.vinaylogics.schoolmanagement.utils.QueryConstants;

import java.io.Serializable;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * (non-javadoc)
 * This class implementation of
 * @see com.vinaylogics.schoolmanagement.repositories.AttendanceDao
 */
public class AttendanceDaoImpl implements AttendanceDao{

    // Database Connection Object
    private static final Connection con = DatabaseManager.getCon();


    /**
     * (non-javadoc)
     * @see  AttendanceDao#findAll()
     */
    @Override
    public List<Attendance> findAll() throws SQLException {
        return null;
    }

    /**
     * (non-javadoc)
     * @see  AttendanceDao#findById(Number)
     */
    @Override
    public Optional<Attendance> findById(Long id) throws SQLException {
        return Optional.empty();
    }

    /**
     * (non-javadoc)
     * @see  AttendanceDao#save(Serializable)
     */
    @Override
    public Attendance save(Attendance attendance) throws SQLException {
        PreparedStatement ps = con.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
        ps.setTimestamp(1, Timestamp.valueOf(LocalDateTime.now()));
        ps.setString(2, attendance.getTeacher());
        ps.setString(3,attendance.getStudent());
        ps.setBoolean(4, attendance.isPresent());
        ps.setString(5, attendance.getSubject());
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        if(rs.next()){
            attendance.setId(rs.getLong(1));
        }
        return attendance;
    }

    /**
     * (non-javadoc)
     * @see  AttendanceDao#update(Serializable)
     */
    @Override
    public Attendance update(Attendance attendance) throws SQLException {
        return null;
    }

    /**
     * (non-javadoc)
     * @see  AttendanceDao#deleteById(Number)
     */
    @Override
    public void deleteById(Long aLong) throws SQLException {

    }


    /**
     * (non-javadoc)
     * @see  AttendanceDao#delete(Serializable)
     */
    @Override
    public void delete(Attendance attendance) throws SQLException {

    }
}
