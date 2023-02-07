public class Item {
	private String name;
	private float calories;
	private String itemType;
	public Item() {
		name = "";
		calories = 0;
		itemType = "";
	}
	public Item(String n, float c, String i) {
		name = n;
		calories = c;
		itemType = i;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getCalories() {
		return calories;
	}
	public void setCalories(float calories) {
		this.calories = calories;
	}
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
}