<!DOCTYPE HTML>
<!--
	Phantom by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<jsp:useBean id="staff" scope="session" class="entity.Staff" />
<jsp:useBean id="mealorder" scope="session" class="entity.Mealorder" />
<%@page import="entity.*, java.util.*" %>
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
                    <h1>Edit Meal Order</h1>
                </header>
                <!-- Form -->
                <section>
                    <form method="post" action="../EditMealOrderList">
                        <div class="row gtr-uniform">
                            <div class="col-6 col-12-xsmall">
                                <input type="text" name="mealorderid" id="demo-name" value="${mealorder.mealorderid}" placeholder="Meal Order ID" readonly="readonly" />
                            </div>
                            <div class="col-6 col-12-xsmall">
                                <input type="date" name="mealorderdate" id="demo-name" value="${mealorder.mealorderdate}" placeholder="Meal Order Date" readonly="readonly"/>
                            </div>
                            <div class="col-6 col-12-xsmall">
                                <input type="text" name="mealname" id="demo-name" value="${(mealorder.getMealname()).getMealname()}" placeholder="Meal Name"  readonly="readonly"/>
                            </div>
                            <div class="col-6 col-12-xsmall">
                                <input type="text" name="studentid" id="demo-name" value="${(mealorder.getStudentid()).getStudentid()}" placeholder="Student ID" readonly="readonly"/>
                            </div>
                            <div class="col-12">
                                <select name="mealorderstatus" id="demo-category">
													<option value="">${mealorder.mealorderstatus}</option>
													<option value="Paid">Paid</option>
													<option value="Completed">Completed</option>
													<option value="Canceled">Canceled</option>
													<option value="Expired">Expired</option>
												</select>
                            </div>
                            <div class="col-12">
                                <ul class="actions">
                                    <li><input type="submit" value="Save Changes" class="primary" /></li>
                                    <li><input type="reset" value="Reset" /></li>
                                </ul>
                            </div>
                        </div>
                    </form>
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