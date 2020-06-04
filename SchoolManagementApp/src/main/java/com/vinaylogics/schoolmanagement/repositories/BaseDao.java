package com.vinaylogics.schoolmanagement.repositories;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * BaseDAO is Data Access Object  generic implementation interaction DB
 * @param <T> is the Data Model
 * @param <ID> is primary key for the table
 */
public interface BaseDao<T extends Serializable, ID extends Number> {

    /**
     * This method helps to get all the list
     * @return List of T object
     * @throws SQLException on any exception occurred
     */
    List<T> findAll() throws SQLException;

    /**
     * This method finds the unique object with the ID
     * @param id - unique primary key for the table
     * @return Optional T model found by the id
     * @throws SQLException on any exception occurred
     */
    Optional<T> findById(ID id) throws SQLException;

    /**
     * This method save T model to the table
     * @param t model to be inserted to the table
     * @return Saved model along with primary key
     * @throws SQLException on any exception occurred
     */
    T save(T t) throws SQLException;

    /**
     * This method update T model to the table
     * @param t model to be updated to the table
     * @return Updated model from the table
     * @throws SQLException on any exception occurred
     */
    T update(T t) throws SQLException;

    /**
     * This method deleted records based on the primary key
     * @param id - primary key to delete the record
     * @throws SQLException on any exception occurred
     */
    void deleteById(ID id) throws SQLException;

    /**
     * This method deleted records based on the model
     * @param t - delete record based on item
     * @throws SQLException on any exception occurred
     */
    void delete(T t) throws SQLException;
}
