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
                      <!--  <td><%=t.getId()%></td> -->
                            <td><%=t.getNome()%></td>
                            <td><%=t.getEmail()%></td>
                            <td><%=t.getEspecialidade()%></td>
                            <td><a class="btn btn-primary" href="Controller?acao=agendamento&id=<%=t.getId()%>" role="button">Agendamentos</a></td>
                            <td><a class="btn btn-info" href="Controller?acao=editar&id=<%=t.getId()%>" role="button">Editar</a>
                            <td><a class="btn btn-danger" href="Controller?acao=excluir&id=<%=t.getId()%>" role="button">Excluir</a>
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

