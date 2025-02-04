package exceptions.unchecked;

public class UncheckedExceptions {

  public static void main(String[] args) {
    // This method call, will throw a unmanaged, unchecked exception: 'java.lang.ArithmeticException'
    divideByZero(1, 0);
  }

  private static void divideByZero(int numerator, int denominator) {
    // Unchecked Exceptions represent programming errors or unexpected conditions during runtime
    int result = numerator / denominator;
  }
}
