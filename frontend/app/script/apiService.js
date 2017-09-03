(function () {
    angular
        .module('webshopModule')
        .service('api', Service);

    function Service($http) {
        var urlBase = 'http://localhost:8080';
        this.getCategories = getCategories;
        this.getProducts = getProducts;
        this.login = login;
        this.postCustomer = postCustomer;

        function getCategories() {
            return $http.get(urlBase + "/backoffice-integration/rest/categories");
        }

        function getProducts() {
            return $http.get(urlBase + "/backoffice-integration/rest/products");
        }

        function login(user) {
            return $http.post(urlBase + "/backoffice-integration/rest/user/authenticate", user);
        }

        function postCustomer(customer) {
            return $http.post(urlBase + "/rest/user/add-user", customer);
        }
    }
})();