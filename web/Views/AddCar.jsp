<%@ page import="Servlets.AddServlet" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AddCar</title>
    <style>
        * {
            padding: 0;
            margin: 0;
        }

        .wrapper1 {
            display: grid;
            width: 60%;
            margin: auto;
            grid-template-columns: repeat(4, 1fr);
            align-content: center;
            padding-top: 2%;
        }

        .label {
            padding: 10px;
            text-align: center;
            font-size: 18px;
            border: 1px solid grey;
            background-color: black;
            color: white;
        }

        .wrapper2 {
            display: grid;
            width: 60%;
            margin-left: 20%;
            grid-template-columns: repeat(4, 1fr);
        }

        .space {
            text-align: center;
            padding: 10px;
            border: 1px solid black;
            background-color: grey;
        }

        .wrapper3 {
            margin-top: 2%;
            text-align: center;
        }

        .btn {
            font-size: 15px;
            padding: 5px;
        }

        h2 {
            text-align: center;
            margin-top: 3%;
        }
    </style>
</head>
<body>
    <div>
        <form method="post">
                <div class="wrapper1">
                    <div class="label">Brand</div>
                    <div class="label">Model</div>
                    <div class="label">Price</div>
                    <div class="label">Color</div>
                </div>
                <div class="wrapper2">
                    <div class="space"><input type="text" name="brand"></div>
                    <div class="space"><input type="text" name="model"></div>
                    <div class="space"><input type="text" name="price"></div>
                    <div class="space"><input type="text" name="color"></div>
                </div>

                <div class="wrapper3">
                    <button type="submit" class="btn">Submit</button>
                </div>
        </form>

        <div class="wrapper3">
            <button onclick="location.href='http://localhost:8090/list'" class="btn">To list</button>
        </div>
    </div>
    <div>
        <%
            if (request.getAttribute("add") != null && request.getAttribute("add") == AddServlet.car) {
                out.println("<h2><b>Car is added!</b></h2>");
            }
            else if (request.getAttribute("add") == "error")
            {
                out.println("<h2><b>Something is wrong</b></h2>");
            }
        %>
    </div>
</body>
</html>
