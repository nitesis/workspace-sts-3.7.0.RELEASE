'use strict';

// Create the service as Closure!
angular.module('flashcard').service('QuestionnaireRepository', function() {
	// Keep 'questionnaires' hidden to the rest of the world.
	var questionnaires = [
		 {id:1, title: 'Q1', description: 'Lorem ipsum...'},
		 {id:2, title: 'Q2', description: 'Lorem ipsum...'},
		 {id:3, title: 'Q3', description: 'Lorem ipsum...'}
	];
	
	function findById(id) {
		var index = -1;
		questionnaires.forEach(function(questionnaire, i) {
			if (questionnaire.id === id) {
				index = i;
			}
		});
		return index;
	};
	
	/*
	 *  Defines the API.
	 */
	this.getAll = function() {
		return questionnaires;
	};
	
	this.add = function(mytitle) {
		var questionnaire = {id:questionnaires.length+1, title: mytitle, description: 'Lorem ipsum...'};
		questionnaires.push(questionnaire);
	};
	
	this.remove = function(id) {
		var index = findById(id);
		questionnaires.splice(index,1);
	};
	
});	