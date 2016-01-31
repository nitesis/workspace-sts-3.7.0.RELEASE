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
}]);