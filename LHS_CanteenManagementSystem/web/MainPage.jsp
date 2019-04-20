<%@page import="java.util.*, entity.*"%>
    <jsp:useBean id="staff" scope="session" class="entity.Staff" />
    <jsp:useBean id="student" scope="session" class="entity.Student" />

    <%-- 
    Document   : MainPage
    Created on : Apr 9, 2019, 1:07:34 PM
    Author     : user
--%>

        <%@page contentType="text/html" pageEncoding="UTF-8"%>
            <!DOCTYPE html>

            <html>

            <head>
                <title>Login Complete!</title>
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
                        <div class="content">
                            <div class="inner">
                                <h1>Lightway High School <br> Canteen Management System</h1>
                                <p>A Web application created for a certain high school <br>to make sure that both students and canteen staffs <br> can make their businesses much more easier to manage.</p>
                                <h3>Welcome to Main Page! ( ${staff.staffname} ${student.studentname})</h3>
                                <h3><a href="../ProcessLogout">Logout</a></h3>
                            </div>
                        </div>
                    </header>
                    <!-- Footer -->
                    <footer id="footer">
                        <p class="copyright">&copy; 2019 All Rights Reserved.</p>
                    </footer>
                </div>
                <!-- BG -->
                <div id="bg"></div>
                <!-- Scripts -->
                <script src="assets/js/jquery.min.js"></script>
                <script src="assets/js/browser.min.js"></script>
                <script src="assets/js/breakpoints.min.js"></script>
                <script src="assets/js/util.js"></script>
                <script src="assets/js/main.js"></script>

            </body>

            </html>