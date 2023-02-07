import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Vending {
	ArrayList<String> directory;
	ArrayList<Queue<Item>> slots;
	public Vending(ArrayList <String> myVending) {
		directory = new ArrayList<String>();
		slots = new ArrayList<Queue<Item>>();
		loadItem(myVending);
	}
	public void loadItem(ArrayList <String> myVending) {
		String type = "";
		for (String line : myVending) {
			try {
			StringTokenizer tokenizer = new StringTokenizer(line);
			type = tokenizer.nextToken().replace(",","");
			String name = tokenizer.nextToken().replace(",","");
			float cal = Float.parseFloat(tokenizer.nextToken().replace(",",""));
			if (type.equals("Snack")) {
				float weight = Float.parseFloat(tokenizer.nextToken().replace(",",""));
				boolean nuts = Boolean.parseBoolean(tokenizer.nextToken().replace(",",""));
				int num = Integer.parseInt(tokenizer.nextToken().replace(",",""));
				directory.add(name);
				Item s = new Snack(name,cal,weight,nuts);
				slots.add(new LinkedList<Item>());
				loadItem(s,num,0);
			}
			else if (type.equals("Drink")) {
				float oz = Float.parseFloat(tokenizer.nextToken().replace(",",""));
				String drType = tokenizer.nextToken().replace(",","");
				int num = Integer.parseInt(tokenizer.nextToken().replace(",",""));
				directory.add(name);
				Item s = new Drink(name,cal,oz,drType);
				slots.add(new LinkedList<Item>());
				loadItem(s,num,1);
			}
			else
				throw new NumberFormatException("Invalid type");
			}
			catch (final NumberFormatException e) {
				System.out.println("Bad Data3");
				System.exit(0);
			}
		}
	}
	public void loadItem (Item i, int num, int t) {
		int l = slots.size() -1;
		slots.get(l).add(i);
		num --;
		if (num > 0) {
			Item j;
			if (t == 0) {
				j = new Snack(i);
			}
			else
				j = new Drink(i);
			loadItem(j,num,t);
		}
	}
	public void DisplayItems() {
		System.out.println(toString());
	}
	public String toString() {
		String val = "";
		for (int i = 0; i<slots.size()-1; i++) {
			if (slots.get(i).size()==0) {
				val += "Empty: (Empty): 0\n";
				continue;
			}
			val += slots.get(i).peek().getName() + ": (" + slots.get(i).peek().getItemType() + "): " + slots.get(i).size();
			val += "\n";
		}
		int i = slots.size()-1;
		if (slots.get(i).size()==0)
			val += "Empty: (Empty): 0";
		else
			val += slots.get(i).peek().getName() + ": (" + slots.get(i).peek().getItemType() + "): " + slots.get(i).size();
		return val;
	}
	public Item UnloadItem(int index) {
		if (slots.get(index).size()==0)
		return null;
		else if (slots.get(index).size()==1) {
			ArrayList<Integer> arr = findProduct(slots.get(index).peek().getName());
			int minSize = 0;
			for (int i = 0; i<arr.size(); i++) {
				if (slots.get(arr.get(i)).size()>minSize) {
					index = i;
					minSize = slots.get(arr.get(i)).size();
				}
			}
		}
		return slots.get(index).remove();
	}
	public void UnloadItem(ArrayList<Integer> arr) {
		for (int i : arr)
			UnloadItem(i);
	}
	public ArrayList<Integer> findProduct(String s){
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 0; i<directory.size(); i++) {
			if (directory.get(i).equals(s))
				arr.add(i);
		}
		return arr;
	}
	protected void finalize()
	{
		DisplayItems();
	}
}