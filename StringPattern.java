import java.util.Scanner;
 public class StringPattern 
 {     
 public static void main(String[] args)     
 {         
	 // Create a Scanner Object          
	 Scanner scanner = new Scanner(System.in);                  
	 // Prompt user for input          
	 System.out.print("Enter a string to analyze: ");         
	 String input = scanner.nextLine();                  
	 // Display the original input string
	 System.out.println("Original String: " + input);                  
	 // Initialize counters         
	 int upperCaseCount = 0, lowerCaseCount = 0, spaceCount = 0, specialCount = 0;        
	 String modified = " ";                 
	 // Analyze each character in the string   
	 for (  int i = 0; i < input.length();i++ )        
		 {            
		 // Extract character 
		 char ch = input.charAt(i);                         
		 // Check for uppercase letters , lowercase letters, check for spaces and special characters            
		 /*   Add your code here                  */ 
		 if(Character.isUpperCase(ch))
		 {
			 upperCaseCount++;
		 }
		 if(Character.isLowerCase(ch))
		 {
			 lowerCaseCount++;
		 }
		 if(Character.isWhitespace(ch))
		 {
			 spaceCount++;
		 }
		 if(!Character.isLetterOrDigit(ch) && !character.isWhitespace(ch)))
		 {
			 spaceCount++;
		 }
		 // Build modified string 
		 
		 char lowerCh = Character.toLowerCase(ch);              
		 /*    Add your code here                  */   
		 if(lowerCh == 'a'|| lowerCh == 'e' || lowerCh == 'i' || lowerCh == 'o' || lowerCh == 'u')
		 {
			 modified = modified + '*';
		 }else{
			 modified = modified + ch;
		 }
		 
		}      
 // Display results        
 System.out.println("Uppercase letters: " + upperCaseCount);    System.out.println("Lowercase letters: " + lowerCaseCount);    System.out.println("Spaces: " + spaceCount);        
 System.out.println("Special characters: " + specialCount);     System.out.println("Modified String (vowels replaced): " + modified);    
 } 
 } 