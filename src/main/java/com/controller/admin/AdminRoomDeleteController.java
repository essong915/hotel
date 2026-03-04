package com.controller.admin;

import com.controller.Action;
import com.dao.AdminDAO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AdminRoomDeleteController implements Action {

    @Override
    public String execute(HttpServletRequest request,
                          HttpServletResponse response) {

        int room_no = Integer.parseInt(request.getParameter("room_no"));

        AdminDAO dao = new AdminDAO(request.getServletContext());
        dao.deleteRoom(room_no);

        return "redirect:/admin/roomManage.do";
    }
}