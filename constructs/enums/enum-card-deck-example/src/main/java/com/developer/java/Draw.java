package com.developer.java;

import jakarta.annotation.Nullable;

import java.util.Set;


public interface Draw {
  @Nullable
  PlayingCard getRandomCard();

  @Nullable PlayingCard getTopCard();

  @Nullable PlayingCard getBottomCard();

  Set<PlayingCard> drawCards(int numberOfCards, DeckDrawPosition position);
}
