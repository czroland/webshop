(function () {
    angular
        .module('webshopModule')
        .directive('carouselModal', function () {
            return {
                restrict: 'A',
                link: function () {
                    var indicators = $('ul.indicators li');
                    var pictures = $('ul.pictures li');
                    var lastElem = indicators.length - 1;
                    var current;

                    indicators.first().addClass('active');
                    pictures.hide().first().show();

                    function sliderResponse(current) {
                        pictures.fadeOut(300).eq(current).fadeIn(300);
                        indicators.removeClass('active').eq(current).addClass('active');
                    }

                    indicators.click(function () {
                        if (!$(this).hasClass('active')) {
                            current = $(this).index();
                            sliderResponse(current);
                            resetTiming();
                        }
                    });


                    function sliderTiming() {
                        current = $('ul.indicators li.active').index();
                        current === lastElem ? current = 0 : current = current + 1;
                        sliderResponse(current);
                    }

                    var timingRun = setInterval(function () {
                        sliderTiming();
                    }, 2000);

                    function resetTiming() {
                        clearInterval(timingRun);
                        timingRun = setInterval(function () {
                            sliderTiming();
                        }, 2000);
                    }


                    $('.next').click(function () {
                        current = $('ul.indicators li.active').index();
                        current === lastElem ? current = 0 : current = current + 1;
                        sliderResponse(current);
                        resetTiming();
                    });
                    $('.prev').click(function () {
                        current = $('ul.indicators li.active').index();
                        lastElem = indicators.length - 1;
                        current === 0 ? current = lastElem : current = current - 1;
                        sliderResponse(current);
                        resetTiming();
                    });
                }
            };
        });
})();