package com.developer.java.fundamentals.accessspecifiers.columbidae.columbinae;

import com.developer.java.fundamentals.accessspecifiers.columbidae.PigeonTalk;

public class Dove extends Zenaida{

    public void twoEggsLaying(){
        System.out.println("As an Dove, I care about overpopulation, so I'm only laying two eggs");
    }

    @Override
    public void shareLivelyChatWith(PigeonTalk pigeonTalk) {
        super.shareLivelyChatWith(this);
        this.twoEggsLaying();
        pigeonTalk.shareLivelyChatWith(this);
    }

}
