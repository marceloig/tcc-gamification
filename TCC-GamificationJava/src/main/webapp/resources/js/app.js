$app = angular.module('app',['ngResource']);

//function Usuario($scope, $http) {
//	$http.get('http://localhost:8080/tcc/usuario').success(function(data) {
//		$scope.usuario = data;
//	});
//}

function Usuario($scope, $resource) {
	
	var usuario = $resource('http://localhost:8080/tcc/usuario');
	$scope.usuario = usuario.get();

}