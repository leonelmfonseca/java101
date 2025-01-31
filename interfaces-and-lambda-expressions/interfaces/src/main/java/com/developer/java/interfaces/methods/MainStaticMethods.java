package com.developer.java.interfaces.methods;

import static com.developer.java.output.Printing.*;

public class MainStaticMethods {

    public static void main(String[] args) {
        Logger.log("Application started");  // ✅ Call static method directly
        TimeLogger logger = new TimeLogger();
        printOneLine(String.valueOf("Get date from TimeLogger"), logger.getDate());
    }
}
