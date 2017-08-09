(function () {
    angular
        .module('webshopModule')
        .config(function ($routeProvider) {
            $routeProvider
                .when('/', {
                    templateUrl: 'templates/main.html',
                    controller: 'mainController'
                })
                .when('/signup', {
                    templateUrl: 'templates/signupPage.html'
                })
                .when('/login', {
                    templateUrl: 'templates/loginPage.html',
                    controller: 'loginController'
                })
                .when('/profile', {
                    templateUrl: 'templates/userProfile.html'
                })
                .when('/offer/:id', {
                    templateUrl: "templates/offerDetails.html",
                    controller: "offerDetailsController"
                });
        });
})();