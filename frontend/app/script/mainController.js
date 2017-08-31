(function () {
    angular
        .module('webshopModule')
        .controller('mainController', Controller);

    function Controller($scope, api, cartService) {
        $scope.addToCart = function (offer) {
            cartService.addToCart(offer);
        };

        $scope.getOffers = function () {
            api.getOffers()
                .then(function (response) {
                    $scope.offers = response.data.offers;
                });
        };

        $scope.sortByOptions = [
            {name: "Name", value: "name"},
            {name: "Price", value: "price"}
        ];

        $scope.selectedOption = $scope.sortByOptions[0];

        function disableButtons () {
            $scope.disableButtons = (!!localStorage.getItem('loggedInUser') || !!sessionStorage.getItem('loggedInUser')) ? false : true;
        }

        $scope.getOffers();
        disableButtons();

    }
})();