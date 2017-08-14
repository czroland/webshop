(function () {
    angular
        .module('webshopModule')
        .controller('offerDetailsController', Controller);
    
    function Controller($scope, api, $routeParams) {
        api.getOfferDetail($routeParams.id)
            .then(function (response) {
                $scope.offer = response.data;
            });
    }
})();