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
            <a class="navbar-brand" href="#page-top">paper submission Section</a>
        </div>
    </nav>

    <!-- Masthead-->
    <header class="masthead bg-primary text-white text-center">
        <div class="container d-flex align-items-center flex-column">
            <h1 class="masthead-heading text-uppercase mb-0"></h1>
        </div>
    </header>



    <!-- Upload Document and View Status Buttons -->
    <div class="d-flex justify-content-between">
        <button class="btn btn-primary btn-xl mr-2" id="uploadDocumentBtn">Upload Document</button>
        <button class="btn btn-secondary btn-xl" id="viewStatusBtn">Status of Uploaded Document</button>
    </div>

    


 <!-- Paper Submission Section (Initially Hidden) -->
<section class="page-section bg-light text-black d-none" id="paper-submission">
    <div class="container">
        <div class="row">
            <div class="col-lg-8 mx-auto">
                <div class="card">
                    <div class="card-body">
                        <h2 class="card-title text-center mb-4">Paper Submission</h2>
                        <form id="fileUploadForm" method="post" enctype="multipart/form-data" action="uploadServlet">
                            <div class="form-group">
                                <label for="authorName">Author Name</label>
                                <input type="text" class="form-control" id="authorName" name="authorName" placeholder="Enter your name" required>
                            </div>
                            <div class="form-group">
                                <label for="email">Email ID</label>
                                <input type="email" class="form-control" id="email" name="email" placeholder="Enter your email" required>
                            </div>
                            <div class="form-group">
                                <label for="contact">Contact Number</label>
                                <input type="text" class="form-control" id="contact" name="contact" placeholder="Enter your contact number" required>
                            </div>
                            <div class="form-group">
                                <label for="postalAddress">Postal Address</label>
                                <textarea class="form-control" id="postalAddress" name="postalAddress" rows="3" placeholder="Enter your postal address" required></textarea>
                            </div>
                            <div class="form-group">
                                <label for="paperTitle">Paper Title</label>
                                <input type="text" class="form-control" id="paperTitle" name="paperTitle" placeholder="Enter paper title" required>
                            </div>
                            <div class="form-group">
                                <label for="abstract">Abstract</label>
                                <textarea class="form-control" id="abstract" name="abstract" rows="5" placeholder="Enter abstract" required></textarea>
                            </div>
                            
                             <div class="form-group">
                                <label for="keywords">Keywords</label>
                                <input type="text" class="form-control" id="keywords" name="keywords" placeholder="Enter keywords" required>
                            </div>
                            
                            
                            <div class="form-group">
                                <label for="file">Choose File</label>
                                <input type="file" class="form-control-file" id="file" name="file" required>
                            </div>
                            <div class="text-center">
                                <button type="submit" class="btn btn-primary btn-xl" id="upload">Upload Document</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>




    <!-- JavaScript for Bootstrap and other functionalities -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
    <script src="js/index-scripts.js"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <script>
        document.getElementById('uploadDocumentBtn').addEventListener('click', function() {
            document.getElementById('paper-submission').classList.toggle('d-none');
            // Hide document status section if visible
            document.getElementById('document-status').classList.add('d-none');
        });

        document.getElementById('fileUploadForm').addEventListener('submit', function(event) {
            event.preventDefault(); // Prevent form submission

            // Get form data
            let form = document.getElementById('fileUploadForm');
            let formData = new FormData(form);

            // Perform AJAX request to the servlet
            fetch(form.getAttribute('action'), {
                method: 'POST',
                body: formData
            })
            .then(response => {
                if (response.ok) {
                    return response.text();
                }
                throw new Error('Network response was not ok.');
            })
            .then(data => {
                // Handle successful upload
                swal("Success", "File uploaded successfully!", "success").then(() => {
                    window.location.href = 'fileList.jsp'; // Redirect after user clicks OK
                });
            })
            .catch(error => {
                // Handle upload error
                swal("Error", "Failed to upload file. Please try again.", "error");
                console.error('There was a problem with the upload:', error);
            });
        });
    </script>
</body>
</html>
