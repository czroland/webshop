(function () {
    angular
        .module('webshopModule')
        .controller('mainController', Controller);

    function Controller($scope, api, cartService) {
        $scope.addToCart = function (offer) {
            cartService.addToCart(offer);
        };

        $scope.getProducts = function () {
            api.getProducts()
                .then(function (response) {
                    $scope.products = response.data;
                    console.log($scope.products);
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

        $scope.getProducts();
        disableButtons();

    }
})();