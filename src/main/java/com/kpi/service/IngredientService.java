package com.kpi.service;

import com.kpi.dao.IngredientDAO;
import com.kpi.dao.SaladDAO;
import com.kpi.models.Ingredient;
import com.kpi.models.Salad;
import com.kpi.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class IngredientService extends SessionUtil implements IngredientDAO {

    @Override
    public void add(Ingredient ingredient) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.save(ingredient);

        //close session with a transaction
        closeTransactionSesstion();
    }

    @Override
    public List<Ingredient> getAll() throws SQLException {
        //open session with a transaction
        openTransactionSession();

        String sql = "SELECT * FROM ingredients";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Ingredient.class);
        List<Ingredient> ingredientList = query.list();

        //close session with a transaction
        closeTransactionSesstion();

        return ingredientList;
    }

    @Override
    public Ingredient getById(Long id) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        String sql = "SELECT * FROM ingredients WHERE Id = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Ingredient.class);
        query.setParameter("id", id);

        Ingredient ingredient = (Ingredient) query.getSingleResult();

        //close session with a transaction
        closeTransactionSesstion();

        return ingredient;
    }

    @Override
    public void update(Ingredient ingredient) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.update(ingredient);

        //close session with a transaction
        closeTransactionSesstion();
    }

    @Override
    public void remove(Ingredient ingredient) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.remove(ingredient);

        //close session with a transaction
        closeTransactionSesstion();
    }
}
