/**
 * 
 */
'use strict';

// Alternative implementation. No changes on the client-side are needed!
// Create the factory as Closure!
angular.module('flashcard').factory('QuestionnaireRepository', function() {
	// Keep 'questionnaires' hidden to the rest of the world.
	var questionnaires = [
		 {id:1, title: 'Q1', description: 'Lorem ipsum...'},
		 {id:2, title: 'Q2', description: 'Lorem ipsum...'},
		 {id:3, title: 'Q3', description: 'Lorem ipsum...'}
	];
	
	var index = questionnaires.length;

	
	/*
	 * Return a function object with public methods. 
	 * Only these methods have access to the instance variables.
	 * This is the public API!
	 */
	return {
		getAll : function() {
			return questionnaires;
		},
		add : function(mytitle) {
			var questionnaire = {id:++index, title: mytitle, description: 'Lorem ipsum...'};
			questionnaires.push(questionnaire);
		}
	};
});