package com.java.infinite.test;


	import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



	public class EmployeeDAO {
		static List<Employee> lstEmployee;
		
		static {
			lstEmployee=new ArrayList<Employee>();
			
		}
		
		public String addEmployeeDao(Employee employee){
			lstEmployee.add(employee);
			return "Leave Added Successflly";
		}
		public static List<Employee> showemployeeDao(){
			return lstEmployee;
		}
		public Employee searchEmployeeDao(int empId){
			Employee result=null;
			
				for (Employee employee2 : lstEmployee) {
					if(employee2.getEmpId()==empId){
					result=employee2;
					break;
				}
				
				
			}
			return result;
			
	}
		
		public String deleteEmployeeDao(int empId){
			Employee employee=searchEmployeeDao(empId);
			if(employee!=null){
				lstEmployee.remove(employee);
				return "Record Deleted Succefully";
			}
			return "Record Not Found";
		}
		
		public int noofDaysEmployee(Employee employee) throws ParseException {
			SimpleDateFormat obj = new SimpleDateFormat("dd/MM/yyyy");           
			String date1=obj.format(employee.getLeaveStartDate());
			String date2=obj.format(employee.getLeaveEndDate());
			Date stdate=obj.parse(date1);
			Date st1date=obj.parse(date2);		
			long time_difference=st1date.getTime()-stdate.getTime();
			long days_difference = (time_difference / (1000*60*60*24)) % 365;   
			long years_difference = (time_difference / (1000l*60*60*24*365));  
			return (int) days_difference;  
		}
		public String leaveAppliedOnDao() {
			 Date date=new Date();
			 System.out.println(date);
			 SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
			 String leave =sdf.format(date);
			 return leave;
			
		}
		public String readEmployeeDao() throws IOException, ClassNotFoundException{
			FileInputStream fin=new FileInputStream("c:/files/employee.txt");
			ObjectInputStream objin=new ObjectInputStream(fin);
			lstEmployee=(List<Employee>)objin.readObject();
			objin.close();
			fin.close();
			return "File Read Successfully...";
		}
		public String writeEmployeeDao() throws IOException {
			FileOutputStream fout=new FileOutputStream("c:/files/employee.txt");
			ObjectOutputStream objout=new ObjectOutputStream(fout);
			objout.writeObject(lstEmployee);
			objout.close();
			fout.close();
			return "File wrote Successfully...";
		}
		public String updateEmployeeDao(Employee employeeNew) {
			Employee employeeOld = searchEmployeeDao(employeeNew.getEmpId());
			if (employeeOld != null) {
				employeeOld.setEmpId(employeeNew.getEmpId());
				employeeOld.setLeaveId(employeeNew.getLeaveId());
				employeeOld.setLeaveStartDate(employeeNew.getLeaveStartDate());
				employeeOld.setLeaveEndDate(employeeNew.getLeaveEndDate());
				employeeOld.setLeaveReason(employeeNew.getLeaveReason());
				return "Record Updated Successfully...";
			}
			return "Record Not Found...";
			
		}
		
		}



