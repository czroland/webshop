(function () {
    angular
        .module('webshopModule')
        .controller('loginController', Controller);

    function Controller($scope, api, $rootScope, $location) {
        $scope.login = function () {
            api.login({
                username: $scope.username,
                password: $scope.password
            }, $scope.remember)
                .then(function (response) {
                    if ($scope.remember) {
                        localStorage.setItem('loggedUser', JSON.stringify(response.data));
                    } else {
                        sessionStorage.setItem('loggedUser', JSON.stringify(response.data));
                    }
                    $rootScope.$broadcast('loginStateChange');
                    $location.path('/');
                });
        };
    }
})();