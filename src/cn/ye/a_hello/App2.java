package cn.ye.a_hello;

import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

public class App2 {

	private static SessionFactory sf;
	
	static {
		//创建配置管理类对象
		Configuration config = new Configuration();
		
		//默认读取hibernate.cfg.xml文件
		config.configure();
		//config.configure("cn/itcast/hibernate.cfg.xml");//也可以选择读取其他位置的配置文件
		
		//得到SessionFactory工厂
		sf = config.buildSessionFactory();
		
	}
	
	@Test
	public void testSave() throws Exception {
		
		//创建实体对象
		Employee emp = new Employee("欧尼酱",2);
		
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
	
	@Test
	public void testUpdate() throws Exception {
		
		//对象
		Employee emp = new Employee("超哥",12);
		emp.setEmpID(1);
		
		//打开session
		Session session = sf.openSession();
		
		//开启事务
		Transaction ts = session.beginTransaction();
		
		//根据主键查询
//		Employee employee = (Employee) session.get(Employee.class, 1);
//		
//		if (employee!=null) {
//			//更新时,需要在对象中插入主键
//			//session.update(employee);
//		}
		
		//对象没有设置主键时，执行插入操作，设置了主键时，执行更新操作 
		session.saveOrUpdate(emp); 
		
		//System.out.println(employee);
		
		//执行
		ts.commit();
		
		//关闭
		session.close();
	}
}
