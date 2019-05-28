<%-- 
    Document   : cadastrar-produto
    Created on : 27/05/2019, 17:27:19
    Author     : witalo
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

    <body class="bg-dark">
        <div class="container">
            <div class="card card-register mx-auto mt-5 ">
                <div class="card-header">Cadastrar Produto</div>
                <div class="card-body">
                    <form action="estoque" method="post" >
                        <div class="form-group">
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-8">
                                    <div class="form-label-group">
                                        <input type="text" id="inputNome" name="nome" class="form-control" placeholder="Nome" required="required">
                                        <label for="inputNome">Nome</label>
                                    </div>
                                </div>
                            </div>
                        </div> 
                            <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-8">
                                    <div class="form-label-group">
                                        <input type="text" id="inputSobrenome" name="quantidade" class="form-control" placeholder="quantidade" required="required">
                                        <label for="inputSobrenome">Quantidade</label>
                                    </div>
                                </div>
                            </div>
                        </div> 
                            <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-8">
                                    <div class="form-label-group">
                                        <input type="number" id="inputEmail" name="valor" class="form-control" placeholder="Valor" required="required">
                                        <label for="inputEmail">valor</label>
                                    </div>
                                </div>
                            </div>
                        </div>                
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-8">
                                    <button type="submit" class="btn btn-primary btn-block" name="acao" value="cadastrar">Registrar</button> 
                                </div>
                            </div>
                        </div>                         
                    </form>               
                </div>
            </div>
        </div>

        <!-- Bootstrap core JavaScript-->
        <script src="template/vendor/jquery/jquery.min.js"></script>
        <script src="template/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="template/vendor/jquery-easing/jquery.easing.min.js"></script>

    </body>

</html>
