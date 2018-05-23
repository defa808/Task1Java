<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alexg
  Date: 22.05.2018
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script src="../Scripts/dataTables.js"></script>
<div class="form-group">
    <label for="min">Min calories:</label>
    <input type="text" id="min" name="min"/>
    <label for="max">Max calories:</label>
    <input type="text" id="max" name="max"/>
</div>
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

<script>
    /* Custom filtering function which will search data in column four between two values */
    $.fn.dataTable.ext.search.push(
        function (settings, data, dataIndex) {
            console.log(data);
            var min = parseInt($('#min').val(), 10);
            var max = parseInt($('#max').val(), 10);
            var age = parseFloat(data[2]) || 0; // use data for the age column

            if ((isNaN(min) && isNaN(max)) ||
                (isNaN(min) && age <= max) ||
                (min <= age && isNaN(max)) ||
                (min <= age && age <= max)) {
                return true;
            }
            return false;
        }
    );

    $(document).ready(function () {
        var table = $('#tableIngredient').DataTable();

        // Event listener to the two range filtering inputs to redraw on input
        $('#min, #max').keyup(function () {
            table.draw();
        });
    });
</script>