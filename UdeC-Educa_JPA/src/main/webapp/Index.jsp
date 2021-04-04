    <%-- 
    Document   : Index
    Created on : 24/03/2021, 1:30:23 a. m.
    Author     : UdeC-Educa Dev's Team
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.udeceduca.controllers.DataController"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <script
      src="https://kit.fontawesome.com/64d58efce2.js"
      crossorigin="anonymous"
    ></script>
    <link rel="shortcut icon" href="public/images/udec-educa-icon.png" />
    <link rel="stylesheet" href="css/style.css" />
    <script async src="https://www.google.com/recaptcha/api.js"></script>
    <title>UdeC-Educa</title>
  </head>
  <body>
    <div class="container">
      <div class="forms-container">
        <div class="signin-signup">
            <form action="DataController" method="POST" class="sign-in-form">
            <h2 class="title">Ingreso</h2>
            <p><font color="red">${errorMessage}</font></p>
            <br>
            <div class="input-field-log">
              <i class="fas fa-user"></i>
              <input type="text" placeholder="Usuario" name="username" required/>
            </div>
            <div class="input-field-log">
              <i class="fas fa-lock"></i>
              <input type="password" placeholder="Contraseña" name="password" required/>
            </div>
            <div class="g-recaptcha" data-sitekey="6LcUA4YaAAAAAD46eZN6pJc5sbVo81mFoZ0FCKS3" name="g-recaptcha-response"></div>
            </br>
            <input type="submit" value="Ingresar" class="btn solid" />
            <!-- <p class="social-text">O ingresa con</p>
            <div class="social-media">
              <a href="#" class="social-icon">
                <i class="fab fa-facebook-f"></i>
              </a>
              <a href="#" class="social-icon">
                <i class="fab fa-google"></i>
              </a>
             </div> -->
          </form>
          <form action="UserController" method="POST" class="sign-up-form">
            <h2 class="title">Registrate</h2>
            <p><font color="red">${errorMessageRegister}</font></p>
            <div class="input-field">
              <i class="fas fa-user"></i>
              <input type="text" placeholder="Primer Nombre" name="firstName" required/>
            </div>
            <div class="input-field">
              <i class="fas fa-user"></i>
              <input type="text" placeholder="Segundo Nombre" name="secondName"/>
            </div>
            <div class="input-field">
              <i class="fas fa-user"></i>
              <input type="text" placeholder="Primer Apellido" name="firstLast" required/>
            </div>
            <div class="input-field">
              <i class="fas fa-user"></i>
              <input type="text" placeholder="Segundo Apellido" name="secondLast"/>
            </div>
            <div class="input-field">
              <i class="fas fa-user"></i>
              <input type="text" placeholder="Identificación" name="identification" required/>
            </div>
            <!-- <div class="input-field">
              <i class="fas fa-user"></i>
              <input type="text" placeholder="Fecha nacimiento" required/>
            </div> -->
            <div class="input-field">
              <i class="fas fa-envelope"></i>
              <input type="text" placeholder="correo" name="email" required />
            </div>
            <div class="input-field">
              <i class="fas fa-lock"></i>
              <input type="password" placeholder="Contraseña" name="password" required/>
            </div>
            <input type="submit" class="btn" value="Registrarse" />
            <!-- <p class="social-text">O Registrate con</p>
            <div class="social-media">
              <a href="#" class="social-icon">
                <i class="fab fa-facebook-f"></i>
              </a>
              <a href="#" class="social-icon">
                <i class="fab fa-google"></i>
              </a>
            </div> -->
          </form>
        </div>
      </div>

      <div class="panels-container">
        <div class="panel left-panel">
          <div class="content">
            <h3>¿Eres nuevo?</h3>
            <p>
              Registrate y disfruta de esta aplicación
            </p>
            <button class="btn transparent" id="sign-up-btn">
              Registrate
            </button>
          </div>
          <img src="../img/logg.svg" class="image" alt="" />
        </div>
        <div class="panel right-panel">
          <div class="content">
              <h3>¿Ya tienes cuenta!</h3>
            <p>
              ¿Qué esperas? Ingresa ahora y disfruta de nuestra plataforma.
            </p>
            <button class="btn transparent" id="sign-in-btn">
              Ingresar
            </button>
          </div>
          <img src="img/reg.svg" class="image" alt="" />
        </div>
      </div>
    </div>

    <script src="js/app.js"></script>
  </body>
</html>


