package com.developer.java.fundamentals.accessspecifiers.columbidae.gourinae;

import com.developer.java.fundamentals.accessspecifiers.columbidae.PigeonTalk;

public class CrownedPigeon extends Goura{

    public void forestForaging(){
        super.shareLivelyChatWith(this);
        System.out.println("Foraging in the forest, makes my crown shinny");
    }

    @Override
    public void shareLivelyChatWith(PigeonTalk pigeonTalk) {
        this.forestForaging();
        pigeonTalk.shareLivelyChatWith(this);
    }
}