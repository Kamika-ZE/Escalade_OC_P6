<%@ page pageEncoding="UTF-8"%>

<%@include file="_include/head.jsp"%>


<main class="page guidebookList-page">
    <section class="clean-block clean-services dark">
        <div class="container">
            <div class="block-heading">
                <h2 class="text-info">Chercher un Topo</h2>
                <select class="mdb-select md-form colorful-select dropdown-primary" multiple searchable="Search here..">
                    <option value="" disabled selected>Choose your country</option>
                    <option value="1">USA</option>
                    <option value="2">Germany</option>
                    <option value="3">France</option>
                    <option value="3">Poland</option>
                    <option value="3">Japan</option>
                </select>
                <label class="mdb-main-label">Label example</label>

                <select class="mdb-select" multiple searchable="Search here..">
                    <optgroup label="team 1">
                        <option value="1">Option 1</option>
                        <option value="2">Option 2</option>
                    </optgroup>
                    <optgroup label="team 2">
                        <option value="3">Option 3</option>
                        <option value="4">Option 4</option>
                    </optgroup>
                </select>
            </div>
            <div class="row">
                <c:forEach items="${guidebookList}" var="guidebook" >
                    <div class="col-md-6 col-lg-4">
                        <div class="card"><img class="card-img-top w-100 d-block" src="<c:url value="/resources/img/image5.jpg"/>">
                            <div class="card-body">
                                <h4 class="card-title">${guidebook.name}</h4>
                                <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc quam urna, dignissim nec auctor in.</p>
                            </div>
                            <div>
                                <button class="btn btn-outline-primary btn-sm" type="button">
                                    <a href="<c:url value="/guidebook/${guidebook.id}"/>">Voir</a>
                                </button>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </section>
</main>

<%@include file="_include/footer.jsp"%>
