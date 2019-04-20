<!DOCTYPE HTML>
<!--
	Phantom by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<jsp:useBean id="student" scope="session" class="entity.Student" />
<%@page import="entity.*, java.util.*" %>
    <% List<Meal> mealList = (List<Meal>) session.getAttribute("mealList");%>
             <%System.out.println(mealList.size());%><!--testing purpose, see amount of record in meal table-->
<html>

<head>
    <title>Phantom by HTML5 UP</title>
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
                    <h1>Meal Menu List</h1>
                    <p>Here you can take a look of meal list and pre order your peferred meal.</p>
                </header>
                <section class="tiles">
                   <%  int[] mealArr = new int[mealList.size()];
                                                        for (int i = 0; i < mealList.size(); ++i) {
                                                        Meal meal = mealList.get(i);%>
                                <article class="style1">
                                    <span class="image">
                                        <img src="images/pic01.jpg" alt="" />
                                    </span>
                                   <!--<a href="StudentPreOrderMeal.jsp">-->
                                   <!-- <a href="../StudenSelectMeal?id=<%=meal.getMealid()%>">-->
                                       <a href="../StudentSelectMeal?mealID=<%=meal.getMealid()%>">
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
                                            <p>Click to Pre Order</p>
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