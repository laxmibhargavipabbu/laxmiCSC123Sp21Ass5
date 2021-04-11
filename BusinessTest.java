package Assignment5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class BusinessTest
{
	public static void main(String [] args) throws FileNotFoundException
	{
		Scanner keyboard = new Scanner(System.in);
		ArrayList<Employee> employeeAL = new ArrayList<Employee>();
		ArrayList<Manager> managerAL = new ArrayList<Manager>();
		ArrayList<Executive> executiveAL = new ArrayList<Executive>();
		String name="";
		String title="";
		int id;
		int age;
		double salary;
		double companyProft;
		double bonusperc;
		System.out.printf("Please enter the name of the input file with employee name and data: ");
		String input = keyboard.next();
		File inputFile = new File(input);
		if(!inputFile.exists())
		{
			System.out.printf("Input File %s was not found.\n", inputFile);
			System.exit(0);
		}
		Scanner inputReader = new Scanner(inputFile);
		while(inputReader.hasNextLine())
		{
			name = inputReader.next();
			title = inputReader.next();
			id = inputReader.nextInt();
			age = inputReader.nextInt();
			salary = inputReader.nextDouble();
			if(id >= 1 && id <=2000)
			{
				Employee emp = new Employee(name,title,id,age,salary);
				employeeAL.add(emp);
			}
			else if(id >= 2001 && id <=3000)
			{
				Manager mgr = new Manager(name,title,id,age,salary);
				managerAL.add(mgr);
			}
			else if(id >= 3001 && id <=3500)
			{
				Executive exc = new Executive(name,title,id,age,salary);
				executiveAL.add(exc);
			}
		}
		int i=0;
		for (Employee e : employeeAL )
		{
			managerAL.get(i).addManagedEmployee(e);
			i++;
			if(i%managerAL.size() == 0)
			{
				i=0;
			}
		}
		i=0;
		for (Manager mgr : managerAL )
		{
			executiveAL.get(i).addManagedEmployee(mgr);
			i++;
			if(i%executiveAL.size() == 0)
			{
				i=0;
			}
		}
		System.out.printf("Please enter the total company profit for the year: $");
		companyProft = keyboard.nextDouble();
		System.out.printf("Please enter the executive bonus percentage for the year correct to 1 decimal place: ");
		bonusperc = keyboard.nextDouble();
		System.out.printf("Please enter the name of the output file: ");
		String output = keyboard.next();
		File outputFile = new File (output);
		PrintWriter outputWriter = new PrintWriter(outputFile);
		double totalPayroll = 0.0;
		for(Executive exc : executiveAL)
		{
			exc.setTotalComp(companyProft, bonusperc);
			totalPayroll = totalPayroll + exc.getTotalComp();
		}
		for(Manager mgr : managerAL)
		{
			totalPayroll = totalPayroll + mgr.getSalary();
		}
		 for(Employee emp : employeeAL)
		{
			 totalPayroll = totalPayroll + emp.getSalary();;
		}
		outputWriter.printf("The total payroll for the business is $%,.2f\n",totalPayroll);
		outputWriter.printf("\n");
		outputWriter.printf("Compensation Table\n");
		outputWriter.printf("Executives\n");
		outputWriter.printf("%-18s%-18s%-10s%-10s%-18s%-22s\n","Name","Title"," ID","Age","Salary","Total Comp");
        for(Executive exc : executiveAL)
		{
        	outputWriter.printf("%-18s%-18s%-10d%-10d$%,-19.2f$%,-22.2f\n",exc.getName(), exc.getTitle(), exc.getId(), exc.getAge(),exc.getSalary(), exc.getTotalComp());
     	}
        outputWriter.printf("\n");
        outputWriter.printf("Managers\n");
        outputWriter.printf("%-18s%-18s%-10s%-10s%-18s\n","Name","Title"," ID","Age","Salary");
		for(Manager mgr : managerAL)
		{
			outputWriter.printf("%-18s%-18s%-10d%-10d$%,-18.2f\n",mgr.getName(), mgr.getTitle(), mgr.getId(),mgr.getAge(), mgr.getSalary());
	    }
		outputWriter.printf("\n");
        outputWriter.printf("Employees\n");
        outputWriter.printf("%-18s%-18s%-10s%-10s%-18s\n","Name","Title"," ID","Age","Salary");
        for(Employee emp : employeeAL)
		{
        	outputWriter.printf("%-18s%-18s%-10d%-10d$%,-18.2f\n",emp.getName(), emp.getTitle(), emp.getId(),emp.getAge(), emp.getSalary());
     	}
       	outputWriter.printf("\n");
       	outputWriter.printf("\n");
		outputWriter.printf("Reporting Structure\n");
		outputWriter.printf("\n");
		outputWriter.printf("Direct Reports To Executives\n");
		for(Executive exc : executiveAL)
		{
			outputWriter.printf("Executive %s has the following direct reports\n", exc.getName());
			for(int j=0;j<exc.getManagedEmployeesListSize(); j++)
			{
				outputWriter.printf("%-18s%-18d\n", exc.getManagedEmployee(j).getName(), exc.getManagedEmployee(j).getId());
			}
			outputWriter.printf("\n");
		}
		outputWriter.printf("\n");
		outputWriter.printf("\n");
		outputWriter.printf("Direct Reports To Managers\n");
		for(Manager mgr : managerAL)
		{
			outputWriter.printf("Manager %s has the following direct reports\n", mgr.getName());
			for(int j=0;j<mgr.getManagedEmployeesListSize(); j++)
			{
				outputWriter.printf("%-18s%-18d\n", mgr.getManagedEmployee(j).getName(), mgr.getManagedEmployee(j).getId());
			}
			outputWriter.printf("\n");
		}
		System.out.printf("Please enter the salary change for a Manager as a percentage: ");
		double percentgeChange = keyboard.nextDouble();
		outputWriter.printf("\n");
		outputWriter.printf("Manager List With New Salary\n");
		for(Manager mgr : managerAL)
		{
			mgr.changeSalary(percentgeChange);
			outputWriter.printf(mgr.toString());
			outputWriter.printf("\n");
		}
		keyboard.close();
		inputReader.close();
		outputWriter.close();
	}
}
