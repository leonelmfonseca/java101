package com.developer.java.fundamentals.accessspecifiers.columbidae.mediumlargepigeons;

import com.developer.java.fundamentals.accessspecifiers.columbidae.PigeonTalk;

public class RockPigeon implements PigeonTalk {

    void showingOffWingsBlackStripes(){

        System.out.println("Rock Pigeons showing of their wings black stripes");
    }

    @Override
    public void shareLivelyChatWith(PigeonTalk pigeonTalk) {
        this.showingOffWingsBlackStripes();
        pigeonTalk.shareLivelyChatWith(this);
    }
}
