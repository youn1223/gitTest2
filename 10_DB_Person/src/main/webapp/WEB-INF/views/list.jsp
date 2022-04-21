<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
list.jsp <br>
레코드 갯수 : ${fn:length(lists)} <br>

<table border="1" width="500">
	<tr>
		<td>번호</td>
		<td>아이디</td>
		<td>이름</td>
		<td>나이</td>
	</tr>
	<c:forEach var="i" begin="0" end="${fn:length(lists)-1}" step="1">
		<tr>
			<td>${lists[i].num }</td>
			<td>${lists[i].id }</td>
			<td>
				<a href="content_view?num=${lists[i].num }">${lists[i].name }</a>
			</td>
			<td>${lists[i].age }</td>
		</tr>
	</c:forEach>
	<tr>
		<td colspan="4">
			<a href="javascript:history.go(-1)">돌아가기</a>
			<a href="insertForm">삽입</a>
		</td>
	</tr>
</table>