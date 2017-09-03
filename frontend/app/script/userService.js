(function () {
    angular
        .module('webshopModule')
        .service('userService', Service);

    function Service() {
        this.getLoggedInUser = getLoggedInUser;

        function getLoggedInUser() {
            var loggedInUser = {
                token: undefined,
                customer: {
                    cart: {
                        products: []
                    }
                }
            };
            if (!!localStorage.getItem('loggedInUser')) {
                loggedInUser = JSON.parse(localStorage.getItem('loggedInUser'));
            }
            else if (!!sessionStorage.getItem('loggedInUser')) {
                loggedInUser = JSON.parse(sessionStorage.getItem('loggedInUser'));
            }
            return loggedInUser;
        }
    }
})();