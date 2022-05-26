package employee.dao;

import java.util.Scanner;

import employee.dto.Employee;

public class EmpDriver {
	public static void main(String[] args) throws Exception {
		Scanner scn =new Scanner(System.in);
		EmployeeDao ed = new EmployeeDao();
		boolean exit = true;
		while(exit)
		{
			System.out.println("=================================");
			System.out.println("1.add employee \n2.delete employee \n3.update employee \n4.show employee \n5.exit\n");
			System.out.print("Enter the chioce:-");
			int chioce  =scn.nextInt();
			switch(chioce)
			{
			case 1:
			{
				System.out.println("enter the no of employss u want enter");
				int no = scn.nextInt();
				System.out.println("enter the employee name ");
				String name= scn.next();
				System.out.println("enter the employee id ");
				int id= scn.nextInt();
				System.out.println("enter the employee email ");
				String email= scn.next();
				System.out.println("enter the password ");
				String password= scn.next();
				Employee e =new Employee();
				e.setEmp_id(id);
				e.setEmp_email(email);
				e.setEmp_name(name);
				e.setEmp_password(password);
				ed.insertEmployee(no,e);
			}
			break;
			case 2:
			{
				System.out.println("enter the employee id ");
				int id= scn.nextInt();
				ed.deleteEmployee(id);
			}
			break;
			case 3:
			{
				System.out.println("enter the employee id to update ");
				int id = scn.nextInt();
				System.out.println("=============================");
				System.out.println("enter the employee name ");
				String name= scn.next();
				System.out.println("enter the employee email ");
				String email= scn.next();
				System.out.println("enter the password ");
				String password= scn.next();
				Employee e =new Employee();
				e.setEmp_email(email);
				e.setEmp_name(name);
				e.setEmp_password(password);
				ed.updateEmployee(id, e);
				
			}
			break;
			case 4:
			{
				System.out.println("enter the employee id ");
				int id= scn.nextInt();
				ed.showEmployee(id);
			}
			break;
			case 5:
			{
				exit=false;
			}
			default:
			{
				System.out.println("==invaild==");
			}
			}
		}
	}

}
