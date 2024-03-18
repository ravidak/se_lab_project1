<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Uploaded Files</title>
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" crossorigin="anonymous">
    <link rel="stylesheet" href="css/index-styles.css">
</head>
<body id="page-top">
    <!-- Navigation-->
    <nav class="navbar navbar-expand-lg bg-secondary text-uppercase fixed-top" id="mainNav">
        <div class="container">
            <div style="text-align: right; margin-top: 10px; margin-right: 10px;">
                <a href="index.jsp" class="btn btn-primary">BACK TO DASHBOARD</a>
            </div>
            <a class="navbar-brand" href="#page-top">u Section</a>
        </div>
    </nav>

    <!-- Masthead-->
    <header class="masthead bg-primary text-white text-center">
        <div class="container d-flex align-items-center flex-column">
            <h1 class="masthead-heading text-uppercase mb-0">Uploaded Files</h1>
        </div>
    </header>

    <!-- Uploaded Files Section -->
    <section class="page-section bg-light text-black" id="uploaded-files">
        <div class="container">
            <h2>Uploaded Files</h2>
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">Paper Title</th>
                        <th scope="col">Download</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="file" items="${fileList}">
                        <tr>
                            <td>${file.paperTitle}</td>
                            <td><a href="download?fileName=${file.fileName}" class="btn btn-primary">Download</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </section>

    <!-- JavaScript for Bootstrap and other functionalities -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
    <script src="js/index-scripts.js"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</body>
</html>
