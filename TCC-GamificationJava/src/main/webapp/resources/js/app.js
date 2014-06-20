var appModule = angular.module('app', []);

appModule.controller('UsuarioController', function($scope, $http) {
	$http.get('http://localhost:8080/tcc/usuario').success(function(data) {
		$scope.usuario = data;
	});
});

appModule.controller('ExercicioController', function($scope) {

});

appModule.controller('CodigoController', function($scope, $http) {

	//$scope.retorno = {mensagem: ">>"};
	var codigo = "System.out.println( );";
	var editor = ace.edit("editor");
	editor.setTheme("ace/theme/eclipse");
	editor.getSession().setMode("ace/mode/java");

	editor.setValue(codigo);

	$scope.reposta;
	$scope.enviarExercicio = function() {
		codigo = editor.getSession().getValue();
		$scope.reposta = {
			"codigo" : codigo
		};
		
		var data = $scope.reposta;
		$http.post('http://localhost:8080/tcc/codigo00', data)
				.success(function(data) {
					//$scope.retorno = data;
					$scope.retorno = data;
					console.log(data.mensagem);
					//alert(data.mensagem);
				});
	};
	
});
