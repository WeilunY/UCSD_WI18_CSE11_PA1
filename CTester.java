public class CTester {

  /**
   * Check the test case to see if it's correct
   * @param testName The name of the unit test being evaluated.
   * @param message The message to encrypt or decrypt
   * @param expectedAnswer The answer expected
   * @param actualAnswer The actual answer produced
   * @param enc_or_dec A string specifying what function was tested.
   * @return 1 if the test failed, and 0 otherwise.
   */
  public static int testCase(String testName,
      String message, String expectedAnswer,
      String actualAnswer, String enc_or_dec) {
    if (!expectedAnswer.equals(actualAnswer)) {
      System.out.println("Test [" + testName + "] FAILED (" +
          enc_or_dec + ")");
      System.out.println("  Given message to " + enc_or_dec + " is: "
          + message);
      System.out.println("  Your Answer is: " + actualAnswer);
      System.out.println("  The correct answer is: " + expectedAnswer + "\n");
      return 1;
    } else {
      System.out.println("Test [" + testName + "] Passed!\n");
      return 0;
    }
  }

  // Given a non-empty plain message,
  // When we encrypt the message with a very small rotation,
  // Then we get the expected code
  public static int testEncryptWithSmallPositiveRotation() {
    // Input
    String message1 = "menu";

    // Do the test
    String encrypted1 = Caesar.encryptStr(message1, 2);

    // Validate
    String encryptedAnswer = "ogpw";
    return testCase("EncryptWithSmallPositiveRotation",
                    message1, encryptedAnswer, encrypted1, "encrypt");
  }

  // Given an encrypted message,
  // When we decrypt the message with a very small rotation,
  // Then we get back the original message
  public static int testDecryptWithSmallPositiveRotation() {
    String encrypted2 = "ogpw";
    String messageAnswer = "menu";
    String message2 = Caesar.decryptStr(encrypted2, 2);

    return testCase("DecryptWithSmallPositiveRotation",
                    encrypted2, messageAnswer, message2, "decrypt");
  }

  // Given an non empty plain message,
  // When we encrypt the message with a very large rotation,
  // Then we get the expected code
  public static int testEncryptWithLargePositiveRotation(){
    String message3 = "menu";
    String encrypted3 = Caesar.encryptStr(message3, 132);
    String encryptedAnswer3 = "ogpw";
    return testCase("testEncryptWithLargePositiveRotation",
                    message3, encryptedAnswer3, encrypted3, "encrypt");
  }

  // Given an encrypted message,
  // When we decrypt the message with a very large rotation,
  // Then we get back the original message
  public static int testDecryptWithLargePositiveRotation() {
    String encrypted4 = "ogpw";
    String messageAnswer4 = "menu";
    String message4 = Caesar.decryptStr(encrypted4, 132);

    return testCase("DecryptWithLargePositiveRotation",
                    encrypted4, messageAnswer4, message4, "decrypt");
  }

  // Given a non-empty plain message,
  // When we encrypt the message with a very small negative rotation,
  // Then we get the expected code
  public static int testEncryptWithSmallNegativeRotation() {
    // Input
    String message5 = "menu";

    // Do the test
    String encrypted5 = Caesar.encryptStr(message5, -24);

    // Validate
    String encryptedAnswer5 = "ogpw";
    return testCase("EncryptWithSmallNegativeRotation",
                    message5, encryptedAnswer5, encrypted5, "encrypt");
  }

  // Given an encrypted message,
  // When we decrypt the message with a very small negative rotation,
  // Then we get back the original message
  public static int testDecryptWithSmallNegativeRotation() {
    String encrypted6 = "ogpw";
    String messageAnswer6 = "menu";
    String message6 = Caesar.decryptStr(encrypted6, -24);

    return testCase("DecryptWithSmallNegativeRotation",
                    encrypted6, messageAnswer6, message6, "decrypt");
  }

  // Given an non empty plain message,
  // When we encrypt the message with a very large negative rotation,
  // Then we get the expected code
  public static int testEncryptWithLargeNegativeRotation(){
    // Input
    String message7 = "menu";

    // Test
    String encrypted7 = Caesar.encryptStr(message7, -154);

    // Validate
    String encryptedAnswer7 = "ogpw";
    return testCase("EncryptWithLargeNegativeRotation",
                    message7, encryptedAnswer7, encrypted7, "encrypt");
  }

  // Given an encrypted message,
  // When we decrypt the message with a very large negative rotation,
  // Then we get back the original message
  public static int testDecryptWithLargeNegativeRotation() {
    String encrypted8 = "ogpw";
    String messageAnswer8 = "menu";
    String message8 = Caesar.decryptStr(encrypted8, -154);

    return testCase("DecryptWithLargeNegativeRotation",
                    encrypted8, messageAnswer8, message8, "decrypt");
  }


  /**
   * The main method to test the Caesar class.
   * @param args Unused
   */
  public static void main (String[] args) {
    System.out.println("Part2Tester");
    System.out.println("===============================================================");
    /** The main method. THIS IS WHERE YOU SHOULD ADD TESTS TO FIND
     * THE ERRORS IN CeasarWithBugs.  We have a few tests, but they
     * do not expose the errors.
     **/

    //The Caesar Cipher With Bugs Tests
    int failCases = 0;

    failCases += testEncryptWithSmallPositiveRotation();
    failCases += testDecryptWithSmallPositiveRotation();
    failCases += testEncryptWithLargePositiveRotation();
    failCases += testDecryptWithLargePositiveRotation();
    failCases += testEncryptWithSmallNegativeRotation();
    failCases += testDecryptWithSmallNegativeRotation();
    failCases += testEncryptWithLargeNegativeRotation();
    failCases += testDecryptWithLargeNegativeRotation();


    // TODO Add your tests here.  Some ideas: negative numbers,
    // non-numeric characters, large values for rotation, etc.
    // (There are more things to test.)


    //Messages that print whether tests were successful or not
    if (failCases == 0) {
      System.out.println("ALL Tests Passed! :D");
    } else {
      System.out.println("Some tests failed! :( Number of Failed Test Cases : " + failCases);
    }
  }
}
