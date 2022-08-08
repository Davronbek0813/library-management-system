<%--
  Created by IntelliJ IDEA.
  User: abror
  Date: 01/08/22
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>BOOK PAGE</title>
    <!--    <link rel="stylesheet" href="styles.css">-->
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>

<body>



<!--NAVIGATION BAR | SAYTNI MENYU QISMI-->
<nav class="navbar navbar-dark bg-dark">

    <div class="logo">
        <h1 class="text-white">MY LIBRARY</h1>
    </div>
    <div class="menu">
        <ul class="d-flex">
            <li class="mx-3"><a href="/add-book">Add </a></li>
            <li class="mx-3"><a href="/update">Update</a></li>
            <li class="mx-3"><a href="/delete">Delete</a></li>
        </ul>
    </div>
    <div class="profile-image">
        <img src="images/img.png" width="60px" height="60px" alt="">
    </div>
</nav>

<!--SAYTNI MENYUDAN PASTKI QISMI KONTENTLAR-->
<section class="container mt-4 ">

    <div class="row justify-content-around">

        <c:forEach items="${bookList}" var="book">
            <div class="card my-4 text-center shadow col-md-3" style="width: 18rem;">
                <img src="${book.getImgUrl()}" class="card-img-top" alt="${book.getTitle()}">
                <div class="card-body">
                    <h5 class="card-title">${book.getTitle()}</h5>
                    <a href="/authors?id=${book.getAuthor().getId()}">
                        <h6 class="card-title">${book.getAuthor().getFullName()}</h6>
                    </a>
                    <p class="card-text">${book.getCategory().getName()}</p>

                </div>
            </div>
        </c:forEach>

    </div>


</section>

<!--SAYTNI PASTKI QISMI | SAYT HAQIDA YOKI KOMPANIYA HAQIDA MA'LUMOTLAR -->
<footer>

</footer>


</body>
</html>
