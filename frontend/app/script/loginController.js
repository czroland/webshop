(function () {
    angular
        .module('webshopModule')
        .controller('loginController', Controller);

    function Controller($scope, api, $rootScope, $location) {
        $scope.failedLogin = false;
        $scope.login = function () {
            api.login($scope.user)
                .then(function (response) {
                    console.log(response.data);
                    if ($scope.remember) {
                        localStorage.setItem('loggedInUser', JSON.stringify(response.data));
                    } else {
                        sessionStorage.setItem('loggedInUser', JSON.stringify(response.data));
                    }
                    $rootScope.$broadcast('loginStateChange');
                    $location.path('/');
                })
                .catch(function () {
                    $scope.failedLogin = true;
                });
        };
    }
})();