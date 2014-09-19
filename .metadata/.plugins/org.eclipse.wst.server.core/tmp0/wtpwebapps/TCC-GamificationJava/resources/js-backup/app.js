'use strict';
var appModule = angular.module('app', [ 'ngRoute' ]);

appModule.factory('Usuario', function () {

    var data = {
        login: "",
        pontos: 0
    };

    return {
        getLogin: function () {
            return data.login;
        },
        setLogin: function (login) {
            data.login = login;
        },
        getPontos: function () {
            return data.pontos;
        },
        setPontos: function (pontos) {
            data.pontos = pontos;
        }
    };
});

appModule.controller('LoginController', function ($rootScope, $scope, $http, $location, Usuario) {
	$rootScope.activetab = $location.path();
    $scope.usuario = {
        "login": "",
        "senha": ""
    };
    $scope.mensagem = "";

    $scope.logarUsuario = function () {
        var data = $scope.usuario;
        $http.post('http://localhost:8080/TCC-GamificationJava/usuario/login',
            data).success(function (data) {
                var status = data;
                if (status == "true") {
                    Usuario.setLogin($scope.usuario.login);
                    Usuario.setPontos($scope.usuario.senha);
                    $location.path('/home');
                    $location.replace();
                } else {
                    $scope.mensagem = "Usuário ou senha incorreto";
                    console.log(data.$resolved);
                }

            });
    };
});

appModule.controller('UsuarioController', function ($rootScope, $location, $scope, $http, Usuario) {
	$rootScope.activetab = $location.path();
	$scope.pontuacao = 0;
    var usuarioLogin = {
        "login": Usuario.getLogin(),
        "pontos": 0
    };

    $http.get('http://localhost:8080/TCC-GamificationJava/usuario/listClassificacao')
        .success(function (data) {
            $scope.usuariosTop = data;
        });

    $http.post('http://localhost:8080/TCC-GamificationJava/usuario/get', usuarioLogin)
        .success(function (data) {
            $scope.usuario = data;
            usuarioLogin.pontos = $scope.usuario.pontos;
        });

});

appModule.controller('ModuloController', function ($rootScope, $location, $scope, $http) {
	$rootScope.activetab = $location.path();
    $http.get('http://localhost:8080/TCC-GamificationJava/modulos/get')
        .success(function (data) {
            $scope.modulos = data;
        });
    
});

appModule.controller('CadastroController', function ($scope, $http) {
    $scope.usuario = {
        "nome": "",
        "login": "",
        "senha": ""
    };
    $scope.mensagem = "";
    $scope.status = "";

    $scope.cadastrarUsuario = function () {
        var data = $scope.usuario;
        $http.post('http://localhost:8080/TCC-GamificationJava/usuario/post',
            data).success(function (data) {
                var cadastro = data;
                if (cadastro == "true") {
                    $scope.mensagem = "Cadastrado com sucesso";
                    $scope.status = "success";

                } else {
                    $scope.mensagem = "Usuário já existe";
                    $scope.status = "warning";
                }

            });
    };

});

