<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Guidebook Form</title>
    <%--<%@include file="_include/head.jsp"%>--%>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Association de fans d'escalade">
    <!-- CDN resources -->
    <%--
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    --%>

    <!-- Locales resources -->
    <script src="https://kit.fontawesome.com/c822637fde.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/styles.css"/>">
</head>
<body>
<div class="container">

    <!-- Body
    ================================================== -->

    <!-- display for see site to update-->


    <!-- form for update site -->
    <div>
        <h3>Topo</h3>

        <p></p>
        <form:form modelAttribute="guidebook" method="post" action="saveGuidebookProcess">
            <table>
                <tr>
                    <!-- display for "nomSite" -->
                    <td> Nom du site:* </td>
                    <td><form:input path="name" type="text" id="name" size="20" placeholder="obligatoire"  cssStyle=""/></td>
                    <td><form:errors path="name" cssClass="errors"/></td>
                </tr>
                <tr>
                    <!-- display for creation date -->
                    <td>Date du topo papier: </td>
                    <td><form:input path="addedDate" type="date" id="addedDate" size="20" placeholder="obligatoire" cssStyle=""/></td>
                    <td><form:errors path="addedDate" cssClass="errors"/></td>
                </tr>
                <tr>
                    <!-- display for "descriptionSite" -->
                    <td>Description:</td>
                    <td><form:input path="description" type="text" id="description" size="40" placeholder=""  cssStyle=""/></td>
                    <td><form:errors path="description" cssClass="errors"/></td>
                </tr>

            </table>
            <p></p>
            <p>(*) obligatoire</p>
            <p></p>
            <input type="submit" value="Envoyer">
        </form:form>
    </div>
</div>
<!-- jQuery -->
<script src="<c:url value="/resources/js/jquery-3.4.1.min.js"/>"></script>
<!-- Popper.js -->
<script src="<c:url value="/resources/js/popper.min.js"/>"></script>
<!-- Javascript de Bootstrap -->
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
</body>
</html>