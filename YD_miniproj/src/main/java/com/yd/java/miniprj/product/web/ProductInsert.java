package com.yd.java.miniprj.product.web;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yd.java.miniprj.common.Command;
import com.yd.java.miniprj.product.ProductDAO;
import com.yd.java.miniprj.product.ProductDAOImpl;
import com.yd.java.miniprj.product.ProductVO;

public class ProductInsert implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");

		System.out.println("doPost call()");
		String path = "c:/tmp";

		ServletContext sc = request.getServletContext();
		path = sc.getRealPath("img"); // 서버상경로.

		MultipartRequest multi;
		ProductVO vo = new ProductVO();
		try {
			String fileName = "";
			multi = new MultipartRequest(request, // 요청정보
					path, // 저장위치
					8 * 1024 * 1024, // 용량
					"UTF-8", // 인코딩
					new DefaultFileRenamePolicy());
			vo.setProductName(multi.getParameter("title"));
			Enumeration en = multi.getFileNames();
			String fileN = null;
			while (en.hasMoreElements()) {
				String name = (String) en.nextElement();
				fileName = multi.getFilesystemName(name);
				fileN = fileName;
				System.out.println("name: " + name + ", fileName: " + fileName);
			}
			vo.setProductImg(fileName.substring(0, fileName.indexOf("(")));
			System.out.println(fileName.substring(0, fileName.indexOf("(")));
			vo.setProductPrice(Integer.parseInt(multi.getParameter("price")));
			vo.setProductCategory(multi.getParameter("category"));
			
			ProductDAOImpl pDAO = new ProductDAOImpl();
			pDAO.productInsert(vo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "layout/home.tiles";
	}

}
