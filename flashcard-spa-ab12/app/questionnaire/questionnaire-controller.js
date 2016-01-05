'use strict';

angular.module('flashcard').controller('QuestionnaireController', 
		['QuestionnaireNetworkService', '$uibModal', '$location', function(QuestionnaireNetworkService, $uibModal, $location) {
//	vm = ViewModel -> geht nur über so eine Variable
			var vm = this;
			this.mytitle = '';

			// QuestionnaireNetworkService returns promises!
			var getAll = function() {
				QuestionnaireNetworkService.getAll()
				.success(function(data, status, headers, config) {
					vm.questionnaires = data;
				})
				.error(function(data, status, headers, config) {
					console.log(data);
				});
			};
//			call server to retrieve all questionnaires
			getAll();
	
			this.remove = function(id) {
				QuestionnaireNetworkService.remove(id)
				.success(function(data, status, headers, config) {
					console.log(data);
					getAll();
				})
				.error(function(data, status, headers, config) {
					console.log(data);
				});
			};
			
			
//	this.add = function() {
//		QuestionnaireNetworkService.add(this.mytitle);
//		this.mytitle = '';
//	};
	
	
	
	this.show = function(id) {
		var url = '/show/' + id;
		$location.path(url);
	};
	
	this.edit = function(id) {
		var url = '/update/' + id;
		$location.path(url);
	};		
	
	this.go = function (path) {
		$location.path(path);
	};
	
	// Put function openModal() into the controller as an alternative to add()
	this.openCreateModalDialog = function() {
		var modalInstance = $uibModal.open({
		      templateUrl: 'questionnaire/overlays/createDialog.html',
		      controller: 'QuestionnaireDetailDialogController as dialog'
		    });

		modalInstance.result.then(function (questionnaire) {
			QuestionnaireNetworkService.save(questionnaire)
			.success (function(data, status, headers, config) {
				console.log(data);
				getAll();
			})
			.error(function(data, status, headers, config) {
				console.log(data);
			});
		}, function (error) {		
			// something went wrong! That's real life ;-);
		});		
	};	
	
	// Example using modal dialog if questionnaire is given. Not activated!
	// To activate this feature uncomment entry in questionnaire/listelement/listelement.html
	this.openUpdateModalDialog = function(id) {
		var modalInstance = $uibModal.open({
		      templateUrl: 'questionnaire/overlays/createDialog.html',
		      controller: 'QuestionnaireDetailUpdateDialogController as dialog',
		      resolve: {
		    	  questionnaire: function() {
		    		  // Read questionnaire to be updated
		    		  return QuestionnaireRepository.getById(id);
		    	  }
		      }
		    });

		modalInstance.result.then(function (questionnaire) {
			// Save updated questionnaire
			QuestionnaireNetworkService.update(questionnaire);
		}, function (error) {		
			// something went wrong!;
		});		
	};
}]);

'use strict';

angular.module('flashcard').controller('QuestionnaireDetailDialogController', 
		[ '$uibModalInstance', function($uibModalInstance) {
	// initialize questionnaire
	var questionnaire = {
		title: null,
		description: null
	};
	
	this.questionnaire = questionnaire;
	this.ok = function() {
		$uibModalInstance.close(questionnaire);
	};

	this.cancel = function() {
		$uibModalInstance.dismiss();
	};
}]);


angular.module('flashcard').controller('QuestionnaireCreateController', 
		[ '$location', 'QuestionnaireRepository', function($location, QuestionnaireRepository) {
	// initialize questionnaire
    var questionnaire = {
    		title: null,
    		description: null
	};
    
    this.questionnaire = questionnaire;
	
	this.save = function() {
		QuestionnaireRepository.save(questionnaire);
		$location.path('/');
	};

	this.cancel = function() {
		$location.path('/');		
	};
}]);

angular.module('flashcard').controller('QuestionnaireUpdateController', 
		[ '$location', '$route', 'QuestionnaireNetworkService', function($location, $route, QuestionnaireNetworkService) {
	
	var vm = this;
	
	// 'params.id' is a string -> convert it to a number!
	var id = parseInt($route.current.params.id);
	this.questionnaire = QuestionnaireNetworkService.getById(id)
	.success(function(data, status, headers, config) {
		vm.questionnaire = data;
	})
	.error(function(data, status, headers, config) {
		console.log(data);
	});

	this.save = function() {
//		QuestionnaireRepository.update(this.questionnaire);
		QuestionnaireNetworkService.update(vm.questionnaire)
		.success(function(data, status, headers, config) {
			console.log(data);
			$location.path('/');
		})
		.error(function(data, status, headers, config) {
			console.log(data);
			$location.path('/');
		});		
	};

	this.cancel = function() {
		$location.path('/');		
	};
}]);

angular.module('flashcard').controller('QuestionnaireShowController', 
		[ '$location', '$route', 'QuestionnaireRepository', function($location, $route, QuestionnaireNetworkService) {
	
	var vm = this;		
	// 'params.id' is a string -> convert it to a number!
    var id = parseInt($route.current.params.id);
    this.questionnaire = QuestionnaireNetworkService.getById(id)
    .success(function(data, status, headers, config) {
    	vm.questionnaire = data;
    })
    .error(function(data, status, headers, config) {
    	console.log(data);
    });

	this.back = function() {
		$location.path('/');		
	};
}]);

