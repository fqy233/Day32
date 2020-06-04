package cn.ye.a_hello;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;


public class App {

	@Test
	public void testHello() {
		Employee emp = new Employee();
		emp.setEmpName("叶师傅");
		emp.setDeptID(1);
		
		//创建Configuration对象
		Configuration config = new Configuration();
		
		//默认加载src/hibernate.cfg.xml文件
		config.configure();		
		
		//创建session工厂对象
		SessionFactory sf = config.buildSessionFactory();
		
		//创建一个session
		Session  session = sf.openSession();
		
		//开启事务
		Transaction tx = session.beginTransaction();
		
		//保存到数据库
		session.save(emp);
		
		//提交事物
		tx.commit();
		
		//关闭
		session.close();
		sf.close();
		
	}
}
