var app = angular.module('shortLink');
app.controller('topSitesController', function ($scope, $http) {

    $http.get('/api/v1/top_sites').success(function (data) {
        var top = data['topTen'];
        var array = [];
        for (var index = 0; index < top.length; index++) {
            array.push({longURL: top[index]['longURL'], click: top[index]['click']});
        }
        $scope.sites = array;
        $scope.geoChart = geoChart(data['statistichePaesi']);
        if (data['num'] == 0) {
            $scope.browserChart = barChart(null, 'Browser', '');
            $scope.platformChart = barChart(null, 'Platform', '');
        } else {
            $scope.browserChart = barChart(data['statisticheBrowser'], 'Browser', 'Clicks');
            $scope.platformChart = barChart(data['statisticheOS'], 'Platform', 'Clicks');
        }
        $scope.totalClicks = data['num'];
    });

});