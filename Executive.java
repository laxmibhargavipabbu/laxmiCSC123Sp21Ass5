package Assignment5;

public class Executive extends Manager
{
	private double totalComp = 0.0;

	public Executive(String name, String title, int id, int age, double salary)
	{
		super(name, title, id, age, salary);
	}
	
	public void setTotalComp(double compnyprft, double bonuspercent)
	{
		double bonus = compnyprft * bonuspercent/100 ;
		totalComp = super.getSalary() + bonus;
	}
	
	public double getTotalComp()
	{
		return totalComp;
	}
	
	public String toString()
	{
		return 	String.format("The executive name and title are %s and %s\n"
				+ "The executive ID is %d  The executive age is %d\n"
				+ "The executive salary and total compensation are $%,.2f and $%,.2f\n",
				this.getName(), this.getTitle(), this.getId(), this.getAge(), this.getSalary(), this.getTotalComp());
	}
}
