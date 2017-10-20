/*==================================
Template Name: Sufia
Author Name: Shakil Hossain
Author URL: http://codeglim.com
Description: Sufia is a Multipurpose Corporate,Business,Personal & App Landing Page Template. it's perfect on any business,peronal,app showcase website. you can easily customize and change it. thank you
Version: 1.2
====================================*/     
/*==================================
[Start Activation Code]
====================================
	+ Custom Jquery
	+ Mobile Menu
	+ Search Jquery
	+ Sidebar Menu
	+ Main SLider
	+ Counter JS
	+ Isotop And Masonry 
	+ Testimonial Carousel
	+ Brand Carousel
	+ App Slide
	+ App Screenshot Slide	
	+ Project Slide	
	+ Project Related Slide	
	+ News Slide	
	+ progress bar	
	+ Onepage Nav
	+ Magnific Popup
	+ Wow JS
	+ Extra Js
	+ ScrollUp jquery
	+ Typed JS
	+ Youtube Player
	+ Google Maps
	+ Preloader JS
====================================
[End Activation Code]
====================================*/ 
(function($) {
    "use strict";
     $(document).on('ready', function() {
		/*====================================
			Sufia Custom JS
		======================================*/ 	
		function custom_js_Sufia() {
			var windowS = $(window),
				windowH = windowS.height(),
				projecthoverS = $('.project-hover'),
				projecthoverH = projecthoverS.height(),
				proejectdevide = (projecthoverH / 2);
				projecthoverS.css({
				marginTop: -proejectdevide,
				});
		}; 
		
		/*====================================
			Mobile Menu
		======================================*/ 	
		$('.menu').slicknav({
			prependTo:".mobile-menu",
		});
	
		/*====================================
			Search Jquery
		======================================*/ 	
		$('.search a').on( "click", function(){
				$('.search-form').toggleClass('s-active');
			});
		$('.search-form i').on( "click", function(){
				$('.search-form').toggleClass('active');
		});  	

		/*====================================
			Sidebar Menu
		======================================*/ 
		$('.fa-bars').on( "click", function(){
				$('.side-menu').toggleClass('active');
			});
		$('.side-menu .remove').on( "click", function(){
				$('.side-menu').toggleClass('active');
		});  
		
		
		/*====================================
			Main Slider
		======================================*/ 
		if ($.fn.slick) {
			$(".slider-main").slick({
				autoplay: true,
				autoplaySpeed: 5000,
				slidesToShow: 1,
				pauseOnHover: true,
				dots: false,
				cssEase: 'linear',
				fade: true,
				draggable: true,
				prevArrow: '<button class="PrevArrow fa fa-angle-left"></button>',
				nextArrow: '<button class="NextArrow fa fa-angle-right"></button>',
				responsive: [{
                    breakpoint: 340,
                    settings: {
                        slidesToShow: 1,
                        slidesToScroll: 1,
                        infinite: true,
						arrows: false,
                    }
                },
            ]
			});
		}
		
		/*====================================
			Counter Js
		======================================*/ 
		$('.count').counterUp({
			time: 1000
		});

		/*====================================
			Isotop And Masonry Active
		======================================*/ 
		$(window).on('load', function() {
			$('.isotop-active').masonry({
                // options
                itemSelector: '.grid-item',
            });
			custom_js_Sufia();
			
			if ($.fn.isotope) {
                $(".isotop-active").isotope({
                    filter: '*',
                });

					$('.project-nav ul li').on('click', function() {
                    $(".project-nav ul li").removeClass("active");
                    $(this).addClass("active");

                    var selector = $(this).attr('data-filter');
                    $(".isotop-active").isotope({
                        filter: selector,
                        animationOptions: {
                            duration: 750,
                            easing: 'easeOutCirc',
                            queue: false,
                        }
                    });
                    return false;
                });
            }
		});
		/*====================================
			Testimonial Carousel
		======================================*/ 
		$('.testimonial-active').slick({
			autoplay: true,
			autoplaySpeed: 5000,
			arrows: false,
			dots: true,
			slidesToShow: 1,
			slidesToScroll: 1,
			pauseOnHover: false,
			draggable: true,
			fade: true,
			cssEase: 'linear'
		});
		
		/*====================================
			Brand Carousel
		======================================*/ 
		$('.brand-slider').slick({
			autoplay: true,
			autoplaySpeed: 2000,
			speed: 600,
			arrows: false,
			slidesToShow: 6,
			slidesToScroll: 1,
			pauseOnHover: false,
			dots: false,
			draggable: true,
			cssEase: 'linear',
			responsive: [{
                    breakpoint: 780,
                    settings: {
                        slidesToShow: 4,
                        slidesToScroll: 1,
                        infinite: true,
                        dots: false
                    }
                }, {
                    breakpoint: 500,
                    settings: {
                        slidesToShow: 2,
                        slidesToScroll: 1,
                        infinite: true,
                    }
                },{
                    breakpoint: 340,
                    settings: {
                        slidesToShow: 1,
                        slidesToScroll: 1,
                        infinite: true,
                    }
                },
            ]
		});
		
		/*====================================
			App Slide
		======================================*/ 
		$('.app-slide').slick({
			autoplay: true,
			autoplaySpeed: 3000,
			slidesToShow: 1,
			slidesToScroll: 1,
			pauseOnHover: false,
			dots: false,
			pauseOnDotsHover: true,
			cssEase: 'linear',
			draggable: true,
			fade:true,
			prevArrow: '<button class="PrevArrow fa fa-angle-left"></button>',
			nextArrow: '<button class="NextArrow fa fa-angle-right"></button>',
		});
		
		/*====================================
			App Screenshot Slide
		======================================*/ 
		$('.screenshot-slide').slick({
			autoplay: true,
			autoplaySpeed: 4000,
			speed: 600,
			slidesToShow: 4,
			slidesToScroll: 1,
			margin:10,
			pauseOnHover: false,
			dots: false,
			pauseOnDotsHover: true,
			cssEase: 'linear',
			draggable: true,
			prevArrow: '<button class="PrevArrow fa fa-angle-left"></button>',
			nextArrow: '<button class="NextArrow fa fa-angle-right"></button>',
			responsive: [{
                    breakpoint: 780,
                    settings: {
                        slidesToShow: 3,
                        slidesToScroll: 1,
                        infinite: true,
                        dots: false
                    }
                }, {
                    breakpoint: 500,
                    settings: {
                        slidesToShow: 2,
                        slidesToScroll: 1,
                        infinite: true,
                    }
                },{
                    breakpoint: 340,
                    settings: {
                        slidesToShow: 1,
                        slidesToScroll: 1,
                        infinite: true,
                    }
                },
            ]
		});	
		
		/*====================================
			Project Slide
		======================================*/ 
		$('.project-slide').slick({
			autoplay: true,
			autoplaySpeed: 4500,
			speed: 600,
			slidesToShow: 1,
			slidesToScroll: 1,
			pauseOnHover: false,
			dots: false,
			pauseOnDotsHover: true,
			cssEase: 'linear',
			draggable: true,
			prevArrow: '<button class="PrevArrow fa fa-angle-left"></button>',
			nextArrow: '<button class="NextArrow fa fa-angle-right"></button>',
		});
		
		/*====================================
			Project Related Slide
		======================================*/ 
		$('.related-slide').slick({
			autoplay: true,
			autoplaySpeed: 4000,
			speed: 600,
			slidesToShow: 4,
			slidesToScroll: 1,
			pauseOnHover: false,
			dots: true,
			pauseOnDotsHover: true,
			cssEase: 'linear',
			arrows: false,
			responsive: [{
                    breakpoint: 780,
                    settings: {
                        slidesToShow: 2,
                        slidesToScroll: 1,
                        infinite: true,
                        dots: false
                    }
                }, {
                    breakpoint: 500,
                    settings: {
                        slidesToShow: 1,
                        slidesToScroll: 1,
                        infinite: true,
                    }
                },{
                    breakpoint: 340,
                    settings: {
                        slidesToShow: 1,
                        slidesToScroll: 1,
                        infinite: true,
                    }
                },
            ]
		});
		
		/*====================================
			News Slide
		======================================*/ 
		$('.news-slide').slick({
			autoplay: true,
			autoplaySpeed: 10000,
			speed: 600,
			slidesToShow: 1,
			slidesToScroll: 1,
			pauseOnHover: false,
			dots: false,
			pauseOnDotsHover: true,
			cssEase: 'linear',
			draggable: true,
			prevArrow: '<button class="PrevArrow fa fa-angle-left"></button>',
			nextArrow: '<button class="NextArrow fa fa-angle-right"></button>',
		});	

		/*====================================
			progress-bar
		======================================*/ 
        $('.progress-bar .prog-bg').each(function () {
            var $this = $(this);
            var width = $(this).data('percent');
            $this.css({
                'transition': 'width 3s'
            });
            setTimeout(function () {
                $this.appear(function () {
                    $this.css('width', width + '%');
                });
            }, 500);
        });
		
		/*====================================
			Onepage Navigation
		======================================*/ 
		if ($.fn.onePageNav) {
			$('.navbar .nav').onePageNav({
				currentClass: 'current',
				scrollSpeed: 600,
			});
			$('.slicknav_nav').onePageNav({
				currentClass: 'current',
				scrollSpeed: 600,
			});
		};	
		
		$('.video-play').magnificPopup({
			type: 'video',	
		});
		
		$('.my-image a').magnificPopup({
			type: 'image',	
		});

		

		/*======================================
			Wow JS
		======================================*/ 		
		var window_width = $(window).width();   
			if(window_width > 767){
            new WOW().init();
		}
		/*====================================
			Extra JS
		======================================*/ 
			
		jQuery(window).on('scroll', function() {
			if ($(this).scrollTop() > 100) {
				$('.header-inner').addClass("sticky");
			} else {
				$('.header-inner').removeClass("sticky");
			}
		});
		
		$('.b-arrow,.btnm,.icon-down,.btn').on("click", function (e) {
			var anchor = $(this);
				$('html, body').stop().animate({
					scrollTop: $(anchor.attr('href')).offset().top - 70
				}, 1000);
			e.preventDefault();
		});
		
		$('.social li').on('mouseenter', function(){
			$('.social li').removeClass('active');
			$(this).addClass('active');
		})
		
		$('.single-brand').on('mouseenter', function(){
			$('.single-brand').removeClass('active');
			$(this).addClass('active');
		})

		/*====================================
			Scrool Up
		======================================*/ 	
		$.scrollUp({
			scrollName: 'scrollUp',      // Element ID
			scrollDistance: 300,         // Distance from top/bottom before showing element (px)
			scrollFrom: 'top',           // 'top' or 'bottom'
			scrollSpeed: 1000,            // Speed back to top (ms)
			easingType: 'linear',        // Scroll to top easing (see http://easings.net/)
			animation: 'fade',           // Fade, slide, none
			animationSpeed: 200,         // Animation speed (ms)
			scrollTrigger: false,        // Set a custom triggering element. Can be an HTML string or jQuery object
			scrollTarget: false,         // Set a custom target element for scrolling to. Can be element or number
			scrollText: ["<i class='fa fa-angle-up'></i>"], // Text for element, can contain HTML
			scrollTitle: false,          // Set a custom <a> title if required.
			scrollImg: false,            // Set true to use image
			activeOverlay: false,        // Set CSS color to display scrollUp active point, e.g '#00FFFF'
			zIndex: 2147483647           // Z-Index for the overlay
		});
		
		/*====================================
			Typed Js
		======================================*/ 
		$(".typed").typed({
			strings: ["Play Store", "Windows Store", "Apps Store"],
			typeSpeed: 50,
			loop: true,
		});
		
		/*====================================
			Youtube Player
		======================================*/
		$('.player').mb_YTPlayer();		
		
		/*====================================
			Google  Maps
		======================================*/
		var map = new GMaps({
			el: '.map',
			lat: 23.810332,
			lng: 90.412518,
			scrollwheel: false,
		});
		map.addMarker({
			lat: 23.810332,
			lng: 90.412518,
			title: 'Marker with InfoWindow',
			infoWindow: {
			content: '<p>Welcome to Sufia</p>'
		}
		});
		
	});
		/*====================================
			Preloader JS
		======================================*/
		$(window).on('load', function() {
				$('.loader').fadeOut('slow', function(){
				$(this).remove();
			});
		});
})(jQuery);
