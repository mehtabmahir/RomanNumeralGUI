import javax.swing.*;
import java.awt.event.*;
/**
 * Handler for Convert Menu
 */
public class ConvertMenuHandler implements ActionListener {
   JFrame jframe;
   RomanNumeral input;
   
   public ConvertMenuHandler (JFrame jf) {
      jframe = jf;
   } // Constructor
   
   public void actionPerformed(ActionEvent event) {
	   String menuName = event.getActionCommand();
	   if (menuName.equals("Roman to Arabic")) { // checks if user selected "Roman to Arabic"
		   try {
			   input = new RomanNumeral(JOptionPane.showInputDialog("Enter a Roman Numeral:"));
		   }catch(RomanNumeralException e) {
			   JOptionPane.showMessageDialog(jframe, e.getMessage());
			   return;
		   }
		   JOptionPane.showMessageDialog(jframe, input);
	   }
   } //actionPerformed
}