package com.controller.admin;

import java.io.File;
import java.util.Collection;
import java.util.UUID;

import com.controller.Action;
import com.dao.AdminDAO;
import com.vo.RoomVO;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

public class AdminRoomUpdateController implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

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

		    try {

		        System.out.println("=== 수정 실행 ===");

		        int roomId = Integer.parseInt(request.getParameter("room_id"));
		        String roomName = request.getParameter("room_name");
		        String capacity = request.getParameter("capacity");
		        String location = request.getParameter("room_location");
		        String description = request.getParameter("room_description");
		        String usage_time = request.getParameter("usage_time");
		        String amenity = request.getParameter("amenity");
		        String minibar = request.getParameter("minibar");

		        RoomVO vo = new RoomVO();
		        vo.setRoom_id(roomId);
		        vo.setRoom_name(roomName);
		        vo.setCapacity(capacity);
		        vo.setRoom_location(location);
		        vo.setRoom_description(description);
		        vo.setUsage_time(usage_time);
		        vo.setAmenity(amenity);
		        vo.setMinibar(minibar);

		        dao.updateRoom(vo);

		        Collection<Part> parts = request.getParts();

		        String uploadPath = "C:/hotelUploads/room";
		        int order = 1;

		        for (Part part : request.getParts()) {

	                if ("room_img".equals(part.getName()) && part.getSize() > 0) {

	                    String originalFileName = part.getSubmittedFileName();
	                    String savedFileName = originalFileName;

	                    File targetFile = new File(uploadPath, originalFileName);

	                    if (targetFile.exists()) {

	                        String extension = "";
	                        int dotIndex = originalFileName.lastIndexOf(".");

	                        if (dotIndex != -1) {
	                            extension = originalFileName.substring(dotIndex);
	                            originalFileName = originalFileName.substring(0, dotIndex);
	                        }

	                        savedFileName = originalFileName + "_" + UUID.randomUUID() + extension;
	                    }

	                    part.write(uploadPath + File.separator + savedFileName);

	                    String imagePath = "/upload/room/" + savedFileName;

	                    dao.insertRoomImage(
	                    		roomId,
	                            imagePath,
	                            order == 1 ? "Y" : "N",   // 첫번째 이미지만 대표
	                            order
	                    );

	                    order++;
	                }
		        }

		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		    return "redirect:/admin/roomManage.do";
		}

		return null;
	}
}