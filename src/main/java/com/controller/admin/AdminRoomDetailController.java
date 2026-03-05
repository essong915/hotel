package com.controller.admin;

import com.controller.Action;
import com.dao.AdminDAO;
import com.vo.RoomVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AdminRoomDetailController implements Action {

    @Override
    public String execute(HttpServletRequest request,
                          HttpServletResponse response) {

        int roomId = Integer.parseInt(request.getParameter("room_id"));

        AdminDAO dao = new AdminDAO(request.getServletContext());
        RoomVO vo = dao.selectRoomByNo(roomId);  

        request.setAttribute("vo", vo);

        return "admin/room/roomDetail";
    }
}