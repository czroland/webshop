(function () {
    angular
        .module('webshopModule')
        .service('cartService', Service);
    
    function Service(userService, $rootScope) {
        this.addToCart = addToCart;
        this.cartItemList = [];
        this.getItemList = getItemList;
        this.removeItem = removeItem;
        this.removeItems = removeItems;
        this.updateItemQuantity = updateItemQuantity;

        function addToCart(product) {
            var loggedInUser = userService.getLoggedInUser();
            var foundItem = loggedInUser.customer.cart.products.find(function (o) {
                return o.name === product.name;
            });
            if(!foundItem) {
                product.quantity = 1;
                loggedInUser.customer.cart.products.push(product);
                updateStorage(loggedInUser);
                $rootScope.$broadcast('cartChanged');
            }
        }

        function cartChanged(loggedInUser) {
            updateStorage(loggedInUser);
            $rootScope.$broadcast('cartChanged');
        }

        function getItemList() {
            var loggedInUser = userService.getLoggedInUser();
            this.cartItemList = loggedInUser.customer.cart.products;
            return this.cartItemList;
        }
        
        function removeItem(index) {
            var loggedInUser = userService.getLoggedInUser();
            loggedInUser.customer.cart.products.splice(index, 1);
            cartChanged(loggedInUser);
        }

        function removeItems() {
            var loggedInUser = userService.getLoggedInUser();
            loggedInUser.customer.cart.products = [];
            cartChanged(loggedInUser);
        }

        function updateItemQuantity(product ,index) {
            var loggedInUser = userService.getLoggedInUser();
            loggedInUser.customer.cart.products[index].quantity = product.quantity;
            cartChanged(loggedInUser);
        }
        
        function updateStorage(loggedInUser) {
            if(sessionStorage.getItem('loggedInUser')) {
                sessionStorage.setItem('loggedInUser', JSON.stringify(loggedInUser));
            }
            else if (localStorage.getItem('loggedInUser')) {
                localStorage.setItem('loggedInUser', JSON.stringify(loggedInUser));
            }
        }
    }
})();