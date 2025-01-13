package com.developer.java.fundamentals.accessspecifiers.columbidae.gourinae;

import com.developer.java.fundamentals.accessspecifiers.columbidae.PigeonTalk;

public class Goura implements PigeonTalk {

    private void flyingThruNewGuinea(){
        System.out.println("All Gouras enjoy New Guinea views");
    }

    @Override
    public void shareLivelyChatWith(PigeonTalk pigeonTalk) {
        this.flyingThruNewGuinea();
        pigeonTalk.shareLivelyChatWith(this);
    }
}
