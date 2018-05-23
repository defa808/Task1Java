package com.kpi.dao;


interface IDaoFactory {
    IngredientDAO getIngredientDAO();
    SaladDAO getSaladDAO();
    TypeIngredientDAO getTypeIngredientDAO();
}
