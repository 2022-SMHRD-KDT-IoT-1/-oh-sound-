<%@page import="Model.NoiseVO"%>
<%@page import="java.util.List"%>
<%@page import="Model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=euc-kr" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<!--
   Astral by HTML5 UP
   html5up.net | @ajlkn
   Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
<head>
<title>Astral by HTML5 UP</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="assets/css/main.css" />
<noscript>
	<link rel="stylesheet" href="assets/css/noscript.css" />
</noscript>
</head>
<style>
#one, #two {
	width: 200px;
	height: 500px;
}
#soundData, #searchDiv {
	width: 800px;
	margin-left: auto;
	margin-right: auto;
}

.rowdata {
	
}

.rowh {
	background-color: black;
}

.color {
	color: white;
}

#sDtop {
	background-color: black;
	color: white;
}

#searchClick {
	width: 150px;
}

#searchText {
	width: 550px;
}

#login {
	width: 100px;
	height: 50px;
	margin-top: 10px;
}

#jungbok {
	width: 100px;
	height: 50px;
	margin-top: 10px;
	margin-bottom: 10px;
}

#join {
	width: 100px;
	height: 50px;
	margin-top: 10px;
}

#searchButton {
	width: 80px;
	height: 50px;
}

input {
	margin-top: 5px;
	margin-bottom: 5px;
}

td {
	color: black;
	font-weight: bolder;
}
#one td{
	background-color:#98FB98;
}
</style>
<body class="is-preload">

	<%
		MemberVO vo = (MemberVO) session.getAttribute("vo");
		// out.print(vo);
		
		List<NoiseVO> list = (List<NoiseVO>)request.getAttribute("list");
	%>
	
	<!-- Wrapper-->
	<div id="wrapper">

		<!-- Nav -->
		<nav id="nav">
		<%if(vo == null) { %>
			<a href="#" class="icon solid fa-home"><span>홈</span></a> 
			<a href="#loginjoin" class="icon solid fa-envelope"><span>로그인</span></a>
		<%}else{ %>
			<a href="#" class="icon solid fa-home"><span>홈</span></a> 
			<a href="#map" class="icon solid fa-map"><span>소음지도</span></a>
			<a href="goNoise" class="icon solid fa-folder"><span>게시판</span></a>
			<!-- <a href="goNoise" class="icon solid fa-folder"><span>게시판</span></a> -->
		<% } %>
		</nav>

		<!-- Main -->
		<div id="main">

			<!-- Me -->
			<% if(vo == null){ %>
			<article id="home" class="panel intro">
				<header>
					<h1>오소리</h1>
					<p>OH Sound</p>
				</header>
				<a href="#map" class="jumplink pic"> <span
					class="arrow icon solid fa-chevron-right"><span>See
							my work</span></span> <img src="images/home.jpg" alt="" />
				</a>
			</article>
			<% } else { %>
			<article id="home" class="panel intro">
				<header>
					<h1><%= vo.getMb_id()%>님 환영합니다.</h1>
					<p>OH Sound</p>
					<a href="logoutService"><button type="submit">로그아웃</button></a>
				</header>
				<a href="#map" class="jumplink pic"> <span
					class="arrow icon solid fa-chevron-right"><span>See
							my work</span></span> <img src="images/home.jpg" alt="" />
				</a>
			</article>
			<%} %>


			<!-- loginjoin -->
			<article id="loginjoin" class="panel">
				<%
					if (vo == null) {
				%>
				<header>
					<h2>로그인</h2>
				</header>
				<form action="loginService" method="post">
					<input name="mb_id" type="text" placeholder="ID를 입력하세요"><br>
					<input name="mb_pw" type="password" placeholder="PW를 입력하세요"><br>
					<button type="submit" class="btn btn-outline-dark" id="login">로그인</button>
					<br>
				</form>
				<hr>
				<header> </header>

				<h2>회원가입</h2>
				<form action="joinService" method="post">
					<input id="check" name="mb_id" type="text" placeholder="ID를 입력하세요">
					<button type="button" onClick="idCheck()"
						class="btn btn-secondary btn-sm" id="jungbok">중복확인</button>
					<!-- 중복확인은 나중에 경고창이나 메시지시스템에서 했던것처럼 글로 보여주기  -->
					<span id="result"></span><input name="mb_pw"
						type="password" placeholder="PW를 입력하세요"> <input
						name="mb_dongho" type="text" placeholder="동-호수를 입력하세요"><br>
					<button type="submit" class="btn btn-outline-dark" id="join">회원가입</button>
					<br>
				</form>
				<%} %>

			</article>

			<!-- Work -->
			<article id="work" class="panel">
				<header>
					<h2>나의 소음 정보</h2>
				</header>
				<div id="top">
					<h3 id="title">스마트인재개발원 아파트 1단지 소음기록</h3>
				</div>
				<hr>
