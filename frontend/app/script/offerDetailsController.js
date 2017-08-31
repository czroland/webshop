(function () {
    angular
        .module('webshopModule')
        .controller('offerDetailsController', Controller);
    
    function Controller($scope, api, $routeParams, cartService) {
        $scope.addToCart = function (offer) {
            cartService.addToCart(offer);
        };

        api.getOfferDetail($routeParams.id)
            .then(function (response) {
                $scope.offer = response.data;
            });

        function disableButton () {
            $scope.disableButton = (!!localStorage.getItem('loggedInUser') || !!sessionStorage.getItem('loggedInUser')) ? false : true;
        }

        disableButton();
    }
})();