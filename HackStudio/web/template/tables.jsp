<%-- 
    Document   : tables
    Created on : 20/05/2019, 21:47:14
    Author     : witalo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.hackstudio.model.Tatuador"%>
<%@page import="java.util.List"%>
<div class="container-fluid">

    <!-- Breadcrumbs-->
    <ol class="breadcrumb">
        <li class="breadcrumb-item">
            <a href="#">Dashboard</a>
        </li>
        <li class="breadcrumb-item active">Tables</li>
    </ol>

    <!-- DataTables Example -->
    <div class="card mb-3">
        <div class="card-header">
            <i class="fas fa-table"></i>
            Data Table Example</div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                        <tr>
                            <th>id</th>
                            <th>nome</th>
                            <th>email</th>                         
                        </tr>
                    </thead>            
                    <tbody>  
                        <%
                            /**
                             * Cria uma lista para receber os registros do
                             * atributo listaPessoas originado do servlet
                             * Controle
                             */
                            List<Tatuador> tatuadors = (ArrayList) request.getAttribute("listaTatuadores");
                            System.out.println("work");

                            // Percorre a lista dos registros e apresenta no navegador
                            for (Tatuador t : tatuadors) {
                        %>

                        <tr>
                            <td><%=t.getId()%></td>
                            <td><%=t.getNome()%></td>
                            <td><%=t.getEmail()%></td>
                            <td><a href="Controle?acao=editar&id=<%=t.getId()%>"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span>&nbsp;Editar</a></td>
                            <td><a href="Controle?acao=excluir&id=<%=t.getId()%>"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span>&nbsp;Excluir</a></td>
                        </tr>
                        <%
                            } // Fim do laço de repetição
                        %>

                    </tbody>
                </table>
            </div>
        </div>
        <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
    </div>

    <p class="small text-center text-muted my-5">
        <em>More table examples coming soon...</em>
    </p>

</div>
<!-- /.container-fluid -->

