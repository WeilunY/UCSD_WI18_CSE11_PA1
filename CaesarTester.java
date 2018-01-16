/*
 * Name: Heitor Schueroff <--- Replace with your name
 * Login: cs8baXX <--- Use your cs8ba course-specific account name
 * Date:  04/04/2017 Tue
 * File:  CaesarTester.java
 * Sources of Help: ... (for example: names of people/tutors/students, books,
 *                       websites, etc.)
 *
 * Tests Caesar.java using basic strings and rotation values.
 *
 */

/*
 * Name:    CaesarTester
 * Purpose: To test Caesar.java for correct output.
 */
public class CaesarTester {

  private static int testNum = 0;  // Keep track of which test we're running

  /**
   * Check the test case to see if it's correct
   * @param message The message to encrypt or decrypt
   * @param expectedAnswer The answer expected
   * @param actualAnswer The actual answer produced
   * @param enc_or_dec A string specifying what function was tested.
   * @return 1 if the test failed, and 0 otherwise.
   */
  public static int testCase(String message, String expectedAnswer,
      String actualAnswer, String enc_or_dec) {
    testNum++;
    if (!expectedAnswer.equals(actualAnswer)) {
      System.out.println("Test " + testNum + " Failed (" +
          enc_or_dec + ")");
      System.out.println("Given message to " + enc_or_dec + " is: "
          + message);
      System.out.println("Your Answer is: " + actualAnswer);
      System.out.println("The correct answer is: " + expectedAnswer + "\n");
      return 1;
    } else {
      System.out.println("Test " + testNum + " Passed!\n");
      return 0;
    }
  }

  /*
   * Name:       main
   * Purpose:    To call methods in Caesar and test them
   * Parameters: String[] args - command line arguments that are unused
   * Return:     void
   */
  public static void main(String[] args) {

    /** The main method. THIS IS WHERE YOU SHOULD ADD MORE TESTS
     * FOR encrypt and decrypt methods AND ANY OTHER METHOD
     * THAT YOU CREATE. BE SURE TO TEST YOUR CODE THOROUGHLY
     **/

    //The Caesar Cipher Tests
    int failCases = 0;

    // Avoid magic numbers for constants
    final int ENC_ROTATION = 17;
    final int DEC_ROTATION = -58;

    String message1 = "When in the course of human events it becomes necessary for one people to" +
      " dissolve the political bands which have connected them with another and to"+
      " assume among the powers of the earth the separate and equal station to"+
      " which the laws of nature and of nature's God entitle them a decent respect"+
      " to the opinions of mankind requires that they should declare the causes"+
      " which impel them to the separation.";

    String encryptedAnswer = "Nyve ze kyv tflijv fw yldre vmvekj zk svtfdvj evtvjjrip " +
      "wfi fev gvfgcv kf uzjjfcmv kyv gfczkztrc sreuj nyzty yrmv tfeevtkvu kyvd nzky refkyvi" +
      " reu kf rjjldv rdfex kyv gfnvij fw kyv vriky kyv jvgrirkv reu vhlrc jkrkzfe kf nyzty " +
      "kyv crnj fw erkliv reu fw erkliv'j Xfu vekzkcv kyvd r uvtvek ivjgvtk kf kyv fgzezfej fw" +
      " drebzeu ivhlzivj kyrk kyvp jyflcu uvtcriv kyv trljvj nyzty zdgvc kyvd kf kyv jvgrirkzfe.";

    System.out.println("***** PART A TESTS ******\n");

    //Test 1
    String encrypted1 = Caesar.encryptStr(message1, ENC_ROTATION);
    failCases += testCase(message1, encryptedAnswer, encrypted1, "encrypt");

    //Test 2
    String encrypted2 = "Byffi yhwlsjncih qilfx, byffi yhwlsjncih qilfx";
    String messageAnswer = "Hello encryption world, hello encryption world";
    String message2 = Caesar.decryptStr(encrypted2, DEC_ROTATION);
    failCases += testCase(encrypted2, messageAnswer, message2, "decrypt");

    System.out.println("\n***** PART B TESTS *******\n");   

    //Test 3
    encrypted1 = Caesar.encryptChArr(message1, ENC_ROTATION);
    failCases += testCase(message1, encryptedAnswer, encrypted1, "encrypt");

    //Test 4
    message2 = Caesar.decryptChArr(encrypted2, DEC_ROTATION);
    failCases += testCase(encrypted2, messageAnswer, message2, "decrypt");

    System.out.println("\n***** PART C TESTS *******\n");

    //Test 5
    encrypted1 = Caesar.encryptSB(message1, ENC_ROTATION);
    failCases += testCase(message1, encryptedAnswer, encrypted1, "encrypt");

    //Test 6
    message2 = Caesar.decryptSB(encrypted2, DEC_ROTATION);
    failCases += testCase(encrypted2, messageAnswer, message2, "decrypt");

    //Messages that print whether tests were successful or not
    if (failCases == 0) {
      System.out.println("All Tests Passed!");
    } else {
      System.out.println("Number of Failed Test Cases : " + failCases);
    }
  }
}
