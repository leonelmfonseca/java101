package com.developer.java.fundamentals.accessspecifiers.columbidae.columbinae;


import com.developer.java.fundamentals.accessspecifiers.columbidae.PigeonTalk;

public class Phaps implements PigeonTalk {
    void beingWildAsWayOfLife(){
        System.out.println("Us, the Phaps, are born to be wild");
    }

    @Override
    public void shareLivelyChatWith(PigeonTalk pigeonTalk) {
        this.beingWildAsWayOfLife();
        pigeonTalk.shareLivelyChatWith(this);
    }
}
