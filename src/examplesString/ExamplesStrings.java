package examplesString;

public class ExamplesStrings {

	public static void main(String[] args) {
		
		
		System.out.println(mergeTwoString("abcdf", "wfghs"));
		
		System.out.println(sumStringLength("hello", "java"));
		System.out.println(compareStrings("hello", "java"));
		System.out.println(javaString("hello", "java"));

	}
	
	private static String mergeTwoString(String cad1, String cad2) {
		String joinStr = "";
		for (int i = 0; i < cad2.length(); i++) {
			joinStr = joinStr + cad1.charAt(i) + cad2.charAt(i);
		}
		return joinStr;
	}
	
	private static int sumStringLength(String cad1, String cad2) {
		int sumLengthStr = cad1.length() + cad2.length();
		return sumLengthStr;
	}
	
	private static String compareStrings(String cad1, String cad2) {
		return cad1.compareTo(cad2) > 0 ? "Yes" : "No";
	}
	
	private static String javaString(String cad1, String cad2) {
		String newCad1 = convertString(cad1);
		String newCad2 = convertString(cad2);
		
		String joinCads = newCad1 + " " + newCad2;
		
		return joinCads;
	}
	
	private static String convertString(String cad1) {
		String newCad1 = cad1.substring(0, 1).toUpperCase() + cad1.substring(1);
		return newCad1;
	}

}
