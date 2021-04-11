package Assignment5;

public abstract class Vehicle {
	private String owner = "";
	private int wheels = 0;

	public Vehicle(String owner, int wheels) {
		setOwner(owner);
		setWheels(wheels);
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getOwner() {
		return owner;
	}

	public void setWheels(int wheels) {
		this.wheels = wheels;
	}

	public int getWheels() {
		return wheels;
	}

	public String toString() 
	{
		return String.format("Owner: %s\nNumber of wheels: %d\n", getOwner(), getWheels());
	}

	public boolean equals(Object obj) 
	{
		if (obj instanceof Vehicle) 
		{
			Vehicle v = (Vehicle) obj;
			if (v.getOwner() == (this.getOwner()) && (v.getWheels() == (this.getWheels())))
			{
					return true;
			}
		}
		return false;
	}
}