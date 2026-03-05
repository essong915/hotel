<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
    
 <h2>객실 수정</h2>

<form action="${pageContext.request.contextPath}/admin/roomUpdate.do" method="post" enctype="multipart/form-data">
    <input type="hidden" name="room_id" value="${vo.room_id}">

    객실명: <input type="text" name="room_name" value="${vo.room_name}"><br>
    정원: <input type="text" name="capacity" value="${vo.capacity}"><br>
    위치: <input type="text" name="room_location" value="${vo.room_location}"><br>
    룸구성: <textarea name="room_description">${vo.room_description}</textarea><br>
    이용시간: <input type="text" name="usage_time" value="${vo.usage_time}"><br>
    어매니티: <input type="text" name="amenity" value="${vo.amenity}"><br>
    미니바: <input type="text" name="minibar" value="${vo.minibar}"><br>
    이미지: <input type="file" name="room_img" multiple onchange="previewImages(event)"><br>
    <div id="preview"></div><hr>
    기존이미지<br>
    <c:forEach var="image" items="${imageVO}">
  	  <img src="${image.image_path}" width="200">
  	  <input type="radio"
               name="main_image"
               value="${image.image_no}"
               ${image.is_main eq 'Y' ? 'checked' : ''}>
        대표이미지 /
	<a href="${pageContext.request.contextPath}/admin/deleteRoomImage.do?room_id=${vo.room_id}&image_path=${image.image_path}">삭제</a><br>
    </c:forEach>

    <button type="submit">수정완료</button>
</form>

<script>
function previewImages(event) {

    const preview = document.getElementById("preview");
    preview.innerHTML = "";   // 기존 preview 초기화

    const files = event.target.files;

    for (let i = 0; i < files.length; i++) {

        const reader = new FileReader();

        reader.onload = function(e) {

            const img = document.createElement("img");
            img.src = e.target.result;
            img.width = 200;
            img.style.margin = "5px";

            preview.appendChild(img);
        }

        reader.readAsDataURL(files[i]);
    }
}
</script>