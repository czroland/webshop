(function () {
    angular
        .module('webshop')
        .service('api', Service);

    function Service($http) {
        var urlBase = 'http://localhost:8080/product';
        this.getProducts = getProducts;

        function getProducts() {
            return $http.get(urlBase);
        }
    }
})();