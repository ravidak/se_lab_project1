package controller;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/viewUploadedFiles")
public class ViewUploadedFilesServlet extends HttpServlet {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/file_info";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "B210445@cs";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            String query = "SELECT paper_title, file_name FROM uploaded_files";
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();

            // Set response content type
            response.setContentType("text/html");

            // Create HTML table to display uploaded files
            OutputStream out = response.getOutputStream();
            out.write("<table border='1'>".getBytes());
            out.write("<tr><th>Paper Title</th><th>Download</th></tr>".getBytes());

            while (rs.next()) {
                String paperTitle = rs.getString("paper_title");
                String fileName = rs.getString("file_name");
                out.write(("<tr><td>" + paperTitle + "</td><td><a href='download?fileName=" + fileName + "'>Download</a></td></tr>").getBytes());
            }

            out.write("</table>".getBytes());
            out.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
