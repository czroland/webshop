(function () {
    angular
        .module('webshopModule')
        .controller('registrationController', Controller);

    function Controller(api, $scope, $location) {
        $scope.reg = function (customer) {
            api.registration(customer)
                .then(function () {
                    $location.path('/login');
                }, function () {
                    $scope.unsuccessfulReg = true;
                });
        }

    }

})();
