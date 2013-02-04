package com.sfeir.oauth.front;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@SuppressWarnings("serial")
public class AuthenticationServlet extends HttpServlet {


    public void doGet(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {

        UserService userService = UserServiceFactory.getUserService();

        String thisURL = request.getRequestURI();
        if (request.getUserPrincipal() != null) {
            response.getWriter().println("<p>Hello, " +
                    request.getUserPrincipal().getName() +
                    "!  You can <a href=\"" +
                    userService.createLogoutURL(thisURL) +
                    "\">sign out</a>.</p>");
        } else {
            response.getWriter().println("<p>Please <a href=\"" +
                    userService.createLoginURL(thisURL) +
                    "\">sign in</a>.</p>");
        }
    }
}