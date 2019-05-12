<<<<<<< HEAD
$(function(){
	
	changeImage();
	showInfo();
	
	var now = 0;
	function changeImage(){
		$(".banner-count i").click(function(){
			now = $(this).index();
			var $index = $(this).index();
			$(this).addClass('active');
			$('.banner-count i').not($(this)).removeClass('active');
			startMove($index);
		});
		
		var timer = setInterval(nextPic, 2000);
		var oLi = parseInt($('.header-banner ul li').css('width'));
//		var $len = $('.header-banner ul li').length;
//		var $width = $('.header-banner ul li').css('width') * $len;
//		$('.header-banner ul').css({'width':$width + 'px'});
		
		$('.left-arrow').click(function(){
			$(".header-banner ul").stop(true,true);
			now--;
			if(now < 0){
				now = $('.header-banner ul li').length-1;
			}
			var cur = parseInt($('.header-banner ul').css('margin-left'));
			$('.banner-count i').eq(now).addClass('active');
			$('.banner-count i').eq(now).siblings().removeClass('active');
			if(cur<0){
				$('.header-banner ul').animate({
					'margin-left':cur + oLi + 'px'
				}, 500);
			}else{
				$('.header-banner ul').animate({
					'margin-left':-(oLi * 2) + 'px'
				}, 500);
			}
		})
		$('.right-arrow').click(function(){
			nextPic();
		})
		
		function nextPic(){
			$(".header-banner ul").stop(true,true);
			now++;
			if(now==$('.header-banner ul li').length){
				now = 0;
				$('.header-banner ul').animate({
					'margin-left':0 + 'px'
				}, 500);
			}else{
				var cur = parseInt($('.header-banner ul').css('margin-left'));
				$('.header-banner ul').animate({
					'margin-left':cur - oLi + 'px'
				}, 500);
			}
			$('.banner-count i').eq(now).addClass('active');
			$('.banner-count i').eq(now).siblings().removeClass('active');
		}
		
		$('.header-banner ul li').mouseenter(function(){
			clearInterval(timer);
		});
		$('.header-banner ul li').mouseleave(function(){
			timer = setInterval(nextPic, 2000);
		});
		
		function startMove(len){
			$(".header-banner ul").stop(true, true);
			$('.header-banner ul').animate({
				'margin-left':-(len) * oLi + 'px'
			}, 500);
		}
	}
	
	function showInfo(){
		$('.gonggao ul li').mouseenter(function(){
			$(this).find('.detail-info').show();
			$('.gonggao ul li').not($(this)).find('.detail-info').hide();
		})
	}
})
=======
$(function(){
	
	changeImage();
	showInfo();
	
	var now = 0;
	function changeImage(){
		$(".banner-count i").click(function(){
			now = $(this).index();
			var $index = $(this).index();
			$(this).addClass('active');
			$('.banner-count i').not($(this)).removeClass('active');
			startMove($index);
		});
		
		var timer = setInterval(nextPic, 2000);
		var oLi = parseInt($('.header-banner ul li').css('width'));
//		var $len = $('.header-banner ul li').length;
//		var $width = $('.header-banner ul li').css('width') * $len;
//		$('.header-banner ul').css({'width':$width + 'px'});
		
		$('.left-arrow').click(function(){
			$(".header-banner ul").stop(true,true);
			now--;
			if(now < 0){
				now = $('.header-banner ul li').length-1;
			}
			var cur = parseInt($('.header-banner ul').css('margin-left'));
			$('.banner-count i').eq(now).addClass('active');
			$('.banner-count i').eq(now).siblings().removeClass('active');
			if(cur<0){
				$('.header-banner ul').animate({
					'margin-left':cur + oLi + 'px'
				}, 500);
			}else{
				$('.header-banner ul').animate({
					'margin-left':-(oLi * 2) + 'px'
				}, 500);
			}
		})
		$('.right-arrow').click(function(){
			nextPic();
		})
		
		function nextPic(){
			$(".header-banner ul").stop(true,true);
			now++;
			if(now==$('.header-banner ul li').length){
				now = 0;
				$('.header-banner ul').animate({
					'margin-left':0 + 'px'
				}, 500);
			}else{
				var cur = parseInt($('.header-banner ul').css('margin-left'));
				$('.header-banner ul').animate({
					'margin-left':cur - oLi + 'px'
				}, 500);
			}
			$('.banner-count i').eq(now).addClass('active');
			$('.banner-count i').eq(now).siblings().removeClass('active');
		}
		
		$('.header-banner ul li').mouseenter(function(){
			clearInterval(timer);
		});
		$('.header-banner ul li').mouseleave(function(){
			timer = setInterval(nextPic, 2000);
		});
		
		function startMove(len){
			$(".header-banner ul").stop(true, true);
			$('.header-banner ul').animate({
				'margin-left':-(len) * oLi + 'px'
			}, 500);
		}
	}
	
	function showInfo(){
		$('.gonggao ul li').mouseenter(function(){
			$(this).find('.detail-info').show();
			$('.gonggao ul li').not($(this)).find('.detail-info').hide();
		})
	}
})
>>>>>>> second commit
