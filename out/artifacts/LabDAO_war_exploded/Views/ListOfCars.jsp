<%@ page import="Entities.Models.CarModel" %>
<%@ page import="java.util.List" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ListOfCars</title>
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
            grid-template-columns: repeat(4, 1fr);
            align-content: center;
            width: 60%;
            margin: auto;
        }

        .text {
            padding: 10px;
            text-align: center;
            font-size: 18px;
            border: 1px solid black;
            background-color: grey;
            color: black;
        }

        .wrapper3 {
            text-align: center;
            margin-top: 3%;
        }

        .btn {
            font-size: 15px;
            padding: 5px;
        }
    </style>
</head>
<body>
    <form method="get">
        <div class="wrapper1">
            <div class="label">Brand</div>
            <div class="label">Model</div>
            <div class="label">Price</div>
            <div class="label">Color</div>
        </div>
        <div>
            <%
                List<CarModel> cars = (List<CarModel>) request.getAttribute("list");

                if (request.getAttribute("list") != null) {
                    for (CarModel car : cars)
                    {
                        out.print("<div class=\"wrapper2\">");
                        out.print("<div class=\"text\">" + car.getBrand() + "</div>");
                        out.print("<div class=\"text\">" + car.getModel() + "</div>");
                        out.print("<div class=\"text\">" + car.getPrise() + "</div>");
                        out.print("<div class=\"text\">" + car.getColor() + "</div>");
                        out.print("</div>");
                    }
                }
            %>
        </div>
    </form>

    <div class="wrapper3">
        <button onclick="location.href='http://localhost:8090/add'" class="btn">Add user</button>
    </div>
</body>
</html>
