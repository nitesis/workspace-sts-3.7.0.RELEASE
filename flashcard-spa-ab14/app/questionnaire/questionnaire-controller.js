'use strict';

angular.module('flashcard').controller('QuestionnaireController', 
		['QuestionnaireRepository', '$uibModal', '$location', function(QuestionnaireRepository, $uibModal, $location) {
	this.mytitle = '';

	this.questionnaires = QuestionnaireRepository.getAll();
	
	this.add = function() {
		QuestionnaireRepository.add(this.mytitle);
		this.mytitle = '';
	};
	
	this.remove = function(id) {
		QuestionnaireRepository.remove(id);
	};
	
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
			QuestionnaireRepository.save(questionnaire);
		}, function (error) {		
			// something went wrong!;
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
			QuestionnaireRepository.update(questionnaire);
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

angular.module('flashcard').controller('QuestionnaireDetailUpdateDialogController', 
		[ '$uibModalInstance', 'questionnaire', function($uibModalInstance, questionnaire) {
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
		[ '$location', '$route', 'QuestionnaireRepository', function($location, $route, QuestionnaireRepository) {
	// 'params.id' is a string -> convert it to a number!
	var id = parseInt($route.current.params.id);
	this.questionnaire = QuestionnaireRepository.getById(id);

	this.save = function() {
		QuestionnaireRepository.update(this.questionnaire);
		$location.path('/');
	};

	this.cancel = function() {
		$location.path('/');		
	};
}]);

angular.module('flashcard').controller('QuestionnaireShowController', 
		[ '$location', '$route', 'QuestionnaireRepository', function($location, $route, QuestionnaireRepository) {
	// 'params.id' is a string -> convert it to a number!
    var id = parseInt($route.current.params.id);
    this.questionnaire = QuestionnaireRepository.getById(id);

	this.back = function() {
		$location.path('/');		
	};
}]);

