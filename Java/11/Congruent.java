//This program will ask the user for two Triangle's vertexes
// and check if the Triangles are congruent
//Written by Michelle Eden, Oct. 2019
import java.util.Scanner;
public class Congruent {
   public static void main(String[] args){ 
  Scanner scan = new Scanner(System.in);
  System.out.println("please enter 6 vertexes (x,y) - 3 for each Triangle");
  System.out.println("each digit seperated with space");
    int a1 = scan.nextInt();
    int a2 = scan.nextInt();
    int b1 = scan.nextInt();
    int b2 = scan.nextInt();
    int c1 = scan.nextInt();
    int c2 = scan.nextInt();
    int d1 = scan.nextInt();
    int d2 = scan.nextInt();
    int e1 = scan.nextInt();
    int e2 = scan.nextInt();
    int f1 = scan.nextInt();
    int f2 = scan.nextInt();
    
   System.out.println("The first Triangle is " + "(" + a1 + "," + a2 + ")"
   + "(" + b1 + "," + b2 + ")" + "(" + c1 + "," + c2 + ")");
  
    System.out.println("The second Triangle is " + "(" + d1 + "," + d2 + ")"
   + "(" + e1 + "," + e2 + ")" + "(" + f1 + "," + f2 + ")");
   
  
   // calculation of lengthes:
   //ab: 
  double ab1 = Math.pow((a1-b1), 2);
  double ab2 = Math.pow((a2 - b2), 2);
  double ab = Math.sqrt(ab1 + ab2);
  
  //bc: 
  double bc1 = Math.pow((b1-c1), 2);
  double bc2 = Math.pow((b2 - c2), 2);
  double bc = Math.sqrt(bc1 + bc2);
  
  //ac: 
  double ac1 = Math.pow((a1-c1), 2);
  double ac2 = Math.pow((a2 - c2), 2);
  double ac = Math.sqrt(ac1 + ac2);
  
  //de: 
  double de1 = Math.pow((d1-e1), 2);
  double de2 = Math.pow((d2 - e2), 2);
  double de = Math.sqrt(de1 + de2);
  
   //ef: 
  double ef1 = Math.pow((e1-f1), 2);
  double ef2 = Math.pow((e2 - f2), 2);
  double ef = Math.sqrt(ef1 + ef2);
  
   //df: 
  double df1 = Math.pow((d1-f1), 2);
  double df2 = Math.pow((d2 - f2), 2);
  double df = Math.sqrt(df1 + df2);
  
 System.out.println("Triangle 1 lengthes are: " + ab +"," + bc + "," + ac); 
 System.out.println("Triangle 2 lengthes are: " + de + "," + ef + "," + df);
 
 // calculation of congruent 
if((ab == de || ab == df || ab == ef)
 & (ac == de || ac == ef|| ac == e1)
 & (bc == de || bc == ef|| bc == df)) {
   System.out.println("The triangles are congruent");

}
else {
    System.out.println("The triangles are not congruent");
   
}
  
}
}