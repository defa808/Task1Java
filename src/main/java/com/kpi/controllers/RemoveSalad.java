package com.kpi.controllers;

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

        SaladService saladService = new SaladService();
        Long saladId = Long.parseLong(request.getParameter("id"));
        try {
            Salad s = saladService.getById(saladId);

            saladService.remove(s);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
