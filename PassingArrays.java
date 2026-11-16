public class PassingArrays{
	public static void main(String[] args){
	
	   int[]nums = {10,20,45,23,45};
	   display(nums);
	   sort(nums);
	   
	   
	}
	public static void  sort(int[]nums){
		for(int i = 0; i<nums.length; i++){
			for(int j = 0; j<nums.length-1;j++){
				if(nums[j]>nums[j+1]){
					int temp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = temp;
					
				}
				
			}
		}
		 for(int i= 0; i<nums.length; i++){
			   System.out.println(nums[i]);
		 }
		
	}
	   public static void display(int[]nums){
		   for(int i= 0; i<nums.length; i++){
			   System.out.println(nums[i]);
		   }
		   
	   
	}
	
}