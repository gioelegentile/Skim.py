var app = angular.module('shortLink');
app.controller('urlStatisticsController', function ($scope, $http, $routeParams) {

    var param1 = 'http://localhost:8080/#/' + $routeParams.param1.replace("/stats", "");
    $http.get('/api/v1/url_statistics/', {params: {"param1": param1}}).success(function (data) {
        if (data !== 'null') {
            console.log(data);
            $scope.total_clicks = (data['statistiche'])['num'];
            $scope.shortURL = param1;
            $scope.longURL = data['longURL'];
            $scope.geoChart = geoChart((data['statistiche'])['statistichePaesi']);
            if ((data['statistiche'])['num'] == 0) {
                $scope.browserChart = barChart(null, 'Browser', '');
                $scope.platformChart = barChart(null, 'Platform', '');
            } else {
                $scope.browserChart = barChart((data['statistiche'])['statisticheBrowser'], 'Browser', 'Clicks');
                $scope.platformChart = barChart((data['statistiche'])['statisticheOS'], 'Platform', 'Clicks');
            }
        } else {
            $scope.shortURL = "THIS SHORT URL DOESN'T EXIST!"
        }
    });

});