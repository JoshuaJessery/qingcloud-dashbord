$(function() {
	"use strict";
	// PreLoader
	$(window).load(function() {
		$(".loader").fadeOut(400);
	});
	// Backstretchs
	$("#header").backstretch("images/bj.png");
	$("#services").backstretch("images/bj.png");
	
	// Countdown
	$('.countdown').downCount({
		date: '09/10/2014 12:00:00',
		offset: +10
	});
	//Scroll Down
	$('#top-arrow').singlePageNav();
});