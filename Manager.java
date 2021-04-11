package Assignment5;

import java.util.ArrayList;

public class Manager extends Employee
{
	private ArrayList<Employee> managedEmployees = new ArrayList<Employee>();
	
	public Manager(String name, String title, int id, int age, double salary)
	{
		super(name, title, id, age, salary);
	}
	
	public void addManagedEmployee(Employee emp)
	{
		managedEmployees.add(emp);
	}
	
	public int getManagedEmployeesListSize()
	{
		return managedEmployees.size();
	}
	
	public Employee getManagedEmployee(int i)
	{
		return managedEmployees.get(i);
	}
	
	public String toString()
	{
		return 	String.format("The manager name and title are %s and %s\n"
				+ "The manager ID is %d  The manager age is %d\n"
				+ "The manager salary is $%,.2f\n", 
				this.getName(), this.getTitle(), this.getId(), this.getAge(), this.getSalary());
		}
}
