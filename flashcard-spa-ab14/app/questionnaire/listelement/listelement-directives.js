angular.module('flashcard').directive('questionnaireElement', function() {
	return {
		restrict: 'A',
		templateUrl: 'questionnaire/listelement/listelement.html',
		scope: {
			questionnaire: '=questionnaire',
			controller: '=controller'         		
        }			     
	};
});