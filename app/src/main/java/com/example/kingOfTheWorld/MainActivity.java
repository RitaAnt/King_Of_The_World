package com.example.kingOfTheWorld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.ActionBar;

import com.example.kingOfTheWorld.utill.CardManager;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        setContentView(R.layout.activity_start);
    }

    public void onStartButtonClick(View view) {
        CardManager cardManager = CardManager.getInstance();
        cardManager.resetGame();

        List<Integer> shuffledCards = cardManager.getShuffledCards();
        int currentCardIndex = cardManager.getCurrentCardIndex();

        if (currentCardIndex < shuffledCards.size()) {
            Intent intent = new Intent(this, DisplayCardActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }
    }

}
