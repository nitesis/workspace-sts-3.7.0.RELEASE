/*
 * created by Viviane
 */

angular.module('flashcard', []);

// Kann man $scope auch anders nennen?
angular.module('flashcard').controller('QuestionnaireController', function ($scope) {
	
	$scope.mytitle ='Write a Title...Pleeease!';

var questionnaires = [
{id:1, title: 'Q1', description: 'Lorem ipsum...'}, 
{id:2, title: 'Q2', description: 'Lorem ipsum...'}, 
{id:3, title: 'Q3', description: 'Lorem ipsum...'},
{id:4, title: $scope.mytitle}
];



//Das macht globalen Zugriff möglich
$scope.bla = questionnaires;	
});

angular.module('flashcard', [])
.controller('InputController', ['$scope', function($scope) {
  $scope.master = {};

  $scope.update = function(user) {
    $scope.master = angular.copy(user);
  };

  $scope.reset = function() {
    $scope.user = angular.copy($scope.master);
  };

  $scope.reset();
}]);

