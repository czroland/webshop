(function () {
    angular
        .module('webshopModule')
        .service('api', Service);

    function Service($http) {
        var urlBase = 'http://localhost:8080';
        this.getProducts = getProducts;
        this.getOfferDetail = getOfferDetail;
        this.getOffers = getOffers;
        this.login = login;

        function getProducts() {
            return $http.get(urlBase + "/product");
        }

        function getOfferDetail(id) {
            return $http.get(urlBase + "/offer/" + id);
        }

        function getOffers() {
            return $http.get(urlBase + "/offer");
        }

        function login(user, remember) {
            return $http.post(urlBase + "/user/login");
        }
    }
})();