<!-- 				<div id="searchDiv">
					<form>
						<select name="searchClick" id="searchClick">
								<option value="title">제목</option>
								<option value="when">등록일자</option>
							</select> <input type="text" name="searchText" placeholder="검색어 입력"
								id="searchText">
							<button type="submit" id="searchButton">검색</button>
					</form>
				</div> -->

				<table id="soundData">
					<tr id="sDtop">
						<th>순번</th>
						<th>소리</th>
						<th>진동</th>
						<th>등록일자</th>
					</tr>
<%--               	<% for(NoiseVO nvo : list){ %>
              		<tr>
              			<td><%=nvo.getNum() %></td>
              			<td><%=nvo.getNoise_db()%></td>
              			<td><%=nvo.getNoise_vibration()%></td>
              			<td><%=nvo.getNoise_date()%></td>
              		</tr>
              	<%} %> --%>
				</table>
			</article>

			<article id="map" class="panel">
				<header>
					<h2 style="text-align: center;">소음지도</h2>
				</header>
				<form action="#" method="post">

					<div id="top">
						<h3 id="title">스마트인재개발원 아파트 1단지 소음지도</h3>

						<div style="text-align: center;">
							<span>소음지도 리셋: </span> <span id="clock"
								style="color: gray; font-size: 30px;">clock</span> <span
								id="apm" style="color: gray; font-size: 20px;">ampm</span>
						</div>
					</div>
					<hr>

					<div id="main">
						<table id="one">
							<tr>
								<th colspan="2" class="rowh"><h4 class="color">101동</h4></th>
							</tr>
							<tr>
								<td class="rowdata" width="40" height="20">1001호</td>
								<td class="rowdata" width="40" height="20">1002호</td>
							</tr>
							<tr>
								<td class="rowdata" width="40" height="20">901호</td>
								<td class="rowdata" width="40" height="20">902호</td>
							</tr>
							<tr>
								<td class="rowdata" width="40" height="20">801호</td>
								<td class="rowdata" width="40" height="20">802호</td>
							</tr>
							<tr>
								<td class="rowdata" width="40" height="20">701호</td>
								<td class="rowdata" width="40" height="20">702호</td>
							</tr>
							<tr>
								<td class="rowdata" width="40" height="20">601호</td>
								<td class="rowdata" width="40" height="20">602호</td>
							</tr>
							<tr>
								<td class="rowdata" width="40" height="20">501호</td>
								<td class="rowdata" width="40" height="20">502호</td>
							</tr>
							<tr>
								<td class="rowdata" width="40" height="20">401호</td>
								<td class="rowdata" width="40" height="20">402호</td>
							</tr>
							<tr>
								<td class="rowdata" width="40" height="20">301호</td>
								<td class="rowdata" width="40" height="20">302호</td>
							</tr>
							<tr>
								<td class="rowdata" width="40" height="20">201호</td>
								<td class="rowdata" width="40" height="20">202호</td>
							</tr>
							<tr>
								<td class="rowdata" width="40" height="20">101호</td>
								<td class="rowdata" width="40" height="20">102호</td>
							</tr>
						</table>

						<table id="one">
							<tr>
								<th colspan="2" class="rowh"><h4 class="color">102동</h4></th>
							</tr>
							<tr>
								<td class="rowdata" width="40" height="20">1003호</td>
								<td class="rowdata" width="40" height="20">1004호</td>
							</tr>
							<tr>
								<td class="rowdata" width="40" height="20">903호</td>
								<td class="rowdata" width="40" height="20">904호</td>
							</tr>
							<tr>
								<td class="rowdata" width="40" height="20">803호</td>
								<td class="rowdata" width="40" height="20">804호</td>
							</tr>
							<tr>
								<td class="rowdata" width="40" height="20">703호</td>
								<td class="rowdata" width="40" height="20">704호</td>
							</tr>
							<tr>
								<td class="rowdata" width="40" height="20">603호</td>
								<td class="rowdata" width="40" height="20">604호</td>
							</tr>
							<tr>
								<td class="rowdata" width="40" height="20">503호</td>
								<td class="rowdata" width="40" height="20">504호</td>
							</tr>
							<tr>
								<td class="rowdata" width="40" height="20">403호</td>
								<td class="rowdata" width="40" height="20">404호</td>
							</tr>
							<tr>
								<td class="rowdata" width="40" height="20">303호</td>
								<td class="rowdata" width="40" height="20">304호</td>
							</tr>
							<tr>
								<td class="rowdata" width="40" height="20">203호</td>
								<td class="rowdata" width="40" height="20">204호</td>
							</tr>
							<tr>
								<td class="rowdata" width="40" height="20">103호</td>
								<td class="rowdata" width="40" height="20">104호</td>
							</tr>
						</table>

						<table id="one">
							<tr>
								<th colspan="2" class="rowh"><h4 class="color">201동</h4></th>
							</tr>
							<tr>
								<td class="rowdata" width="40" height="20">1001호</td>
								<td class="rowdata" width="40" height="20">1002호</td>
							</tr>
							<tr>
								<td class="rowdata" width="40" height="20">901호</td>
								<td class="rowdata" width="40" height="20">902호</td>
							</tr>
							<tr>
								<td class="rowdata" width="40" height="20">801호</td>
								<td class="rowdata" width="40" height="20">802호</td>
							</tr>
							<tr>
								<td class="rowdata" width="40" height="20">701호</td>
								<td class="rowdata" width="40" height="20">702호</td>
							</tr>
							<tr>
								<td class="rowdata" width="40" height="20">601호</td>
								<td class="rowdata" width="40" height="20">602호</td>
							</tr>
							<tr>
								<td class="rowdata" width="40" height="20">501호</td>
								<td class="rowdata" width="40" height="20">502호</td>
							</tr>
							<tr>
								<td class="rowdata" width="40" height="20">401호</td>
								<td class="rowdata" width="40" height="20">402호</td>
							</tr>
							<tr>
								<td class="rowdata" width="40" height="20">301호</td>
								<td class="rowdata" width="40" height="20">302호</td>
							</tr>
							<tr>
								<td class="rowdata" width="40" height="20">201호</td>
								<td class="rowdata" width="40" height="20">202호</td>
							</tr>
							<tr>
								<td class="rowdata" width="40" height="20">101호</td>
								<td class="rowdata" width="40" height="20">102호</td>
							</tr>
						</table>

						<table id="one">
							<tr>
								<th colspan="2" class="rowh"><h4 class="color">202동</h4></th>
							</tr>
							<tr>
								<td class="rowdata" width="40" height="20">1003호</td>
								<td class="rowdata" width="40" height="20">1004호</td>
							</tr>
							<tr>
								<td class="rowdata" width="40" height="20">903호</td>
								<td class="rowdata" width="40" height="20">904호</td>
							</tr>
							<tr>
								<td class="rowdata" width="40" height="20">803호</td>
								<td class="rowdata" width="40" height="20"
									style="background-color: #FFA500;">804호</td>
							</tr>
							<tr>
								<td class="rowdata" width="40" height="20">703호</td>
								<td class="rowdata" width="40" height="20">704호</td>
							</tr>
							<tr>
								<td class="rowdata" width="40" height="20">603호</td>
								<td class="rowdata" width="40" height="20">604호</td>
							</tr>
							<tr>
								<td class="rowdata" width="40" height="20">503호</td>
								<td class="rowdata" width="40" height="20">504호</td>
							</tr>
							<tr>
								<td class="rowdata" width="40" height="20">403호</td>
								<td class="rowdata" width="40" height="20">404호</td>
							</tr>
							<tr>
								<td class="rowdata" width="40" height="20"
									style="background-color: #98FB98;">303호</td>
								<td class="rowdata" width="40" height="20">304호</td>
							</tr>
							<tr>
								<td class="rowdata" width="40" height="20">203호</td>
								<td class="rowdata" width="40" height="20">204호</td>
							</tr>
							<tr>
								<td class="rowdata" width="40" height="20">103호</td>
								<td class="rowdata" width="40" height="20">104호</td>
							</tr>
						</table>
					</div>
				</form>
			</article>
		</div>



		<!-- Footer -->
		<div id="footer">
			<ul class="copyright">
				<li>&copy; Untitled.</li>
				<li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
			</ul>
		</div>
		
		<script type="text/javascript">
				function idCheck(){
					
					// 1. email 가져오기
					let mb_id = $('#check').val();
					
					// 2. ajax
					$.ajax({
						url : "checkService",
						type : 'post',
						data : {
							'mb_id' : mb_id
						},
						success : function(res){
							console.log(res);
							
							if(res == 'true'){
								// 사용가능한 아이디
								// .css('속성명', '값') : 해당 태그의 css를 바꿔주는 함수
								// $('form').attr('action', 'loginService') : 태그의 속성값을 변경해주는 함수
								$('#result').html('사용가능한 이메일 입니다');
								$('#result').css('color', 'green');
							}else{
								// 중복된 아이디
								$('#result').html('중복된 이메일 입니다');
								$('#result').css('color', 'red');
							}						
						},
						error : function(){
							alert("error");
						},
					});
				}
			</script>

	</div>

	<!-- Scripts -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/browser.min.js"></script>
	<script src="assets/js/breakpoints.min.js"></script>
	<script src="assets/js/util.js"></script>
	<script src="assets/js/main.js"></script>

</body>
</html>