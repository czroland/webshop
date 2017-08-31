(function () {
    angular
        .module('webshopModule')
        .controller('headerController', Controller);

    function Controller($scope, userService) {
        $scope.logout = function () {
            localStorage.removeItem('loggedInUser');
            sessionStorage.removeItem('loggedInUser');
            getLoggedInUser();
        };

        $scope.$on('loginStateChange', getLoggedInUser);
        $scope.$on('cartChanged', getLoggedInUser);
        getLoggedInUser();

        function getLoggedInUser() {
            $scope.loggedInUser = userService.getLoggedInUser();
        }

    }
})();