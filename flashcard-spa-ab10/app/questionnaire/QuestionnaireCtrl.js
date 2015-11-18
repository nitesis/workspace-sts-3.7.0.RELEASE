/**
 * 
 */

// Kann man $scope auch anders nennen? Nein. Das bezeichnet das Model.
//angular.module('flashcard').controller('QuestionnaireController', function ($scope) {
//Nach refactoring
app.controller('QuestionnaireController', ['QuestRepoService',function (QuestRepoService) {
	
	

	this.mytitle ='';

	this.bla = QuestRepoService.getAll();
	
	this.addQuestionnaire = function(){
		QuestRepoService.add(this.mytitle);
		this.mytitle ='';
	}
	

}]);



