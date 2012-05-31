<%@ page language="java" import="java.util.*,model.User,config.GlobleConfig" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
			String followed=(String)request.getAttribute("followed");
			String joined=(String)request.getAttribute("joined");
			String owner=(String)request.getAttribute("owner");
			int i=0;
			User user=(User)session.getAttribute("user");
			List activityAlbumList=(List)request.getAttribute("activityAlbum");
				
	request.setAttribute("path1",GlobleConfig.pathPath);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'activity.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <link rel="stylesheet" type="text/css" media="screen,projection" href="${path1}activity/font/font.css" />
    <link rel="stylesheet" type="text/css" media="screen,projection" href="${path1}activity/css/style.css" />
    <link rel="stylesheet" type="text/css" media="screen,projection" href="${path1}activity/css/css3.css" />
      <link rel="stylesheet" type="text/css" href="${path1}activity/css/jquery.lightbox.css" media="screen" />
    <link rel="stylesheet" type="text/css" media="screen,projection" href="${path1}activity/css/slider.css" />
     	<script type="text/javascript" src="${path1}activity/css/js/jquery.mousewheel-3.0.4.pack.js"></script>
	<script type="text/javascript" src="${path1}activity/css/js/jquery.fancybox-1.3.4.pack.js"></script>
     	<link rel="stylesheet" type="text/css" href="${path1}activity/css/jquery.fancybox-1.3.4.css" media="screen" />

     <script type="text/javascript" src="${path1}js/jquery-1.6.2.min.js"></script>	
     <script src="http://maps.google.cn/maps?file=api&amp;v=2&amp;key=ABQIAAAAVjCvQMEky2Xe635UMlEabxTaxHhufQQ_wqXxGIk3tfPhbmHbTBTcMgGyho7ATM90-GzVNkgnC6ko4w&sensor=true"
			type="text/javascript"></script>
		<script type="text/javascript">
   var map = null;
    var geocoder = null;
        function initialize() {
      if (GBrowserIsCompatible()) {
        map = new GMap2(document.getElementById("map_canvas"));
        map.setCenter(new GLatLng(${activityLat}, ${activityLong}), 13);
        geocoder = new GClientGeocoder();
        
map.openInfoWindow(map.getCenter(),
                   document.createTextNode("${activityInfo.activityStreet}"));
		 mapControl= new GMapTypeControl();<!--地图类型控件-->
        map.addControl(mapControl);
      
		  map.addControl(new GOverviewMapControl ());
              var marker = new GMarker(${activityLat}, ${activityLong});
              map.addOverlay(marker);
              
      }
    }
      function showAddress(address) {
      if (geocoder) {
        geocoder.getLatLng(
          address,
          function(point) {
            if (!point) {
              alert(address + " not found");
            } else {
              map.setCenter(point, 13);
              var marker = new GMarker(point);
              map.addOverlay(marker);
              marker.openInfoWindow(document.createTextNode(address));
            }
          }
        );
      }
    }
  function followActivity(url){
    
     http_request = false;
    if (window.XMLHttpRequest) {    								// 非IE浏览器
        http_request = new XMLHttpRequest();							//创建XMLHttpRequest对象
    } else if (window.ActiveXObject) {     							// IE浏览器
        try {
            http_request = new ActiveXObject("Msxml2.XMLHTTP");		//创建XMLHttpRequest对象
        } catch (e) {
            try {
                http_request = new ActiveXObject("Microsoft.XMLHTTP");	//创建XMLHttpRequest对象
           } catch (e) {}
        }
    }
    if (!http_request) {
        alert("不能创建XMLHttpRequest对象实例！");
        return false;
    }
    http_request.onreadystatechange = getResult;							//调用返回结果处理函数
    http_request.open('GET', url, true);								//创建与服务器的连接
    http_request.send(null);		
    
    }
