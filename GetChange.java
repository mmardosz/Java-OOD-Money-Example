import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class GetChange {

	static final double	QUARTER_VALUE = 0.25,
						DIME_VALUE = 0.10,
						NICKLE_VALUE = 0.05,
						PENNY_VALUE = 0.01;

	public static void main(String[] args) {

		double results = 0;
		
		// grab inputs from a user
		int userInputQuarters = displayQuestion("How many quarters?", "User input");
		int userInputDimes = displayQuestion("How many dimes?", "User input");
		int userInputNickels = displayQuestion("How many nickles?", "User input");
		int userInputPennies = displayQuestion("How many pennies?", "User input");
		
		// calculate final answer
		results = calcualteTotal(userInputQuarters, userInputDimes, userInputNickels, userInputPennies);
		
		// show final results
		showResults(userInputQuarters, userInputDimes, userInputNickels, userInputPennies, results);
		
		// end of the program..
		System.out.println("User hits OK. Program exits.");
		// always close dialog!
	    System.exit(0);

	}
	
	private static double calcualteTotal(int quaters, int dimes, int nickels,
			int pennies) {

		double results =  (QUARTER_VALUE * quaters)
						+ (DIME_VALUE * dimes)
						+ (NICKLE_VALUE * nickels)
						+ (PENNY_VALUE * pennies);
		
		System.out.println("Returns: " + results);
		
		return results;

	}

	// takes string questions and returns user input:
	private static int displayQuestion(String strQuestion, String strBlueStrip){
		
		String inputTempString;
		int returnInt = Integer.parseInt(inputTempString = JOptionPane.showInputDialog(
				null, 
				strQuestion, 
				strBlueStrip,
				JOptionPane.QUESTION_MESSAGE
		));
		
		System.out.println("User inputs: " + returnInt);
		
		return returnInt;
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
	
	private static void showResults(int numQuarters, int numDimes, int numNickles, int numPennies, double results){
		
		DecimalFormat twoZeros = new DecimalFormat("0.00");
		
		// show the final results to the user..
		JOptionPane.showMessageDialog(null, 
				
				"The total value of " + numQuarters + " quarter" + singularOrPlural(numQuarters) + ", "
				+ numDimes + " dime" + singularOrPlural(numDimes)  + ", \n"
				+ numNickles + " nickle" + singularOrPlural(numNickles) + ", "
				+ "and " + numPennies  + " " + singularOrPluralPenny(numPennies)
				+ " is $" + twoZeros.format(results),
				
				"Results", 
				JOptionPane.PLAIN_MESSAGE
		);
	}


}
