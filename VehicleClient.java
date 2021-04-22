package laxmiCSC123Sp21Ass5;

import java.util.Scanner;

public class VehicleClient
{
	public static void main(String [] args)
	{
		Scanner keyboard = new Scanner(System.in);
		String owner ="";
		int wheels = 0;
		double vd = 0.0;
		System.out.printf("Please enter the owner name for motorized vehicle one in one word: ");
		owner = keyboard.next();
		System.out.printf("Please enter the number of wheels for motorized vehicle one as an int: ");
		wheels = keyboard.nextInt();
		System.out.printf("Please enter the volume displacement for motorized vehicle one as a double: ");
		vd = keyboard.nextDouble();
		MotorizedVehicle mv1 = new MotorizedVehicle(owner, wheels, vd);
		System.out.printf(mv1.toString());
		System.out.println();
		
		System.out.printf("\nPlease enter the owner name for motorized vehicle second in one word: ");
		owner = keyboard.next();
		System.out.printf("Please enter the number of wheels for motorized vehicle second as an int: ");
		wheels = keyboard.nextInt();
		System.out.printf("Please enter the volume displacement for motorized vehicle second as a double: ");
		vd = keyboard.nextDouble();
		MotorizedVehicle mv2 = new MotorizedVehicle(owner, wheels, vd);
		System.out.printf(mv2.toString());
		System.out.println("\n");
		
		if(mv1.equals(mv2))
		{
			System.out.printf("mv1 and mv2 are equal\n");
		}
		else		
		{
			System.out.printf("mv1 and mv2 are not equal\n");
		}
		mv2.setOwner(mv1.getOwner());
		if(mv1.equals(mv2))
		{
			System.out.printf("mv1 and mv2 are now equal\n");
		}
		else		
		{
			System.out.printf("mv1 and mv2 are still not equal\n");
		}
		System.out.println();
		
		System.out.printf("Please enter the owner name for a bicycle in one word: ");
		owner = keyboard.next();
		System.out.printf("Please enter the number of wheels for a bicycle as an int: ");
		wheels = keyboard.nextInt();
		Bicycle b1 = new Bicycle(owner, wheels);
		System.out.printf(b1.toString());
		keyboard.close();
	}
	
}
