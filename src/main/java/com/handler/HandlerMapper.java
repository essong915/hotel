package com.handler;

import java.util.HashMap;

import com.controller.Action;
import com.controller.HomeController;
import com.controller.MemberMypageController;
import com.controller.ReservationMainController;
import com.controller.admin.AdminDashboardController;
import com.controller.admin.AdminLoginController;
import com.controller.admin.AdminLogoutController;
import com.controller.admin.AdminRoomAddController;
import com.controller.admin.AdminRoomDeleteController;
import com.controller.admin.AdminRoomDetailController;
import com.controller.admin.AdminRoomInsertController;
import com.controller.admin.AdminRoomManageController;
import com.controller.admin.AdminRoomUpdateController;

public class HandlerMapper {

	private HashMap<String, Action> map = new HashMap<>();

	public HandlerMapper() {
		map.put("/main.do", new HomeController()); // 메인
		map.put("/member/mypage.do", new MemberMypageController());
		map.put("/reservationMain.do", new ReservationMainController());
		map.put("/admin/login.do", new AdminLoginController());
		map.put("/admin/dashboard.do", new AdminDashboardController());
		map.put("/admin/roomManage.do", new AdminRoomManageController());
		map.put("/admin/logout.do", new AdminLogoutController());
		map.put("/admin/roomDetail.do", new AdminRoomDetailController());
		map.put("/admin/roomUpdate.do", new AdminRoomUpdateController());
		map.put("/admin/roomDelete.do", new AdminRoomDeleteController());
		map.put("/admin/roomInsert.do", new AdminRoomInsertController());
		map.put("/admin/roomAdd.do", new AdminRoomAddController());
	}

	public Action getController(String path) {
		return map.get(path);
		
	}
}