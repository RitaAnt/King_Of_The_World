package com.example.kingOfTheWorld.utill;

import com.example.kingOfTheWorld.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CardManager {
    private static CardManager instance;
    private List<Integer> shuffledCards;
    private int currentCardIndex = 0;

    private CardManager() {
        initializeAndShuffleCards();
    }

    public static CardManager getInstance() {
        if (instance == null) {
            instance = new CardManager();
        }
        return instance;
    }

    private void initializeAndShuffleCards() {
        List<Integer> cardImages = Arrays.asList(
                R.drawable.card2,
                R.drawable.card3,
                R.drawable.card4,
                R.drawable.card5,
                R.drawable.card6,
                R.drawable.card7,
                R.drawable.card8,
                R.drawable.card9,
                R.drawable.card10,
                R.drawable.cardj,
                R.drawable.cardq,
                R.drawable.cardk,
                R.drawable.cardt
        );

        shuffledCards = new ArrayList<>();
        shuffledCards.addAll(cardImages);
        shuffledCards.addAll(cardImages);
        shuffledCards.addAll(cardImages);
        shuffledCards.addAll(cardImages);
        Collections.shuffle(shuffledCards);
    }

    public List<Integer> getShuffledCards() {
        return shuffledCards;
    }

    public int getCurrentCardIndex() {
        return currentCardIndex;
    }

    public void incrementCardIndex() {
        currentCardIndex++;
    }

    public void resetGame() {
        currentCardIndex = 0;
        initializeAndShuffleCards();
    }
}
