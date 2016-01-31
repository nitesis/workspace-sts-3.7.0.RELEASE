/**
 * 
 */
angular.module('flashcard').directive('questionnaireElement', function() {
	return {
		restrict : 'EA',
		scope: {
			questionnaire: '=questionnaire',
			controller: '=controller'
		},
		template: 	'<div class="row">' +
					'<div class="col-md-1 vcenter">{{questionnaire.id}}</div>' +
					'<div class="col-md-2 vcenter">{{questionnaire.title}}</div>' +
					'<div class="col-md-5 vcenter">{{questionnaire.description}}</div>' +
					'<div class="vcenter">' +
					'<a href="#" class="btn" ng-click="controller.remove(questionnaire.id)">' +
						'<span class="glyphicon glyphicon-remove"></span>' +
					'</a>' +
					'</div>' +
					'</div>'
	};
});