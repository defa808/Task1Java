package com.kpi.controllers;

import com.kpi.models.Ingredient;
import com.kpi.models.Salad;
import com.kpi.service.SaladService;
import com.kpi.util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LoadIngredient", urlPatterns = "/loadingredients")
public class LoadIngredient extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long saladId = Long.parseLong(request.getParameter("id"));

        SaladService saladService = new SaladService();
        try {
            Salad s = saladService.getById(saladId);
            System.out.println(s);
            if (s != null) {

                for (Ingredient ing : s.getIngredients()
                        ) {
                    System.out.println(ing);

                }
                request.setAttribute("currentIngredients", s.getIngredients());
                request.getRequestDispatcher("Views/loadingredient.jsp").forward(request, response);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