function getResult() {
    if (http_request.readyState == 4) {     							// 判断请求状态
        if (http_request.status == 200) {     							// 请求成功，开始处理返回结果
            document.getElementById("bt1").value=http_request.responseText;;	//设置提示内容
 
        } else {     													// 请求页面有错误
            alert("您所请求的页面有错误！");
        }
    }
}
  function joinActivity(url){
    
     http_request = false;
    if (window.XMLHttpRequest) {    								// 非IE浏览器
        http_request = new XMLHttpRequest();							//创建XMLHttpRequest对象
    } else if (window.ActiveXObject) {     							// IE浏览器
        try {
            http_request = new ActiveXObject("Msxml2.XMLHTTP");		//创建XMLHttpRequest对象
        } catch (e) {
            try {
                http_request = new ActiveXObject("Microsoft.XMLHTTP");	//创建XMLHttpRequest对象
           } catch (e) {}
        }
    }
    if (!http_request) {
        alert("不能创建XMLHttpRequest对象实例！");
        return false;
    }
    http_request.onreadystatechange = getResult1;							//调用返回结果处理函数
    http_request.open('GET', url, true);								//创建与服务器的连接
    http_request.send(null);		
    
    }
    function getResult1() {
    if (http_request.readyState == 4) {     							// 判断请求状态
        if (http_request.status == 200) {     							// 请求成功，开始处理返回结果
            document.getElementById("bt2").value=http_request.responseText;;	//设置提示内容
 
        } else {     													// 请求页面有错误
            alert("您所请求的页面有错误！");
        }
    }		  
} 


    function check(){
    	if($.trim($("#commentContent").val()) == ""){
    		alert("empty comment");
    	}if($.trim($("#commentContent").val()) == "Name Says : ..."){
    		alert("empty comment");
    	}else{
    		$("#formComment").submit();
    	}
    	
    }
   function   showMap(){
            alert("hello");
         
            }

 </script>

    <script type="text/javascript" src="${path1}activity/css/js/jquery.min.js"></script>
    <script type="text/javascript" src="${path1}activity/css/js/jquery.lightbox.js"></script>
    <script src="${path1}activity/css/js/smoothscroll.js" type="text/javascript"></script>
	<script src="${path1}activity/css/js/mobilyslider.js" type="text/javascript"></script>
    <script src="${path1}activity/css/js/init.js" type="text/javascript"></script>
    <script src="${path1}activity/css/js/jquery.raty.js" type="text/javascript"></script>

	<script type="text/javascript">
        $(document).ready(function() {
				$('.map #in_map').lightBox();
        	});
    </script>
    <script type="text/javascript">
		$(function() {
			$('#score').raty({
				  starOn  : 'blue_star1.jpg',
				  starOff : 'blue_star2.jpg'	,							  
				score: function() {
					return $(this).attr('data-rating');
				}
			});
					   
					   
    $(".selectOne").click(function() {
     $(".selectOne").addClass("click_done");
     $(".selectTwo").removeClass("click_done");
    });
    $(".selectTwo").click(function() {
     $(".selectTwo").addClass("click_done");
     $(".selectOne").removeClass("click_done");
    });   
            });
            
       
        </script>
  <style type="text/css">
