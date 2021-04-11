package Assignment5;

public class Employee 
{
	private String name="";
	private String title="";
	private int id;
	private int age;
	private double salary;
	public Employee(String name, String title, int id, int age, double salary)
	{
		setName(name);
		setTitle(title);
		setId(id);
		setAge(age);
		setSalary(salary);
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public void setAge(int age)
	{
		this.age = age;
	}
	
	public void setSalary(double salary)
	{
		this.salary = salary;
	}
	
	public String getName()
	{
		return this.name;
	}
	public String getTitle()
	{
		return this.title;
	}
	public int getId()
	{
		return this.id;
	}
	public int getAge()
	{
		return this.age;
	}
	public double getSalary()
	{
		return this.salary;
	}
	
	public void changeSalary(double percntChange)
	{
		salary = salary * (1.0 + (percntChange/100.0));
	}
	
	public String toString()
	{
		return 	String.format("The employee name and title are %s and %s\n"
				+ "The employee ID is %d  The employee age is %d\n"
				+ "The employee salary is $%,.2f\\n",
				this.getName(), this.getTitle(), this.getId(), this.getAge(), this.getSalary());
	}
}
