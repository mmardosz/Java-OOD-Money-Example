import java.math.RoundingMode;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class SumDue {

	public static void main(String[] args) {
		// Create storage Strings
		String inputQuantity, inputPrice, inputDiscoutDecimal;
		
		// Create double storage
		double doubleQuantitySold = 0, doublePriceEach = 0, doubleDiscRate = 0;
		double ansBeforeDiscount = 0, ansDiscountAmt = 0, ansTotalDueAfterDisc = 0;
			
		// take input -- Enter Quantity sold
		doubleQuantitySold = Double.parseDouble(inputQuantity = JOptionPane.showInputDialog(
				null, 
				"Enter quantity sold:", 
				"Enter numbers:",
				JOptionPane.QUESTION_MESSAGE
		));


		// take input -- Enter Price each
		doublePriceEach = Double.parseDouble(inputPrice = JOptionPane.showInputDialog(
				null, 
				"Enter price each:", 
				"Enter numbers:",
				JOptionPane.QUESTION_MESSAGE
		));
		
		// take input -- Enter discount rate as a decimal
		doubleDiscRate = Double.parseDouble(inputDiscoutDecimal = JOptionPane.showInputDialog(
				null, 
				"Enter discount rate as decimal:", 
				"Enter numbers:",
				JOptionPane.QUESTION_MESSAGE
		));
		
		// Decimal formats "0.00"
		DecimalFormat twoDigits = new DecimalFormat("0.00");
		
		// Decimal format with round down "0.00**"
		DecimalFormat twoDigitsRoundDown = new DecimalFormat("0.00**");
		twoDigitsRoundDown.setRoundingMode(RoundingMode.DOWN);

		// Call and store calculations..
		// TAKES variables from main method
		ansBeforeDiscount = calcTotalDueBeforeDisc(doubleQuantitySold, doublePriceEach);
		ansDiscountAmt = calcDiscountAmt(doubleQuantitySold, doublePriceEach, doubleDiscRate);
		
		// TAKES variables from main method AND ansDisountAmt calculated above
		ansTotalDueAfterDisc = calcTotalDueAfterDisc(doubleQuantitySold, doublePriceEach, ansDiscountAmt);
		
		// show the final results to the user..
		JOptionPane.showMessageDialog(null, 
				
				"Total due before discount is $" + twoDigits.format(ansBeforeDiscount)
				+ "\nDiscount amount is $" + twoDigits.format(ansDiscountAmt)
				+ "\nTotal due after discount is $" + twoDigitsRoundDown.format(ansTotalDueAfterDisc),
				"Results", 
				JOptionPane.PLAIN_MESSAGE
		);
		
		// always close dialog!
	    System.exit(0);
	}

	// Calculation methods:
	private static double calcTotalDueAfterDisc(double doubleQuantitySold, double doublePriceEach,
			double ansDiscountAmt) {
		return (doubleQuantitySold * doublePriceEach) - ansDiscountAmt;
	}

	private static double calcDiscountAmt(double doubleQuantitySold, double doublePriceEach, double doubleDiscRate) {
		
		return (doubleQuantitySold * doublePriceEach) - (doubleQuantitySold * doublePriceEach) * (1 - doubleDiscRate);
	}

	private static double calcTotalDueBeforeDisc(double doubleQuantitySold, double doublePriceEach) {
		return doubleQuantitySold * doublePriceEach;
	}
	
	
}
