<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alexg
  Date: 23.05.2018
  Time: 18:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form action="/createSalad" method="POST" id="createSaladForm}">
    <div class="form-group">
        <label for="title">Title:</label>
        <input type="text" name="title" class="form-control" id="title" placeholder="Input name of salad">
    </div>
    <div class="form-group">
        <label for="ingredients">Ingredients:</label>
        <select class="selectpicker" multiple id="ingredients" name="ingredients">
            <c:forEach var="s" items="${ingredients}">
                <option value="${s.getId()}">${s.getName()}</option>
            </c:forEach>
        </select>

        <button type="submit" class="btn btn-default">Create Salad</button>
    </div>




</form>

<script>
    $(document).ready(function(e) {
        $('.selectpicker').selectpicker({
            style: 'btn',
            size: 4
        });
        $('inpuut').selectpicker({
            size: 10
        });

    });
</script>