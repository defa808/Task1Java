package com.kpi.service;

import com.kpi.dao.TypeIngredientDAO;
import com.kpi.models.TypeIngredient;
import com.kpi.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class TypeIngredientService extends SessionUtil implements TypeIngredientDAO {
    @Override
    public void add(TypeIngredient typeIngredient) throws SQLException {
//open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.save(typeIngredient);

        //close session with a transaction
        closeTransactionSesstion();
    }

    @Override
    public List<TypeIngredient> getAll() throws SQLException {
        //open session with a transaction
        openTransactionSession();

        String sql = "SELECT * FROM typeingredients";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(TypeIngredient.class);
        List<TypeIngredient> typeIngredientsList = query.list();

        //close session with a transaction
        closeTransactionSesstion();

        return typeIngredientsList;
    }

    @Override
    public TypeIngredient getById(Long id) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        String sql = "SELECT * FROM typeingredients WHERE ID = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(TypeIngredient.class);
        query.setParameter("id", id);

        TypeIngredient typeIngredient = (TypeIngredient) query.getSingleResult();

        //close session with a transaction
        closeTransactionSesstion();

        return typeIngredient;
    }

    @Override
    public void update(TypeIngredient typeIngredient) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.update(typeIngredient);

        //close session with a transaction
        closeTransactionSesstion();
    }

    @Override
    public void remove(TypeIngredient typeIngredient) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.remove(typeIngredient);

        //close session with a transaction
        closeTransactionSesstion();
    }
}
