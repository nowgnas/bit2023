package web.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import app.dto.Item;
import app.frame.ControllerFrame;
import app.item.ItemServiceImpl;

/**
 * Servlet implementation class CustServlet
 */
@WebServlet({"/item"})
public class ItemController implements ControllerFrame {
	
	ItemServiceImpl service;

    public ItemController() {
        super();
        service = new ItemServiceImpl();
    }

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String next = "index.jsp";
		String cmd = request.getParameter("cmd");

		if(cmd != null){
			next = build(request, cmd);
		}

		RequestDispatcher rd = 
				request.getRequestDispatcher(next);
				rd.forward(request, response);		
	}
	
	private String build(HttpServletRequest request,
			String cmd) throws UnsupportedEncodingException{
		String next = "index.jsp";
		if(cmd.equals("register")){
			request.setAttribute("center", "item/register");
		}else if(cmd.equals("registerimpl")) {
		
			int fileSizeMax = 1024 * 1024 * 100;
			String dir_path="C:\\web\\day05\\webapp\\img";

			boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);
			Item data = new Item();
			
			if (isMultipartContent) {

				DiskFileItemFactory factory = new DiskFileItemFactory();
				factory.setSizeThreshold(fileSizeMax);
				
				ServletFileUpload sfu = new ServletFileUpload(factory);
				sfu.setFileSizeMax(fileSizeMax);

				try {
					List<FileItem> items = sfu.parseRequest(request);
					for (FileItem item : items) {

						if (item.isFormField()) { 
							if(item.getFieldName().equals("name")) {	
								data.setName(item.getString("UTF-8"));
							}
							if(item.getFieldName().equals("price")) {	
								data.setPrice(Long.parseLong(item.getString("UTF-8")));
							}

						} else {
							
							if(item.getFieldName().equals("img")) {
								if(item.getName() == null) {
									continue;	
								}else {
									data.setImgname(item.getName());
								}
								String fileName = FilenameUtils.getName(item.getName());
								File saveFile = new File(dir_path, fileName);
								try {
									item.write(saveFile);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						}
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			try {
				service.register(data);
				next = "item.bit?cmd=getall";
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}else if(cmd.equals("modifyimpl")) {

			int fileSizeMax = 1024 * 1024 * 100;
			String dir_path="C:\\web\\day05\\webapp\\img";

			boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);
			Item data = new Item();
			
			if (isMultipartContent) {

				DiskFileItemFactory factory = new DiskFileItemFactory();
				factory.setSizeThreshold(fileSizeMax);
				
				ServletFileUpload sfu = new ServletFileUpload(factory);
				sfu.setFileSizeMax(fileSizeMax);

				try {
					List<FileItem> items = sfu.parseRequest(request);
					for (FileItem item : items) {

						if (item.isFormField()) { 
							if(item.getFieldName().equals("id")) {	
								data.setId(Integer.parseInt(item.getString("UTF-8")));
							}
							if(item.getFieldName().equals("name")) {	
								data.setName(item.getString("UTF-8"));
							}
							if(item.getFieldName().equals("price")) {	
								data.setPrice(Long.parseLong(item.getString("UTF-8")));
							}
							if(item.getFieldName().equals("imgname")) {	
								data.setImgname(item.getString("UTF-8"));
							}

						} else {
							
							if(item.getFieldName().equals("img")) {
								System.out.println(item.getName());
								if(item.getName() == null || item.getName().equals("")) {
									continue;	
								}else {
									data.setImgname(item.getName());
								}
								String fileName = FilenameUtils.getName(item.getName());
								File saveFile = new File(dir_path, fileName);
								try {
									item.write(saveFile);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						}
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			try {
				System.out.println(data);
				service.modify(data);
				next = "item.bit?cmd=getall";
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}else if(cmd.equals("removeimpl")) {
			int id = Integer.parseInt(request.getParameter("id"));
			try {
				service.remove(id);
				next = "item.bit?cmd=getall";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(cmd.equals("getall")){
			List<Item> list = null;
			try {
				list = service.get();
				request.setAttribute("ilist", list);
				request.setAttribute("center", "item/getall");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(cmd.equals("get")) {
			int id = Integer.parseInt(request.getParameter("id"));
			Item item = null;
			try {
				item = service.get(id);
				request.setAttribute("ditem", item);
				request.setAttribute("center", "item/get");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return next;
	}





}
