package com.example.kingOfTheWorld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.kingOfTheWorld.utill.CardManager;

public class DisplayCardActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        setContentView(R.layout.activity_display_card);

        imageView = findViewById(R.id.imageView);
        showNextCard();
    }

    private void showNextCard() {
        CardManager cardManager = CardManager.getInstance();
        if (cardManager.getCurrentCardIndex() < cardManager.getShuffledCards().size()) {
            int currentCard = cardManager.getShuffledCards().get(cardManager.getCurrentCardIndex());
            imageView.setImageResource(currentCard);
            cardManager.incrementCardIndex();
        } else {
            Intent endIntent = new Intent(this, EndActivity.class);
            startActivity(endIntent);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }
    }

    public void onNextButtonClick(View view) {
        CardManager cardManager = CardManager.getInstance();
        if (cardManager.getCurrentCardIndex() < cardManager.getShuffledCards().size()) {
            Animation fadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out);
            imageView.startAnimation(fadeOut);

            int currentCard = cardManager.getShuffledCards().get(cardManager.getCurrentCardIndex());
            imageView.setImageResource(currentCard);
            cardManager.incrementCardIndex();

            Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
            imageView.startAnimation(fadeIn);
        } else {
            Intent endIntent = new Intent(this, EndActivity.class);
            startActivity(endIntent);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }
    }
}
