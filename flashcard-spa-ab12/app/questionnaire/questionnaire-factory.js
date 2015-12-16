'use strict';

// Alternative implementation. No changes on the client-side are needed!
// Create the factory as Closure!
// vor AB 14.2 :angular.module('flashcard').factory('QuestionnaireRepository', function() {
angular.module('flashcard').factory('QuestionnaireNetworkService', function($http) {
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
//			questionnaires.push(questionnaire);
			$http.post("http://flashcard-server/questionnaires", questionnaire);
		},
		remove : function(id) {
			var index = findById(id);
//			entfernt an Stelle von index 1 Element
			questionnaires.splice(index,1);
			return $http['delete'](baseUrl + '/' + id);
		},
		save : function(questionnaire) {
			questionnaire.id = ++index;
			questionnaires.push(questionnaire);
			$http.push("http://flashcard-server/questionnaires", questionnaire);
		},
		getById : function(id) {
			var index = findById(id);
//			return questionnaires[index];
			return $http.get("http://flashcard-server/questionnaires/{id}", questionnaire);
		},
		update : function(questionnaire) {
			var index = findById(questionnaire.id);
			questionnaires[index].title = questionnaire.title;
			questionnaires[index].description = questionnaire.description;
		}		
	};
});