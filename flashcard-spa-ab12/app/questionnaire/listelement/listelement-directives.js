angular.module('flashcard').directive('questionnaireElement', function() {
	return {
		restrict: 'A',
		templateUrl: 'questionnaire/listelement/listelement.html',
		scope: {
			questionnaire: '=questionnaire',
			controller: '=controller'
		},
//		template: '<div class="row">' +
//						'<div class="col-md-1 vcenter">{{questionnaire.id}}</div>' +
//						'<div class="col-md-2 vcenter">{{questionnaire.title}}</div>' +
//						'<div class="col-md-5 vcenter">{{questionnaire.description}}</div>' +
//						'<div class="vcenter">' +
//						    '<button href="#" class="btn-link" ng-click="controller.show(questionnaire.id)">' +
//							    '<span class="glyphicon glyphicon-zoom-in"></span>' +
//						    '</button>' +
//							'<button href="#" class="btn-link" ng-click="controller.remove(questionnaire.id)">' +
//								'<span class="glyphicon glyphicon-remove"></span>' +
//							'</button>' +
//							'<button href="#" class="btn-link" ng-click="controller.edit(questionnaire.id)">' +
//							     '<span class="glyphicon glyphicon-edit"></span>' +
//						    '</button>' +
//						'</div>' +
//			     '</div>',
        link: function(scope, elem, attrs) {
	    		// Only an example how to interact with a DOM element!
	    		// The styling itself can be achieved simpler by a CSS rule.
        		elem.bind('mouseover', function() {
        			elem.css('background-color', '#F5F5F5');
        		});
        		elem.bind('mouseout', function() {
        			elem.css('background-color', 'white');
        		});         		
        }			     
	};
});