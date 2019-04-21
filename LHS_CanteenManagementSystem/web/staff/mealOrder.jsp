<!DOCTYPE HTML>
<!--
	Phantom by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<jsp:useBean id="staff" scope="session" class="entity.Staff" />
<%@page import="entity.*, java.util.*" %>
    <% List<Mealorder> mealOrderList = (List<Mealorder>) session.getAttribute("mealOrderList");%>
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
                            <h1>Meal Order List</h1>
                            
                        </header>
                        <!-- Table -->
                        <section>
                            <div class="table-wrapper">
                                <table class="alt">
                                    <thead>
                                        <tr>
                                            <th>Meal Order ID</th>
                                            <th>Meal Order Date</th>
                                            <th>Meal Name</th>
                                            <th>Student ID</th>
                                            <th>Status</th>
                                            <th>Edit</th>                                            
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%  int[] mealOrderArr = new int[mealOrderList.size()];
                                        for (int i = 0; i < mealOrderList.size(); ++i) {
                                          Mealorder mealOrder = mealOrderList.get(i);%>
                                                                                            
                                            <tr>
                                                <form action="../GetMealOrder?mealorderID=<%=mealOrder.getMealorderid()%>" method="post">
                                                <td name="mealorderid">
                                                    <%=mealOrder.getMealorderid()%>
                                                </td>
                                                <td name="mealorderdate">
                                                    <%=(mealOrder.getMealorderdate())%>
                                                </td>
                                                <td name="mealordername">
                                                    <%=(mealOrder.getMealname()).getMealname()%>
                                                </td>
                                                <td name="studentid">
                                                    <%=(mealOrder.getStudentid()).getStudentid()%>
                                                </td>
                                                <td name="mealorderstatus">
                                                    <%=mealOrder.getMealorderstatus()%>
                                                </td>
                                                <td><input type="submit" value="Edit" class="primary small" /></td>
                                            </form>
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