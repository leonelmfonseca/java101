package com.developer.java.fundamentals.accessspecifiers.columbidae.columbinae;

import com.developer.java.fundamentals.accessspecifiers.columbidae.PigeonTalk;

public class Zenaida implements PigeonTalk {

    protected void matingThrougoutAmerica(){

        System.out.println("Mr. Zenaida is looking for Ms. Zenaida");
    }


    @Override
    public void shareLivelyChatWith(PigeonTalk pigeonTalk) {
        this.matingThrougoutAmerica();
        pigeonTalk.shareLivelyChatWith(this);
    }

}
