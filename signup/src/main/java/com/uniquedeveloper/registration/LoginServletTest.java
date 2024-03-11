import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.uniquedeveloper.registration.Login;

public class LoginServletTest {
    
    @Mock
    HttpServletRequest request;
    
    @Mock
    HttpServletResponse response;
    
    @Mock
    HttpSession session;
    
    @Mock
    RequestDispatcher dispatcher;
    
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void testDoPost_Success() throws ServletException, IOException, SQLException {
        // Mock HttpServletRequest parameters
        when(request.getParameter("username")).thenReturn("test@example.com");
        when(request.getParameter("password")).thenReturn("password");
        
        // Mock database connection, PreparedStatement, and ResultSet
        Connection mockConnection = mock(Connection.class);
        PreparedStatement mockPreparedStatement = mock(PreparedStatement.class);
        ResultSet mockResultSet = mock(ResultSet.class);
        when(mockConnection.prepareStatement(any(String.class))).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true); // Simulate user found
        
        // Mock HttpSession
        when(request.getSession()).thenReturn(session);
        
        // Test Login servlet doPost method
        new Login().doPost(request, response);
        
        // Verify HttpSession attribute is set
        verify(session).setAttribute(eq("name"), anyString());
        
        // Verify dispatcher forward
        verify(dispatcher).forward(request, response);
    }
    
    @Test
    public void testDoPost_Failure() throws ServletException, IOException, SQLException {
        // Mock HttpServletRequest parameters
        when(request.getParameter("username")).thenReturn("test@example.com");
        when(request.getParameter("password")).thenReturn("password");
        
        // Mock database connection, PreparedStatement, and ResultSet
        Connection mockConnection = mock(Connection.class);
        PreparedStatement mockPreparedStatement = mock(PreparedStatement.class);
        ResultSet mockResultSet = mock(ResultSet.class);
        when(mockConnection.prepareStatement(any(String.class))).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(false); // Simulate user not found
        
        // Mock request dispatcher
        when(request.getRequestDispatcher(any(String.class))).thenReturn(dispatcher);
        
        // Test Login servlet doPost method
        new Login().doPost(request, response);
        
        // Verify request attribute "status" is set to "failed"
        verify(request).setAttribute("status", "failed");
        
        // Verify dispatcher forward
        verify(dispatcher).forward(request, response);
    }
}
