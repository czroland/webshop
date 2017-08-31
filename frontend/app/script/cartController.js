(function () {
    angular
        .module('webshopModule')
        .controller('cartController', Controller);

    function Controller($scope, $location, userService, cartService) {
        $scope.continueShopping = function () {
            $location.path('/');
        };

        $scope.goToLogin = function () {
            $location.path('/login');
        };

        $scope.goToSignup = function () {
            $location.path('/signup');
        };

        $scope.removeCartItem = function (index) {
            cartService.removeItem(index);
        };

        $scope.removeCartItems = function () {
            cartService.removeItems();
        };

        $scope.updateItemQuantity = function (item, index) {
            cartService.updateItemQuantity(item, index);
        };

        $scope.$on('cartChanged', function () {
            getLoggedInUser();
            getItemList();
        });

        getLoggedInUser();
        getItemList();

        function calcTotal() {
            $scope.total = 0;
            if($scope.itemList) {
                $scope.itemList.forEach(function (i) {
                    $scope.total += i.price * i.quantity;
                });
            }
        }

        function getItemList() {
            $scope.itemList = cartService.getItemList();
            calcTotal();
        }

        function getLoggedInUser() {
            $scope.loggedInUser = userService.getLoggedInUser();
        }
    }
})();