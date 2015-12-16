'use strict';

// Alternative implementation. No changes on the client-side are needed!
// Create the factory as Closure!
// vor AB 14.2 :angular.module('flashcard').factory('QuestionnaireRepository', function() {
angular.module('flashcard').factory('QuestionnaireNetworkService', function() {
	// Keep 'questionnaires' hidden to the rest of the world.


	/*
	 * Return a function object with public methods. 
	 * Only these methods have access to the instance variables.
	 * This is the public API!
	 */
	return {
		getAll : function() {
			//return questionnaires;
			return $http.get("/flashcard-server/questionnaires");
		},
		add : function(mytitle) {
			var questionnaire = {id:++index, title: mytitle, description: 'Lorem ipsum...'};
			questionnaires.push(questionnaire);
		},
		remove : function(id) {
			var index = findById(id);
			questionnaires.splice(index,1);
		},
		save : function(questionnaire) {
			questionnaire.id = ++index;
			questionnaires.push(questionnaire);
		},
		getById : function(id) {
			var index = findById(id);
			return questionnaires[index];
		},
		update : function(questionnaire) {
			var index = findById(questionnaire.id);
			questionnaires[index].title = questionnaire.title;
			questionnaires[index].description = questionnaire.description;
		}		
	};
});