package com.developer.java.interfaces.conversion;

import com.developer.java.interfaces.NumberSequence;
import com.developer.java.interfaces.Sequence;
import com.developer.java.interfaces.SquareSequence;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InstanceOfPatternMatching {
    private static final List<Sequence> sequenceList =
            new ArrayList<>(Arrays.asList(new SquareSequence(), new NumberSequence(654363)));

    public static void main(String[] args){
        for (Sequence sequence : sequenceList){

            /*
            In this example, the numbers variable contains the sequence reference, cast as a NumberSequence.
            If sequence is not an instance of NumberSequence, no variable is declared, and the if body is not executed.
            On the other hand if instance is int fact a NumberInstance we can use the variable immediately.
             */
            if (sequence instanceof NumberSequence numbers && numbers.hasNext()){
                numbers.printCurrentNumber();
            }
        }
    }
}
