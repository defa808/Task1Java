package com.kpi.controllers;

import com.kpi.dao.DaoFactory;
import com.kpi.dao.SaladDAO;
import com.kpi.models.Salad;
import com.kpi.service.SaladService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "RemoveSalad", urlPatterns = "/removeSalad")
public class RemoveSalad extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoFactory daoFactory = new DaoFactory();
        SaladDAO saladService = daoFactory.getSaladDAO();

        Long saladId = Long.parseLong(request.getParameter("id"));
        try {
            Salad s = saladService.getById(saladId);
            if (s != null)
                saladService.remove(s);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
