package listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class ContextAttributeListener implements ServletContextAttributeListener{

	@Override
	public void attributeAdded(ServletContextAttributeEvent e) {
		System.out.println("增加属性	");
		System.out.println("属性是"+e.getName());
		System.out.println("值是"+e.getValue());
		
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent e) {
		System.out.println("移除属性	");
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent e) {
		System.out.println("替换属性	");
	}

}
