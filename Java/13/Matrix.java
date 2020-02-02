
/**
Write a description of class Matrix here.
This class represent a two dimension arr, named Matrix and some methods

@author (Michelle Eden)
@version (2019a)
*/


public class Matrix
{
int size1; // SHAY: Private (-2)
int size2;
private int _Matrix[][];
private int newMatrix[][];
final int MAXVALUE = 255;
final int MINVALUE = 0;
    /**
     * Constructor for objects of class Matrix
     * @paran int [][] array
     */
public Matrix(int [][] array)
    {
        _Matrix = new int[array.length][array[0].length]; // initializing the matrix
    
    // copying cells
    for (int i = 0; i < array.length; i++){
      for (int j = 0; j < array[0].length; j++){
        _Matrix[i][j] = array[i][j];
      }
    }
        
    }
    /**
     * constructor
     * @param int size1, int size2
     */
public Matrix(int size1, int size2)
    {
        _Matrix = new int[size1][size2];
        
    }

//string of Matrix's elements
/**
 * @return outPut, a string of Matrix's elements
 */    
public String toString() {  
    String outPut=""; 
    for(int i=0;i<_Matrix.length;i++) { 
        for(int j=0;j<_Matrix[0].length;j++) { 
            outPut = outPut + _Matrix[i][j]  + "\t";
    }
    outPut = outPut + "\n";
   }
    return outPut;   
}

//negative version of Matrix
/**
 * @return newMatrix, a negative version of Matrix
 */ 
public Matrix makeNegative() {
  {
     Matrix newMatrix =  new Matrix (_Matrix.length,_Matrix[0].length); 
     for(int i=0; i<_Matrix.length; i++) {
         for(int j = 0; j<_Matrix[0].length; j++) {
             newMatrix._Matrix[i][j] = MAXVALUE - _Matrix[i][j];
            }
         }
      return newMatrix;   
         }   
}

//filtered / retouched version of Matrix
/**
 * @return newMatrix, a filtered version of Matrix (each cell is an average of its neighbor cells
 */   
public Matrix imageFilterAverage() {
     Matrix newMatrix =  new Matrix (_Matrix.length,_Matrix[0].length); 
     int ncount = 0; // neighbor counter
     int nsum = 0; // neighbor value sum
     for(int i=0; i<_Matrix.length; i++) {
         for(int j = 0; j<_Matrix[0].length; j++) {
             int ni= i -1;
             int nj= j -1 ;
             int nim = i +1;
             int njm = j +1;
             // avoid hitting lowest boundaries of the matrix
             if(ni <0) 
             {
                 ni = 0;
             }
             if(nj <0)
             {
                 nj = 0;
             }
             
             // avoid hitting highest boundaries of the matrix
             if(nim >= _Matrix.length) 
             {
                 nim = _Matrix.length-1;
             }
             if(njm >= _Matrix[0].length)
             {
                 njm = _Matrix[0].length-1;
             }   
             
             for(int ri = ni; ri<=nim; ri++) {
                 for(int rj = nj; rj<=njm; rj++) {
                     if ((ri != i) && (rj != j)) // if not our real matrix's cell - do 
                     {
                        
                         nsum = nsum + _Matrix[ri][rj];
                         ncount++;
                     }
                 }
             }
             // neighbor average
             int navg =  (nsum / ncount);
             newMatrix._Matrix[i][j]= navg;
  
            }
         }
      return newMatrix;      
}


// the two next methods are rotations of the Matrix - the first clockwise, the second counter clockwise
/**
 * @return newMatrix, a clockwise rotation of the Matrix
 */  
public Matrix rotateClockwise() {
 
     Matrix newMatrix =  new Matrix (_Matrix[0].length,_Matrix.length); 
     for(int i=0; i<_Matrix[0].length; i++) {
         for(int j = 0; j<_Matrix.length; j++) {
             newMatrix._Matrix[i][j] = _Matrix[j][i];
            }
         }
      return newMatrix;   
           
}
/**
 * @return newMatrix, a counter clockwise rotation of the Matrix
 */
public Matrix rotateCounterClockwise() {
    
     Matrix newMatrix =  new Matrix (_Matrix[0].length,_Matrix.length); 
     int zlp =0;
     for(int i=0; i<_Matrix[0].length; i++) {
         zlp=0;
         for(int j = _Matrix.length-1; j>=0; j--) {
             
             newMatrix._Matrix[i][j] = _Matrix[zlp][i];
             zlp++;
             //System.out.println(_Matrix[j][i]);
            }
         }
      return newMatrix;  
}
}
     
    

