<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Staff Registration</title>
</head>
<body>
    <h2>Staff Registration</h2>
    <form action="staff" method="post">
        <input type="hidden" name="action" value="register">
        
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required>
        <br>
        
        <label for="age">Age:</label>
        <input type="number" id="age" name="age" required>
        <br>
        
        <label for="gender">Gender:</label>
        <select id="gender" name="gender" required>
            <option value="Male">Male</option>
            <option value="Female">Female</option>
            <option value="Other">Other</option>
        </select>
        <br>
        
        <label for="address">Address:</label>
        <input type="text" id="address" name="address" required>
        <br>
        
        <label for="phone_number">Phone Number:</label>
        <input type="text" id="phone_number" name="phone_number" required>
        <br>
        
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>
        <br>
        
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>
        <br>
        
        <button type="submit">Register</button>
    </form>
    
    <p>Already have an account? <a href="staff_login.jsp">Login here</a>.</p>
</body>
</html>