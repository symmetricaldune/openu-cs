
/**
 * This class represents questions from Maman 14
 *
 * @author (Michelle Eden)
 * @version (2020a)
 */

public class Ex14
{
//methods
    /**
     * 
     *
     * @param  s, @param c
     * @return    numOfStrings - answer to quations 1.a. from the Maman
     * Time complexity O(n)
     * Memory complexity O(1)
     */
public static int subStrC(String s, char c)
    {
        int numOfStrings = 0;
        int count = 0;
    for(int i = 0; i<s.length();i++)
    {
        if(s.charAt(i) == c) 
        {
            count++;
        }

    }
    numOfStrings = count-2;
    if(count<3) {
        return 0;
    }
    return numOfStrings; 
    
}
/**
 * @param s, @param c, @param k
 * @return numOfStrings - answer to question 1.b. from the Maman
 * Time complexity O(n^2)
   Memory complexity O(1)
 */

  
public static int subStrMaxC(String s, char c, int k)
{
  int numOfStrings = 0;
  int count = 0;
    for(int i = 0; i < s.length(); i++)
    {
       if(s.charAt(i) == c)
       {
          numOfStrings += Integer.min(k + 1, count);
          count++;
            }
        }   
    return numOfStrings;
} 
/**
 * question 2 of the Maman, an array with 0's and distances
 * from the last zero. 
 * @param [] a
 * @return an array with zeros and distanceses
 * Time complexity O(n)
 * Memory complexity O(1)
 */
public static void zeroDistance(int [] a)
{
    int lastZero = -1;
    for(int i=0 ; i<a.length ; i++)
    {
       if(a[i]==0)
       {
           lastZero = 0;
        }
       else {         
           if(lastZero==-1)
           {
               a[i]=Integer.MAX_VALUE;
            }
           else 
           {
               lastZero++;
               a[i]=lastZero;
           }                    
       }
    }
   lastZero=-1;
    for(int i=a.length-1;i>=0;i--)
    {
       if(a[i]==0)
       {
           lastZero=0;
        }
       else if(lastZero!=-1 && a[i]>++lastZero)
       {
           a[i]=lastZero;
        }
    }
}

/**
 * @param s, @param t
 * @return isTrans - calling the next method (public method)
 */
public static boolean isTrans(String s, String t)
{
    if(s.equals(t))
    {
        return true;
    }
    if(s.length() > t.length())
    {
        return false;
        
    }
    if(t.indexOf(0) != s.indexOf(0))
    {
        return false;
    }
    else 
    {
        return isTrans(s,t,1,1);   
    }

}
/**
 * @param s, @param t, @param x, @param y
 * @return isTrans
 * This is the private method
 */
private static boolean isTrans(String s, String t, int x,int y)
{
    if(s.length()==x)
    {
        return true; 
    }
    if(t.length()==y)
    {
        return true; 
    }
    if(t.charAt(x)==s.charAt(x))
    {
        return isTrans(s,t,x+1,y);
    }
   
    if(t.charAt(y) != s.charAt(x))
    {
        String newT=t.substring(y);
        String newS=s.substring(x);
        return isTrans(newS,newT,x,y+1);
        
    }
  
    return false;
}
/**
 * @param [][] mat
 * @return countpaths (calling the next method)
 */
public static int countPaths(int [][] mat)
{
    
  return countPaths(mat,0,0);
}

/**
 * @param [][] mat, @param x, @param y
 * @return countpaths - answer to question 4 
 */
private static int countPaths(int [][] mat, int x, int y)
{
    int n = mat.length -1;
    int m = mat[0].length -1;
    if (x==n && y==m)
    {
        return 1;
    }
    if(x>n || y>m)
    {
        return 0;
    }
    if(mat[x][y]==0)
    {
        return 0;
    }

    if(x+(mat[x][y]/10) == x+(mat[x][y]%10) && x+(mat[x][y]%10) == x+mat[x][y]/10)
    {
        return countPaths(mat,x+(mat[x][y]/10),y+(mat[x][y]%10));
    }
    else
    {
        return countPaths(mat,x+(mat[x][y]/10),y+(mat[x][y]%10)) + countPaths(mat,x+(mat[x][y]%10),y+(mat[x][y]/10) );
    }

}
}

