<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="src.main.java.com.Model.Adopter" %>
<%@ page import="src.main.java.com.Model.Pet" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Adopter Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        h2 {
            color: #4CAF50;
        }
        .pet-list {
            margin-top: 20px;
        }
        .pet-card {
            border: 1px solid #ccc;
            border-radius: 4px;
            padding: 10px;
            margin-bottom: 10px;
        }
        .pet-card h3 {
            margin: 0;
        }
        .pet-card p {
            margin: 5px 0;
        }
        .logout {
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <h2>Welcome, ${adopter.name}!</h2>

    <h3>Your Profile</h3>
    <p><strong>Email:</strong> ${adopter.email}</p>
    <p><strong>Contact Info:</strong> ${adopter.contactInfo}</p>
    <p><strong>Age:</strong> ${adopter.age}</p>

    <h3>Available Pets</h3>
    <div class="pet-list">
        <c:forEach var="pet" items="${availablePets}">
            <div class="pet-card">
                <h3>${pet.name}</h3>
                <p><strong>Type:</strong> ${pet.type}</p>
                <p><strong>Age:</strong> ${pet.age} years</p>
                <p><strong>Health:</strong> ${pet.health}</p>
                <p><strong>Status:</strong> ${pet.status}</p>
                <form action="pets" method="post">
                    <input type="hidden" name="action" value="view">
                    <input type="hidden" name="id" value="${pet.id}">
                    <input type="submit" value="View Details">
                </form>
            </div>
        </c:forEach>
    </div>

    <div class="logout">
        <form action="adopter" method="post">
            <input type="hidden" name="action" value="logout">
            <input type="submit" value="Logout">
        </form>
    </div>
</body>
</html>