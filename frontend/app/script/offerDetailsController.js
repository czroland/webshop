(function () {
    angular
        .module('webshopModule')
        .controller('offerDetailsController', Controller);
    
    function Controller($scope, api, $routeParams) {
        api.getOfferDetail($routeParams.id)
            .then(function (response) {
                $scope.offer = response.data;

                $(document).ready(function () {
                    $('img').click(function () {
                        $('.image-modal').css('display', 'block');
                        $('.image-modal-content').attr('src', $(this).attr('src'));
                        $('.image-caption').html($(this).attr('alt'));
                    });
                    
                    $('.image-modal-close').click(function () {
                        $('.image-modal').css('display', 'none');
                    });
                });
            });
    }
})();