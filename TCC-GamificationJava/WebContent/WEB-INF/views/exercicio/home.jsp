<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

<title>Exercicio</title>

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<script src="resources/js/angular.min.js"></script>
<script src="resources/js/app.js"></script>


<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<form action="salvarExercicio" method="post">
					<div class="form-group">
						<label for="Nome">Nome</label> <input
							type="text" class="form-control" name="nome">
					</div>
					<button type="submit" class="btn btn-default">Salvar</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>