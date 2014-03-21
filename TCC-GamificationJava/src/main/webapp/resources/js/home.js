function Usuario($scope, $http) {
    $http.get('http://localhost:8080/tcc/usuario').
        success(function(data) {
            $scope.usuario = data;
        });
}