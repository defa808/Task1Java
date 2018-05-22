package com.kpi.controllers;

import com.kpi.models.Ingredient;
import com.kpi.models.Salad;
import com.kpi.models.TypeIngredient;
import com.kpi.service.IngredientService;
import com.kpi.service.SaladService;
import com.kpi.service.TypeIngredientService;
import com.kpi.util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@WebServlet(name = "TakeSalads", urlPatterns = "/salads")
public class TakeSalads extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

//        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

//    private Question TakeQuestion() {
//
//        try {
//            return DAO.getQuestion(1);
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return new Question(0,"null",0,0,0.0);
//    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
        SaladService saladService = new SaladService();
        IngredientService ingredientService = new IngredientService();
        TypeIngredientService typeIngredientService = new TypeIngredientService();


        try {
            List<Salad> salads = saladService.getAll();
            for (Salad s : salads
                    ) {
                System.out.println(s);
            }

//            List<TypeIngredient> typeIngredients = typeIngredientService.getAll();
//
//            for (TypeIngredient s : typeIngredients
//                    ) {
//                System.out.println(s);
//            }

            List<Ingredient> ingredients = ingredientService.getAll();

            for (Ingredient s : ingredients
                    ) {
                System.out.println(s);
            }
            request.setAttribute("salads", salads);
            request.setAttribute("ingredients", ingredients);
        } catch (SQLException e) {
            e.printStackTrace();
        }

//        HibernateUtil.shutdown();

        request.getRequestDispatcher("Views/salads.jsp").forward(request, response);

//        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
