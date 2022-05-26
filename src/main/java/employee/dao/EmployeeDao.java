package employee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import employee.dto.Employee;

public class EmployeeDao {
	public static Connection getConnect() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_prc", "root", "root");
		return con;
	}

	public void insertEmployee(int no,Employee e) throws Exception {
		PreparedStatement ps=null;
		for(int i=0;i<=no;i++)
		{
			Connection con = getConnect();
			ps = con.prepareStatement("insert into employee values(?,?,?,?)");
			ps.setInt(1, e.getEmp_id());
			ps.setString(2, e.getEmp_name());
			ps.setString(3, e.getEmp_email());
			ps.setString(4, e.getEmp_password());
			ps.addBatch();
		}
		ps.executeBatch();
		System.out.println("====inserted====");
	}

	public void deleteEmployee(int id) throws Exception {
		Connection con = getConnect();
		PreparedStatement ps = con.prepareStatement("delete from employee where emp_id = ?");
		ps.setInt(1, id);
		ps.executeUpdate();
		System.out.println("====deleted====");
	}

	public void updateEmployee(int id, Employee e) throws Exception {
		Connection con = getConnect();
		PreparedStatement ps = con.prepareStatement("update employee set emp_name=?,emp_email=?,emp_password=? where emp_id=?");
		ps.setString(1,e.getEmp_name());
		ps.setString(2,e.getEmp_email());
		ps.setString(3,e.getEmp_password());
		
		ps.setInt(4, id);
		
		ps.executeUpdate();
		System.out.println("===Updated===");
	}
	public void showEmployee(int id) throws Exception {
		Connection con = getConnect();
		PreparedStatement ps = con.prepareStatement("select * from employee where emp_id= ?");
		ps.setInt(1, id);
		ResultSet rs =ps.executeQuery();
		while(rs.next())
		{
			System.out.println("employee id is     : "+rs.getInt(1)+"  ");
			System.out.println("employee name is   : "+rs.getString(2)+"  ");
			System.out.println("employee email_id  : "+rs.getString(3)+"  ");
			System.out.println("=================================");
		}
		System.out.println("=================================");
	}

}
