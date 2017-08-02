(function () {
    angular
        .module('webshopModule')
        .config(function ($routeProvider) {
            $routeProvider
                .when('/', {
                    templateUrl: 'templates/main.html',
                    controller: 'mainController'
                })
                .when('/profile', {
                    templateUrl: 'templates/userProfile.html'
                });
        });
})();