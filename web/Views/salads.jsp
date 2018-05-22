<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alexg
  Date: 22.05.2018
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FactorySalad</title>
    <link rel="stylesheet" href="../Contents/bootstrap.min.css">
    <link rel="stylesheet" href="../Contents/salad.css">
    <script src="../Scripts/jquery.js"></script>
    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/all.js"
            integrity="sha384-xymdQtn1n3lH2wcu0qhcdaOpQwyoarkgLVxC/wZ5q7h9gHtxICrpcaSUfygqZGOe"
            crossorigin="anonymous"></script>
</head>
<body style="padding: 100px;">
<h1>Generate your salad</h1>
<div class="row">
    <div class="col-sm-12 col-md-4 col-lg-4">
        <div><h2>Salads</h2></div>
    </div>
</div>
<div class="row">
    <div class="col-sm-12 col-md-4 col-lg-4">
        <div class="header"><i class="fas fa-plus"></i>
        </div>

        <div class="table-responsive">
            <table class="table">
                <thead>
                <tr>
                    <th>Tools</th>
                    <th>Name Salad</th>
                    <th>Count Ingredients</th>
                </tr>
                </thead>
                <tbody>

                <c:forEach var="s" items="${salads}">
                    <form id="ingredientForm${s.getId()}" action="/loadingredients" method="POST">

                        <tr>
                            <td>
                                <button><i class="fas fa-edit"></i></button>
                                <button name="btn" value="remove"><i class="fas fa-trash-alt"></i></button>
                            </td>
                            <td onclick="loadIngredients(${s.getId()})">
                                ${s.getTitle()}
                            </td>
                            <td>
                                ${s.getIngredients().size()}
                            </td>
                        </tr>


                        <input type="hidden" name="id" value="${s.getId()}">

                        <br/>
                    </form>

                </c:forEach>
                </tbody>


            </table>
        </div>

    </div>

    <div class="col-sm-12 col-md-4 col-lg-4">
        <div class="header"><i class="fas fa-plus"></i>
        </div>
        <div id="ingredients"></div>

    </div>
</div>

<script>
    function loadIngredients(id) {
        $.ajax({
            type: 'POST',
            url: '/loadingredients',
            data: $("#ingredientForm" + id).serialize(),
            success: function (data, textstatus) {
                if (data != '') {
                    $("#ingredients").html("");
                    $("#ingredients").append(data);
                }

            }
        });


    }
</script>

</body>
</html>