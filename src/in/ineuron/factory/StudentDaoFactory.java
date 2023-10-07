package in.ineuron.factory;

import in.ineuron.dao.IStudentDao;
import in.ineuron.dao.StudentDaoImpl;

public class StudentDaoFactory {
private static IStudentDao studentDao=null;
private StudentDaoFactory() {
	
}
static {
	System.out.println("dao factory class get loaded");
}

public static IStudentDao getStudentDao() {
	if(studentDao==null) {
		studentDao=new StudentDaoImpl();
	}
	return studentDao;
}
	
}
