<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>ADD NEW BOOK</title>
</head>
<body>
<h1>ADD NEW BOOK</h1>
<br/>


<form action="/update" method="post" enctype="multipart/form-data">



    <input  value="${book.getId()}" type="hidden" name="id">

    <label for="title">Title:</label>

    <input id="title"  value="${book.getTitle()}" type="text" name="title">

    <br>
    <label for="description">Description:</label>

    <textarea  id="description"  name="description">${book.getDescription()}</textarea>

    <br>
    <label for="authorsIds">Title:</label>
    <select id="authorsIds" multiple name="authorsIds">
        <option value="0">Select authors:</option>
        <c:forEach items="${authors}" var="author">
            <option value="${author.getId()}">${author.getFullName()}</option>
        </c:forEach>
    </select>

    <br>
    <label for="categoryId">Select category:</label>

    <select id="categoryId" name="categoryId "  required>
        <option disabled value="0">Select category:</option>
        <c:forEach items="${categoryList}" var="category">
            <option value="${category.getId()}">${category.getName()}</option>
        </c:forEach>
    </select>

    <br>
    <label for="isbn">Isbn:</label>

    <input id="isbn" value="${book.getIsbn()}" type="text" name="isbn">

    <br>
    <label for="year">Year:</label>

    <input id="year" value="${book.getYear()}" type="number" name="year">

    <br>

    <label for="quantity">Quantity:</label>

    <input id="quantity" value="${book.getQuantity()}" type="number" name="quantity">

    <br>


    <label for="image">Upload cover image:</label>

    <input  id="image"  value="null" type="file" name="image">

    <input  value="${book.getImgUrl()}"  type="text"  name="url">

    <br>

    <input type="submit" value="Saqlash">

</form>
</body>
</html>