import javax.swing.*; 
import java.awt.event.*;
import java.io.*;
import java.util.StringTokenizer;
/**
 * Handler for File Menu
 */
public class FileMenuHandler implements ActionListener {
   JFrame jframe;
   
   public FileMenuHandler (JFrame jf) {
      jframe = jf;
   } // Constructor
   
   public void actionPerformed(ActionEvent event) {
      String menuName = event.getActionCommand();
      if (menuName.equals("Open"))
    	  openFile();
      else if (menuName.equals("Quit"))
    	  System.exit(0);
   } //actionPerformed
   /**
    * Function to open file using JFileChooser
    */
   private void openFile() {
	   JFileChooser chooser;
	   int status;
	   chooser = new JFileChooser();
	   status = chooser.showOpenDialog(null);
	   if (status == JFileChooser.APPROVE_OPTION)
		   readSource(chooser.getSelectedFile()); // to read a file of roman numerals
	   else
		   JOptionPane.showMessageDialog(null, "Cancelled");
   }
   /**
    * Function to display a GUI of RomanNumerals from a file
    */
   private void readSource(File chosenFile) {
	   RomanTree romanTree = new RomanTree();
	   try {
		   fillRomanTree(chosenFile.getAbsolutePath(), romanTree);
	   }catch(NullPointerException e) {
		   JOptionPane.showMessageDialog(jframe, "File Empty");
		   return;
	   }
	   jframe.setVisible(false);
	   jframe = new RomanNumeralGUI(romanTree); // creates a new Jframe from the file
   }
   /**
    * Function to fill a RomanNumeral tree from a file
    */
   public static void fillRomanTree(String myFile, RomanTree romanTree) {
		TextFileInput in = new TextFileInput(myFile);
		String index;
		String line = in.readLine();
		StringTokenizer myTokens = new StringTokenizer(line, ","); // seperates roman numerals from the file by commas
		for (int i = 0; i < in.getLineCount(); i++) { // checks each line of the file
			while (myTokens.hasMoreTokens()) {
				index = myTokens.nextToken();
				romanTree.insert(index);
			}
			line = in.readLine();
			if (line != null)
				myTokens = new StringTokenizer(line, ",");
		}
		
   }
}