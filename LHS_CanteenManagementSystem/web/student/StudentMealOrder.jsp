<!DOCTYPE HTML>
    <!--
	Phantom by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<jsp:useBean id="student" scope="session" class="entity.Student" />
<%@page import="entity.*, java.util.*" %>


    <html>

    <head>
        <title>LHS Canteen Management System</title>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
        <link rel="stylesheet" href="assets/css/main.css" />
        <noscript>
            <link rel="stylesheet" href="assets/css/noscript.css" />
        </noscript>

    </head>

    <body class="is-preload">
        <!-- Wrapper -->
        <div id="wrapper">
<input type="hidden" name="studentid" class="a" value="${student.studentid}" readonly="readonly">
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
                <h2>Student Menu</h2>
                <ul>
                       <li><a href="StudentMealList.jsp">Meal List</a></li>
                <li><a href="StudentMealOrder.jsp">Meal Order</a></li>
                <li><a href="StudentProfile.jsp">Profile</a></li>
                <li><a href="../ProcessLogout">Logout</a></li>
                </ul>
            </nav>

            <!-- Main -->
            <div id="main">
                <div class="inner">
                    <header>
                        <h1>Lightway High School Canteen Management System</h1>
                        <h1>Student Meal Order</h1>
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
                                        <th>Credit Points</th>
                                        <!--<th>Print Coupon</th>-->
                                        <!--<th>Status</th>-->
                                        <th>Edit</th>
                                        <th>Cancel</th>
                                    </tr>
                                </thead>
                                <tbody>
<% List<Mealorderb> mealorders =(List<Mealorderb>) session.getAttribute("mealorders");
for (Mealorderb mealorder : mealorders) {%>
                                     <td><%=mealorder.getMealorderid()%></td>
                                        <td>01-01-2019</td>
                                        <td>Meal Set A</td>
                                        <td>499</td>
                                        <td><a href="editMealOrder.html">Edit</a></td>
                                        <td><a href="index.html">Cancel</a></td>
                                            <%}%>
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