<!--
.STYLE1 {color: #000000}
-->
</style>
  </head>
  
  <body  onload="initialize()">
  
	<div id="wrapper"><!--start wrapper-->
    	<div id="header"><!--start header-->
        	<div class="logo"><a href="index.html"><img src="${path1}activity/img/logo.png" alt="" width="59" height="65" /></a></div>
            <div id="header_rgt"><!--start header_rgt-->
            	<div id="menu_bg"><div id="menu_lft"><div id="menu_rgt">
                    <ul>
                    			<li class="current_page_item">
										<a href="activity/index.action">CITY</a>
									</li>
									<li>
										<a href="movie/movieHomePage.action" title="MOVIE">MOVIE</a>
									</li>
									<li>
										<a href="book/bookHomePage.action" title="BOOK">BOOK</a>
									</li>
									<li>
										<a href="music/musicHomePage.action" title="MUSIC">MUSIC</a>
									</li>
									<li>
										<a href="user/my.action" title="My TRIBUS">MY TRIBUS</a>
									</li>
                    </ul>
                    <div class="header_search">
                    	<form action="#">
                        	<p class="txt_header"><input type="text" /></p>
                            <p class="submit_header"><input type="submit" value=" " /></p>
                        </form>
                    </div>
                    <div class="header_icon_area">
                    	<span class="space_btm"><a href="#"><img src="${path1}activity/img/icon_header1.png" alt="" width="10" height="11" /></a></span>
                        <span><a href="#"><img src="${path1}activity/img/icon_header2.png" alt="" width="12" height="13" /></a></span>
                    </div>
                </div></div></div>
            </div><!--//end #header_rgt-->
        </div><!--//end #header-->
        <div id="main_area"><!--start main_area-->
        	<div id="saerch_area"><!--start saerch_area-->
            	<div id="search_bg" class="space_lft"><!--start search_bg-->
                	<form action="activity/search.action">
                    	<p class="search_text"><input id="searchCondition" name="searchCondition" type="text" value="Seach activity, activity time, activity location" onclick="if(this.value=='Seach activity, activity time, activity location')(this.value='')"  onblur="if(this.value=='')(this.value='Seach activity, activity time, activity location')" /></p>
                        <p class="search_submit"><input type="submit" value=" " /></p>
                    </form>
                </div><!--//end #search_bg-->
                <div id="social_media"><!--start social_media-->
                	<div id="social_lftcol">
                    	<a href="#"><img src="${path1}activity/img/icon_facebook.jpg" alt="" width="24" height="24" /></a>
                        <a href="#"><img src="${path1}activity/img/icon_tweet.jpg" alt="" width="24" height="24" /></a>
                    </div>
                    <div id="social_box"><!--start social_box-->
                    	<div id="message">
                        	<a href="#"><img src="${path1}activity/img/icon_message1.jpg" alt="" width="22" height="22" /><span>5</span></a>
                            <a href="#"><img src="${path1}activity/img/icon_message2.jpg" alt="" width="22" height="22" /></a>
                            <a href="#"><img src="${path1}activity/img/icon_message3.jpg" alt="" width="22" height="22" /></a>
                            <a href="#"><img src="${path1}activity/img/icon_message4.jpg" alt="" width="22" height="22" /></a>
                        </div>
                        <div class="address">
                        	<h3><%if(user!=null){ %><a href="user/my/<%=user.getUserId()%>">welcome back,<%=user.getUserAlias()%></a><%}else{ %><a href="user/login.action">login</a><%} %></h3>
                            <span>New York City</span>
                        </div>
                    </div><!--//end #social_box-->
                </div><!--//end #social_media-->
            </div><!--//end #saerch_area-->
            <div id="common_maincontent"><!--start common_maincontent-->
                <div id="review_lftcol"><!--start review_lftcol-->
                    <div id="product_area"><!--start product_area-->
                    	<h2>${activityInfo.activityName}</h2>
                        <div id="product_twocol"><!--start product_twocol-->
                        	<div id="product_lftcol"><img src="${activityInfo.activityPic}" alt="" width="313" height="417" /></div>
                            <div id="product_rgtcol"><!--start product_rgtcol-->
                            	<p>Start Date: ${activityInfo.activityStartTime}<br />End Date: ${activityInfo.activityFinishTime}<br />PLace: ${activityInfo.activityCity} ${activityInfo.activityStreet} ${activityInfo.activityState}<br />Starter:<br />
                                Type: ${activityClassified}<br />Fees: ${activityInfo.activityFees} USD</p>
                                <div class="wish_listbox">
                                	<ul>
                                    	<li><%if(owner==null) {%>
				<input id="bt1" type="button" name="Submit" value="<%if(followed.equals("true")){%>unFollow<%}else{%>Follow<%}%>" 
			onclick="followActivity('activity/followActivity.action?activityId=${activityId}')"/></li>
                                        <li><input id="bt2" type="button" name="Submit" value="<%if(joined.equals("true")){%>unJoin<%}else{%>Join<%}%>" 
			onclick="joinActivity('activity/joinActivity.action?activityId=${activityId}')"/><%} %></li>
                                      
                                    </ul>
                                    <div class="facebook_icon_area">
                                    	<a href="#"><img src="${path1}activity/img/icon_facebook.jpg" alt="" width="24" height="24" /></a>
                                        <a href="#"><img src="${path1}activity/img/icon_tweet.jpg" alt="" width="24" height="24" /></a>
                                    </div>
                                </div>
                               
                             
                             <div class="map">
                             
                            <div id="in_map">
                          <!--      -->
                            </div>
                              <img alt="" src="http://maps.google.com/maps/api/staticmap?center=${activityLat},${activityLong}&zoom=13&size=200x200&markers=color:blue%7Clabel:S%7C${activityLat},${activityLong}&key=ABQIAAAAVjCvQMEky2Xe635UMlEabxTaxHhufQQ_wqXxGIk3tfPhbmHbTBTcMgGyho7ATM90-GzVNkgnC6ko4w&sensor=true"  width= 172 height=167>
                            
                             <a id="various1" href="#inline1" title="Lorem ipsum dolor sit amet">Enlarge</a>
                           
                             <div style="display: none;">
		
		<div id="inline1" style="width:400px;height:400px;overflow:auto;">
			 <iframe width="172" height="167" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="http://maps.google.com/maps?hl=en&amp;q=400+e+33rd+st+chicago+il&amp;ie=UTF8&amp;hq=&amp;hnear=400+E+33rd+St,+Chicago,+Illinois+60616&amp;gl=us&amp;ll=41.835101,-87.616246&amp;spn=0.010184,0.01929&amp;t=m&amp;z=14&amp;output=embed"></iframe><br />
		</div>
	</div>
                             </div>                                  
                            </div><!--//end #product_rgtcol-->
                        </div><!--//end #product_twocol-->
                    </div><!--//end #product_area-->
                  <div id="brief_main"><!--start brief_main-->
                    	<div class="brief_activity"><!--start brief_activity-->
                        	<h2>Brief Introduction</h2>
                            <div class="comment_box"><!--start comment_box-->
                                <div class="brief_content">
                                	<p>
                                	${activityInfo.activityDetail}</p>
                                    <div class="icon_brief"><img src="${path1}activity/img/icon_plus.jpg" alt="" width="20" height="20" /></div>
                                </div>
                            </div><!--//end .comment_box-->
                        </div><!--//end .brief_activity-->
                      <%if(activityAlbumList.size()!=0) {%>
                        <div class="brief_gallery"><!--start brief_gallery-->
                          	<h2><%if(activityAlbumList.size()!=0) {%><a href="activity/album.action?activityId=${activityId}"><%}%>Activity Album</a></h2>
                          	<div class="slider"><div class="sliderContent">
                        	 <div class="brief_img">
                            <c:forEach items="${activityAlbum}" var="item">
                           <a href="activity/showPicList.action?albumId=${item.albumId}"><img src="${item.albumCover}" width="103"
								height="103" />  </a>
                               </c:forEach>
                               <c:choose><c:when test="${flag == 1}"><a href="activity/album.action?activityId=${activityId}" class="bar_arrow">
                               <img src="${path1}activity/img/tripple_arrow2.jpg" width="20" height="7" alt="" /></a>
                               </c:when>
                               </c:choose>
                            </div>
                            </div></div>
                        </div><!--//end #brief_gallery--><!--//end .video_box-->
                      <%}else{ %>
                        <div class="brief_gallery"><!--start brief_gallery-->
                        	<h2>Activity Image &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;00000000000000000000000000000000000                  
							  <c:choose><c:when test="${flagg==1}"> <span class="STYLE1"><a href="activity/addPicIndex.action?activityId=${activityId }">Upload New Picture</a></span></h2></c:when></c:choose>
                        	
                           
                        </div><!--//end #brief_gallery-->
                      <%} %>
                    
                    </div>
                    <!--//end #brief_main-->
                    
                    
                                        <div id="comment_box_brief"><!--start comment_box_brief-->
                        <%if(session.getAttribute("user")!=null){ %>
                      
                        <div class="comment_box"><!--start comment_box-->
                            <div class="arrow_author2"></div>
                            <div class="comment_first_content"><!--start comment_first_content-->
                                <div class="pic_author">
                                    <div class="arrow_author1"></div>
                                    <img src="" alt="" width="73" height="73" />
                                </div>
                                <form id="formComment" name="formComment" method="post" action="activity/addComment.action?activityId=${activityId}">
                                <div class="author_total_rgt">
                                    <div class="author_speech">
                                        <textarea id="commentContent" name="commentContent" rows="10" cols="10" onclick="if(this.value=='Name Says : ...')(this.value='')"  onblur="if(this.value=='Name Says : ...')(this.value='')">Name Says : ...</textarea>
                                    </div>
                                    <div class="author_icon">
                                        <span><img src="${path1}activity/img/icon_album.jpg" alt="" width="20" height="19" /></span>
                                        <div class="btn_done"><a href="javascript: check();">Done</a></div>
                                    </div>
                                </div>
                                </form>
                            </div><!--//end .comment_first_content-->
                        </div><!--//end .comment_box-->
                        <%} %>
                     
                        
                      
                          
                       
                        <c:forEach items="${userCommentList}" var="item" varStatus="in">
                        
                            <c:choose>
                       <c:when test="${in.index %2!=0}">
                         <div class="comment_box bg_differ"><!--start comment_box-->
                       </c:when>
                       <c:otherwise>
                       <div class="comment_box"><!--start comment_box-->
                       </c:otherwise>
                       </c:choose>
                            <div class="comment_scnd_content"><!--start comment_scnd_content-->
                                <div class="pic_author">
                                  <a href="user/my/${item.userId}"><img src="${item.userPic}" width="72" height="72" /></a>
                                </div>
                                <div class="author_total_rgt">
                                    <div class="author_speech">
                                        <h3><a href="user/my/${item.userId}">${item.userName}</a></h3>
                                        <p>${item.commentContent}</p>
                                        <span>${item.commentDate}</span>
                                    </div>
                                </div>
                            </div><!--//end .comment_scnd_content-->
                        </div><!--//end .comment_box-->
                       </c:forEach>  
                    </div><!--//end #comment_box_brief-->
                    
                    
                    <div id="comment_pagination">
                    
                         
                         
                         <c:forEach items="${pageNumbers}" var="item">  
             <a href="activity/info.action?activityId=${activityId}&page=${item}">
             ${item}
             </a>
            </c:forEach>
                   
                    </div>
                </div><!--//end #review_lftcol-->
                <div class="clear"></div>
            </div><!--//end #common_maincontent-->
            <div id="footer"><p>Copyright @ Tribus.us 2012.      <span>All rights reserved</span> </p></div>
        </div><!--//end #main_area-->
    </div><!--//end #wrapper-->
</body>
</html>
