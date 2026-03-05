package com.controller.admin;

import java.util.List;

import com.controller.Action;
import com.dao.AdminDAO;
import com.vo.RoomVO;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AdminRoomUpdateController implements Action {

    @Override
    public String execute(HttpServletRequest request,
                          HttpServletResponse response) {

        String method = request.getMethod();
        ServletContext context = request.getServletContext();
        AdminDAO dao = new AdminDAO(context);

        if (method.equals("GET")) {

            int roomId = Integer.parseInt(request.getParameter("room_id"));
            RoomVO room = dao.selectRoomByNo(roomId);

            request.setAttribute("room", room);

            return "admin/room/roomDetail";
        }

        if (method.equals("POST")) {
        	System.out.println("=== 수정 실행 ===");
            int roomId = Integer.parseInt(request.getParameter("room_id"));
            String roomName = request.getParameter("room_name");
            String capacity = request.getParameter("capacity");
            String location = request.getParameter("room_location");
            String description = request.getParameter("room_description");

            RoomVO vo = new RoomVO();
            vo.setRoom_id(roomId);
            vo.setRoom_name(roomName);
            vo.setCapacity(capacity);
            vo.setRoom_location(location);
            vo.setRoom_description(description);

            dao.updateRoom(vo);

            return "redirect:/admin/roomManage.do";
        }

        return null;
    }
}