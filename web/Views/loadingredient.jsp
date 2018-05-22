<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alexg
  Date: 22.05.2018
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<c:forEach var="ingr" items="${currentIngredients}">
    <tr>
        <td>
            <i class="fas fa-edit"></i>
            <i class="fas fa-trash-alt"></i>
        </td>
        <td>
            <span>${ingr.getName()}</span>
        </td>
        <td>
            <span>${ingr.getNumberCalories()}</span>
        </td>
    </tr>
</c:forEach>
