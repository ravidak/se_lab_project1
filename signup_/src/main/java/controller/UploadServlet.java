package controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@WebServlet("/uploadServlet")
@MultipartConfig
public class UploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/file_info";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "B210445@cs";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get form data and file
        String authorName = request.getParameter("authorName");
        String email = request.getParameter("email");
        String contact = request.getParameter("contact");
        String postalAddress = request.getParameter("postalAddress");
        String paperTitle = request.getParameter("paperTitle");
        String abstractText = request.getParameter("abstract");
        String akeywordsText = request.getParameter("keywords");
        
        
        Part filePart = request.getPart("file");
        String fileName = filePart.getSubmittedFileName();
        String fileType = filePart.getContentType();
        
        long fileSize = filePart.getSize();
        InputStream fileContent = filePart.getInputStream();
        HttpSession session = request.getSession();

        // Database connection and insertion
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/file_info", "root", "B210445@cs")) {
            String sql = "INSERT INTO uploaded_files (author_name, email, contact_number, postal_address, paper_title, abstract, keywords, file_name, file_type, file_size, file_data, upload_time) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, authorName);
                statement.setString(2, email);
                statement.setString(3, contact);
                statement.setString(4, postalAddress);
                statement.setString(5, paperTitle);
                statement.setString(6, abstractText);
                statement.setString(7, fileName);
                statement.setString(8, fileType);
                statement.setLong(9, fileSize);
                statement.setBlob(10, fileContent);
                statement.setTimestamp(11, new Timestamp(System.currentTimeMillis())); // Current timestamp

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    // File upload successful
                    String uploadPath = getServletContext().getRealPath("") + File.separator + "uploaded_files";
                    File uploadDir = new File(uploadPath);
 
                    // Save file to the specified upload directory
                    File file = new File(uploadDir, fileName);
                    filePart.write(file.getAbsolutePath());
                    // Set success message in session
                    session.setAttribute("msg", "File uploaded successfully!");
                    // Redirect back to index.jsp
                    response.sendRedirect("index.jsp");
                    
                } else {
                    // Failed to insert into database
                    response.getWriter().println("Failed to upload file. Please try again.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Database connection error or upload failed. Please try again.");
        }
    }
}
