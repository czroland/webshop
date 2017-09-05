(function () {
    angular
        .module('webshopModule')
        .controller('productDetailsController', Controller);
    
    function Controller($scope, api, $routeParams, cartService, $location) {
        $scope.addToCart = function (offer) {
            cartService.addToCart(offer);
        };

        $scope.backToMain = function () {
            $location.path('/');
        };

        function getProduct() {
            api.getProducts()
                .then(function (response) {
                    var products = response.data;
                    $scope.product = products.find(function (p) {
                        return Number(p.number) === Number($routeParams.number);
                    });
                });
        }

        function disableButton () {
            $scope.disableButton = (!!localStorage.getItem('loggedInUser') || !!sessionStorage.getItem('loggedInUser')) ? false : true;
        }

        getProduct();
        disableButton();
    }
})();