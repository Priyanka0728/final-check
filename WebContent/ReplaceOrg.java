import java.util.Scanner;
class ReplaceOrg
{
	   public static void main(String...arg) {
	      Scanner sc=new Scanner(System.in);
	
			System.out.println("Enter the content of document");
			String x=sc.nextLine();
						
			System.out.println("Enter the old name of the company");
			String y=sc.nextLine();
			
			System.out.println("Enter the new name of the company");
			String z=sc.nextLine();
			
			String cont=x.replace(y,z);
			System.out.println("The content of the modified document is \n"+cont);
			     
			}
				
}