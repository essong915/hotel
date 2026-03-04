package com.controller.admin;

import java.io.File;
import java.util.UUID;

import com.controller.Action;
import com.dao.AdminDAO;
import com.vo.RoomVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

public class AdminRoomInsertController implements Action {

    @Override
    public String execute(HttpServletRequest request,
                          HttpServletResponse response) {

        try {

            // 1️⃣ 기본 데이터 받기
            int room_no = Integer.parseInt(request.getParameter("room_no"));
            String room_name = request.getParameter("room_name");
            String capacity = request.getParameter("capacity");
            String room_location = request.getParameter("room_location");
            String room_description = request.getParameter("room_description");

            // 2️⃣ 파일 업로드 처리
            Part filePart = request.getPart("room_img");

            String uploadPath = "C:/hotelUploads/room";

            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            
            String savedFileName = filePart.getSubmittedFileName();
            if (filePart != null && filePart.getSize() > 0) {

                String originalFileName = filePart.getSubmittedFileName();
                savedFileName = UUID.randomUUID() + "_" + originalFileName;

                filePart.write(uploadPath + File.separator + savedFileName);
            }

            // 3️⃣ VO 세팅
            RoomVO vo = new RoomVO();
            vo.setRoom_no(room_no);
            vo.setRoom_name(room_name);
            vo.setCapacity(capacity);
            vo.setRoom_location(room_location);
            vo.setRoom_description(room_description);
            vo.setRoom_image(savedFileName);

            // 4️⃣ DAO 호출
            AdminDAO dao = new AdminDAO(request.getServletContext());
            dao.insertRoom(vo);

            return "redirect:/admin/roomManage.do";

        } catch (Exception e) {

            e.printStackTrace();

            // 에러 발생 시 에러페이지로 이동
            request.setAttribute("errorMsg", "객실 등록 중 오류가 발생했습니다.");
            return "/admin/room/roomManage";
        }
    }
}