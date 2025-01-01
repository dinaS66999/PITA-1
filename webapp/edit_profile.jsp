<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="src.main.java.com.Model.Adopter" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Adopter Profile</title>
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
        input[type="email"],
        input[type="number"],
        input[type="submit"] {
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
    <h2>Edit Your Profile</h2>

    <form action="adopter" method="post">
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="id" value="${adopter.id}"> 

        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${adopter.name}" required>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="${adopter.email}" required>

        <label for="contact_info">Contact Info:</label>
        <input type="text" id="contact_info" name="contact_info" value="${adopter.contactInfo}" required>

        <label for="age">Age:</label>
        <input type="number" id="age" name="age" value="${adopter.age}" required>

        <input type="submit" value="Update Profile">
    </form>

    <p><a href="adopter_dashboard.jsp">Back to Dashboard</a></p>
</body>
</html>