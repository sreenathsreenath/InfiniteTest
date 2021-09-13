package com.java.infinite.test;


	import java.util.ArrayList;
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



