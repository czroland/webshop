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

        function addToCart(offer) {
            var loggedInUser = userService.getLoggedInUser();
            var foundItem = loggedInUser.user.cart.items.find(function (o) {
                return o.name === offer.name;
            });
            if(!foundItem) {
                offer.quantity = 1;
                loggedInUser.user.cart.items.push(offer);
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
            this.cartItemList = loggedInUser.user.cart.items;
            return this.cartItemList;
        }
        
        function removeItem(index) {
            var loggedInUser = userService.getLoggedInUser();
            loggedInUser.user.cart.items.splice(index, 1);
            cartChanged(loggedInUser);
        }

        function removeItems() {
            var loggedInUser = userService.getLoggedInUser();
            loggedInUser.user.cart.items = [];
            cartChanged(loggedInUser);
        }

        function updateItemQuantity(item ,index) {
            var loggedInUser = userService.getLoggedInUser();
            loggedInUser.user.cart.items[index].quantity = item.quantity;
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