package exceptions.checked.custom;

public class CheckedCustomException {


  // VotingAgeException is declared in the method signature, which means that any code that calls this method
  // must either handle the VotingAgeException or also declare it in its own method signature.
  public static void main(String[] args) throws VotingAgeException {
    try {
      validateVoterAge(15);
    } catch (VotingAgeException e) {
       /*
         In Java, exceptions are designed to "bubble up" the call stack if not caught and handled within the method where they occurred.
         For instance, consider the validateVoterAge method, if this method throws an exception and does not catch it,
         the exception will propagate up to the next method that called validateVoterAge.

         If no such handler exists anywhere in the call stack, the application will halt abruptly,
         producing an error message indicating an unhandled exception.
       */
      System.out.println(e.getMessage());
    }
  }

  public static void validateVoterAge(int age) throws VotingAgeException {
    if (age < 18) {
      throw new VotingAgeException("Person must be 18 or older to vote.");
    }
  }
}
