public class Drink extends Item {
	float ounces;
	String type;
	public Drink(String n, float c, float o, String t) {
		super(n,c,"Drink");
		ounces = o;
		type = t;
	}
	public Drink(Item i) {
		super(i.getName(),i.getCalories(),"Drink");
		Drink s = (Drink)i;
		ounces = s.getOunces();
		type = s.getType();
	}
	public float getOunces() {
		return ounces;
	}
	public void setOunces(float ounces) {
		this.ounces = ounces;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String toString() {
		return "Snack: " + super.getName() +", calories: " + super.getCalories() + ", ounces: " + ounces + ", type" + type;
	}
}