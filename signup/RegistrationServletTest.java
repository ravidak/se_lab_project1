import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.uniquedeveloper.registration.RegistrationServlet;

public class RegistrationServletTest {
    
    @Mock
    HttpServletRequest request;
    
    @Mock
    HttpServletResponse response;
    
    @Mock
    RequestDispatcher dispatcher;
    
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void testDoPost_Success() throws ServletException, IOException, SQLException {
        // Mock HttpServletRequest parameters
        when(request.getParameter("name")).thenReturn("TestUser");
        when(request.getParameter("email")).thenReturn("test@example.com");
        when(request.getParameter("pass")).thenReturn("password");
        when(request.getParameter("contact")).thenReturn("1234567890");
        
        // Mock database connection and PreparedStatement
        Connection mockConnection = mock(Connection.class);
        PreparedStatement mockPreparedStatement = mock(PreparedStatement.class);
        when(mockConnection.prepareStatement(any(String.class))).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeUpdate()).thenReturn(1); // Simulate successful registration
        
        // Mock request dispatcher
        when(request.getRequestDispatcher(any(String.class))).thenReturn(dispatcher);
        
        // Test RegistrationServlet doPost method
        new RegistrationServlet().doPost(request, response);
        
        // Verify that request attribute "status" is set to "success"
        verify(request).setAttribute("status", "success");
        
        // Verify dispatcher forward
        verify(dispatcher).forward(request, response);
    }
    
    @Test
    public void testDoPost_Failure() throws ServletException, IOException, SQLException {
        // Mock HttpServletRequest parameters
        when(request.getParameter("name")).thenReturn("TestUser");
        when(request.getParameter("email")).thenReturn("test@example.com");
        when(request.getParameter("pass")).thenReturn("password");
        when(request.getParameter("contact")).thenReturn("1234567890");
        
        // Mock database connection and PreparedStatement
        Connection mockConnection = mock(Connection.class);
        PreparedStatement mockPreparedStatement = mock(PreparedStatement.class);
        when(mockConnection.prepareStatement(any(String.class))).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeUpdate()).thenReturn(0); // Simulate failed registration
        
        // Mock request dispatcher
        when(request.getRequestDispatcher(any(String.class))).thenReturn(dispatcher);
        
        // Test RegistrationServlet doPost method
        new RegistrationServlet().doPost(request, response);
        
        // Verify that request attribute "status" is set to "failed"
        verify(request).setAttribute("status", "failed");
        
        // Verify dispatcher forward
        verify(dispatcher).forward(request, response);
    }
}
