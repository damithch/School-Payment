<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Login</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background: linear-gradient(135deg, #1a2b49, #356abc, #5c7fbc);
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            min-height: 100vh; /* Allows footer to stick to the bottom */
            color: #fff;
        }
        .header, .footer {
            background-color: rgba(26, 43, 73, 0.9);
            color: white;
            text-align: center;
            padding: 20px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.3);
        }
        .form-container {
            max-width: 400px;
            margin: 40px auto;
            padding: 20px;
            background-color: rgba(255, 255, 255, 0.1);
            border-radius: 12px;
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
            backdrop-filter: blur(6px);
            flex: 1; /* Allows the form container to grow */
        }
        input {
            width: calc(100% - 24px);
            padding: 12px;
            margin: 10px 0;
            border: 1px solid rgba(255, 255, 255, 0.3);
            border-radius: 4px;
            background-color: rgba(255, 255, 255, 0.1);
            color: #fff;
            font-size: 14px;
        }
        input[type="submit"] {
            background-color: #356abc;
            color: white;
            border: none;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s ease, box-shadow 0.3s ease;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }
        input[type="submit"]:hover {
            background-color: #2a4e7e;
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.3);
        }
    </style>
</head>
<body>
    <div class="header">
        <h1>Admin Login</h1>
    </div>
    
    <div class="form-container">
        <form action="adminLogin" method="post">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>

            <input type="submit" value="Login">
        </form>
    </div>

    <div class="footer" style="margin-top: auto;">
        <p>&copy; 2024 School Information Management System | All Rights Reserved</p>
    </div>
</body>
</html>
