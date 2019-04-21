<!DOCTYPE HTML>
<html>

<head>
    <title>Student Registration Form</title>
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
        <!-- Student Register-->
        <article>
            <h2 class="major">Student Registration</h2>
            <form action="ProcessStudentRegistration" method="POST">

                <div class="fields">

                    <div class="field half">
                        <label for="studentID">
                            ID
                        </label>
                        <input type="text" placeholder="Enter ID" name="studentid" title="Only use alphabets and numbers" value="${studentID}" required>
                    </div>

                    <div class="field half">
                        <label for="studentName">
                            Student Name
                        </label>
                        <input type="text" placeholder="Enter name" name="studentname" pattern="[A-Za-z ]{1,50}" title="Only use alphabets and spaces" value="${studentName}" required>
                        (Please Enter it according your registered name, the capital Letter and small letter does matter, example:Jason Voo Teng Xing)
                    </div>

                    <div class="field half">
                        <label for="studentPassword">
                            Student Password
                        </label>
                        <input type="password" placeholder="Enter Password" name="studentpassword" pattern="[0-9a-zA-Z]{8,15}" required>
                        (minimum of 8 characters is required, and no space allow)
                    </div>

                    <div class="field half">
                        <label for="studentPhoneNo">
                            Phone No
                        </label>
                            <input type="text" placeholder="Enter Phone No" name="studentphoneno" title="Only use numbers, and the length should between be 9 to 12" pattern="[0-9]{9,12}" value="${studentPhoneNo}" required>
                    </div>

                    <div class="field half">
                        <label for="studentEmail">
                            Email
                        </label>
                        <input type="email" placeholder="Enter Email" name="studentemail" value="${studentEmail}" required>
                    </div>
                </div>
                <ul class="actions">
                    <li>
                        <input type="submit" value="Register" class="primary" />
                    </li>
                    <li>
                        <input type="reset" value="Reset" />
                    </li>
                </ul>

            </form>
            <ul class="links">
                <li><a href="StaffRegistration.html">Not a student?</li>
                <li><a href="index.html">Already have an account?</li>
            </ul>
        </article>
                      ${ID_NoExistMessage}
            <footer id="footer">
                <p class="copyright">&copy; 2019 All Rights Reserved.</p>
            </footer>
                        </div>
            <div id="bg"></div>
            <script src="assets/js/jquery.min.js"></script>
            <script src="assets/js/browser.min.js"></script>
            <script src="assets/js/breakpoints.min.js"></script>
            <script src="assets/js/util.js"></script>
            <script src="assets/js/main.js"></script>
    </body>
</html>