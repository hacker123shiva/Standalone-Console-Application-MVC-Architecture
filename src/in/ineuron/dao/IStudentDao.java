package in.ineuron.dao;

import in.ineuron.dto.Student;

public interface IStudentDao {
	String save(Student student); //For Create Operation of Database
    Student findById(Integer sid);//Reading record
    String updateByStudent(Student student); //updating a recod
    String deleteById(Integer sid);//Deleting a record 
}
