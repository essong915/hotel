<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
    
 <h2>객실 수정</h2>

<form action="${pageContext.request.contextPath}/admin/roomUpdate.do" method="post">
    <input type="hidden" name="room_id" value="${vo.room_id}">

    객실명: <input type="text" name="room_name" value="${vo.room_name}"><br>
    정원: <input type="text" name="capacity" value="${vo.capacity}"><br>
    위치: <input type="text" name="room_location" value="${vo.room_location}"><br>
    룸구성: <textarea name="room_description">${vo.room_description}</textarea><br>
    이미지: <input type="file" name="room_img"><br>
    <c:forEach var="image" items="${imageVO}">
  	  <img src="${image.image_path}" width="200">
  	  ${image.image_path}
    </c:forEach>

    <button type="submit">수정완료</button>
</form>

