package com.developer.java.fundamentals.accessspecifiers.columbidae.columbinae;

import com.developer.java.fundamentals.accessspecifiers.columbidae.PigeonTalk;

public class FlockBronzewingPigeon extends Phaps implements PigeonTalk {


  void survivingAustralianOutback() {
    System.out.println("Only the Flock Bronzewing can survive the Bush");
  }


  @Override
  public void shareLivelyChatWith(PigeonTalk pigeonTalk) {
    super.shareLivelyChatWith(this);
    this.survivingAustralianOutback();
    pigeonTalk.shareLivelyChatWith(this);
  }
}
