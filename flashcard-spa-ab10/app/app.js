/*
 * created by Viviane
 */

angular.module('flashcard', []);

// Kann man $scope auch anders nennen?
angular.module('flashcard').controller('QuestionnaireController', function ($scope) {
	
	$scope.mytitle ='Write a Title...Pleeease...NOW!';

var questionnaires = [
{id:1, title: 'Q1', description: 'Lorem ipsum...'}, 
{id:2, title: 'Q2', description: 'Lorem ipsum...'}, 
{id:3, title: 'Q3', description: 'Lorem ipsum...'}
];

//Das macht globalen Zugriff möglich
$scope.bla = questionnaires;	
});

