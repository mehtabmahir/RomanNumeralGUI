import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
/**
 * GUI to display the roman numeral String array, UnsortedRomanNumeralList, and SortedRomanNumeralList
 */
public class RomanNumeralGUI extends JFrame{
	JMenuItem item;
	JMenuBar menuBar = new JMenuBar();
	JMenu menu;
	RomanTree romanTree;
	ArrayList<RomanNumeral> sorted;
	
	public RomanNumeralGUI() {
		new RomanNumeralGUI(new RomanTree());
	} // no parameter constructor
	
    public RomanNumeralGUI(RomanTree romanTree){
    	setSize(800, 600);
        setLocation(100, 100);
        setTitle("Roman Numeral GUI");
        setJMenuBar(menuBar);
        createFileMenu();
        createConvertMenu();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        int size = romanTree.length();
        Container myContentPane = getContentPane(); // to create the container that is put in the JFrame that will be displayed
        GridLayout grid = new GridLayout(size, 2); // to initialize GridLayout with 2 columns and size of the tree as rows
        myContentPane.setLayout(grid);
        sorted = romanTree.inOrder(); // creates an array list 
        if (sorted == null) {
        	setVisible(true);
        	return;
        }
        for (int i = 0; i < sorted.size(); i++) { // displays the array list in the GUI using JButtons
        	for (int j = 0; j < 2; j++) {
        		if (j == 0) // first column (roman numeral String)
        			myContentPane.add(new JButton(sorted.get(i).getRoman()));
        		if (j == 1) // sechond column (converted arabic int)
        			myContentPane.add(new JButton(Integer.toString(sorted.get(i).getArabic())));
        	}
        }
        setVisible(true);
        
    } // constructor
    /**
     * Creates file menu
     */
    private void createFileMenu(){
    	menu = new JMenu("File");
    	FileMenuHandler fmh = new FileMenuHandler(this);
    	
    	item = new JMenuItem("Open");
    	item.addActionListener(fmh);
    	menu.add(item);
    	
    	menu.addSeparator();
    	
    	item = new JMenuItem("Quit");
    	item.addActionListener(fmh);
    	menu.add(item);
    	
    	menuBar.add(menu);
    }
    /**
     * Creates convert menu
     */
    private void createConvertMenu(){
    	menu = new JMenu("Convert");
    	ConvertMenuHandler cmh = new ConvertMenuHandler(this);
    	
    	item = new JMenuItem("Roman to Arabic");
    	item.addActionListener(cmh);
    	menu.add(item);
    	
    	menuBar.add(menu);
    }
}