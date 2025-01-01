<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="src.main.java.com.Model.Pet" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Pet</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        label {
            display: block;
            margin: 10px 0 5px;
        }
        input[type="text"],
        input[type="number"],
        input[type="submit"],
        select {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h2>Edit Pet Details</h2>

    <form action="pets" method="post">
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="id" value="${pet.id}"> 

        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${pet.name}" required>

        <label for="type">Type:</label>
        <input type="text" id="type" name="type" value="${pet.type}" required>

        <label for="age">Age:</label>
        <input type="number" id="age" name="age" value="${pet.age}" required>

        <label for="sex">Sex:</label>
        <select id="sex" name="sex" required>
            <option value="Male" <c:if test="${pet.sex == 'Male'}">selected</c:if>>Male</option>
            <option value="Female" <c:if test="${pet.sex == 'Female'}">selected</c:if>>Female</option>
        </select>

        <label for="health">Health Status:</label>
        <input type="text" id="health" name="health" value="${pet.health}" required>

        <label for="status">Adoption Status:</label>
        <select id="status" name="status" required>
            <option value="Available" <c:if test="${pet.status == 'Available'}">selected</c:if>>Available</option>
            <option value="Adopted" <c:if test="${pet.status == 'Adopted'}">selected</c:if>>Adopted</option>
        </select>

        <input type="submit" value="Update Pet">
    </form>

    <p><a href="pets">Back to Pet List</a></p>
</body>
</html>