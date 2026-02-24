<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/board.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<div class='wrapper'>
		<header>
			<h3 style="fontWeight: bolder">KH C CLASS</h3>
		</header>
		<nav>
			<a id='list'>게시판</a> <a id='insert'>등록</a>
		</nav>
		<div class='outer'>
			<!-- 
				게시글 목록,
				게시글 등록,
				게시글 상세보기				
			 -->						
		</div>
	</div>
	<script>
	// 요번 실습 숙지 하기
	
		//첫 요청
		function showList(){
			$.ajax({
				url : '/ajax/board/list',
				success : function(data){
					$(".outer").html(data);
				},
				error : function(xhr, status){
					console.log(xhr)
				}
			})
		}
		showList();
		$("#list").on('click',function(e){
			// 게시판 클릭시 (월래의 게시판 으로 돌아가는 장치)
			showList();
		});
		
		$("#insert").on('click',function(e){
			// 등록 클릭시(등록 jsp로 넘어가는 장치)
			$.ajax({
				url : '/ajax/board/insert',
				success : function(data){
					$(".outer").html(data);
				},
				error : function(xhr, status){
					console.log(xhr);
				}
			})
		});
		$(".outer").on('click',"table.list-table > tbody > tr", function(){
			// 
			
			//table.list-table 이라고 한이유는 그냥 table이라고 적으면 그 게시판 안에 들어
			// 가서도 게시판 1번글 작성자등을 눌려도 반응을 하는데 그걸 방지 하기 위해서 
			// list 에 table.list을 적음으로써 방지를 한거임
			
			// 게시판 리스트 클릭시
			//console.log("print");
			//let bno = $(this).children().eq(0).text();
			//console.log("클릭한 글 번호: " + bno);
			
			//현제 선택된 tr태그(원래 같으면 이코드는 list에서 작성하는 게 좋음)
			var bno = $(this).children().eq(0).text();
			console.log("클릭한 글 번호: " + bno)
			
			$.ajax({
				url : "/ajax/board/view",
				data : {bno}, // 키값과 벨류값이 같으면 하나로 합치기 가능{키값 : 벨류값}
				success : function(data){
					$(".outer").html(data);
					
				},
				error : function(xhr){
					console.log(xhr);
				}
			});
			
		});
		
		$(".outer").on("click",".enroll-table #btn", function(){
			// 백엔드에 전송할 데이터
			var data = {
				title : $("[name=title]").val() ,
				writer : $("[name=nickname]").val() ,
				content : $("[name=content]").val()
			};
			$.ajax({
				url : '/ajax/board/insert',
				data,
				method : "post",
				success : function(){
					alert("저장성공!");
					showList();
				},
				error : function(err){
					console.log(err);
				}
			});
		});
	</script>

</body>
</html>