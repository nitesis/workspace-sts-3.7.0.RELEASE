angular.module('flashcard').controller('QuestionnaireController', ['QuestionnaireRepository', '$uibModal', function(QuestionnaireRepository, $uibModal) {
	this.mytitle = '';

	this.questionnaires = QuestionnaireRepository.getAll();
	
	this.add = function() {
		QuestionnaireRepository.add(this.mytitle);
		this.mytitle = '';
	};
	
	this.remove = function(id) {
		QuestionnaireRepository.remove(id);
	};
	
	this.openModal = function () {

	    var modalInstance = $uibModal.open({
	      
	      templateUrl: 'questionnaire/createDialog.html',
	      controller: 'QuestionnaireDetailDialogController as dialog'
	    });
	    modalInstance.result.then(function(questionnaire) {
	    	QuestionnaireRepository.save(questionnaire);
	    }, function (error) {
	    	// to do
	    });
	};
	   

}]);

'use strict';

angular.module('flashcard').controller('QuestionnaireDetailDialogController', ['$uibModalInstance', function($uibModalInstance) {
	//initialize questionnaire
	var questionnaire = {
			title: null,
			description: null,
	};
	
	this.questionnaire = questionnaire;
	this.ok = function() {
		$uibModalInstance.close(questionnaire);
	};
	
	this.cancel = function() {
		$uibModalInstance.dismiss('cancel');
	}
}])