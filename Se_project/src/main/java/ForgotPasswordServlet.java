import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/forgot_password")
public class ForgotPasswordServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // Retrieve values from the form
        String emailOrPhone = request.getParameter("email_or_phone");
        String enteredOTP = request.getParameter("otp");
        String newPassword = request.getParameter("password");

        // Simulate OTP verification (replace with your actual logic)
        boolean isOTPCorrect = verifyOTP(emailOrPhone, enteredOTP);

        if (isOTPCorrect) {
            // Update the password in the database (replace with your actual logic)
            boolean passwordUpdated = updatePassword(emailOrPhone, newPassword);

            if (passwordUpdated) {
                out.println("Password reset successful");
            } else {
                out.println("Password reset failed. Please try again.");
            }
        } else {
            out.println("Invalid OTP. Please enter the correct OTP.");
        }
    }

    // Simulate OTP verification (replace with your actual logic)
    private boolean verifyOTP(String emailOrPhone, String enteredOTP) {
        // Implement your OTP verification logic here
        // Compare enteredOTP with the stored OTP in your system
        // Return true if OTP is correct, false otherwise
        return true; // For simplicity, always return true
    }

    // Simulate updating the password in the database (replace with your actual
    // logic)
    private boolean updatePassword(String emailOrPhone, String newPassword) {
        // Implement your logic to update the password in the database
        // Return true if the password is updated successfully, false otherwise
        return true; // For simplicity, always return true
    }
}
