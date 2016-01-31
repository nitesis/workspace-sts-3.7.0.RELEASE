/**
 * 
 */
angular.module('flashcard').directive('questionnaireElement', function() {
	return {
		restrict : 'EA',
		scope: {
			questionnaireInfo: '=q'
		},
		template: 	'<div class="row">' +
					'<div class="col-md-1 vcenter">{{questionnaireInfo.id}}</div>' +
					'<div class="col-md-2 vcenter">{{questionnaireInfo.title}}</div>' +
					'<div class="col-md-5 vcenter">{{questionnaireInfo.description}}</div>' +
					'<div class="vcenter">' +
					'<a href="#" class="btn" ng-click="controller.remove(questionnaire.id)">' +
						'<span class="glyphicon glyphicon-remove"></span>' +
					'</a>' +
					'</div>' +
					'</div>'
	};
});