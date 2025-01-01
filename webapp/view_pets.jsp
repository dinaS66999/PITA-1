<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Pets</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h2>Available Pets for Adoption</h2>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Type</th>
                <th>Age</th>
                <th>Sex</th>
                <th>Health</th>
                <th>Status</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="pet" items="${pets}">
                <tr>
                    <td>${pet.id}</td>
                    <td>${pet.name}</td>
                    <td>${pet.type}</td>
                    <td>${pet.age}</td>
                    <td>${pet.sex}</td>
                    <td>${pet.health}</td>
                    <td>${pet.status}</td>
                    <td>
                        <a href="adopt_pet.jsp?id=${pet.id}">Adopt</a>
                        <a href="edit_pet.jsp?id=${pet.id}">Edit</a>
                        <a href="delete_pet.jsp?id=${pet.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="pet_registration.jsp">Add New Pet</a></p>
    <p><a href="staff_dashboard.jsp">Back to Dashboard</a></p>
</body>
</html>