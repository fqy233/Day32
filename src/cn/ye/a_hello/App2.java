package cn.ye.a_hello;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

public class App2 {

	@Test
	public void testSave() throws Exception {
		
		//创建实体对象
		Employee emp = new Employee("欧尼酱",2);
		
		//创建配置管理类对象
		Configuration config = new Configuration();
		
		//默认读取hibernate.cfg.xml文件
		config.configure();
		//config.configure("cn/itcast/hibernate.cfg.xml");//也可以选择读取其他位置的配置文件
		
		//得到SessionFactory工厂
		SessionFactory sf = config.buildSessionFactory();
		
		//开启session
		Session session = sf.openSession();
		
		//开启事物
		Transaction transaction = session.beginTransaction();
		
		//保存数据
		session.save(emp);
		
		//提交数据
		transaction.commit();
		
		//关闭
		session.close();
		sf.close();
		
	}
}
