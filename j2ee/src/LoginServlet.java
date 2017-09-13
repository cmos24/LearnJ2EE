import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	/*
	 * service() LoginServlet�̳���HttpServlet,ͬʱҲ�̳���һ������
	 * 
	 * service(HttpServletRequest , HttpServletResponse )
	 * 
	 * 
	 * 
	 * ʵ���ϣ���ִ��doGet()����doPost()֮ǰ��������ִ��service()
	 * 
	 * ��service()���������жϣ����׸õ���doGet()����doPost()
	 * 
	 * ���Է��֣�service(), doGet(), doPost() ���ַ�ʽ�Ĳ����б���һ���ġ�
	 * 
	 * ���ԣ���ʱ��Ҳ��ֱ����дservice()�������������ṩ��Ӧ�ķ��񣬾Ͳ������ֵ�����get����post�ˡ�
	 * 
	 * �����ǰ��ĵ�¼��LoginServlet����Ϊ�ṩservice������Ҳ���Դﵽ��ͬ��Ч��
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("�������������ʱ������URL������Э�� ������ �˿�(�����): " + request.getRequestURL());
		System.out.println("����������������Դ�����֣�ȥ����Э���������: " + request.getRequestURI());
		System.out.println("�������еĲ�������: " + request.getQueryString());
		System.out.println("����������ڵĿͻ�����IP��ַ: " + request.getRemoteAddr());
		System.out.println("����������ڵĿͻ�����������: " + request.getRemoteHost());
		System.out.println("����������ڵĿͻ���ʹ�õ�����˿�: " + request.getRemotePort());
		System.out.println("��������IP��ַ: " + request.getLocalAddr());
		System.out.println("��������������: " + request.getLocalName());
		System.out.println("�õ��ͻ�������ʽ: " + request.getMethod());
		/*
		 * ��servlet���н���ͱ���
		 * 
		 * byte[] bytes= name.getBytes("ISO-8859-1"); name = new
		 * String(bytes,"UTF-8");
		 * 
		 * 
		 * �ȸ���ISO-8859-1���룬Ȼ����UTF-8���� �����Ϳ��Եõ���ȷ�����Ĳ�����
		 * 
		 * ������Ҫ��ÿһ���ύ�����ݶ����б���ͽ��봦����������鷳��Ҳ����ʹ��һ�仰���棺
		 */
		request.setCharacterEncoding("UTF-8");// ���Ұ���仰����request.getParameter()֮ǰ

		String name = request.getParameter("name");
		String password = request.getParameter("password");

		System.out.println("name=" + name);
		System.out.println("password=" + password);

		String html = null;
		/*
		 * �Ƚϵ�ʱ��ѳ����ַ���"admin" "123"��ǰ�棬��Ϊ�û�����û�������˺�������ύ�� servlet���ȡ��null��
		 * �����͹���˿�ָ���쳣�����⡣
		 */
		if ("admin".equals(name) && "123".equals(password)) {
			request.getRequestDispatcher("success.html").forward(request, response);
			// html="<div style='color:green'>��¼�ɹ�</div>";
		} else {
			response.sendRedirect("fail.html");
			// html="<div style='color:red'>��¼ʧ��</div>";
		}

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.println(html);
	}
}
