package exceptions.checked;

import java.io.*;

public class FileNotFoundException {

  private static final String FILE_PATH_NAME = "checked-exceptions.txt";

  // Checked exceptions are checked at compile-time by the Java compiler.
  // This means that the compiler ensures that these exceptions are either caught or declared in
  // the method signature using the throws keyword.
  public static void main(String[] args) throws IOException {

    System.out.println(readFromInputStream());
  }

  private static String readFromInputStream() throws IOException {

    InputStream stream =
        FileNotFoundException.class.getClassLoader().getResourceAsStream(FILE_PATH_NAME);

    StringBuilder resultStringBuilder = new StringBuilder();


    // Unchecked: not checked at compile-time, means that the compiler does not enforce handling of unchecked exceptions.
    // In below code, if stream variable is 'null', an unchecked 'NullPointerException' will be thrown
    try (BufferedReader br = new BufferedReader(new InputStreamReader(stream))) {
        String line;
        while ((line = br.readLine()) != null) {
          resultStringBuilder.append(line).append("\n");
        }
    }
    return resultStringBuilder.toString();
  }
}
