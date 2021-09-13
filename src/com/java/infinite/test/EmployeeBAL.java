package com.java.infinite.test;


	import java.text.ParseException;
	import java.text.SimpleDateFormat;
	import java.util.Calendar;
	import java.util.Date;
	import java.util.List;

	public class EmployeeBAL {
		static StringBuilder sb=new StringBuilder();
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		public boolean validateEmployee(Employee employee) throws ParseException{
			boolean isAdded=true;
			Calendar cal=Calendar.getInstance();
			cal.add(Calendar.DATE,-1);
			String yesterday=sdf.format(cal.getTime());
			
			if(employee.getLeaveStartDate().before(sdf.parse(yesterday))){
				isAdded=false;
				sb.append("leave Start Date cannot be yesterdays date");
			}
			if(employee.getLeaveEndDate().before(sdf.parse(yesterday))){
				isAdded=false;
				sb.append("Leave End Date Cannot be Yseterdays Date");
			}
			
			Date x=employee.getLeaveStartDate();
			Date y=employee.getLeaveEndDate();
			Date thisDate=new Date();
			SimpleDateFormat dateForm=new SimpleDateFormat("yyyy-MM-dd");
			
			if(x.getDate()>y.getDate()){
				
				isAdded=false;
				sb.append("Start Date Is Invalid");
			}
			return isAdded;
			
		}
		
		public String addEmployeeBal(Employee employee)throws EmployeeException, ParseException{
			if(validateEmployee(employee)==true){
				employee.setLeaveAppliedOn(new Date());
				
				return new EmployeeDAO().addEmployeeDao(employee);
			}else{
				throw new EmployeeException(sb.toString());
			}
			
		}
		public List<Employee> showEmployeeBal(){
			return new EmployeeDAO().showemployeeDao();
		}
		
		
		public String deleteEmployeeBal(int empId){
			return new EmployeeDAO().deleteEmployeeDao(empId);
		}
		public Employee searchEmployeeBal(int empId){
			return new EmployeeDAO().searchEmployeeDao(empId);
		}
		public String updateEmployeeBal(Employee employee) throws EmployeeException, ParseException {
			if (validateEmployee(employee) == true) {
				return new EmployeeDAO().updateEmployeeDao(employee);
			} else {
				throw new EmployeeException(sb.toString());
			}
		}
	}





