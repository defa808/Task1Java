package com.kpi.dao;

import com.kpi.models.Ingredient;
import java.sql.SQLException;
import java.util.List;

public interface IngredientDAO {

    //create
    void add(Ingredient ingredient) throws SQLException;

    //read
    List<Ingredient> getAll() throws SQLException;

    Ingredient getById(Long id) throws SQLException;

    //update
    void update(Ingredient ingredient) throws SQLException;

    //delete
    void remove(Ingredient ingredient) throws SQLException;

}
