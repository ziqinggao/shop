// JavaScript Document
$(document).ready(function() {
    $(".oRange img").hide().first().show();
	$(".buttons li").click(function(){
		n=$(this).index()
		$(".oRange img").hide().eq(n).show();
		})
	$(".Join_bot").hide();	
	$(".Join_us:eq(0)").children(".Join_bot").show();
	$(".Tb_offce > i").click(function(){
		$(this).parentsUntil(this).children(".Join_bot").toggle();
		$(this).parentsUntil(this).siblings(this).children(".Join_bot").hide();
		})
		// menu
		$(".menu").mouseenter(function(){
			$(".menu_now").addClass("VG");
			}).mouseleave(function(){
				$(".menu_now").removeClass("VG");
			})
		$(".iqst").hide().eq(0).show();		
		$(".nav_Xq li").click(function(){
				$(".iqst").hide().eq($(this).index()).show();
				$(this).children(this).addClass("Ggs");
				$(this).find(".Jk_ccc").addClass("Ggss");
				$(this).siblings(this).children(this).removeClass("Ggs");
				$(this).siblings(this).find(".Jk_ccc").removeClass("Ggss");
			})
			//列表DD最后一个去掉背景
		//setInterval(function(){	
		//	$(".list-dl dd").last().removeClass("ddM_u").addClass("bn").siblings(".list-dl dd").addClass("ddM_u");
		//},100)
		$(".rl").hide();
		$(".jGll span").click(function(){
			$(this).toggleClass("hoverb");
			$(this).siblings(this).toggle()
			//控制兄弟类别的存在与消失
			$(this).parent(this).siblings().children().removeClass("hoverb");
			$(this).parent(this).siblings().children(".rl").hide();
		})
		
		
		
})
$(".Two_title dd:last").each(function(e) {
    $(this).addClass("uuui").siblings().removeClass("uuui")
});

$(".As1,.As2,.As3").click(function(){
	$(this).css("outline-width","0");
	})