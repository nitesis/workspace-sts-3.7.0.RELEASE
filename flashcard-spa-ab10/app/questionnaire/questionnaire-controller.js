/**
 * 
 */
angular.module('flashcard').controller('QuestionnaireController', ['QuestionnaireRepository', function(QuestionnaireRepository){
		
		this.mytitle ='Huhu...!';

		//Das macht globalen Zugriff möglich
		this.quest = QuestionnaireRepository.getAll();	
		
		this.add = function() {
			QuestionnaireRepository.add(this.mytitle);
			this.mytitle = '';
		};
		
		this.remove = function(id) {
			QuestionnaireRepository.remove(id);
		};
		
		// put function openModal() into the controller as an alternative to add()
		this.openModal = function() {
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
}]);

