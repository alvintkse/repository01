<!DOCTYPE HTML>
<!--
	Phantom by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<jsp:useBean id="staff" scope="session" class="entity.Staff" />
<%@page import="entity.*, java.util.*" %>
    <% List<Meal> mealList = (List<Meal>) session.getAttribute("mealList");%>

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
                            <h1>Meal Menu List</h1>
                            <ul class="actions">
                                <li><a href="../GetFoodAndBeverage" class="button primary">Add New Meal</a></li>
                            </ul>

                            <p>Here you can take a look of meal list available in the canteen.</p>
                        </header>
                        <section class="tiles">
                            <%  int[] mealArr = new int[mealList.size()];
                            for (int i = 0; i < mealList.size(); ++i) {
                            Meal meal = mealList.get(i);%>
                                <article class="style1">
                                    <span class="image">
					<img src="images/pic01.jpg" alt="" />
					</span>
                                    <a href="../GetMeal?mealID=<%=meal.getMealid()%>">
                                        <h2>
                                            <%=meal.getMealname()%>
                                        </h2>
                                        <div class="content">
                                            <p>Type:
                                                <%=meal.getMealtype()%>
                                                    </br>Content:
                                                    <%=(meal.getFoodname()).getFoodname()%>,
                                                        <%=(meal.getBeveragename()).getBeveragename()%>
                                                            </br>Credit Points:
                                                            <%=meal.getMealcreditpoints()%>
                                            </p>
                                            <p>Click to edit meal</p>
                                        </div>
                                    </a>
                                </article>
                                <% }%>
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