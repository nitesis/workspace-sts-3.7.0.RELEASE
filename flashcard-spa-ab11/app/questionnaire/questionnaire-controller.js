angular.module('flashcard').controller('QuestionnaireController', ['QuestionnaireRepository', function(QuestionnaireRepository) {
	this.mytitle = '';

	this.questionnaires = QuestionnaireRepository.getAll();
	
	this.add = function() {
		QuestionnaireRepository.add(this.mytitle);
		this.mytitle = '';
	};
	
	this.remove = function(id) {
		QuestionnaireRepository.remove(id);
	};
}]);