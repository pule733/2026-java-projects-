import java.util.Scanner;
     public class SubjectLeviesApp{
      public static void main(String [] args)
     {
		 Scanner kb=new Scanner(System.in);
		String [] subjectCodess={"CFA115D","COH115D","PPA115D","WEB115D","PPB115D","DCT115D","CFB115D"};
		 double [] oldLevies={323.95,100.05,625.75,380.95,850.55,122.55,200.99};
		 String [] levyStatus=new String[subjectCodess.length];
		 double [] newLevies=new double[subjectCodess.length];
		 char option,optionFound;
		 displayLevyDetails(subjectCodess,oldLevies,newLevies,levyStatus);
		
		do{
			  optionFound=getUserOption();
		 switch(optionFound){
			 case 'C':populateLevies(newLevies,subjectCodess,oldLevies);
			 determineLevyStatus(levyStatus,oldLevies,newLevies);
			  displayLevyDetails(subjectCodess,oldLevies,newLevies,levyStatus);
			  
			 break;
			 case 'S': System.out.print("Enter the code you are looking for: ");
			     String searchingCode=kb.nextLine();
			 int searched=searchSubjectLevy(subjectCodess,searchingCode);
			 if(searched==-1){
				 System.out.println(searchingCode+" is not found");
			 }else{
				 System.out.println("Subject code "+searchingCode+" status: "+levyStatus[searched]);
			 }
			 
			 case 'E':
			 System.out.println();break;
			 default: System.out.print("Select any option to start:\nEnter C– Determine Levy Status\nEnter S – Search Subject Levy.\nEnter E – Exit");
				  option=kb.next().charAt(0);
		 }
		 
				 
	    }while(optionFound!='E');
	 }
	     public static void populateLevies(double[] p_newLevies, String[] p_subjectCodess, double[] p_oldLevies){
			 Scanner kb=new Scanner(System.in);
			 for(int i=0; i < p_subjectCodess.length;i++){
				 System.out.print("Enter the new levies for "+p_subjectCodess[i]+" :");
				 p_newLevies[i]=kb.nextDouble();
				 while(validateLevies( p_oldLevies,p_newLevies)==false){
					 System.out.print("Invalid levy amount entered, must not be negative or less than the current levy");
					 System.out.print("Enter the new levies for "+p_subjectCodess[i]+" :");
				    p_newLevies[i]=kb.nextDouble();
				 }
			 }
		 }
         public static boolean validateLevies(double[] p_oldLevies, double [] p_newLevies ){
			boolean bfalg=false;

			for(int i=0; i < p_oldLevies.length;i++){
			 if(p_newLevies[i] >0 && p_newLevies[i] > p_oldLevies[i]){
				 bfalg=true;
			 }
			 }
			 return bfalg;
		 }
			 public static char getUserOption(){
				 Scanner kb=new Scanner(System.in);
				 System.out.print("Select any option to start:\nEnter C– Determine Levy Status\nEnter S – Search Subject Levy.\nEnter E – Exit");
				 char option=Character.toUpperCase(kb.next().charAt(0));
				 return option;
			 }
			 public static void determineLevyStatus( String[] p_levyStatus, double[] p_oldLevies, double[] p_newLevies){
				 double [] totalAmount=new double[p_oldLevies.length];
				 for(int i=0; i < p_oldLevies.length;i++){
					 totalAmount[i]=((p_newLevies[i]-p_oldLevies[i])/p_oldLevies[i])*100;
					 if(totalAmount[i] <= 6.5){
						p_levyStatus[i]="Approved - increase "+totalAmount[i]+"% is not more than inflation"; 
					 }else if(totalAmount[i] >= 6.5){
						 p_levyStatus[i]="Not approved –  increase"+ totalAmount[i]+"% is more than inflation";
						 }else if(p_newLevies[i] < p_oldLevies[i]){
							p_levyStatus[i]= "Approved –"+totalAmount[i]+" less than previous levy";
						 }else if(p_newLevies[i]==p_oldLevies[i]){
							 p_levyStatus[i]="Approved – "+totalAmount[i]+"levy stays the same";
						 }
						 
				 }
				 
			 }
			 public static int  searchSubjectLevy(String[] p_subjectCodess, String p_searchingCode) {
				 int index=-1;
				 for(int i=0; i < p_subjectCodess.length;i++){
					 if(p_subjectCodess[i].equalsIgnoreCase(p_searchingCode))
						 index=i;
				 }
				 return index;
			 }
			 public static void displayLevyDetails(String[] p_subjectCodess ,double[] p_oldLevies,double[] p_newLevies,String[] p_levyStatus){
				
				for(int i=0; i < p_oldLevies.length;i++){
					System.out.println(p_subjectCodess[i]+"\t"+p_oldLevies[i]+"\t"+p_newLevies[i]+"\t"+p_levyStatus[i]);
				}
			    }
		 		 
	 }