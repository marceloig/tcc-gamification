'use strict';
var appModule = angular.module('app', [ 'ngRoute' ]);

appModule.config([ '$routeProvider',
		function($routeProvider, $locationProvider) {
			// remove o # da url use the HTML5 History API
			// $locationProvider.html5Mode(true);
			$routeProvider.when('/', {
				templateUrl : 'login.html',
				controller : 'LoginController'
			}).when('/home', {
				templateUrl : 'home.html',
				controller : 'UsuarioController'
			}).when('/modulos', {
				templateUrl : 'modulos.html',
				controller : 'ModuloController'
			}).when('/cadastro', {
				templateUrl : 'cadastro.html',
				controller : 'CadastroController'
			}).when('/exercicio', {
				templateUrl : 'exercicios.html',
				controller : 'ExercicioController'
			}).when('/uml/exercicios', {
				templateUrl : 'uml/exercicios.html',
				controller : 'UmlController'
			}).when('/sair', {
				templateUrl : 'login.html',
				controller : 'LoginController'
			}).otherwise({
				redirectTo : '/'
			});

		} ]);

appModule.controller('LoginController', function($scope, $http, $location) {

	$scope.usuario = {
		"login" : "",
		"senha" : ""
	};
	$scope.mensagem = "";

	$scope.logarUsuario = function() {
		var data = $scope.usuario;
		$http.post('http://localhost:8080/TCC-GamificationJava/usuario/login',
				data).success(function(data) {
			var status = data;
			if (status == "ok") {
				// alert(status);
				$location.path('/home');
				$location.replace();
			} else {
				$scope.mensagem = data;
			}

		});
	};
});

appModule.controller('UsuarioController', function($scope, $http) {
	$http.get('http://localhost:8080/TCC-GamificationJava/usuario/get')
			.success(function(data) {
				$scope.usuario = data;
			});

	$http.get('http://localhost:8080/TCC-GamificationJava/usuario/listByPontuacao')
				.success(function(data) {
					$scope.usuariosTop = data;
				});	
	$http.get('http://localhost:8080/TCC-GamificationJava/usuario/listByClassificacao')
				.success(function(data) {
					$scope.usuariosClassificacao = data;
	});	
	
});

appModule.controller('ModuloController', function($scope, $http) {
	$http.get('http://localhost:8080/TCC-GamificationJava/modulos/get')
			.success(function(data) {
				$scope.modulos = data;
			});
});

appModule.controller('ExercicioController', function($scope) {
	$scope.titulo = "Exercicio Olá Mundo";
	$scope.descricao = "Escreva Olá Mundo!";

});

appModule.controller('CadastroController', function($scope, $http) {
	$scope.usuario = {
		"nome" : "",
		"login" : "",
		"senha" : ""
	};
	$scope.mensagem = "";
	$scope.status = "";

	$scope.cadastrarUsuario = function() {
		var data = $scope.usuario;
		$http.post('http://localhost:8080/TCC-GamificationJava/usuario/post',
				data).success(function(data) {
			var cadastro = data;
			if (cadastro == "true") {
				$scope.mensagem = "Cadastrado com sucesso";
				$scope.status = "success";

			} else {
				$scope.mensagem = "Usuário já existe";
				$scope.status = "warning";
			}
			// $scope.mensagem = data;
		});
	};

});

appModule.controller('CodigoController', function($scope, $http) {

	// $scope.retorno = {mensagem: ">>"};
	var codigo = "System.out.println(pá);";
	var editor = ace.edit("editor");
	editor.setTheme("ace/theme/eclipse");
	editor.getSession().setMode("ace/mode/java");

	editor.setValue(codigo);

	$scope.resposta = "";
	$scope.enviarExercicio = function() {
		codigo = editor.getSession().getValue();
		$scope.resposta = {
			"codigo" : codigo
		};

		var data = $scope.resposta;
		$http.post('http://localhost:8080/TCC-GamificationJava/java/exercicio/post', data)
				.success(function(data) {
					// $scope.retorno = data;
					var retornoResposta = {"retorno" : data};
					console.log(retornoResposta);
					alert(retornoResposta);
					
				});
	};

});

appModule.controller('UmlController', function($scope, $http, $location) {
	
	$scope.exercicio = null;
	$scope.alternativa = null;
	$scope.resposta = "";	
	$scope.respostaUml = "";
	
	$http.get('http://localhost:8080/TCC-GamificationJava/java/exercicio/get')
	.success(function(data) {
		$scope.exercicio = data;
		$scope.alternativa = data.alternativas;
	});
	
	$scope.enviarResposta = function() {
		$scope.respostaUml = {
				"resposta" : $scope.resposta
			};
		var data = $scope.respostaUml;
		
		$http.post('http://localhost:8080/TCC-GamificationJava/uml/exercicio/post', data)
				.success(function(data) {
					$scope.retorno = data;
					
				});
	};
});
