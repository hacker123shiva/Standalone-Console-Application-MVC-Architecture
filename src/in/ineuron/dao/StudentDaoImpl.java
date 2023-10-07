package in.ineuron.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.ineuron.dto.Student;
import in.ineuron.util.JdbcUtil;

public class StudentDaoImpl implements IStudentDao {
    
	private Connection connection=null;
	{
		try {
			connection=JdbcUtil.getJdbcConnection();
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}
    
	@Override
	public String save(Student student) {
		 String status=null;
		 String sqlInsertQuery="insert into student (`name`, `city`, `email`, `country`) values(?,?,?,?)";;
	     PreparedStatement pstmt=null;
		try {
			 
			pstmt=connection.prepareStatement(sqlInsertQuery);
			  
			if(pstmt!=null) {
		  
		   pstmt.setString(1,student.getName());
		   pstmt.setString(2,  student.getCity() );
		   pstmt.setString(3, student.getEmail());
		   pstmt.setString(4, student.getCountry());
		   System.out.println("Check all value inserted succesfully");
			}
			if(pstmt!=null) {
				 
				int rowAffected =  pstmt.executeUpdate();
				 
				if(rowAffected==1) {
					status="success";
					System.out.println(status);
				}
				else {
					status="failure";
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(connection!=null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return status;
	}

	@Override
	public Student findById(Integer sid) {
		
		 
		 String sqlInsertQuery="select id, name, city, email ,country from student where id=?";;
	     PreparedStatement pstmt=null;
	     ResultSet rs=null;
	     Student student=null;
	     System.out.println("check1");
		try {
			 
			pstmt=connection.prepareStatement(sqlInsertQuery);
			 System.out.println("check2");
			if(pstmt!=null) {
		  pstmt.setInt(1, sid);
		  System.out.println("check2.1");
			}
			if(pstmt!=null) {
				rs= pstmt.executeQuery();
				 System.out.println("check2.2");
				if(rs.next()) {
					//copy the resultset data to studentDTO and transfer  to the biew
					student =new Student();
					 System.out.println("check3");
					student.setId(rs.getInt(1));
					student.setName(rs.getString(2));
					student.setCity(rs.getString(3));
					student.setEmail(rs.getString(4));
					student.setCountry(rs.getString(5));
				}
				 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(connection!=null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return student;
	}
    @Override
	public String updateByStudent(Student student) {
		  
	     PreparedStatement pstmt=null;
	     int sid=student.getId();
	     String name=student.getName();
	     String city=student.getCity();
	     String email=student.getEmail();
	     String country=student.getCountry();
	     String sqlInsertQuery="Update student set name=?, city=?, email=?, country=? where id=?";
	     
		try {
			 
			pstmt=connection.prepareStatement(sqlInsertQuery);
			 
			if(pstmt!=null) {
		 
		  pstmt.setString(1,name);
		  pstmt.setString(2,city);
		  pstmt.setString(3, email);
		  pstmt.setString(4, country);
		  pstmt.setInt(5, sid);
		 
			}
			 if(pstmt!=null) {
				 int affectedRow=pstmt.executeUpdate();
				 if(affectedRow==1) {
					 return "success";
				 }
				 else {
					 return "failure";
				 }
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(connection!=null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return "Some problem occcured";
		
	}

	@Override
	public String deleteById(Integer sid) {
		 String status=null;
		 String sqlInsertQuery="Delete from student where id=? ";;
	     PreparedStatement pstmt=null;
	 	try {
			Student student=findById(sid);
			if(student!=null) {
				pstmt=connection.prepareStatement(sqlInsertQuery);
				  
				if(pstmt!=null) {
			  
			    pstmt.setInt(1, sid);
			 
				}
				if(pstmt!=null) {
					 
					int rowAffected =  pstmt.executeUpdate();
					 
					if(rowAffected==1) {
						status="success";
						System.out.println(status);
					}
					else {
						status="failure";
					}
				}
				else {
					status="not available";
				}
			}
	 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(connection!=null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return status;
	}

}
