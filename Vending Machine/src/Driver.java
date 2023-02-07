import java.util.ArrayList;

public class Driver {

	public static void main(String[] args) {
		//System.runFinalizersOnExit(true);
	    //load data from file
	    Datafile myData = new Datafile("./Directory/directory1.txt", "./Input/input.txt");
	    myData.LoadDirectory();
	    myData.LoadSampleInput();

	    //initialize Vending machine with loaded data
	    ArrayList <String> myVending = myData.GetDirectory();
	    ArrayList <Integer> mySelections = myData.GetSelections(); // YES INTEGER, not int. Why??? ;)
//	    for (String s : myVending) {
//	    	System.out.println(s);
//	    }
//	    for (int i: mySelections) {
//	    	System.out.println(i);
//	    }
	    Vending myMachine = new Vending(myVending);
	    // Test line to show items before removing initially
	    System.out.println("Items originally there:");
	    myMachine.DisplayItems(); //debug helper function, REALLY NEEDS toString()
	    // System.out.println("______________________________");
	    //remove items
	    // System.out.println("Items removed final count: ");
	    myMachine.UnloadItem(mySelections);
	    //System.out.println(myMachine.findProduct("Coca-Cola"));
	    // //Final output to display after removing
	    myMachine.DisplayItems(); //debug helper function, REALLY NEEDS toString()
	    //myMachine.gc();
	    /*****************/
	    // Above DisplayItems() call is fine, but the Vending machine's deconstructor 
	    // should call that function since it's the LAST operation. Notice it could be
	    // done with a helper function that USES the toString()
	    // We will NOT call DisplayItems() in testing 
	    /*****************/
	    
    //System.gc();
	}
}
