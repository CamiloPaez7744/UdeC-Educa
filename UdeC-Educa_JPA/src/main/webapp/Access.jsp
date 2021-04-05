<%-- 
    Document   : Access
    Created on : 24/03/2021, 1:26:44 p. m.
    Author     : UdeC-Educa Dev's Team
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="com.udeceduca.DAO.UserDAO"

        %>
<%UserDAO ud = (UserDAO) session.getAttribute("userSession");
    if (ud != null) {
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>UdeC-Ecuca</title>
        <link rel="shortcut icon" href="public/images/udec-educa-icon.png" />
        <link rel="stylesheet" href="css/estilos.css">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700,800&display=swap" rel="stylesheet">
    </head>

    <body>
        <header>
            <nav>
                <form action="CloseSession" method="post">
                    <button href="#">Inicio</button>
                    <button href="#">Eventos</button>
                    <button href="#">Nosotros</button>
                    <button type="submit" name="button" value="closeSession">cerrar sesion</button>
                </form>
            </nav>
            <section class="textos-header">
                <h1>UdeC-Educa</h1>
                <h2>Sigue tus sueños</h2>
            </section>
            <div class="wave" style="height: 150px; overflow: hidden;"><svg viewBox="0 0 500 150" preserveAspectRatio="none"
                                                                            style="height: 100%; width: 100%;">
                <path d="M0.00,49.98 C150.00,150.00 349.20,-50.00 500.00,49.98 L500.00,150.00 L0.00,150.00 Z"
                      style="stroke: none; fill: #fff;"></path>
                </svg></div>
        </header>
        <main>
            <section class="contenedor sobre-nosotros">
                <table>
                    <thead>
                    <th>Nombre de Evento</th>
                    </thead>
                    <tbody>
                    <c:forEach var="eventName" items="${eventList}">
                        <tr>
                            <td><c:out value="${eventName}"></c:out></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>                            

            </section>
            <section class="portafolio">
                <div class="contenedor">
                    <h2 class="titulo">Portafolio</h2>
                    <div class="galeria-port">
                        <div class="imagen-port">
                            <img src="img/img1.jpg" alt="">
                            <div class="hover-galeria">
                                <img src="img/icono1.png" alt="">
                                <p>Nuestro trabajo</p>
                            </div>
                        </div>
                        <div class="imagen-port">
                            <img src="img/img2.jpg" alt="">
                            <div class="hover-galeria">
                                <img src="img/icono1.png" alt="">
                                <p>Nuestro trabajo</p>
                            </div>
                        </div>
                        <div class="imagen-port">
                            <img src="img/img3.jpg" alt="">
                            <div class="hover-galeria">
                                <img src="img/icono1.png" alt="">
                                <p>Nuestro trabajo</p>
                            </div>
                        </div>
                        <div class="imagen-port">
                            <img src="img/img1.jpg" alt="">
                            <div class="hover-galeria">
                                <img src="img/icono1.png" alt="">
                                <p>Nuestro trabajo</p>
                            </div>
                        </div>
                        <div class="imagen-port">
                            <img src="img/img4.jpg" alt="">
                            <div class="hover-galeria">
                                <img src="img/icono1.png" alt="">
                                <p>Nuestro trabajo</p>
                            </div>
                        </div>
                        <div class="imagen-port">
                            <img src="img/img5.jpg" alt="">
                            <div class="hover-galeria">
                                <img src="img/icono1.png" alt="">
                                <p>Nuestro trabajo</p>
                            </div>
                        </div>
                        <div class="imagen-port">
                            <img src="img/img6.jpg" alt="">
                            <div class="hover-galeria">
                                <img src="img/icono1.png" alt="">
                                <p>Nuestro trabajo</p>
                            </div>
                        </div>
                        <div class="imagen-port">
                            <img src="img/img7.jpg" alt="">
                            <div class="hover-galeria">
                                <img src="img/icono1.png" alt="">
                                <p>Nuestro trabajo</p>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <section class="clientes contenedor">
                <h2 class="titulo">Que dicen nuestros clientes</h2>
                <div class="cards">
                    <div class="card">
                        <img src="img/face1.jpg" alt="">
                        <div class="contenido-texto-card">
                            <h4>Name</h4>
                            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Vitae, sapiente!</p>
                        </div>
                    </div>
                    <div class="card">
                        <img src="img/face2.jpg" alt="">
                        <div class="contenido-texto-card">
                            <h4>Name</h4>
                            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Vitae, sapiente!</p>
                        </div>
                    </div>
                </div>
            </section>
            <section class="about-services">
                <div class="contenedor">
                    <h2 class="titulo">Nuestros servicios</h2>
                    <div class="servicio-cont">
                        <div class="servicio-ind">
                            <img src="img/ilustracion1.svg" alt="">
                            <h3>Name</h3>
                            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Labore, qui?</p>
                        </div>
                        <div class="servicio-ind">
                            <img src="img/ilustracion4.svg" alt="">
                            <h3>Name</h3>
                            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Labore, qui?</p>
                        </div>
                        <div class="servicio-ind">
                            <img src="img/ilustracion3.svg" alt="">
                            <h3>Name</h3>
                            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Labore, qui?</p>
                        </div>
                    </div>
                </div>
            </section>
        </main>
        <footer>
            <div class="contenedor-footer">
                <div class="content-foo">
                    <h4>Phone</h4>
                    <p>8296312</p>
                </div>
                <div class="content-foo">
                    <h4>Email</h4>
                    <p>8296312</p>
                </div>
                <div class="content-foo">
                    <h4>Location</h4>
                    <p>8296312</p>
                </div>
            </div>
            <h2 class="titulo-final">&copy; UdeC-Educa</h2>
        </footer>
    </body>

</html>
<%
    } else {
        request.setAttribute("errorMessage", "Ingrese sus credenciales");
        request.getRequestDispatcher("Index.jsp").forward(request, response);
    }
%>