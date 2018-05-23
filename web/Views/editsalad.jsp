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
    <i class="fas fa-check" onclick="editSaladSubmit(${salad.getId()})"></i>
    <i class="fas fa-times"></i>
</td>
<td>
    <form action="/editSalad" method="post" id="editSaladForm${salad.getId()}">
        <input type="hidden" name="id" value="${salad.getId()}"/>
        <input id="title${salad.getId()}" type="text" name="title" value="${salad.getTitle()}"/>

    </form>

</td>
<td>
    <span>${salad.getIngredients().size()}</span>
</td>
<script>
    function editSaladSubmit(id) {
        $.ajax({
            type: 'POST',
            url: '/editSalad',
            data: $("#editSaladForm" + id).serialize(),
            success: function (data) {
                    location.reload();
            }
        });
    }
</script>