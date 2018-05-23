<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alexg
  Date: 22.05.2018
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<table class="table" id="tableIngredient">
    <thead>
    <tr>
        <th onclick="sortTable(0, 'tableIngredient')">Name Ingredient</th>
        <th onclick="sortTable(1, 'tableIngredient')">Type Ingredient</th>
        <th onclick="sortTable(2, 'tableIngredient')">Count Calories</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="ingr" items="${currentIngredients}">
        <tr>
            <td>
                <span>${ingr.getName()}</span>
            </td>
            <td>
                <span>${ingr.getTypeIngredient()}</span>
            </td>
            <td>
                <span>${ingr.getNumberCalories()}</span>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

