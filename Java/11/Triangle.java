//This program will calculate a Triangle's area and perimeter.
//Written by Michelle Eden, Oct. 2019
import java.util.Scanner;
public class Triangle {
    public static void main (String[] args){
        Scanner scan = new Scanner (System.in);
        System.out.println ("this program calculate the area "
        + "and the perimeter of a given triangle. ");
        System.out.println ("please enter the three lengths"
        + " of the triangle's sides"); 
        System.out.println("* please remember the 3 rules of a Triangle: ");
        System.out.println("a+b>c,b+c>a,a+c>b");  
        //the user choose 3 numbers to be the triangle's edges
        
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        //this will send a error message to the user for any wrong edges
        if((a + b < c) || (b+c < a) || (a + b < b) || a < 0 || b<0 || c<0) {
            System.out.println("Please enter legit Triangle's edges" 
            + " by the rules");
        }
        
        else {
        int perimeter = a + b + c; //calculation of perimeter
        // here starts teh calculation of area by Heron 's formula
        double s = perimeter / 2.0;
        double heron = s * (s-a) * (s-b) * (s-c);
        //final step for Heron's formula 
       double area = Math.sqrt(heron);
       
    
        System.out.println("the perimeter of the triangle is " + perimeter);
        System.out.println("the heron area of the triangle is " + area);
        
    }
        
        
        
        
    } 
}
