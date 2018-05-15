package com.kpi.dao;

import com.kpi.models.Salad;

import java.sql.SQLException;
import java.util.List;

public interface SaladDAO {

    //create
    void add(Salad salad) throws SQLException;

    //read
    List<Salad> getAll() throws SQLException;

    Salad getById(Long id) throws SQLException;

    //update
    void update(Salad salad) throws SQLException;

    //delete
    void remove(Salad salad) throws SQLException;

}
