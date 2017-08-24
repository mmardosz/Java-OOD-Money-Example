import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class GiveChange {

	static final double	QUARTER_VALUE = 0.25,
						DIME_VALUE = 0.10,
						NICKLE_VALUE = 0.05,
						PENNY_VALUE = 0.01;
	
	public static void main(String[] args) {
		
		int outputQuarter = 0, outputDime = 0, outputNickle = 0, outputPenny = 0;		
		int mod;
		// ask user for input
		double userInputValue = displayQuestion("Enter the total value: ", "User input");
		
		double userInputValueForResult = userInputValue;
		
		// calculate
		outputQuarter = (int) (userInputValue /QUARTER_VALUE);
		userInputValue %= QUARTER_VALUE; 
		System.out.println("Return value: " + outputQuarter  + " .. userInputValue = " + userInputValue);
		
		outputDime = (int) (userInputValue / DIME_VALUE);
		userInputValue %= DIME_VALUE;
		System.out.println("Return value: " + outputDime + " .. userInputValue = " + userInputValue);

		outputNickle = (int) (userInputValue / NICKLE_VALUE);
		userInputValue %= NICKLE_VALUE;
		System.out.println("Return value: " + outputNickle + " .. userInputValue = " + userInputValue);

		outputPenny = (int) Math.round((userInputValue / PENNY_VALUE));
		userInputValue %= PENNY_VALUE;
		System.out.println("Return value: " + outputPenny + " .. userInputValue = " + userInputValue);

		// display results
		showResults(outputQuarter, outputDime, outputNickle, outputPenny, userInputValueForResult);
		
		// end of the program..
		System.out.println("User hits OK. Program exits.");
		// always close dialog!
	    System.exit(0);
	}
	private static void showResults(int numQuarters, int numDimes, int numNickles, int numPennies, double uservalue){
		
		DecimalFormat twoZeros = new DecimalFormat("0.00");
		
		// show the final results to the user..
		JOptionPane.showMessageDialog(null, 
				
				"The correct change for $" + twoZeros.format(uservalue)
				+ " is\n" + numQuarters + " quarter" + singularOrPlural(numQuarters) + ", "
				+ numDimes + " dime" + singularOrPlural(numDimes)  + ", \n"
				+ numNickles + " nickle" + singularOrPlural(numNickles) + ", "
				+ "and " + numPennies  + " " + singularOrPluralPenny(numPennies),
				
				"Results", 
				JOptionPane.PLAIN_MESSAGE
		);
	}
	
	// return empty, otherwise return suffix -s
	private static String singularOrPlural(int x){
		return (x == 1 ? "" : "s");
	}
	
	// specially for a lonely and never appreciated penny..
	private static String singularOrPluralPenny(int numPennies) {
		if (numPennies == 1)
			return "penny";
		else
			return "pennies";
	}
	
	private static double displayQuestion(String strQuestion, String strBlueStrip){
		
		String inputTempString;
		double returnDouble = Double.parseDouble(inputTempString = JOptionPane.showInputDialog(
				null, 
				strQuestion, 
				strBlueStrip,
				JOptionPane.QUESTION_MESSAGE
		));
		
		System.out.println("User inputs: " + returnDouble);
		
		return returnDouble;
	}
}
