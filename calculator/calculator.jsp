<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Calculator Result</title>
</head>
<body>

<h2>Calculator Result</h2>

<%
    String num1 = request.getParameter("number1");
    String num2 = request.getParameter("number2");
    String operation = request.getParameter("operation");

    if (num1 != null && num2 != null && operation != null) {
        try {
            double a = Double.parseDouble(num1);
            double b = Double.parseDouble(num2);
            double result = 0;

            switch (operation) {
                case "add":
                    result = a + b;
                    break;

                case "sub":
                    result = a - b;
                    break;

                case "mul":
                    result = a * b;
                    break;

                case "div":
                    if (b == 0) {
                        out.println("<h3>Cannot divide by zero</h3>");
                    } else {
                        result = a / b;
                        out.println("<h3>Result: " + result + "</h3>");
                    }
                    break;

                default:
                    out.println("<h3>Invalid Operation</h3>");
            }

            if (!operation.equals("div")) {
                out.println("<h3>Result: " + result + "</h3>");
            }

        } catch (Exception e) {
            out.println("<h3>Invalid Input</h3>");
        }
    }
%>

</body>
</html>