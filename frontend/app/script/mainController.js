(function () {
    angular
        .module('webshop')
        .controller('main', Controller);

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