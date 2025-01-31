package com.developer.java.interfaces.multiple;

import static com.developer.java.output.Printing.print;

public class PrinterWithScanner implements Printer , Scanner{

    public static void main(String[] args){
        PrinterWithScanner printer = new PrinterWithScanner();
        printer.scan();
        printer.printDoc("secret document");
    }

    @Override
    public void printDoc(String document) {
        print("As a multifunction printer, I'll use my capabilities to print");
    }

    @Override
    public void scan() {
        print("I want to capture the information on paper and translating it into a digital file that can be stored, edited, or shared on a computer or other devices");
    }

}
