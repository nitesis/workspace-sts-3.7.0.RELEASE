angular.module('flashcard', ['ui.bootstrap', 'ngRoute']);

angular.module('flashcard').config(['$routeProvider', function($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl : 'questionnaire/partials/list.html',
//            controller  : 'QuestionnaireController as ctrl'
        })
        .when('/create', {
            templateUrl : 'questionnaire/partials/create.html',
//            controller  : 'QuestionnaireCreateController as dialog'
        })
        .when('/show/:id', {
            templateUrl : 'questionnaire/partials/show.html',
//            controller  : 'QuestionnaireShowController as detail'
        })
        .when('/update/:id', {
            templateUrl : 'questionnaire/partials/update.html',
//            controller  : 'QuestionnaireShowController as detail'
        })
        .otherwise({
            redirectTo : '/'
        });
    // use the HTML5 History API
	//$locationProvider.html5Mode(true);    
}]);