package com.developer.java;

import java.util.Set;
import org.jetbrains.annotations.Nullable;

public interface Draw {
  @Nullable PlayingCard getRandomCard();

  @Nullable PlayingCard getTopCard();

  @Nullable PlayingCard getBottomCard();

  Set<PlayingCard> drawCards(int numberOfCards, DeckDrawPosition position);
}
