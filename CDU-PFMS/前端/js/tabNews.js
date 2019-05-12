<<<<<<< HEAD
function tabNews(){
					var now = 0;
					$(".tab-dot i").mouseenter(function(){
						now = $(this).index();
						var $index = $(this).index();
						$(this).addClass('active');
						$('.tab-dot i').not($(this)).removeClass('active');
						startMove($index);
					});
					
					var timer = setInterval(nextPic, 2000);
					var oLi = parseInt($('.content-right ul li').css('width'));
					
					$('.arrow-left-on').click(function(){
						$(".content-right ul").stop(true,true);
						now--;
						if(now < 0){
							now = $('.content-right ul li').length-1;
						}
						var cur = parseInt($('.content-right ul').css('margin-left'));
						$('.tab-dot i').eq(now).addClass('active');
						$('.tab-dot i').eq(now).siblings().removeClass('active');
						if(cur<0){
							$('.content-right ul').animate({
								'margin-left':cur + oLi + 'px'
							}, 300);
						}else{
							$('.content-right ul').animate({
								'margin-left':-(oLi * 2) + 'px'
							}, 300);
						}
					})
					$('.arrow-right-on').click(function(){
						nextPic();
					})
					
					function nextPic(){
						$(".content-right ul").stop(true,true);
						now++;
						if(now==$('.content-right ul li').length){
							now = 0;
							$('.content-right ul').animate({
								'margin-left':0 + 'px'
							}, 500);
						}else{
							var cur = parseInt($('.content-right ul').css('margin-left'));
							$('.content-right ul').animate({
								'margin-left':cur - oLi + 'px'
							}, 500);
						}
						$('.tab-dot i').eq(now).addClass('active');
						$('.tab-dot i').eq(now).siblings().removeClass('active');
					}
					
					$('.content-right ul li').mouseenter(function(){
						clearInterval(timer);
					});
					$('.content-right ul li').mouseleave(function(){
						timer = setInterval(nextPic, 2000);
					});
					
					function startMove(len){
						$(".content-right ul").stop(true, true);
						$('.content-right ul').animate({
							'margin-left':-(len) * oLi + 'px'
						}, 300);
					}
=======
function tabNews(){
					var now = 0;
					$(".tab-dot i").mouseenter(function(){
						now = $(this).index();
						var $index = $(this).index();
						$(this).addClass('active');
						$('.tab-dot i').not($(this)).removeClass('active');
						startMove($index);
					});
					
					var timer = setInterval(nextPic, 2000);
					var oLi = parseInt($('.content-right ul li').css('width'));
					
					$('.arrow-left-on').click(function(){
						$(".content-right ul").stop(true,true);
						now--;
						if(now < 0){
							now = $('.content-right ul li').length-1;
						}
						var cur = parseInt($('.content-right ul').css('margin-left'));
						$('.tab-dot i').eq(now).addClass('active');
						$('.tab-dot i').eq(now).siblings().removeClass('active');
						if(cur<0){
							$('.content-right ul').animate({
								'margin-left':cur + oLi + 'px'
							}, 300);
						}else{
							$('.content-right ul').animate({
								'margin-left':-(oLi * 2) + 'px'
							}, 300);
						}
					})
					$('.arrow-right-on').click(function(){
						nextPic();
					})
					
					function nextPic(){
						$(".content-right ul").stop(true,true);
						now++;
						if(now==$('.content-right ul li').length){
							now = 0;
							$('.content-right ul').animate({
								'margin-left':0 + 'px'
							}, 500);
						}else{
							var cur = parseInt($('.content-right ul').css('margin-left'));
							$('.content-right ul').animate({
								'margin-left':cur - oLi + 'px'
							}, 500);
						}
						$('.tab-dot i').eq(now).addClass('active');
						$('.tab-dot i').eq(now).siblings().removeClass('active');
					}
					
					$('.content-right ul li').mouseenter(function(){
						clearInterval(timer);
					});
					$('.content-right ul li').mouseleave(function(){
						timer = setInterval(nextPic, 2000);
					});
					
					function startMove(len){
						$(".content-right ul").stop(true, true);
						$('.content-right ul').animate({
							'margin-left':-(len) * oLi + 'px'
						}, 300);
					}
>>>>>>> second commit
				}