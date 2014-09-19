'use strict';
var appController = angular.module('app');

appModule.factory('exercicios', function () {

    var data = {exercicios: {}, qtd: 0};
    
    return { 
    	getExercicios: function () {
        	return data.exercicios;
    	},
    	setExercicios: function (exercicios) {
        	data.exercicios = exercicios;
    	},
    	getQuantidade: function () {  		
    	    var x;
    	    for (x in data.exercicios) {
    	    	data.qtd =+ 1;
    	    }
        	return data.qtd;
    	},
    };
});

appModule.factory('resposta', function () {
	var data = {resposta: false, tentativas: 0, pontos: 0};

    return { 
    	verificarResposta: function (resposta, respostaCorreta) {
    		if (resposta === respostaCorreta) {
    			data.resposta = true;
    			return data.resposta;
    		}else{
    			return data.resposta;
    		}
    	},verificarTentativa: function (tentativa) {
    		if (tentativa !== 0) {
    			return data.tentativas = tentativa - 1;
    		}else{
    			return data.tentativas;
    		}
    	},verificarPontos: function (pontos) {
    		if (data.tentativas === 0 && pontos !== data.pontos) {
    			data.pontos = pontos - 20;
    			return data.pontos;
    		}else{
    			return data.pontos;
    		}
    	},
    };
});

appController.controller('JavaController', function ($scope, $http, usuario, exercicios, Modulo, Usuario) {

    var editor = ace.edit("editor");
    editor.setTheme("ace/theme/eclipse");
    editor.getSession().setMode("ace/mode/java");

    $scope.exercicioJava = {};
    var codigo = "";
    
    var exercicio = exercicios.getExercicios();
    var ex = exercicios.getQuantidade() - 1;
    Modulo.get({ modulo:'java', exercicio: exercicio[ex].id }, function(data) {
            $scope.exercicioJava = data;
            $scope.modulo = data.assunto.modulo;
            codigo = $scope.exercicioJava.codigoReferencia;
            editor.setValue(codigo);
        });

    $scope.enviarExercicio = function () {
        codigo = editor.getSession().getValue();
        Modulo.save({ modulo:'java', exercicio: exercicio[0].id }, {codigo: codigo}, function(data) {
                $scope.retornoJava = data;
                var retorno = data.resposta;
                var resposta = $scope.exercicioJava.respostaJava;
                $scope.mensagem = verificarResposta(retorno, resposta);
                $('#javaModal').modal();

            });
    };
    
    $scope.dica1 = {"status": true, "id": 1, "hidden": false};
    $scope.dica2 = {"status": true, "id": 2, "hidden": false};
    $scope.dica3 = {"status": true, "id": 3, "hidden": false};

    $scope.dicas = function (dica) {
        if (dica.status === true && dica.id === 1) {
            $scope.exercicioJava.pontos = $scope.exercicioJava.pontos - 10;
            $scope.dica1.status = false;
        }
        if (dica.status === true && dica.id === 2) {
            $scope.exercicioJava.pontos = $scope.exercicioJava.pontos - 10;
            $scope.dica2.status = false;
        }
        if (dica.status === true && dica.id === 3) {
            $scope.exercicioJava.pontos = $scope.exercicioJava.pontos - 10;
            $scope.dica3.status = false;
        }
    };
    function verificarResposta(retorno, resposta) {
        var mensagem = "";
        if (retorno === resposta) {
            mensagem = "Parabéns você acertou!";
            if ($scope.exercicioJava.tentativas == 0) {
                $scope.exercicioJava.pontos = $scope.exercicioJava.pontos - 20;
            }
           
            Usuario.update({login: usuario.getLogin()}, {pontos: $scope.exercicioJava.pontos}, function(data) {
                    console.log("Enviado");
                });
            console.log("Acertou!!!");
        } else {
            if ($scope.exercicioJava.tentativas !== 0) {
                $scope.exercicioJava.tentativas = $scope.exercicioJava.tentativas - 1;
            }
            mensagem = "Você errou, tente novamente";
            console.log("Errou!!!");
        }
        return mensagem;
    }

});

appController.controller('UmlController', function ($scope, usuario, Modulo, Usuario, exercicios) {

    $scope.resposta = "";
    $scope.respostaUml = {};
    var exercicio = exercicios.getExercicios();
    
    Modulo.get({ modulo:'uml', exercicio: exercicio[0].id }, function(data) {
    	$scope.exercicio = data;
    	$scope.alternativa = data.alternativas;
    	$scope.modulo = data.assunto.modulo;
    });

    $scope.enviarResposta = function () {
    	
        $scope.mensagem = verificarResposta($scope.resposta, $scope.exercicio.respostaUml);
        $('#umlModal').modal();

    };
    $scope.dica1 = {"status": true, "id": 1, "hidden": false};
    $scope.dica2 = {"status": true, "id": 2, "hidden": false};
    $scope.dica3 = {"status": true, "id": 3, "hidden": false};

    $scope.dicas = function (dica) {
        if (dica.status === true && dica.id === 1) {
            $scope.exercicioJava.pontos = $scope.exercicioJava.pontos - 10;
            $scope.dica1.status = false;
        }
        if (dica.status === true && dica.id === 2) {
            $scope.exercicioJava.pontos = $scope.exercicioJava.pontos - 10;
            $scope.dica2.status = false;
        }
        if (dica.status === true && dica.id === 3) {
            $scope.exercicioJava.pontos = $scope.exercicioJava.pontos - 10;
            $scope.dica3.status = false;
        }
    };

    function verificarResposta(resposta, respostaCorreta) {
        var mensagem = "";
        if (resposta === respostaCorreta) {
            mensagem = "Parabéns você acertou!";
            if ($scope.exercicio.tentativas == 0) {
                $scope.exercicio.pontos = $scope.exercicio.pontos - 20;
            }
            
            Usuario.update({login: usuario.getLogin()}, {pontos: $scope.exercicio.pontos}, function(data) {
            	console.log("Teste");
            });
        } else {
            if ($scope.exercicio.tentativas !== 0) {
                $scope.exercicio.tentativas = $scope.exercicio.tentativas - 1;
            }
            mensagem = "Que pena você errou! Tente novamente";
        }
        return mensagem;
    }
});