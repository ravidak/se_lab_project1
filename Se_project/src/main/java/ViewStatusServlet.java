import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/view_status")
public class ViewStatusServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Fetch data from the database (replace this with your actual database logic)
        List<PaperStatus> paperList = getPaperListFromDatabase();

        // Set the data as an attribute in the request
        request.setAttribute("paperList", paperList);

        // Forward the request to the JSP page for rendering
        request.getRequestDispatcher("/view_status.jsp").forward(request, response);
    }

    // Simulated data retrieval from the database
    private List<PaperStatus> getPaperListFromDatabase() {
        List<PaperStatus> paperList = new ArrayList<>();

        // Add sample data (replace with actual database queries)
        paperList.add(new PaperStatus("Paper 1", "Submitted"));
        paperList.add(new PaperStatus("Paper 2", "Under Review"));
        paperList.add(new PaperStatus("Paper 3", "Approved"));
        paperList.add(new PaperStatus("Paper 4", "Rejected"));
        paperList.add(new PaperStatus("Paper 5", "Submitted"));

        return paperList;
    }

    // Simple data structure to represent paper status
    public static class PaperStatus {
        private String paperName;
        private String status;

        public PaperStatus(String paperName, String status) {
            this.paperName = paperName;
            this.status = status;
        }

        public String getPaperName() {
            return paperName;
        }

        public String getStatus() {
            return status;
        }
    }
}
