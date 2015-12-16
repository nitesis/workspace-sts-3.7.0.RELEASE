angular.module('flashcard', ['ui.bootstrap', 'ngRoute']);

angular.module('flashcard').config(['$routeProvider', '$locationProvider', function($routeProvider, $locationProvider) {
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
    // No hash '#' in URLs. Entry <base href="/flashcard-spa/"> in index.html must be set!
	//$locationProvider.html5Mode({enabled: true, requireBase: false});    
}]);