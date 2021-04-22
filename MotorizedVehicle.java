package laxmiCSC123Sp21Ass5;

public class MotorizedVehicle extends Vehicle {
	private double volumeDisplacement = 0.0;

	public MotorizedVehicle(String owner, int wheels, double volumeDisplacement) {
		super(owner, wheels);
		setVolumeDisplacement(volumeDisplacement);
	}

	public void setVolumeDisplacement(double volumeDisplacement) {
		this.volumeDisplacement = volumeDisplacement;
	}

	public double getVolumeDisplacement() {
		return this.volumeDisplacement;
	}

	public double horsepower() {
		return this.getVolumeDisplacement() * this.getWheels();
	}

	public String toString() {
		return String.format(super.toString() + "Volume Displacement: %.2f\nhas %.2f horse power",
				this.getVolumeDisplacement(), this.horsepower());
	}

	public boolean equals(Object obj) {
		if (obj instanceof MotorizedVehicle) {
			MotorizedVehicle mv = (MotorizedVehicle) obj;

			if (super.equals(mv) && mv.getVolumeDisplacement() == this.volumeDisplacement) {
				return true;
			}
		}
		return false;
	}
}
