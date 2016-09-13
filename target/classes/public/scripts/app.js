var app = angular.module('shortLink', [
    'ngCookies',
    'ngResource',
    'ngSanitize',
    'ngRoute',
    'googlechart'
]);

app.config(function ($routeProvider) {
    $routeProvider.when('/', {
        templateUrl: 'views/createShort.html',
        controller: 'createShortController'
    }).when('/:param1/stats', {
        templateUrl: 'views/urlStatistics.html',
        controller: 'urlStatisticsController'
    }).when('/404_Rendering_Error_Page_Not_Found', {
        templateUrl: 'views/404.html',
        controller: 'pageNotFoundController'
    }).when('/topSites', {
        templateUrl: 'views/topSites.html',
        controller: 'topSitesController'
    }).otherwise({
        templateUrl: 'views/long.html',
        controller: 'longUrlController'
    })
});
