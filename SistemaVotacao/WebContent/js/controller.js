var crudVotacao = angular.module('crudVotacao', ["ngResource"]);

crudVotacao.controller("VotacaoController", ["$resource", "$scope","$http",  function($resource, $scope,$http) {
	
	var angularResource = $resource("/SistemaVotacao/ws/votacao");
	var angularResourceListaRestaurnate = $resource("/SistemaVotacao/ws/votacao/listarTodosRestaurantes");
	var angularResourceListaVotacao = $resource("/SistemaVotacao/ws/votacao/listarVotacao");
	
	var angularResourceVotar = $resource("/SistemaVotacao/ws/votacao/votar");
	var angularResourceLogar = $resource("/SistemaVotacao/ws/votacao/logar/");
	
	var angularResourceParam = $resource("/SistemaVotacao/ws/votacao/:idUsuario", {idUsuario : "@idUsuario"});
	
	$scope.usuarios = angularResource.query(function(){});
	$scope.restaurantes = angularResourceListaRestaurnate.query(function(){});
	
	
	$scope.usuario;
	$scope.restaurante;
	
	$scope.usuarioLogado = false;
	$scope.formVotacao = true;
	$scope.formResultado = true;
	
	$scope.logar = function() {
	 if($scope.usuario) {
		var newResource = new angularResourceLogar($scope.usuario);
		newResource.$save(function(){
			//$scope.usuarios.push(newResource);
			$scope.usuarioLogado = true;
			$scope.formVotacao = false;
		});
		
		  }
	}
	
	$scope.resultListnner = function() {
		var d = new Date();
		
//		$scope.formResultado = false;
//		$scope.listaVotacao = angularResourceListaVotacao.query(function(){});
		
		if(((d.getHours() == 11)&&(d.getMinutes()==30)) &&(d.getHours() < 13 )){
			$scope.listaVotacao = angularResourceListaVotacao.query(function(){});
			$scope.formResultado = false;
		}else{
			alert("O resultado será exibito a partir das 11:30.\n E ficará disponivel até as 12 hrs");
		}
	};
	
	$scope.closeResult = function() {
		 
		$scope.formResultado = true;
	};
	
	$scope.votar = function() {
		
		if($scope.restaurante){	
			$http.post('/SistemaVotacao/ws/votacao/votar', $scope.restaurante)
			.success(function(data) {
				//console.log("Sucesso: " + data);
				alert(data.msg);
			})
			.error(function() {
				//console.log("Erro: " + data);
				alert("Falha do app ");
				});
			}
		};

	$scope.logout = function() {
		$scope.usuarioLogado = false;
		$scope.formVotacao = true;
		$scope.novo();
		
	};
	
	$scope.novo = function () { 
		$scope.usuario = "";
		$scope.restaurante = "";
	}; 	
	
}])