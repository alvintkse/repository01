<!DOCTYPE HTML>
<!--
	Phantom by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<jsp:useBean id="staff" scope="session" class="entity.Staff" />
<%@page import="entity.*, java.util.*" %>
    <% List<Beverage> beverageList = (List<Beverage>) session.getAttribute("beverageList");%>
        <html>

        <head>
            <title>Phantom by HTML5 UP</title>
            <meta charset="utf-8" />
            <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
            <link rel="stylesheet" href="assets/css/main.css" />
            <noscript><link rel="stylesheet" href="assets/css/noscript.css" /></noscript>

        </head>

        <body class="is-preload">
            <!-- Wrapper -->
            <div id="wrapper">

                <!-- Header -->
                <header id="header">
                    <div class="inner">
                        <!-- Nav -->
                        <nav>
                            <ul>
                                <li><a href="#menu">Menu</a></li>
                            </ul>
                        </nav>
                    </div>
                </header>

                <!-- Menu -->
                <nav id="menu">
                    <h1>${staff.staffname}</h1>
                    <h2>Staff Menu</h2>
                    <ul>
                        <li><a href="../GetMealList">Meal List</a></li>
                        <li><a href="../GetMealOrderList">Meal Order List</a></li>
                        <li><a href="../GetFoodList">Food List</a></li>
                        <li><a href="../GetBeverageList">Beverage List</a></li>
                        <li><a href="topUp.jsp">Top Up Credit Points</a></li>
                        <li><a href="coupon.jsp">Coupon</a></li>
                        <li><a href="studentProfile.jsp">Profile</a></li>
                        <li><a href="../ProcessLogout">Logout</a></li>
                    </ul>
                </nav>

                <!-- Main -->
                <div id="main">
                    <div class="inner">
                        <header>
                            <h1>Lightway High School Canteen Management System</h1>
                            <h1>Beverage List</h1>
                        </header>
                        <!-- Table -->
                        <section>
                            <ul class="actions">
                                <li><a href="addBeverage.html" class="button primary">Add New Beverage</a></li>
                            </ul>
                            <div class="table-wrapper">
                                <table class="alt">
                                    <thead>
                                        <tr>
                                            <th>Beverage ID</th>
                                            <th>Beverage Name</th>
                                            <th>Credit Points</th>
                                            <th>Quantity</th>
                                            <th>Edit</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%  int[] beverageArr = new int[beverageList.size()];
                                             for (int i = 0; i < beverageList.size(); ++i) {
                                           Beverage beverage = beverageList.get(i);%>
                                            <tr>
                                                <form action="../GetBeverage?beverageID=<%=beverage.getBeverageid()%>" method="post">
                                                <td name="beverageid">
                                                    <%=beverage.getBeverageid()%>
                                                </td>
                                                <td name="beveragename">
                                                    <%=beverage.getBeveragename()%>
                                                </td>
                                                <td name="beveragecreditpoints">
                                                    <%=beverage.getBeveragecreditpoints()%>
                                                </td>
                                                <td name="beveragequantity">
                                                    <%=beverage.getBeveragequantity()%>
                                                </td>
                                                <td><input type="submit" value="Edit" class="primary small" /></td>
                                            </tr>
                                            <% }%>
                                    </tbody>
                                </table>
                            </div>

                        </section>
                    </div>
                </div>

                <!-- Footer -->
                <footer id="footer">
                    <ul class="copyright">
                        <li>&copy; Untitled. All rights reserved</li>
                    </ul>
                </footer>

            </div>

            <!-- Scripts -->
            <script src="assets/js/jquery.min.js"></script>
            <script src="assets/js/browser.min.js"></script>
            <script src="assets/js/breakpoints.min.js"></script>
            <script src="assets/js/util.js"></script>
            <script src="assets/js/main.js"></script>

        </body>

        </html>