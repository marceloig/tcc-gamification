$app = angular.module('app', [ 'ngResource' ]);

// function Usuario($scope, $http) {
// $http.get('http://localhost:8080/tcc/usuario').success(function(data) {
// $scope.usuario = data;
// });
// }

function Usuario($scope, $resource) {

	var usuario = $resource('http://localhost:8080/tcc/usuario');
	$scope.usuario = usuario.get();

}

function ExercicioController($scope, $resource) {

}

function CodigoController($scope, $http) {
	$scope.codigo = "System.out.println( );";
	$scope.reposta;
	$scope.enviarExercicio = function() {
		$scope.reposta = {
			"codigo" : $scope.codigo
		};
		
		var data = $scope.reposta;

		$http.post('http://localhost:8080/tcc/codigo00', data).success(
				function(data) {
					console.log(data.mensagem);
					$scope.respostaConsole = data.mensagem;
				});
	};
}

