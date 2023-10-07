package in.ineuron.service;

import in.ineuron.dto.Student;

public interface IStudentService {
	String save(Student student); //For Create Operation of Database
    Student findById(Integer sid);//Reading record
    String updateByStudent(Student student); //updating a recod
    String deleteById(Integer sid);//Deleting a record
}
