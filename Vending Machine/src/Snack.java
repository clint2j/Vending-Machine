public class Snack extends Item {
	float weight;
	boolean containsNuts;
	public Snack(String n, float c, float w, boolean nuts) {
		super(n,c,"Snack");
		weight = w;
		containsNuts = nuts;
	}
	public Snack(Item s) {
		super(s.getName(),s.getCalories(),"Snack");
		Snack ss = (Snack)s;
		weight = ss.getWeight();
		containsNuts = ss.getcontainsNuts();
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public boolean getcontainsNuts() {
		return containsNuts;
	}
	public void setContainsNuts(boolean containsNuts) {
		this.containsNuts = containsNuts;
	}
	public String toString() {
		String nuts = ", ";
		nuts += containsNuts ? "(it has nuts)" : "(it doesn\'t have nuts)";
		return "Snack: " + super.getName() +", calories: " + super.getCalories() + ", weight: " + weight + nuts;
	}
}