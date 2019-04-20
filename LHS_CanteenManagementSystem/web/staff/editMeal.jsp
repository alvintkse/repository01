<!DOCTYPE HTML>
<!--
	Phantom by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<jsp:useBean id="staff" scope="session" class="entity.Staff" />
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
                <li><a href="index.jsp">Meal List</a></li>
                <li><a href="../GetMealOrderList">Meal Order List</a></li>
                <li><a href="../GetFoodList">Food List</a></li>
                <li><a href="../GetBeverageList">Beverage List</a></li>
                <li><a href="topUp.html">Top Up Credit Points</a></li>
                <li><a href="studentProfile.jsp">Profile</a></li>
                <li><a href="../ProcessLogout">Logout</a></li>
            </ul>
        </nav>

        <!-- Main -->
        <div id="main">
            <div class="inner">
                <header>
                    <h1>Lightway High School Canteen Management System</h1>
                    <h1>Edit Meal</h1>
                </header>
                <!-- Form -->
                <section>
                    <form method="post" action="index.html">
                        <div class="row gtr-uniform">
                            <div class="col-6 col-12-xsmall">
                                <input type="text" name="mealid" id="demo-name" placeholder="Meal ID" />
                            </div>
                            <div class="col-6 col-12-xsmall">
                                <input type="text" name="mealname" id="demo-name" placeholder="Meal Name" />
                            </div>
                            <div class="col-6 col-12-xsmall">
                                <select name="foodname" id="demo-category">
                                                                                                    <option value="">Food Name</option>
                                                                                                    <%  int[] foodArr = new int[foodList.size()];
                                                                                                    for (int i = 0; i < foodList.size(); ++i) {
                                                                                                    Food food = foodList.get(i);%>
                                                                                                    <option value=""><%=food.getFoodname()%></option>
                                                                                                    <% }%>
                                                                                            </select>
                            </div>
                            <div class="col-6 col-12-xsmall">
                                <select name="beveragename" id="demo-category">
                                                                                                    <option value="">Beverage Name</option>
                                                                                                    <%  int[] beverageArr = new int[beverageList.size()];
                                                                                                    for (int i = 0; i < beverageList.size(); ++i) {
                                                                                                    Beverage beverage = beverageList.get(i);%>
                                                                                                    <option value=""><%=beverage.getBeveragename()%></option>
                                                                                                    <% }%>
                                                                                            </select>
                            </div>
                            <div class="col-6 col-12-xsmall">
                                <select name="mealtype" id="demo-category">
													<option value="">Meal Type</option>
													<option value="Breakfast">Breakfast</option>
													<option value="Lunch">Lunch</option>													
												</select>
                            </div>
                            <div class="col-6 col-12-xsmall">
                                <input type="text" name="mealcreditpoints" id="demo-name" value="" placeholder="Meal Credit Points" />
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