/**
 * 
 */
'use strict';

// Create the service as Closure!
angular.module('flashcard').service('QuestionnaireRepository', function() {
	// Keep 'questionnaires' hidden to the rest of the world.
	var questionnaires = [
		 {id:1, title: 'Q1', description: 'Lorem ipsum...'},
		 {id:2, title: 'Q2', description: 'Lorem ipsum...'},
		 {id:3, title: 'Q3', description: 'Lorem ipsum...'}
	];
	
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
	
});	