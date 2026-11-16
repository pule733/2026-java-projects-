import java.util.Scanner;
public class PasswordValidator{
	 public static boolean hasCorrectLength( String password ) {

	 if( password.length()>= 8 ) {
	 return true;
	 }

	 return false;
	 }
	 
	public static boolean hasUppercase(String password) {
		 for(int i = 0; i < password.length() ; i++) {
		 char ch = password.charAt(i) ;
		 if( Character.isUpperCase(ch) ) {
		 return true;
		 }
		 }
		 return false;
	 }
	 
	public static boolean hasLowercase(String password) {
		 for(int i = 0; i < password.length() ; i++) {
		 char ch = password.charAt(i) ;
		 if( Character.isLowerCase(ch) ) {
		 return true;
		 }
		 }
		 return false;
	 }
	 
	 public static boolean hasDigit(String password) {
		 for(int i = 0; i < password.length() ; i++) {
		 char ch = password.charAt(i) ;
		 if( Character.isDigit(ch) ) {
		 return true;
		 }
		 }
		 return false;
	 }
	 
	 public static boolean hasSpecialCharacter(String password) {
		 for(int i = 0; i < password.length(); i++){
		 char ch = password.charAt(i) ;
		 if( !Character.isLetterOrDigit(ch) && !Character.isWhitespace(ch) ) {
		 return true;
		 }
		 }
		 return false;
	 }
	 
	 public static boolean isStrongPassword(String password) {
		 if( hasCorrectLength(password) && hasUppercase(password) && hasLowercase(password) &&
		 hasDigit(password) && hasSpecialCharacter(password) )
		 return true;
		else
		return false;
	 }
	 
	 public static void displayPasswordReport(String password) {
	 System.out.println("\nPassword Analysis:");
		 if(  hasCorrectLength(password) )
		 System.out.println("Correct!! Length requirement satisfied");
		 else
		 System.out.println("Error!! Password must be at least 8 characters");
		 if( hasUppercase(password) )
		 System.out.println("Correct!! Contains uppercase letter");
		 else
		 System.out.println("Error!! Missing uppercase letter");
		 if( hasLowercase(password) )
		 System.out.println("Correct!! Contains lowercase letter");
		 else
		 System.out.println("Error!! Missing lowercase letter");
		 if( hasDigit(password ))
		 System.out.println("Correct!! Contains digit");
		 else
		 System.out.println("Error!! Missing digit");
		 if(hasSpecialCharacter(password))
		 System.out.println("Correct!! Contains special character");
		 else
		 System.out.println("Error!! Missing special character");
		 if( isStrongPassword(String password)  )
		 System.out.println("\nPassword is STRONG");
		 else
		 System.out.println("\nPassword is WEAK");
	 }
	 
	 public static void main(String[] args) {
		 Scanner input = new Scanner(System.in);
		String password;
		do{
		 System.out.print("Enter your secret password or 9999 to stop: ");
		 password = input.nextLine();
		 displayPasswordReport( password );
		}while( !password.equals("9999") );
	 }
}