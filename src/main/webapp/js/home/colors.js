$(document).ready(function(){
	
		
	$(".color1" ).click(function(){
		$("#colors" ).attr("href", "css/skin/blue.css" );
		return false;
	});
	
		
	$(".color2" ).click(function(){
		$("#colors" ).attr("href", "css/skin/blaze.css" );
		return false;
	});
	
	$(".color3" ).click(function(){
		$("#colors" ).attr("href", "css/skin/blue2.css" );
		return false;
	});
	
	$(".color4" ).click(function(){
		$("#colors" ).attr("href", "css/skin/green.css" );
		return false;
	});
		
	$(".color5" ).click(function(){
		$("#colors" ).attr("href", "css/skin/orange.css" );
		return false;
	});
	
	$(".color6" ).click(function(){
		$("#colors" ).attr("href", "css/skin/pink.css" );
		return false;
	});
	
	$(".color7" ).click(function(){
		$("#colors" ).attr("href", "css/skin/purple.css" );
		return false;
	});
	
	$(".color8" ).click(function(){
		$("#colors" ).attr("href", "css/skin/red.css" );
		return false;
	});
	
		

	$('.icon').click (function(event){
		event.preventDefault();
		if( $ (this).hasClass('inOut')  ){
			$('.mp-color').stop().animate({left:'0px'},500 );
		} else{
			$('.mp-color').stop().animate({left:'-200px'},500 );
		} 
		$(this).toggleClass('inOut');
		return false;

	}  );

	
	
	
	
} );
