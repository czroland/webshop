(function () {
    angular
        .module('webshopModule')
        .controller('registrationController', Controller);

    function Controller(api, $scope, $location, $timeout) {
        claerInputFields();
        $scope.reg = function () {
            var customer = {};
            if ($scope.sameBillingAddress) {
                customer = {
                    user: $scope.user,
                    deliveryAddress: $scope.deliveryAddress,
                    billingAddress: $scope.deliveryAddress
                };
            }
            else {
                customer = {
                    user: $scope.user,
                    deliveryAddress: $scope.deliveryAddress,
                    billingAddress: $scope.billingAddress
                };
            }
            claerInputFields();
            api.registration(customer)
                .then(function() {
                    $scope.successfulReg = true;
                    $timeout(function () {
                        $location.path('/login');
                    }, 3000);
                }, function () {
                    $scope.failedReg = true;
                });

        };

        function claerInputFields () {
            $scope.passwconf = '';
            $scope.sameBillingAddress = false;
            $scope.user = {
                email: '',
                username: '',
                password: '',
                fullName: '',
                phone: ''
            };
            $scope.deliveryAddress = {
                city: '',
                street: '',
                number: '',
                zipCode: ''
            };
            $scope.billingAddress = {
                city: '',
                street: '',
                number: '',
                zipCode: ''
            };
        }
    }

})();
