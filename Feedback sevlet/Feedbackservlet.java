/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Feedbackservlet")
public class Feedbackservlet extends HttpServlet {

    public void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        String course = request.getParameter("course");
        String rating = request.getParameter("rating");
        String feedback = request.getParameter("feedback");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head><title>Feedback Response</title></head>");
        out.println("<body>");

        out.println("<h2>Feedback Submitted Successfully</h2>");

        out.println("<h3>Submitted Feedback Details</h3>");

        out.println("Name: " + name + "<br><br>");
        out.println("Email: " + email + "<br><br>");
        out.println("Mobile Number: " + mobile + "<br><br>");
        out.println("Course: " + course + "<br><br>");
        out.println("Rating: " + rating + "<br><br>");
        out.println("Feedback: " + feedback + "<br><br>");

        out.println("</body>");
        out.println("</html>");
    }
}