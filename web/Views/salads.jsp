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
        <div class="header"><i class="fas fa-plus"></i></div>
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


                    <tr id="th${s.getId()}">

                        <td>
                            <i class="fas fa-edit" onclick="editSalad(${s.getId()})"></i>
                            <i class="fas fa-trash-alt" onclick="removeId(${s.getId()}"></i>
                        </td>
                        <td onclick="loadIngredients(${s.getId()})">
                            <form id="saladForm${s.getId()}" action="/loadingredients" method="POST">
                                <input type="hidden" name="id" value="${s.getId()}"/>

                                    ${s.getTitle()}
                            </form>

                        </td>
                        <td>
                                ${s.getIngredients().size()}
                        </td>

                    </tr>


                    <br/>

                </c:forEach>
                </tbody>


            </table>
        </div>

    </div>

    <div class="col-sm-12 col-md-4 col-lg-4">
        <div class="header"><i class="fas fa-plus"></i>
        </div>
        <div class="table-responsive">
            <table class="table">
                <thead>
                <tr>
                    <th>Tools</th>
                    <th>Name Ingredient</th>
                    <th>Count Calories</th>
                </tr>
                </thead>
                <tbody id="ingredients">
                </tbody>
            </table>
        </div>

    </div>
</div>

<script>
    function loadIngredients(id) {
        $.ajax({
            type: 'POST',
            url: '/loadingredients',
            data: $("#saladForm" + id).serialize(),
            success: function (data, textstatus) {
                if (data !== '') {
                    $("#ingredients").html("").append(data);
                }

            }
        });
    }

    function editSalad(id) {
        $.ajax({
            type: 'GET',
            url: '/editSalad',
            data: $("#saladForm" + id).serialize(),
            success: function (data, textstatus) {
                if (data !== '') {
                    $("#th" + id).html("").append(data);
                }

            }
        });
    }



</script>

</body>
</html>
