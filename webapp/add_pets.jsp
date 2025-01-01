<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Pet</title>
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
    <h2>Add New Pet</h2>
    <form action="pets" method="post">
        <input type="hidden" name="action" value="add">

        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required>

        <label for="type">Type:</label>
        <input type="text" id="type" name="type" required>

        <label for="age">Age:</label>
        <input type="number" id="age" name="age" required>

        <label for="sex">Sex:</label>
        <select id="sex" name="sex" required>
            <option value="Male">Male</option>
            <option value="Female">Female</option>
        </select>

        <label for="health">Health Status:</label>
        <input type="text" id="health" name="health" required>

        <label for="status">Adoption Status:</label>
        <select id="status" name="status" required>
            <option value="Available">Available</option>
            <option value="Adopted">Adopted</option>
        </select>

        <input type="submit" value="Add Pet">
    </form>

    <p><a href="pets">Back to Pet List</a></p>
</body>
</html>