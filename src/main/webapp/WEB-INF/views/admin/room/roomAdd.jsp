<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<h2>객실 추가</h2>

<form action="${pageContext.request.contextPath}/admin/roomInsert.do"
      method="post"
      enctype="multipart/form-data">

    객실번호: <input type="text" name="room_id"><br>
    객실명: <input type="text" name="room_name"><br>
    정원: <input type="text" name="capacity"><br>
    위치: <input type="text" name="room_location"><br>
    룸구성: <input type="text" name="room_description"><br>
    이용시간: <input type="text" name="usage_time"><br>
    어매니티: <input type="text" name="amenity"><br>
    미니바: <input type="text" name="minibar"><br>
    이미지: <input type="file" name="room_img" multiple><br>

    <button type="submit">등록</button>
</form>