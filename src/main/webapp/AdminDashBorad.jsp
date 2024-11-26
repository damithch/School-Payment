<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background: linear-gradient(135deg, #6a11cb 0%, #2575fc 100%);
            color: white;
        }
        .card {
            background-color: rgba(255, 255, 255, 0.1);
            border: none;
        }
        .card-title {
            font-size: 1.5rem;
        }
        .card-text {
            font-size: 1rem;
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center mb-4">Admin Dashboard</h1>
        <div class="row">
            <!-- Payment Dashboard Tile -->
            <div class="col-md-4 mb-4">
                <div class="card">
                    <div class="card-body text-center">
                        <h5 class="card-title">Payment Dashboard</h5>
                        <p class="card-text">View and manage all payment information.</p>
                        <a href="PaymentDashBoard.jsp" class="btn btn-primary">Go to Payment Dashboard</a>
                    </div>
                </div>
            </div>
            <!-- Student Details Tile -->
            <div class="col-md-4 mb-4">
                <div class="card">
                    <div class="card-body text-center">
                        <h5 class="card-title">Student Details</h5>
                        <p class="card-text">Manage student information and records.</p>
                        <a href="studentDetails.jsp" class="btn btn-primary">Go to Student Details</a>
                    </div>
                </div>
            </div>
            <!-- Employee Dashboard Tile -->
            <div class="col-md-4 mb-4">
                <div class="card">
                    <div class="card-body text-center">
                        <h5 class="card-title">Employee Dashboard</h5>
                        <p class="card-text">Access and manage employee records.</p>
                        <a href="employeeDashboard.jsp" class="btn btn-primary">Go to Employee Dashboard</a>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
