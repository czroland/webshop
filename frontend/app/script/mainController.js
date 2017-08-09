(function () {
    angular
        .module('webshopModule')
        .controller('mainController', Controller);

    function Controller($scope, api) {
        $scope.getOffers = function () {
            api.getOffers()
                .then(function (response) {
                    $scope.offers = response.data.offers;
                });
        };

        $scope.getOffers();
    }
})();