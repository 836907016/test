package com.hddx.listener;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.util.List;

@WebServlet("/uploadServlet")
public class uploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        String root = request.getServletContext().getRealPath("/");
        File file = new File(root + "/temp/");
        if (!file.exists()) {
            file.mkdirs();
        }
        diskFileItemFactory.setRepository(file);
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
        servletFileUpload.setHeaderEncoding("utf-8");

        try {
            List<FileItem> fileItems = servletFileUpload.parseRequest(request);
            for (FileItem fileItem : fileItems) {
                if (fileItem.isFormField()) {
                    String username = fileItem.getFieldName();
                    if (!fileItem.getString().equals("")) {
                        String username_value = fileItem.getString("utf-8");
                        writer.write(username + ":" + username_value + "</br>");
                    }
                } else {
                    String fieldName = fileItem.getName();
                    if (fieldName != null && !fieldName.equals("")) {
                        writer.write("文件名" + fieldName + "</br>");
                        // 文件保存
                        InputStream is = fileItem.getInputStream();
                        File file2 = new File(root + "/files/");
                        if (!file2.exists()) {
                            file2.mkdirs();
                        }
                        FileOutputStream os = new FileOutputStream(file2 + "/" + fieldName);
                        byte[] bytes = new byte[1024];
                        int len = 0;
                        while ((len = is.read(bytes)) != -1) {
                            os.write(bytes, 0, len);
                        }
                        is.close();
                        os.close();
                        fileItem.delete();
                        writer.write("上传成功" + "</br>");
                    }
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }
}