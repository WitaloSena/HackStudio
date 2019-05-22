<%-- 
    Document   : novo-tatuador
    Created on : 21/05/2019, 12:18:56
    Author     : witalo.sena
--%>

<!DOCTYPE html>
<html lang="pt-br">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>HackStudio</title>

        <!-- Custom fonts for this template-->
        <link href="template/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

        <!-- Custom styles for this template-->
        <link href="template/css/sb-admin.css" rel="stylesheet">
        <link rel="stylesheet" href="template/scss/_login.scss" type="text/css"/>


    </head>
    
    <%@include file="template/header.jsp" %>
    <%@include file="template/main.jsp" %>

    <body class="bg-dark">
        <div class="container pb-5">
            <div class="card card-register mx-auto mt-2 ">
                <div class="card-header">Registrar novo Tatuador</div>
                <div class="card-body">
                    <form action="tatuadores" method="post">
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-12">
                                    <div class="form-label-group">
                                        <input type="text" id="firstName" name="nome" class="form-control" placeholder="First name" required="required" autofocus="autofocus">
                                        <label for="firstName">Nome</label>
                                    </div>
                                </div>                        
                            </div>
                        </div> 
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-6">
                                    <div class="form-label-group">
                                        <input type="email" id="inputEmail" name="email" class="form-control" placeholder="Email" required="required">
                                        <label for="inputEmail">Email</label>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-label-group">
                                        <input type="text" id="cpf" name="cpf" class="form-control" placeholder="cpf" required="required">
                                        <label for="cpf">CPF</label>
                                    </div>

                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-9 pb-3">
                                    <div class="form-label-group">
                                        <input type="text" name="endereco" id="endereço" class="form-control" placeholder="endereço" required="required">
                                        <label for="endereço">endereço</label>
                                    </div>
                                </div>                   
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-9">
                                    <div class="form-label-group">
                                        <input type="phone" id="telefone" name="telefone" class="form-control" placeholder="telefone" required="required">
                                        <label for="telefone">telefone</label>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-9">
                                    <div class="form-label-group">
                                        <input type="text" id="especialidade" name="especialidade" class="form-control" placeholder="especialidade" required="required">
                                        <label for="especialidade">Especialidade</label>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-8">
                                    <div class="form-label-group">
                                        <input type="text" id="facebook" name="facebook" class="form-control" placeholder="facebook" required="required">
                                        <label for="facebook">facebook</label>
                                    </div>

                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-8">
                                    <div class="form-label-group">
                                        <input type="text" id="instagram" name="instagram" class="form-control" placeholder="intagram" required="required">
                                        <label for="instagram">instagram</label>
                                    </div>

                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-12">
                                    <button type="submit" class="btn btn-primary btn-block" name="acao" value="cadastrar">Registrar</button> 
                                </div>                              
                            </div>
                        </div>                         
                    </form>                  
                </div>
            </div>
        </div>
        
        <%@include file="template/footer.jsp" %>

        <!-- Bootstrap core JavaScript-->
        <script src="template/vendor/jquery/jquery.min.js"></script>
        <script src="template/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="template/vendor/jquery-easing/jquery.easing.min.js"></script>

    </body>

</html>
