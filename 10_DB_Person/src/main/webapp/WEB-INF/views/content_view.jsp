<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
content_view.jsp
<br>

회원 상세정보 보기(수정 폼) <br>
<form action="modify" method="post">
	<input type="hidden" name="num" value="${dto.num}">
	<table border="1" width="400">
		<tr>
			<td>아이디</td>
			<td>${dto.id}</td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="name" value="${dto.name}"></td>
		</Tr>
		<tr>
			<td>나이</td>
			<td><input type="text" name="age" value="${dto.age}"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="수정하기">
				<a href="list">목록보기</a> 
				<a href="delete?num=${dto.num }">삭제하기</a> 
			</td> 
		</tr>
	</table>
</form>
