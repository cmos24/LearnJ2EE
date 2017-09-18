import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadPhotoServlet2 extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		String filename = null;
		try {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			//
			factory.setSizeThreshold(1024 * 1024);

			List items = null;
			try {
				items = upload.parseRequest(request);
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
			Iterator iter = items.iterator();
			while (iter.hasNext()) {
				FileItem item = (FileItem) iter.next();
				if (!item.isFormField()) {
					//
					// String
					// username=request.getParameter("heroName");//无法这样获得参数因为form中的数据是用二进制提交的
					filename = System.currentTimeMillis() + ".jpg";
					String photoFolder = "e:\\code\\GitHub\\LearnJ2EE\\j2ee\\web\\uploaded";
					File f = new File(photoFolder, filename);
					f.getParentFile().mkdirs();

					//
					InputStream is = item.getInputStream();

					//
					FileOutputStream fos = new FileOutputStream(f);
					byte[] b = new byte[1024 * 1024];
					int length = 0;
					while (-1 != (length = is.read(b))) {// 如果文件长度不为零
						fos.write(b, 0, length);
					}
					fos.close();

				} else {
					System.out.println(item.getFieldName());
					String value = item.getString();
					value = new String(value.getBytes("ISO-8859-1"), "UTF-8");
					System.out.println(value);
				}

			}
			// 在页面上显示
			String html = "<img width='200' height='150' src='uploaded/%s' />";
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			pw.format(html, filename);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
