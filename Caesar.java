import java.io.*;
import java.util.*;

/**
* @author: cs11wml
* @pid: A15017352
* @date: 1/15/2018
* @about: Found bugs in the original files and fixed them
* */
public class Caesar {

  /** Check whether rotation is in the range 0-26, if not modify it, else return
    * the original one.
    * @param rotation The number of time the letter wheel rotates
    * @return The (modified) rotation in range 0-26
    * */
  private static int rotationSetter(int rotation) {
    // Check rotation of negative and large num Case

    // Large positive
    if (rotation > 26)
      rotation = rotation % 26;

    // Small negative
    if (rotation < 0 && rotation >= -26)
      rotation = 26 + rotation;

    // Large negative
    if (rotation < -26)
      rotation = 26 - (Math.abs(rotation) % 26);

    return rotation;
  }


  /** Return the char after rotation, if char is not alphabetical return the original
    * @param a The character being rotated
    * @param rotation The number of time the letter wheel rotates
    * @return The alphabetical character after rotation, or the original
    * */
  private static char letterOperation(char a, int rotation) {
    // Make sure the rotaion is in range
    rotation = rotationSetter(rotation);

    if (a >= 65 && a <= 90){
      // Check if a is in the range of Upper Case after rotation
      if (a <= 90 - rotation)
        a += rotation;
      else
        a = (char)(a + rotation - 26); // if not start a by -26
    }
    // Check if char is in Lower Case range
    else if (a >= 97 && a <= 122){
      if (a <= 122 - rotation)
        a += rotation;
      else
        a = (char)(a + rotation - 26); // if not start a by +26
    }

    return a;
  }


  /** Return the string after encryption using String type object
    * @param s The string being encrypted
    * @param rotation The number of time the letter wheel rotates
    * @return The encrypted string
    * */
  public static String encryptStr(String s, int rotation) {
    // initialize the return string (String type)
    String result = "";

    // traverse the string and rotate each character by using letterOperation
    // then add it to the result string
    for (int i = 0; i < s.length(); i++){
     char a = s.charAt(i);
     result += letterOperation(a, rotation);
   }

    return result;
  }


  /** Return the string after decryption using String type object
    * @param s The string being decrypted
    * @param rotation The number of time the letter wheel rotates
    * @return The decrypted string
    * */
  public static String decryptStr(String s, int rotation) {
    // initialize the return string (String type)
    String result = "";

    // traverse the string and rotate each character by using letterOperation
    // then added it to the result string
    for (int i = 0; i < s.length(); i++){
     char a = s.charAt(i);
     // decryption rotates different direction, which is 26 - rotation
     result += letterOperation(a, 26 - rotation);
   }

    return result;
  }


  /** Return the string after encryption using char array type object
    * @param s The string being encrypted
    * @param rotation The number of time the letter wheel rotates
    * @return The encrypted string
    * */
  public static String encryptChArr(String s, int rotation) {
    // convert string to char array
    char[] array_s = s.toCharArray();

    // traverse the array and modify each character by using letterOperation
    for (int i = 0; i < array_s.length; i++){
      char a = array_s[i];
      array_s[i] = letterOperation(a, rotation);
    }

    // convert char array to String and return it
    String result = new String(array_s);
    return result;
  }


  /** Return the string after decryption using char array type object
    * @param s The string being decrypted
    * @param rotation The number of time the letter wheel rotates
    * @return The decrypted string
    * */
  public static String decryptChArr(String s, int rotation) {
    // convert string to char array
    char[] array_s = s.toCharArray();

    // traverse the array and modify each character by using letterOperation
    for (int i = 0; i < array_s.length; i++){
      char a = array_s[i];
      // decryption rotates different direction, which is 26 - rotation
      array_s[i] = letterOperation(a, 26 - rotation);
    }

    // convert char array to String and return it
    String result = new String(array_s);
    return result;
  }


  /** Return the string after encryption using StringBuilder type object
    * @param s The string being encrypted
    * @param rotation The number of time the letter wheel rotates
    * @return The encrypted string
    * */
  public static String encryptSB(String s, int rotation) {
    // initialize result as StringBuilder type
    StringBuilder result = new StringBuilder();

    // traverse the string and rotate each character by using letterOperation
    // then append it to the result StringBuilder
    for (int i = 0; i < s.length(); i++){
      char a = s.charAt(i);
      result.append(letterOperation(a, rotation));
    }

    // convert the result to string and return it
    return result.toString();
  }


  /** Return the string after decryption using StringBuilder type object
    * @param s The string being decrypted
    * @param rotation The number of time the letter wheel rotates
    * @return The decrypted string
    * */
  public static String decryptSB(String s, int rotation) {
    // initialize result as StringBuilder type
    StringBuilder result = new StringBuilder();

    // traverse the string and rotate each character by using letterOperation
    // then append it to the result StringBuilder
    for (int i = 0; i < s.length(); i++){
      char a = s.charAt(i);
      // decryption rotates different direction, which is 26 - rotation
      result.append(letterOperation(a, 26 - rotation));
    }

    // convert the result to string and return it
    return result.toString();
  }
}
