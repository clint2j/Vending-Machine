import java.io.*;
import java.util.*;
public class Datafile {
    private String dir;
    private String inp;
    private ArrayList<String> directory;
    private ArrayList<Integer> selections;
    public Datafile(String d, String i){
        dir = d;
        inp = i;
        directory = new ArrayList<String>();
        selections = new ArrayList<Integer>();
    }
    public void LoadDirectory(){
        Scanner file = null;
        try {
            file = new Scanner(new FileReader(dir));
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
            e.printStackTrace();
            System.exit(0);
        }
        while(file.hasNextLine()){
            String line = file.nextLine();
            directory.add(line);
        }
        file.close();
    }
    public void LoadSampleInput() {
        Scanner file = null;
        try {
            file = new Scanner(new FileReader(inp));
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
            e.printStackTrace();
            System.exit(0);
        }
        while(file.hasNextLine()){
            String line = file.nextLine();
            try {
            selections.add(Integer.parseInt(line));
            }
            catch (final NumberFormatException e) {
				System.out.println("Bad Data");
				System.exit(0);
			}
        }
        file.close();
    }
    public ArrayList<String> GetDirectory(){
        return directory;
    }
    public ArrayList <Integer> GetSelections(){
        return selections;
    }
}