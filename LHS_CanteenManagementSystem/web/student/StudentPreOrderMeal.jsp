<!DOCTYPE HTML>
<%@page import="java.util.*, entity.*"%>
    <jsp:useBean id="meal" scope="session" class="entity.Meal" />
    <jsp:useBean id="student" scope="session" class="entity.Student" />
    <!--
	Phantom by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
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
                        <h1>Pre Order Meal</h1>
                    </header>
                    <!-- Form -->
                    <section>

                        <form method="post" action="../ProcessStudentMealOrder">
                            <input type="hidden" name="studentid" value="${student.studentid}" readonly="readonly" />
                            <input type="hidden" name="studentcreditpoints" value="${student.studentcreditpoints}" readonly="readonly">
                            <div class="row gtr-uniform">
                                <!--fubveorvbierovbreiov ioerv-->
                                <div class="col-6 col-12-xsmall">
                                    <input type="text" name="mealid" id="demo-name" value="${meal.mealid}" placeholder="Meal Order ID" readonly="readonly" />
                                </div>
                                <div class="col-6 col-12-xsmall">
                                    <input type="text" name="mealname" id="demo-name" value="${meal.mealname}" placeholder="Meal Order Name" readonly="readonly" />
                                </div>
                                <div class="col-6 col-12-xsmall">
                                    <input type="text" name="foodname" id="demo-name" value="${(meal.foodname).getFoodname()}" placeholder="Food Name" readonly="readonly" />
                                </div>
                                <div class="col-6 col-12-xsmall">
                                    <input type="text" name="beveragename" id="demo-name" value="${(meal.beveragename).getBeveragename()}" placeholder="Beverage Name" readonly="readonly" />
                                </div>
                                <div class="col-6 col-12-xsmall">
                                    <input type="text" name="mealCreditPoints" id="demo-name" value="${meal.mealcreditpoints}" placeholder="Credit Points" readonly="readonly" />
                                </div>
                            </div>
                            <br>
                            <div class="row gtr-uniform">
                                <div class="col-6 col-12-xsmall">
                                    <b>Date You want to get the meal<b>
                                    <input type="date" name="mealorderdate" id="demo-name" value="" placeholder="Meal Order Date" required/>
                                </div>
                            </div>
                            <br>
                            <div class="col-12">
                                <ul class="actions">
                                    <li>
                                        <input type="submit" value="Order" class="primary" />
                                    </li>
                                    <li>
                                        <input type="reset" value="Reset the Date" />
                                    </li>
                                     &emsp;&emsp;&emsp;&emsp; &emsp;&emsp;<span style="color:red"> ${creditPointNotEnough}</span>
                                </ul>
                            </div>
                               <div class="col-12">
                                   <ul class="actions">
                                        <li>
                                            <a href="StudentMealList.jsp">Back to Meal Menu</a>
                                        </li>
                                    </ul>
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