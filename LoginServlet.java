package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        // Get username and password from form
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Create PrintWriter
        PrintWriter out = response.getWriter();

        // Check login
        if ("admin".equals(username)
                && "1234".equals(password)) {

            // Create session
            HttpSession session = request.getSession();

            // Store username in session
            session.setAttribute("username", username);

            // Display success message
            out.println("<h1>Login Successful</h1>");

            // Link to home
            out.println("<a href='home'>Go to Home</a>");

        } else {

            // Invalid login
            out.println("<h1>Invalid Login</h1>");
        }
    }
}