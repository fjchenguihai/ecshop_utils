package com.ecshop.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class FTPTools extends HttpServlet{
	private FTPClient ftp;
	final static int BUFFER_SIZE = 4096;  

	public boolean connect(String path, String addr, int port,
			String username, String password) throws Exception {
		boolean result = false;
		ftp = new FTPClient();
		int reply;
		ftp.connect(addr, port);
		ftp.login(username, password);
		ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
		reply = ftp.getReplyCode();
		if (!FTPReply.isPositiveCompletion(reply)) {
			ftp.disconnect();
			return result;
		}
		ftp.changeWorkingDirectory(path);
		result = true;
		return result;
	}

	/**
	 * 
	 * @param file
	 *            上传的文件或文件夹
	 * @throws Exception
	 */
	public void upload(File file) throws Exception {
		if (file.isDirectory()) {
			ftp.makeDirectory(file.getName());
			ftp.changeWorkingDirectory(file.getName());
			String[] files = file.list();
			for (int i = 0; i < files.length; i++) {
				File file1 = new File(file.getPath() + "\\" + files[i]);
				if (file1.isDirectory()) {
					upload(file1);
					ftp.changeToParentDirectory();
				} else {
					File file2 = new File(file.getPath() + "\\" + files[i]);
					FileInputStream input = new FileInputStream(file2);
					ftp.storeFile(file2.getName(), input);
					input.close();
				}
			}
		} else {
			File file2 = new File(file.getPath());
			FileInputStream input = new FileInputStream(file2);
			ftp.storeFile(file2.getName(), input);
			input.close();
		}
	}

	public void upload(File file,String dir) throws Exception {
		if (file.isDirectory()) {
			ftp.makeDirectory(file.getName());
			ftp.changeWorkingDirectory(file.getName());
			String[] files = file.list();
			for (int i = 0; i < files.length; i++) {
				File file1 = new File(file.getPath() + "\\" + files[i]);
				if (file1.isDirectory()) {
					upload(file1);
					ftp.changeToParentDirectory();
				} else {
					File file2 = new File(file.getPath() + "\\" + files[i]);
					FileInputStream input = new FileInputStream(file2);
					ftp.storeFile(file2.getName(), input);
					input.close();
				}
			}
		} else {
			File file2 = new File(file.getPath());
			FileInputStream input = new FileInputStream(file2);
			ftp.changeWorkingDirectory(dir);
			ftp.storeFile(file2.getName(), input);
			input.close();
		}
	}

	public String upload(File file,String dir,String newname) throws Exception {
		String newFileName = UUID.randomUUID() + file.getName().substring(file.getName().lastIndexOf("."));;
		if (file.isDirectory()) {
			ftp.makeDirectory(file.getName());
			ftp.changeWorkingDirectory(file.getName());
			String[] files = file.list();
			for (int i = 0; i < files.length; i++) {
				File file1 = new File(file.getPath() + "\\" + files[i]);
				if (file1.isDirectory()) {
					upload(file1);
					ftp.changeToParentDirectory();
				} else {
					File file2 = new File(file.getPath() + "\\" + files[i]);
					FileInputStream input = new FileInputStream(file2);
					ftp.storeFile(file2.getName(), input);
					ftp.rename(file2.getName(), newFileName); 
					input.close();
				}
			}
		} else {
			File file2 = new File(file.getPath());
			FileInputStream input = new FileInputStream(file2);
			ftp.changeWorkingDirectory(dir);
			ftp.storeFile(file2.getName(), input);
			ftp.rename(file2.getName(),newFileName); 
			input.close();
		}
		return newFileName;
	}

	public void upload(InputStream in,String dir) throws Exception {
			ftp.changeWorkingDirectory(dir);	
			ftp.storeUniqueFile(in);
	}
	


	private String errorcode = null;	//用于接收上传结果
	private static String msg = null;	//用于接收上传结果
	private static String subfix = null;
	
//	@SuppressWarnings("unchecked")

//    public void init() throws ServletException {
//        File uploadFile = new File(uploadPath);
//        if (!uploadFile.exists()) {
//            uploadFile.mkdirs();
//        }
//        File tempPathFile = new File(tempPath);
//         if (!tempPathFile.exists()) {
//            tempPathFile.mkdirs();
//        }
//     }
	
	
	
	public void upload(HttpServletRequest request, HttpServletResponse response,String dir)throws Exception 
	{
		DiskFileItemFactory factory = new DiskFileItemFactory();
    	  System.out.println("begin try");
      factory.setSizeThreshold(4096000); // 设置缓冲区大小，这里是4kb
      ServletFileUpload upload = new ServletFileUpload(factory);
      System.out.println("begin 1");
      upload.setSizeMax(419430400); // 设置最大文件尺寸，这里是4MB

      List<FileItem> items = upload.parseRequest(request);// 得到所有的文件
      Iterator<FileItem> i = items.iterator();
      System.out.println("get file success");
      System.out.println("begin 2");
      while (i.hasNext()) {
         FileItem fi = (FileItem) i.next();
         String fileName = fi.getName();
         if (fileName != null) {
             System.out.println("file content:"+fi.getString());

     		System.out.println("upload begin:");
    		FTPTools t = new FTPTools();
    		System.out.println("upload new:");
    		try {
				t.connect("", "115.28.1.179", 21, "root", "VveShop123456");
			} catch (Exception e) {
				e.printStackTrace();
			}
    		System.out.println("upload connected:");
    		t.upload(fi.getInputStream(),"1/upload/idcart");
    		System.out.println("upload success:");
    		
 			} 
	}
}
	
	public static void main(String[] args) throws Exception {
		System.out.println("upload begin:");
		FTPTools t = new FTPTools();
		System.out.println("upload new:");
		t.connect("", "115.28.1.179", 21, "root", "VveShop123456");
		File file = new File("F:\\SqlServer_script.sql");
		System.out.println("upload connected:");
		t.upload(file,"1/upload/idcart");
		System.out.println("upload success:");
	}
}
