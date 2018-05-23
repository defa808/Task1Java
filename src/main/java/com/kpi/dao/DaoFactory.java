package com.kpi.dao;

import com.kpi.service.IngredientService;
import com.kpi.service.SaladService;
import com.kpi.service.TypeIngredientService;

public class DaoFactory implements IDaoFactory {

    @Override
    public IngredientDAO getIngredientDAO() {
        return new IngredientService();
    }

    @Override
    public SaladDAO getSaladDAO() {
        return new SaladService();
    }

    @Override
    public TypeIngredientDAO getTypeIngredientDAO() {
        return new TypeIngredientService();
    }
}
