import java.io.*;
import java.util.*;

/**
* @author: cs11wml
* @pid: A15017352
* @date: 1/29/2018
* @about: Encrypt and decrypt string using Mono-alphabetic Cipher
* @Mono-alphabetic Cipher:
* Each plaintext letter maps to a different random cipher text letter
* ie: original: abcdefghijklmnopqrstuvwxyz (all lowercase)
*          key: QWERTYUIOPASDFGHJKLZXCVBNM (randomly generated upper case)
* */
public class ExtraCreditEncryption{

  /** Main method: generate a new key. Prompt user for input message.
    * Encrypt it, validate it, and print out the encrypted message.
    **/
  public static void main(String[] args){

    // create a scanner
    Scanner input = new Scanner(System.in);

    // generate the original lower case array
    // using generateOriginal() method
    char[] original = generateOriginal();

    // generate the random uppercase key array
    // using generateKey() methid
    char[] key = generateKey();

    // Print out each
    String o = new String(original);
    String k = new String(key);

    System.out.println("Key generation succeed! ");
    System.out.println("original: " + o + ", key: " + k);

    // Ask user for input
    System.out.print("Please enter the message that you want to encrypt (no space): ");

    // convert input string to lowercase for encryption
    String msg = input.nextLine().toLowerCase();

    // Encrypt the message using encrypt method
    String encrypted = encrypt(msg, original, key);

    // Decrypt the encrypted message to check its validity
    // using decrypt method
    String decrypted = decrypt(encrypted, original, key );
    if(decrypted.equals(msg)){
      System.out.println("Encryption succeed!");
      System.out.println("The encrypted message of " + msg + " is \"" +
      encrypted +"\". ");
    }

    input.close();

  }


  /** Return the string after encryption.
    * @param s the original message
    * @param original the lower case original char array for reference
    * @param key the upper case key char array for refence
    * @return string after encryption
    */
  public static String encrypt(String s, char[] original, char[] key){
    // convert input string to char array
    char[] array_s = s.toCharArray();

    // change each element in array_s
    // get character's index in original array using getIndex method
    // change it into the character in key array with same index
    for(int i = 0; i < array_s.length; i++){
      int pos = getIndex(array_s[i], original);
      if (pos >= 0)
        array_s[i] = key[pos];
    }

    String result = new String(array_s);

    return result;

  }


  /** Return the string after decryption.
    * @param s the encrypted message
    * @param original the lower case original char array for reference
    * @param key the upper case key char array for refence
    * @return string after decryption
    */
  public static String decrypt(String s, char[] original, char[] key){
    // convert input string to char array
    char[] array_s = s.toCharArray();

    //change each element in array_s
    // get character's index in key array using getIndex method
    // change it into the character in original array with same index
    for(int i = 0; i < array_s.length; i++){
      int pos = getIndex(array_s[i], key);
      if (pos >= 0)
        array_s[i] = original[pos];
    }

    String result = new String(array_s);

    return result;

  }


  /** Return the index of char in array, -1 if do not exist
    * @param a the character
    * @param arr the array
    * @return -1 if doesn't exist, or index of a in arr
    */
  public static int getIndex(char a, char[] arr){
    int pos = 0;
    for(int i = 0; i < arr.length; i++){
      if(arr[i] == a){
        pos = i;
      }
    }
    return pos;
  }


  /** Return the char array in alphabetical order (lowercase)
    * @return  char array in alphabetical order (lowercase)
    */
  public static char[] generateOriginal(){
    char[] original = new char[26];

    for(int i = 0, j = 97; i < 26; i++, j++){
      original[i] = (char) j;
    }

    return original;
  }


  /** Return the char array in random order (uppercase)
    * @return  char array in random order (uppercase)
    */
  public static char[] generateKey(){
    char[] choice = new char[26];

    // initialize the array in alphabetical order
    for(int i = 0, j = 65; i < 26; i++, j++){
      choice[i] = (char) j;
    }

    // max and min for random generator
    // position in array
    int max = 25, min = 0;

    // iterate the array
    // swap the element at i with random position afterward
    for(int i = 0; i < 26; i++){
      int n = (int)(Math.random() *((max - min) + 1)) + min;
      char temp = choice[i];
      choice[i] = choice[n];
      choice[n] = temp;
      min++;
    }

    return choice;
  }


}
