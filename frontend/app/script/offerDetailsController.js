(function () {
    angular
        .module('webshopModule')
        .controller('offerDetailsController', Controller);
    
    function Controller($scope, api, $routeParams) {
        api.getOfferDetail($routeParams.id)
            .then(function (response) {
                $scope.offer = response.data;
            });

        function disableButton () {
            $scope.disableButton = (!!localStorage.getItem('loggedUser') || !!sessionStorage.getItem('loggedUser')) ? false : true;
        }

        disableButton();
    }
})();