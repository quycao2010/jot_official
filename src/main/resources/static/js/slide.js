$(function(){
	$('#slider li').hide().filter(':first').show();
	setInterval(slideshow, 5000);
});

function slideshow() {
	$('#slider li:first').fadeOut('slow').next().fadeIn('slow').end().appendTo('#slider');
}