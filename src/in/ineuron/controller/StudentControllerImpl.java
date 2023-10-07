/**
 * 
 */
package in.ineuron.controller;

import in.ineuron.dto.Student;
import in.ineuron.factory.StudentServiceFactory;
import in.ineuron.service.IStudentService;

 
public class StudentControllerImpl implements IStudentController {
    IStudentService stdService;
	
	@Override
	public String save(Student student) {
		stdService=StudentServiceFactory.getStudentService();
		System.out.println("Implementation className is:: "+stdService.getClass().getName());
		return  stdService.save(student);
	}

	@Override
	public Student findById(Integer sid) {
		stdService=StudentServiceFactory.getStudentService();
		return stdService.findById(sid);
	}

	@Override
	public String updateByStudent(Student student) { 
		stdService=StudentServiceFactory.getStudentService();
		return stdService.updateByStudent(student);
	}

	@Override
	public String deleteById(Integer sid) {
		stdService=StudentServiceFactory.getStudentService();
		return stdService.deleteById(sid);
	}

}
