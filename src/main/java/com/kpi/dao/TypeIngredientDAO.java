package com.kpi.dao;

import com.kpi.models.TypeIngredient;

import java.sql.SQLException;
import java.util.List;

public interface TypeIngredientDAO {
    //create
    void add(TypeIngredient typeIngredient) throws SQLException;

    //read
    List<TypeIngredient> getAll() throws SQLException;

    TypeIngredient getById(Long id) throws SQLException;

    //update
    void update(TypeIngredient typeIngredient) throws SQLException;

    //delete
    void remove(TypeIngredient typeIngredient) throws SQLException;
}
