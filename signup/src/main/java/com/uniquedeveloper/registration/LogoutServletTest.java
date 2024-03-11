import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.uniquedeveloper.registration.Logout;

public class LogoutServletTest {
    
    @Mock
    HttpServletRequest request;
    
    @Mock
    HttpServletResponse response;
    
    @Mock
    HttpSession session;
    
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void testDoGet_Success() throws ServletException, IOException {
        // Mock HttpSession
        when(request.getSession()).thenReturn(session);
        
        // Test Logout servlet doGet method
        new Logout().doGet(request, response);
        
        // Verify HttpSession invalidation
        verify(session).invalidate();
        
        // Verify redirect to login.jsp
        verify(response).sendRedirect("login.jsp");
    }
}
