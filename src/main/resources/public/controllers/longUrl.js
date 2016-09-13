var app = angular.module('shortLink');
app.controller('longUrlController', function ($scope, $http, $location) {

    $http.post('/api/v1/risultato', $location.absUrl()).success(function (data) {
        data = data.replace(/\"/g, "");
        location.href = data;
    })

});