<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Student Details</title>
</head>
<body>

<%
    String roll = request.getParameter("roll");
    String name = request.getParameter("name");
    String course = request.getParameter("course");
    String email = request.getParameter("email");
    String marks = request.getParameter("marks");

    session.setAttribute("studentName", name);

    response.setContentType("text/html");
%>

<h2>Student Details Submitted Successfully</h2>

<h3>Student Information</h3>

<%
    out.println("Roll Number: " + roll + "<br><br>");
    out.println("Student Name: " + name + "<br><br>");
    out.println("Course: " + course + "<br><br>");
    out.println("Email: " + email + "<br><br>");
    out.println("Marks: " + marks + "<br><br>");
    out.println("Session Student Name: " + session.getAttribute("studentName"));
%>

</body>
</html>