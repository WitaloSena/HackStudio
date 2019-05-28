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

                            for (Tatuador tatuador : tatuadores) {
                        %>

                        <tr>
                            <td><%=tatuador.getNome()%></td>
                            <td><%=tatuador.getEmail()%></td>
                            <td><%=tatuador.getEspecialidade()%></td>

                            <td><a class="btn btn-primary"  data-toggle="modal" data-target="#ModalLongoExemplo" href="">Agendamentos</a></td>
                            <td><a class="btn btn-info" href="tatuadores?acao=editar&id=<%=tatuador.getId()%>" role="button">Editar</a>
                            <td><a class="btn btn-danger" href="tatuadores?acao=excluir&id=<%=tatuador.getId()%>" role="button">Excluir</a>
                        </tr>
                    </tbody>
                </table>
                <%
                    } // Fim do laço de repetição
                %>
            </div>
        </div>
        <!-- <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div> -->
    </div>
</div>
            
            <!-- Modal -->
<div class="modal fade" id="ModalLongoExemplo" tabindex="-1" role="dialog" aria-labelledby="TituloModalLongoExemplo" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="TituloModalLongoExemplo">Agendamentos</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          <p>Não há agendamentos disponíveis</p>
        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
        <!--<button type="button" class="btn btn-primary">Salvar mudanças</button> -->
      </div>
    </div>
  </div>
</div>
<!-- /.container-fluid -->

