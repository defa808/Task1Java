package com.kpi.controllers;

import com.kpi.models.Ingredient;
import com.kpi.models.Salad;
import com.kpi.service.IngredientService;
import com.kpi.service.SaladService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

@WebServlet(name = "CreateSalad", urlPatterns = "/createSalad")
public class CreateSalad extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        SaladService saladService = new SaladService();
        IngredientService ingredientService = new IngredientService();

        String newTitle = request.getParameter("title");

        List<Long> idList = Arrays.asList(request.getParameterValues("ingredients")).stream().map(Long::parseLong).collect(Collectors.toList());

        Salad salad = new Salad();
        salad.setTitle(newTitle);


        try {

            for (Long currentId : idList
                    ) {
                Ingredient ingredient = ingredientService.getById(currentId);
                ingredient.addSalad(salad);
                ingredientService.update(ingredient);
                salad.addIngredient(ingredient);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>Success</h1>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        IngredientService ingredientService = new IngredientService();

        try {
            List<Ingredient> ingredientList = ingredientService.getAll();
            request.setAttribute("ingredients", ingredientList);

            request.getRequestDispatcher("Views/createsalad.jsp").forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
