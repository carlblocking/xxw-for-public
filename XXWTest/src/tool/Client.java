package tool;



import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Client {
	 public static void main(String[]args){  
		 Configuration configuration=new Configuration().configure();
		 SessionFactory factory=configuration.buildSessionFactory();
		 Session session=null;
		 try {
			session=factory.openSession();
			session.beginTransaction();
			Student student=new Student();
			student.setCreateTime(new Date());
			student.setExpireTime(new Date());
			student.setName("lisa");
			student.setPassword("123");
			session.save(student);
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();session.getTransaction().rollback();
		}
		 finally
		 {
			 if(session!=null){
				 if(session.isOpen())
				 {
					 session.close();
				 }
			 }
		 }
	 }  
}
