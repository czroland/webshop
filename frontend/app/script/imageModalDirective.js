(function () {
    angular
        .module('webshopModule')
        .directive('imageModal', function () {
            return {
                restrict: 'A',
                link: function () {
                    $('img').click(function () {
                        $('.image-modal').css('display', 'block');
                        $('.image-modal-content').attr('src', $(this).attr('src'));
                    });

                    $('.image-modal-close').click(function () {
                        $('.image-modal').css('display', 'none');
                    });
                }
            };
        });
})();