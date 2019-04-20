<%-- 
    Document   : StudentAccountEdit
    Created on : Apr 13, 2019, 9:15:12 AM
    Author     : User
--%>

    <%@page import="java.util.*, entity.*"%>
        <jsp:useBean id="student" scope="session" class="entity.Student" />
        <!DOCTYPE HTML>
        <!--
                   interface design use and reference from: 
	Phantom by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->

        <head>
            <title>Account</title>
            <meta charset="utf-8" />
            <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
            <link rel="stylesheet" href="assets/css/main.css" />
            <noscript>
                <link rel="stylesheet" href="assets/css/noscript.css" />
            </noscript>
        </head>
        <link rel="stylesheet" href="StudentAccount.css">

        <body class="is-preload">
            <div id="wrapper">

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
                <nav id="menu">
                    <h2>Student Menu</h2>
                    <ul>
                        <li><a href="StudentMealList.jsp">Meal List</a></li>
                        <li><a href="StudentMealOrder.jsp">Meal Order</a></li>
                        <li><a href="StudentProfile.jsp">Profile</a></li>
                        <li><a href="../ProcessLogout">Logout</a></li>
                    </ul>
                </nav>
                <div id="main">
                    <div class="inner">
                        <header>
                            <h1>Lightway High School Canteen Management System</h1>
                            <h1>Account Info</h1>
                        </header>

                        <section>
                            <form action="../ProcessStudentUpdate" method="POST">

                                <div class="row gtr-uniform">
                                    <div class="col-6 col-12-xsmall">
                                        <b>ID</b><span style="color:red">[non editable]</span>
                                        <input type="text" name="studentid" class="a" value="${student.studentid}" readonly="readonly">
                                    </div>
                                    <br>
                                    <div class="col-6 col-12-xsmall">
                                        <b>Name</b><span style="color:red">[non editable]</span>

                                        <input type="text" name="studentname" class="a" value="${student.studentname}" readonly="readonly">
                                    </div>
                                    <br>
                                     <div class="col-6 col-12-xsmall">
                                        <b>Credit Points</b><span style="color:red">[non editable]</span>
                                        <input type="text" name="studentcreditpoint" class="a" value="${student.studentcreditpoints}" readonly="readonly">
                                    </div>
                                </div>
                                <br>
                                <div class="row gtr-uniform">
                                    <div class="col-6 col-12-xsmall">
                                        <b>Phone No</b>

                                        <input title="Only use numbers, and the length should between be 9 to 12" type="text" pattern="[0-9]{9,12}" name="studentphoneno" value="${student.studentphoneno}">
                                    </div>
                                    <br>
                                    <div class="col-6 col-12-xsmall">
                                        <b>Email</b>

                                        <input type="email" name="studentemail" value="${student.studentemail}">
                                    </div>
                                    <br>
                                    <div class="col-6 col-12-xsmall">
                                        <b>Password</b>(minimum of 8 characters is required, and no space allow)

                                        <input type="password" name="studentpassword" pattern="[0-9a-zA-Z]{8,15}" value="${student.studentpassword}">
                                    </div>
                                    <br>
                                    <br>
                                    <div class="col-12">
                                        <ul class="actions">
                                            <li>
                                                <input type="submit" />
                                                <li>
                                        </ul>
                                    </div>

                                </div>
                            </form>
                            <section>
                    </div>
                </div>
            </div>
            <script src="assets/js/jquery.min.js"></script>
            <script src="assets/js/browser.min.js"></script>
            <script src="assets/js/breakpoints.min.js"></script>
            <script src="assets/js/util.js"></script>
            <script src="assets/js/main.js"></script>
        </body>

        </html>