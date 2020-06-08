package cn.ye.a_hello;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

public class App3 {

	private static SessionFactory sf;
	
	static {
		
		Configuration config = new Configuration();
		
		//默认记载配置文件
		config.configure();
		
		sf = config.buildSessionFactory();
	}
	
	@Test
	public void testQuery() throws Exception {
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		//HQL查询全部数据
		Query query = session.createQuery("from Employee where empID = 1 or empID = 2");
		List<Employee> list = query.list();
		
		System.out.println(list);
		
		
		tx.commit();
		session.close();
	}
	
	/**
	 * QBC查询：query by criteria 完全面向对象的查询
	 * */
	@Test
	public void testQBC() throws Exception {
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Employee.class);
		
		criteria.add(Restrictions.eq("empID", 1));
		
		//查询全部
		List<Employee> list = criteria.list();
		
		System.out.println(list);
		
		tx.commit();
		session.close();
	}
	
	/**
	 * 根据本地sql查询
	 * */
	@Test
	public void testSQL() throws Exception {
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		SQLQuery sqlQuery = session.createSQLQuery("select * from employees").addEntity(Employee.class);
		
		List<Employee> list = sqlQuery.list();
		
		System.out.println(list);
		
		tx.commit();
		session.close();
	}
}
