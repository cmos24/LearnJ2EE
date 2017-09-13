import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	public void init(ServletConfig cnofig) {
		System.out.println("init of Hello Servlet");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) {

		try {

			/*���ò�ʹ�û���  ����
			ʹ�û�����Լӿ�ҳ��ļ��أ����ͷ���˵ĸ���������Ҳ���ܿ�����ʱ����Ϣ������ͨ�������ֶ�֪ͨ�������Ҫʹ�û���

			 
			response.setDateHeader("Expires",0 );
			response.setHeader("Cache-Controll","no-cache");
			response.setHeader("pragma","no-cache");*/
			
			response.setDateHeader("Expires", 0);
			response.setHeader("Cache-Controll", "no-cache");
			response.setHeader("pragma", "no-cache");			
			
			/*��ȡͷ��Ϣ
			request.getHeader() ��ȡ��������ݹ�����ͷ��Ϣ�� 
			����getHeader("user-agent") ���Ի�ȡ������Ļ������ϣ����������ж���firefox��IE��chrome��������safari�����
			request.getHeaderNames() ��ȡ��������е�ͷ��Ϣ���ƣ�����ͷ��Ϣ���ƾ��ܱ��������е�ͷ��Ϣ

			�ڱ������޸�HelloServlet,ʹ���ȡͷ��Ϣ
			����HelloServlet��ȡ����ͷ��Ϣ:
			host: ������ַ
			user-agent: �������������
			accept: ��ʾ��������ܵ���������
			accept-language: ��ʾ��������ܵ�����
			accept-encoding: ��ʾ��������ܵ�ѹ����ʽ����ѹ����ʽ�����Ǳ���
			connection: �Ƿ񱣳�����
			cache-control: ����ʱ��*/
			
			Enumeration<String> headerNames = request.getHeaderNames();
			while (headerNames.hasMoreElements()) {
				String header = headerNames.nextElement();
				String value = request.getHeader(header);
				System.out.printf("%s\t%s%n", header, value);
			}

			response.getWriter().println("<h1>Hello Servlet!</h1>");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date n = new Date();
			String time = sdf.format(n);
			// response.getWriter().println(new Date().toLocaleString());
			response.getWriter().println(time);
			
			
			/*������Ӧ��ʽ
			 
			response.setContentType("text/html");
			 


			"text/html" �Ǽ���ʽ ����request��ȡͷ��Ϣ �ж�Ӧ��request.getHeader("accept"). 
			"text/html" �Ǵ��ڵģ���ʾ���������ʶ�����ָ�ʽ�������һ�������ĸ�ʽ�� ���� "text/lol" �����������ʶ����ô�򿪴�servlet�ͻᵯ��һ�����صĶԻ���

			�������ֶ�Ҳ�ͳ�������ʵ�����ع���*/
			response.setContentType("text/lol");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
