package com.kpi.controllers;

import com.kpi.dao.DaoFactory;
import com.kpi.dao.SaladDAO;
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
import java.util.stream.Collectors;

@WebServlet(name = "EditSalad", urlPatterns = "/editSalad")
public class EditSalad extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoFactory daoFactory= new DaoFactory();
        SaladDAO saladService = daoFactory.getSaladDAO();

        Long saladId = Long.parseLong(request.getParameter("id"));
        String newTitle = request.getParameter("title");

        if(newTitle.isEmpty())
            request.getRequestDispatcher("/salads").forward(request,response);

        try {
            Salad s = saladService.getById(saladId);

            if(s!=null){
                s.setTitle(newTitle);
            }

            saladService.update(s);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DaoFactory daoFactory = new DaoFactory();
        SaladDAO saladService = daoFactory.getSaladDAO();

        Long saladId = Long.parseLong(request.getParameter("id"));

        try {
            Salad s = saladService.getById(saladId);
            if (s != null) {
                request.setAttribute("salad", s);
                request.getRequestDispatcher("Views/editsalad.jsp").forward(request, response);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

    }
}
