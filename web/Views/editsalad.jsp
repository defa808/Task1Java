<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alexg
  Date: 22.05.2018
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<td>
    <i class="fas fa-check icon" onclick="editSaladSubmit(${salad.getId()})"></i>
    <i class="fas fa-times icon" onclick="cancelEditSalad()"></i>
</td>
<td>
    <form action="/editSalad" method="post" id="editSaladForm${salad.getId()}">
        <input type="hidden" name="id" value="${salad.getId()}"/>
        <input type="text" name="title" value="${salad.getTitle()}"/>

    </form>

</td>
<td>
    ${salad.getIngredients().size()}
</td>
<td>
    ${salad.countAndGetTotalCalories()}
</td>
<td>
    ${salad.countAndGetTotalPrice()}
</td>
<script src="../Scripts/editSalad.js"></script>