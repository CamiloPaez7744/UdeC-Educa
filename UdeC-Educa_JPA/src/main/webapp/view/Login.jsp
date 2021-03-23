<%-- 
    Document   : Login
    Created on : 23/03/2021, 12:52:37 a. m.
    Author     : UdeC-Educa Dev's Team
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" import="com.udeceduca.controllers.UserController"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>UdeC-Educa</title>
        <link rel="icon" href="../public/images/udec-educa-icon.png"
              type="image/icon type">
        <link rel="stylesheet" href="../css/bootstrap.min.css">
        <link rel="stylesheet" href="../css/own-style.css">

    </head>
    <body>

        <div id="login">
            <div class="mask" style="background-image: url('../public/images/ubate-front.jpg');">
                <div class="container ">
                    <div id="login-row"
                         class="row justify-content-center align-items-center">
                        <div id="login-column" class="col-md-6">


                            <div id="login-box" class="d-flex justify-content-center">
                                <form action="UserController" id="login-form" class="form-horizontal col-md-auto">

                                    <div class="row  d-flex justify-content-center">
                                        <img src="../public/images/udec-educa-logo.png"
                                             class="brand-logo img-fluid" alt="Responsive image">
                                    </div>

                                    <div class="form-group">
                                        <label for="exampleInputEmail1">Email address</label> <input
                                            type="email" class="form-control" id="exampleInputEmail1"
                                            aria-describedby="emailHelp" placeholder="Enter email">
                                        <small id="emailHelp" class="form-text text-muted">We'll
                                            never share your email with anyone else.</small>
                                    </div>
                                    <div class="form-group">
                                        <label for="exampleInputPassword1">Password</label> <input
                                            type="password" class="form-control" id="exampleInputPassword1"
                                            placeholder="Password">
                                    </div>
                                    <button type="submit" class="btn login_btn">Submit</button>
                                </form>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="../js/bootstrap.min.js"></script>
    </body>
</html>