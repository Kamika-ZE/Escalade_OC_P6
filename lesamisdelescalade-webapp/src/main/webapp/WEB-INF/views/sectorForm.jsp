

<%@include file="_include/head.jsp"%>


<main class="page sectorForm-page">
    <section class="clean-block clean-form dark">
        <div class="container">
            <div class="block-heading">
                <h2 class="text-login">Création d'un secteur</h2>
                <p>
                    <c:if test="${!empty errorMessage}">
                        <c:out value="${errorMessage}"/>
                    </c:if>
                </p>
            </div>
            <form:form modelAttribute="sector" method="post" action="saveSector/${climbId}">
                <div class="form-group">
                    <form:hidden path="climbingArea.id" value="${climbId}"/>
                    <form:errors path="climbingArea.id" cssClass="errors"/>
                </div>
                <div class="form-group">
                    <form:input path="name" type="text" cssClass="form-control item" placeholder="Nom de la voie" required="true" autofocus=""/>
                    <form:errors  path="name" cssClass="error"/>
                </div>
                <div class="form-group">
                    <form:input path="description" type="text" cssClass="form-control item" placeholder="Description de la voie" required="true" autofocus=""/>
                    <form:errors  path="description" cssClass="error"/>
                </div>
                <div class="form-group">
                    <form:button class="btn btn-primary btn-block" type="submit">Enregistrer</form:button>
                </div>
            </form:form>
        </div>
    </section>
</main>

<%@include file="_include/footer.jsp"%>
