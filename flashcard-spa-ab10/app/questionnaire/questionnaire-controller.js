/**
 * 
 */
angular.module('flashcard').controller('QuestionnaireController', function($scope){
		
		$scope.mytitle ='Huhu...!';
		
		var questionnaires = [
		             {id:1, title: 'Q1', description: 'Lorem ipsum...'},
		             {id:2, title: 'Q2', description: 'Lorem ipsum...'},
		             {id:3, title: 'Q3', description: 'Lorem ipsum...'}
		];
		
		//Das macht globalen Zugriff möglich
		$scope.quest = questionnaires;	
		
		$scope.add = function() {
			var questionnaire = {id:questionnaires.length+1, title: $scope.mytitle, description: 'Lorem ipsum...'};
			questionnaires.push(questionnaire);
			$scope.mytitle = '';
		};
});