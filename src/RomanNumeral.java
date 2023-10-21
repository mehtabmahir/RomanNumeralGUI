import java.util.HashMap;
/**
 * Class RomanNumeral
 */
public class RomanNumeral {
	private String roman;
	private int arabic;
	
	public RomanNumeral() {
		setRomanNumeral("");
	} // no parameter constructor
	public RomanNumeral(String input) {
		if (input != null) {
			roman = input;
			arabic = romantoInt(input);
			if (arabic == -1) // throws exception if arabic is -1 (-1 means input is invalid)
				throw new RomanNumeralException("Invalid Roman Numeral: " + input);
		}
	} // constructor
	/**
	 * get function for String roman
	 */
	public String getRoman() {
		return roman;
	}
	/**
	 * set function for String roman
	 */
	public void setRomanNumeral(String input) {
		roman = input;
	}
	/**
	 * get function for int arabic
	 */
	public int getArabic() {
		return arabic;
	}
	/**
	 * set function for int arabic
	 */
	public void setArabic(int input) {
		arabic = input;
	}
	/**
	 * standard equals function
	 */
	public boolean equals(Object other) {
		if (!(other instanceof RomanNumeral))
			return false;
		RomanNumeral otherRoman = (RomanNumeral)other;
		return (roman.equals(otherRoman.getRoman()) && arabic == otherRoman.getArabic());
	}
	/**
	 * standard toString function
	 */
	public String toString() {
		String temp = roman + ' ' + arabic;
		return temp;
	}
	/**
	 * standard compareTo function
	 */
	public int compareTo(RomanNumeral other) {
		return arabic-other.getArabic();
	}
	/**
	 * Converts a Roman Numeral and returns an arabic int
	 */
	public static int romantoInt(String input) {
		if (input == null || input.length() == 0) // checks for null or empty string
			return -1;
		System.out.println("Roman Number: " + input);
        HashMap<Character, Integer> map = new HashMap<Character, Integer>(); 
        map.put('I', 1); // HashMap that sets each roman numeral (I,V,X,L,C,D,M) to an the corresponding int value
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int len = input.length();
        int result;
        try {
        	result = map.get(input.charAt(len - 1));
        }catch(NullPointerException e) {
        	return -1; // returns -1 if result is null (invalid input)
        }
        for (int i = len - 2; i >= 0; i--) {
            if (map.get(input.charAt(i)) >= map.get(input.charAt(i + 1))) // checks if the current >= next 
                result += map.get(input.charAt(i)); // adds current
            else
                result -= map.get(input.charAt(i)); // if not, subtracts current
        }

        System.out.println("Integer: " + result);
        System.out.println("------------------------------------");
        return result;
	}
}
