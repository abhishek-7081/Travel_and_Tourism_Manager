package com.exa.service;

import com.example.dao.UserDao;
import com.example.model.User;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class UserProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Assuming you have a UserDao to fetch user data from the database
        UserDao userDao = new UserDao();
        int userId = Integer.parseInt(request.getParameter("userId")); // Get user ID from query parameter
        
        // Fetch the user information from the database
        User user = userDao.getUserById(userId);
        
        // Set user attributes to be used in the JSP page
        request.setAttribute("name", user.getName());
        request.setAttribute("email", user.getEmail());
        request.setAttribute("phone", user.getPhone());
        request.setAttribute("address", user.getAddress());
        request.setAttribute("profileImage", user.getProfileImageURL());
        
        // Forward the request to the profile.jsp page
        RequestDispatcher dispatcher = request.getRequestDispatcher("/profile.jsp");
        dispatcher.forward(request, response);
    }
}
