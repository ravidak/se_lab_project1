import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/submit")
public class UploadDocumentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Basic Paper Information
        String title = request.getParameter("title");
        String field = request.getParameter("field");
        String country = request.getParameter("country");

        // File Upload
        List<Part> fileParts = (List<Part>) request.getParts();
        for (Part filePart : fileParts) {
            // Process each file part (you can save the file to disk or handle it as needed)
            String fileName = getFileName(filePart);
            // You can save the file or perform other operations based on your requirements
        }

        // Other Information
        String abstractText = request.getParameter("abstract");
        String keywords = request.getParameter("keywords");

        // Author Information
        String author1Name = request.getParameter("author1_name");
        String author1Designation = request.getParameter("author1_designation");
        String author1Contact = request.getParameter("author1_contact");
        String author1Email = request.getParameter("author1_email");

        // Communication Address
        String addressLine1 = request.getParameter("address_line1");
        String addressLine2 = request.getParameter("address_line2");
        String cityDistrict = request.getParameter("city_district");
        String state = request.getParameter("state");
        String countryCommunication = request.getParameter("country_communication");
        String postalCode = request.getParameter("postal_code");

        // Perform database operations or any other processing based on the collected
        // data

        // Redirect or forward to a success page
        response.sendRedirect("/success.html");
    }

    // Extracts file name from content-disposition header of a part
    private String getFileName(Part part) {
        String contentDisposition = part.getHeader("content-disposition");
        String[] elements = contentDisposition.split(";");
        for (String element : elements) {
            if (element.trim().startsWith("filename")) {
                return element.substring(element.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return "";
    }
}
