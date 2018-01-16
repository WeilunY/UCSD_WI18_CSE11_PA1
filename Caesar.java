// Keep these two lines.  They are what tell Java to include the
// classes you need for working with files.
// You might get warnings about them at first.  That's OK, just
// ignore the warnings.  They should go away as you complete your code.
import java.io.*;
import java.util.*;

/** Your header comment goes here.
 * Be sure to include your name, cse account name, and the date
 * */
public class Caesar {
  // Complete the methods below.  MAKE SURE to add header
  // comments for each. You may (and should) also write additional
  // helper methods.  Be sure to make the helper methods private and include
  // header comments for each.

  private static char letterOperation(char a, int rotation) {
    // TODO: Complete this method
    
    // Check rotation of negative and large num Case
    // Convert large number to smaller
    if (rotation > 26)
      rotation = rotation % 26;

    // Small negative Case
    if (rotation < 0 && rotation >= -26)
      rotation = 26 + rotation;

    // Large negative
    if (rotation < -26)
      rotation = 26 - (Math.abs(rotation) % 26);

    if (a >= 65 && a <= 90){
      // Check if a is in the range of Upper Case after rotation
      if (a <= 90 - rotation)
        a += rotation;
      else
        a = (char)(a + rotation - 26); // if not start from A by -26
    }
    // Check if char is in Lower Case range
    else if (a >= 97 && a <= 122){
      if (a <= 122 - rotation)
        a += rotation;
      else
        a = (char)(a + rotation - 26);
    }

    return a;
  }

  public static String encryptStr(String s, int rotation) {
    // TODO: Complete this method
    // letters are between 65 and 90 (Upper Case) and 97 and 122 (Lower Case)
    String result = ""; // initialize the return string

    for (int i = 0; i < s.length(); i++){
     char a = s.charAt(i);
     result += letterOperation(a, rotation);
   }

    return result;
  }

  public static String decryptStr(String s, int rotation) {
    // TODO: Complete this method
    String result = ""; // initialize the return string

    for (int i = 0; i < s.length(); i++){
     char a = s.charAt(i);
     result += letterOperation(a, 26 - rotation);
   }

    return result;
  }

  public static String encryptChArr(String s, int rotation) {
    // TODO: Complete this method
    // letters are between 65 and 90 (Upper Case) and 97 and 122 (Lower Case)
    return "";
  }

  public static String decryptChArr(String s, int rotation) {
    // TODO: Complete this method
    return "";
  }

  public static String encryptSB(String s, int rotation) {
    // TODO: Complete this method
    // letters are between 65 and 90 (Upper Case) and 97 and 122 (Lower Case)
    return "";
  }

  public static String decryptSB(String s, int rotation) {
    // TODO: Complete this method
    return "";
  }
}
