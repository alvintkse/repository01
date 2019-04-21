    <!--

-->

    <!DOCTYPE HTML>
    <html>

    <head>
        <title>Student Login Form</title>
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
            <!-- Main -->

            <!-- Student Login-->
            <article>
                <h2 class="major">Student Login</h2>
                <form method="post" action="ProcessStudentLogin">
                    <div class="fields">
                        <div class="field half">
                            <label for="studentid">Student ID</label>
                            <!--pattern="[0-9A-Z]{10}"-->
                            <input type="text" name="studentid" title="10 characters of numbers and capital letters" value="${studentID}" required/>
                        </div>
                        <div class="field half">
                            <label for="studentpassword">Student Password</label>
                            <input type="password" name="studentpassword" required/>
                        </div>
                    </div>
                    <ul class="actions">
                        <!--<li><input type="submit" value="Login" class="primary" /></li>-->
                        <li>
                            <input type="submit" value="Login" id="loginbutton" class="primary" />
                        </li>
                        <li>
                            <input type="reset" value="Reset" />
                        </li>
                    </ul>
                </form>
                <ul class="links">
                    <li><a href="StaffLogin.html">Not a student?</a></li>
                    <li><a href="StudentRegistration.jsp">Do not have an account?</a></li>
                </ul>
            </article>
                          &emsp;&emsp;${logInInvalidMessage}

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
