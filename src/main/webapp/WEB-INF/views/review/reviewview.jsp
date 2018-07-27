<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>리뷰 글보기</title>
<meta charset="utf-8">
<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style type="text/css">
/* th{border: 10px solid red;} */
  
  
  </style>
  
<script>
	$(document).ready(function() {
// 		$("#update").click(function() {
// 			location = 
// 				"reviewupdate.do?rno=" + $("#td_rno").text();
			
// 		});
		$("#delete").click(function() {
			if (confirm("정말 삭제하시겠습니까?"))
				location = "reviewdelete.do?rno=" + $("#td_rno").text();
		});
		$("#list").click(function() {
			 		location="reviewlist.do";
// 			$("#rno").attr("disabled","disabled");
// 			$("#dataForm").attr("action", "reviewlist.do");
// 			$("#dataForm").submit();
		});
	});
</script>
</head>
<body>
	<!-- 넘어온 데이터를 저장해 놓는 form tag 작성. 모든 input tag는 type 속성을 hidden -->
	<form id="dataForm">
		<input type="hidden" name="rno" value="${dto.rno}" /> <input
			type="hidden" name="page" value="${param.page }" /> <input
			type="hidden" name="rowPerPage" value="${param.rowPerPage }" /> <input
			type="hidden" name="searchKey" value="${param.searchKey }" /> <input
			type="hidden" name="searchWord" value="${param.searchWord }" />
	</form>
	<div class="container">
		<h1>리뷰 글보기</h1>
		<table class="table table-bordered"  >
			
			<tbody>
				<!-- 데이터를 출력한다. -->
				<tr>
					<th class="1">번호</th>
					<td id="td_rno">${dto.rno}</td>
				</tr>
				<tr>
					<th class="1" id="1" >아이디</th>
					<td>${dto.id}</td>
				</tr>
				<tr>
					<th class="1">조회수</th>
					<td>${dto.hit}</td>
				</tr>
				<tr>
					<th class="1">회사명</th>
					<td>${dto.fname}</td>
				</tr>
				<tr>
					<th class="1">주요메뉴</th>
					<td>${dto.maindish}</td>
				</tr>
				<tr>
					<th class="1">행사장소</th>
					<td>${dto.festloc}</td>
				</tr>
				<tr>
					<th class="1">행사날짜</th>
					<td>${dto.festdate}</td>
				</tr>
				
				<tr>
					<th class="1">평점</th>
					<td>${dto.score}</td>
				<tr />
				<tr>
					<th class="1">별점</th>
					<td style="color: red; font-size: 25px;">${dto.starscore}</td>
				</tr>
				<tr>
					<th class="1">내용</th>
					<td>${dto.content}</td>
				</tr>
			</tbody><tr></tr>
						</table>
						<table>
						
						<tr><td><br>
						<button id="update" class="btn btn-primary" onclick="window.open('reviewupdate.do?rno=${dto.rno}','window_name','width=600,height=800,location=no,status=no,scrollbars=yes');">수정</button>
						<button id="delete" class="btn btn-danger">삭제</button>
						<button id="list" class="btn btn-success">리스트</button>
					</td>
				</tr>

		</table>
	</div>
</body>
</html>