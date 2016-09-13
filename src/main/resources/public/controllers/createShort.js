var app = angular.module('shortLink');
app.controller('createShortController', ['$scope', '$http', function ($scope, $http) {

    $scope.createUrl = function () {
        if (isDomainValid($scope.URL.longURL)) {
            if (!$scope.URL.customURL) {
                $http.post('/api/v1/short', $scope.URL.longURL).success(function (data) {
                    var short = data['shortURL'];
                    short = short.replace(/\"/g, "");
                    $scope.URL.short = short;
                    $scope.URL.clicks = data['click'];
                    document.getElementById("buttonStatistics").style.visibility = 'visible';
                    document.getElementById("url-card").style.visibility = 'visible';
                    short = short.replace("http://localhost:8080/#/", "");
                    $scope.requestStatistics = '/#/' + short + '/stats';
                })
            } else {
                if (!isValid($scope.URL.customURL)) {
                    Materialize.toast('Custom url not allowed! It can contains only letters and numbers; bad words are not allowed.', 7000);
                    document.getElementById("buttonStatistics").style.visibility = 'hidden';
                    document.getElementById("url-card").style.visibility = 'hidden';
                } else {
                    $http.post('/api/v1/shortCustom', $scope.URL).success(function (data) {
                        if (data === 'null') {
                            Materialize.toast('Word not available, try again', 5000);
                            document.getElementById("buttonStatistics").style.visibility = 'hidden';
                            document.getElementById("url-card").style.visibility = 'hidden';
                        } else {
                            var short = 'http://localhost:8080/#/' + $scope.URL.customURL;
                            $scope.URL.short = short;
                            $scope.URL.clicks = data['click'];
                            document.getElementById("buttonStatistics").style.visibility = 'visible';
                            document.getElementById("url-card").style.visibility = 'visible';
                            short = short.replace("http://localhost:8080/#/", "");
                            $scope.requestStatistics = '/#/' + short + '/stats';
                        }
                    })
                }
            }
        } else {
            Materialize.toast('Url not allowed!', 5000);
            document.getElementById("buttonStatistics").style.visibility = 'hidden';
            document.getElementById("url-card").style.visibility = 'hidden';
        }
    }

}]);