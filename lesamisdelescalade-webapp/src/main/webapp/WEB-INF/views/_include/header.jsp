<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>

<!-- Nav Bar displayed on all jsp -->
<nav class="navbar navbar-inverse " role="navigation">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand page-top" href="${pageContext.request.contextPath}/home">Les amis de l'escalade</a>
    </div>


    <!-- All elements on navbar -->
    <div class="collapse navbar-collapse">

        <!-- identification -->
        <ul class="nav navbar-nav navbar-right" >
            <li class="dropdown">

                <!-- if user is logged -->
                <c:if test="${!empty memberInBdd}"><p style="color:black;"><c:out value="${memberInBdd}"/>

                    <br><a href="${pageContext.request.contextPath}/memberSpace">Mon espace personnel</a><br>
                    <a href="${pageContext.request.contextPath}/logOut">Se deconnecter </a></p>
                </c:if>

                <!-- if user not logged -->
                <c:if test="${empty memberInBdd}">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">S'identifier <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li class="dropdown-header">Vous n'êtes pas identifié.</li>
                        <li><form class="navbar-form" method="post" action="${pageContext.request.contextPath}/logInTry" modelAttribute="member">
                            <input type="text" class="form-control" name="email" placeholder="email" /><br />
                            <input type="password" class="form-control" name="password" placeholder="Mot de passe"/>
                            <input type="submit" class="btn btn-primary btn-xs btn-block" /></form></li>
                        <li class="enable"><a href="${pageContext.request.contextPath}/signUp">Créer un compte...</a></li>
                    </ul>
                </c:if>
            </li>
        </ul>

    </div>
</nav>
