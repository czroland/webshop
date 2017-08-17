(function () {
    angular
        .module('webshopModule')
        .controller('headerController', Controller);

    function Controller($scope) {
        $scope.logout = function () {
            localStorage.removeItem('loggedUser');
            sessionStorage.removeItem('loggedUser');
            getLoggedUser();
        };

        $scope.$on('loginStateChange', getLoggedUser);
        getLoggedUser();

        function getLoggedUser() {
            if (localStorage.getItem('loggedUser')) {
                $scope.loggedUser = JSON.parse(localStorage.getItem('loggedUser'));
            }
            else if (sessionStorage.getItem('loggedUser')) {
                $scope.loggedUser = JSON.parse(sessionStorage.getItem('loggedUser'));
            }
            else {
                $scope.loggedUser = {
                    username: undefined,
                    token: undefined,
                    logged: false
                };
            }
        }
    }
})();