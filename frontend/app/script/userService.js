(function () {
    angular
        .module('webshopModule')
        .service('userService', Service);

    function Service() {
        this.getLoggedInUser = getLoggedInUser;

        function getLoggedInUser() {
            return JSON.parse(sessionStorage.getItem('loggedInUser')) || JSON.parse(localStorage.getItem('loggedInUser')) || {
                token: undefined,
                customer: {
                    cart: {
                        products: []
                    }
                }
            };
        }
    }
})();