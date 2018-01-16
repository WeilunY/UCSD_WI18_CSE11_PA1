/*
 * @author: cs11wml
 * @pid: A15017352
 * @date: 1/15/2018
 * @about: Found bugs in the original files and fixed them

 # Error 1: line 8
  Sytax Error - invalid method declaration; return type required
  - Incorrect: public static findMax(int[] array)
  - FIXED: public static int findMax(int[] array)
  - Explanation: Correction adds the return datatype "int" to the original Method
    declaration, which is required.
---------------------------------------------------------------------------------

# Error 2: line 15
 Runtime Error - Array out of bounds
 - Incorrect: for (int i = 0; i <= array.length; i++)
 - FIXED: for (int i = 0; i < array.length; i++)
 - Explanation: Correction makes i stop at array.length - 1 rather than array.length
---------------------------------------------------------------------------------

# Error 3: line 30
 Syntax Error - invalid variable declaration; datatype required
 - Incorrect: min = array[0];
 - FIXED: int min = array[0];
 - Explanation: Correction declares the int datatype for 'min'
---------------------------------------------------------------------------------

# Error 4: line 51
 Syntax Error - not a statement
 - Incorrect: sum == array[i];
 - FIXED: sum += array[i];
 - Explanation: Correction declares the int datatype for 'min'
---------------------------------------------------------------------------------

# Error 5: line 54
 Syntax Error - wrong return datatype
 - Incorrect: int average = ( sum / ( array.length ) );
 - FIXED: double average = ( sum / ( array.length ) );
 - Explanation: Correction makes 'average' as double rather than int, so the function
    returns the right type of data.
---------------------------------------------------------------------------------

# Error 6: line 60
 Syntax Error - wrong input datatype
 - Incorrect: public static int[] arrayCopy(int array)
 - FIXED: public static int[] arrayCopy(int[] array)
 - Explanation: Correction changes input datatype from "int" to "int[]"
---------------------------------------------------------------------------------

# Error 7: line 67
 Logic Error - wrong i increment
 - Incorrect: result[i++] = array[i];
 - FIXED: presult[i] = array[i];
 - Explanation: Correction changes i's increment from 2 to 1
---------------------------------------------------------------------------------

# Error 8: line 74
 Logic Error - wrong short circuit protects
 - Incorrect: if (array != null)
 - FIXED: if (array == null)
 - Explanation: Correction corrects the short circuit protects' statement
---------------------------------------------------------------------------------

# Error 9: line 92
 Syntax Error - wrong indentifier used
 - Incorrect: for (int j = 0; i < result.length - i - 1; j++)
 - FIXED: for (int j = 0; j < result.length - i - 1; j++)
 - Explanation: Correction changes i to j
---------------------------------------------------------------------------------


# Error 10: line 94
 Logic Error - wrong temporary holder choice
 - Incorrect: int temp = result[j];
 - FIXED: int temp = result[j + 1];
 - Explanation: Correction assigns temp to a correct value 'result[j + 1]'
---------------------------------------------------------------------------------

 * */

 public class FunWithIntArrays {

   // return the largest element in the input array
   public static int findMax(int[] array) { //FIXED
     //short circuit protects null access
     if (array == null || array.length == 0)
       return -1;

     int max = array[0];

     for (int i = 0; i < array.length; i++) { //FIXED
       if (array[i] > max) {
         max = array[i];
       }
     }

     return max;
   }

   // return the smallest element in the input array
   public static int findMin(int[] array) {
     //short circuit protects null access
     if (array == null || array.length == 0)
       return -1;

     int min = array[0]; //FIXED

     for (int i = 0; i < array.length; i++) {
       if (array[i] < min) {
         min = i;
       }
     }

     return min;
   }


   // return the average of elements in the input array
   public static double findAvg( int array[] ) {
     //short circuit protects null access
     if ( array == null || array.length == 0 )
       return -1;

     double sum = 0;

     for ( int i=0; i < array.length; i++ ) {
       sum += array[i]; //FIXED
     }

     double average = ( sum / ( array.length ) ); //FIXED

     return average;
   }

   // return a copy of the input array
   public static int[] arrayCopy(int[] array) { //FIXED
     if (array == null)
       return null;

     int[] result = new int[array.length];

     for (int i = 0; i < array.length; i++) {
       result[i] = array[i]; //FIXED
     }
     return result;
   }

   // output the elements of the input array
   public static void printArray(int[] array) {
     if (array == null) //FIXED
       return;

     for (int i = 0; i < array.length; i++) {
       System.out.print(array[i] + ", ");
     }

     System.out.println();
   }

   // return a sorted copy of the input array
   public static int[] arraySort(int[] array) {
     if (array == null)
       return null;

     int[] result = arrayCopy(array);

     for (int i = 0; i < result.length - 1; ++i) {
       for (int j = 0; j < result.length - i - 1; j++) { //FIXED
         if (result[j] > result[j + 1]) {
           //swapping result[j] and result[j+1]
           int temp = result[j + 1]; //FIXED
           result[j + 1] = result[j];
           result[j] = temp;
         }
       }
     }
     return result;
   }
 }
