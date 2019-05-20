<%@include file="template/header.jsp" %>
<!-- Painel de Mensagem -->

<%@include file="template/main.jsp" %>


<div class="container col-md-6 col-md-offset-3">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title h1">Mensagem</h3>
        </div>
        <div class="panel-body text-justify">
            <h4>
                <!-- A linha abaixo apresenta a mensagem gerada no Controle -->
                <%out.print(request.getAttribute("mensagem"));%>
            </h4>
        </div>
    </div>
</div>
<%@include file="template/footer.jsp" %>                   


