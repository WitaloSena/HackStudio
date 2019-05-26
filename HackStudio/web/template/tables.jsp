<%-- 
    Document   : tables
    Created on : 20/05/2019, 21:47:14
    Author     : witalo
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="br.com.hackstudio.model.Tatuador"%>
<%@page import="java.util.List"%>
<div class="container-fluid">

    <!-- Breadcrumbs-->
    <ol class="breadcrumb">
        <li class="breadcrumb-item">
            <a href="#">Dashboard</a>
        </li>
        <li class="breadcrumb-item active">Tatuadores</li>
    </ol>

    <!-- DataTables Example -->
    <div class="card mb-3">
        <!--
        <div class="card-header">
            <i class="fas fa-table"></i>
            Data Table Example
        </div> -->
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                        <tr>
                            <!-- <th>id</th> -->
                            <th>nome</th>
                            <th>email</th>     
                            <th>especialidade</th>
                        </tr>
                    </thead>            
                    <tbody>  
                        <%
                            List<Tatuador> tatuadores = (List) request.getAttribute("listaTatuadores");

                            // Percorre a lista dos registros e apresenta no navegador
                            for (Tatuador tatuador : tatuadores) {
                        %>

                        <tr>

                            <td><%=tatuador.getNome()%></td>
                            <td><%=tatuador.getEmail()%></td>
                            <td><%=tatuador.getEspecialidade()%></td>

                            <td><a class="btn btn-primary" href="tatuadores?acao=agendamento&id=<%=tatuador.getId()%>">Agendamentos</a></td>
                           <td><a class="btn btn-info" href="tatuadores?acao=editar&id=<%=tatuador.getId()%>" role="button">Editar</a>
                            <td><a class="btn btn-danger" href="tatuadores?acao=excluir&id=<%=tatuador.getId()%>" role="button">Excluir</a>
                        </tr>
                        <%
                            } // Fim do laço de repetição
                        %>

                    </tbody>
                </table>
            </div>
        </div>
        <!-- <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div> -->
    </div>


</div>
<!-- /.container-fluid -->

