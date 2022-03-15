$(function(){
	var imgNum = $(".banner").length;
	var lef = $(".icoList").width()/1000;
	$(".icoList").css("margin-top","-"+lef+"px").show();
	
	var timer;
	
	$(".icoList li a").click(function(){
		var index = $(".icoList li a").index($(this));
		changeImg(index);
	}).eq(0).click();
	
	$(".banner-left").click(function(){
		var index = $(".icoList li a").index($(".icoList li a.cur"));
		var indexImg = index-1;
		if(indexImg<0)
			indexImg=imgNum-1;
		changeImg(indexImg);
		//alert(index);
	});
	
	$(".banner-right").click(function(){
		var index = $(".icoList li a").index($(".icoList li a.cur"));
		var indexImg = index+1;
		if(indexImg>imgNum-1)
			indexImg=0;
		changeImg(indexImg);
		//alert(index);
	});
	
	function changeImg(index)
	{
		$(".icoList li a").removeClass("cur").eq(index).addClass("cur");
		$(".indexBanner .banner").fadeOut(600).eq(index).fadeIn(400);
	}
	
	 
	
	timer = setInterval(function(){
		if (!$(".indexBanner .banner").is(":animated"))
		{
			var index = $(".icoList li a").index($(".icoList li a.cur"));
			if (index < $(".icoList li").length-1)
				index++;
			else
				index=0;
			changeImg(index);		
		}
		
	},4000);
});


 