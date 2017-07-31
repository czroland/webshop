(function () {
    angular
        .module('webshopModule')
        .controller('mainController', Controller);

    function Controller($scope, api) {
        $scope.getProducts = function () {
            api.getProducts()
                .then(function (response) {
                    $scope.products = response.data.products;
                    console.log($scope.products);
                });
        };

        $scope.getProducts();
    }
})();