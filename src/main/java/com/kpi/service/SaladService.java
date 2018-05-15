package com.kpi.service;

import com.kpi.dao.SaladDAO;
import com.kpi.models.Salad;
import com.kpi.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class SaladService extends SessionUtil implements SaladDAO {
    @Override
    public void add(Salad salad) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.save(salad);

        //close session with a transaction
        closeTransactionSesstion();
    }

    @Override
    public List<Salad> getAll() throws SQLException {
        //open session with a transaction
        openTransactionSession();

        String sql = "SELECT * FROM salads";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Salad.class);
        List<Salad> saladList = query.list();

        //close session with a transaction
        closeTransactionSesstion();

        return saladList;
    }

    @Override
    public Salad getById(Long id) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        String sql = "SELECT * FROM salads WHERE id = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Salad.class);
        query.setParameter("id", id);

        Salad salad = (Salad) query.getSingleResult();

        //close session with a transaction
        closeTransactionSesstion();

        return salad;
    }

    @Override
    public void update(Salad salad) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.update(salad);

        //close session with a transaction
        closeTransactionSesstion();
    }

    @Override
    public void remove(Salad salad) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.remove(salad);

        //close session with a transaction
        closeTransactionSesstion();
    }
}
