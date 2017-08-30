(function () {
    angular
        .module('webshopModule')
        .controller('registrationController', Controller);

    function Controller(api, $scope, $location, $timeout) {
        $scope.reg = function (customer) {
            api.registration(customer)
                .then(function () {
                    $scope.successfulReg = true;
                    $timeout(function () {
                        $location.path('/login');
                    }, 3000)
                }, function () {
                    $scope.unsuccessfulReg = true;
                });
        }

    }

})();
