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
                        localStorage.setItem('loggedUser', JSON.stringify({
                            username: $scope.username,
                            token: response.data.token,
                            logged: true
                        }));
                    } else {
                        sessionStorage.setItem('loggedUser', JSON.stringify({
                            username: $scope.username,
                            token: response.data.token,
                            logged: true
                        }));
                    }
                    $rootScope.$broadcast('loginStateChange', true);
                    $location.path('/');
                });
        };
    }
})();