(function () {
    angular
        .module('webshopModule')
        .controller('loginController', Controller);

    function Controller($scope, api, $rootScope, $location) {
        $scope.failedLogin = false;
        $scope.login = function () {
            api.login($scope.user)
                .then(function (response) {
                    var loggedInUser = response.data;
                    if (!loggedInUser.customer.hasOwnProperty('cart')) {
                        loggedInUser.customer.cart = {
                            products: []
                        };
                    }
                    if ($scope.remember) {
                        localStorage.setItem('loggedInUser', JSON.stringify(loggedInUser));
                    } else {
                        sessionStorage.setItem('loggedInUser', JSON.stringify(loggedInUser));
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