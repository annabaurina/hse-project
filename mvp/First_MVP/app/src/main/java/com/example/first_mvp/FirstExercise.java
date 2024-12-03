package com.example.first_mvp;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FirstExercise extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_first_exercise);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button button1 = findViewById(R.id.button4);
        Button button2 = findViewById(R.id.button5);
        Button button3 = findViewById(R.id.button6);
        Button buttonToNextPage = findViewById(R.id.buttonToNextPage);

        button1.setOnClickListener(v -> changeButtonColor((Button) v, "#FCC35454"));
        button2.setOnClickListener(v -> {changeButtonColor((Button) v, "#5AAF4F");
            buttonToNextPage.setVisibility(View.VISIBLE);
        });
        button3.setOnClickListener(v -> changeButtonColor((Button) v, "#FCC35454"));

        buttonToNextPage.setOnClickListener(v -> {
            Intent intent = new Intent(this, SecondExercise.class);
            startActivity(intent);
        });

        ImageButton goBackBtw1 = findViewById(R.id.goBackBtw1);
        goBackBtw1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfoAlert("Вы действительно хотите закрыть тренировку?");
            }
        });

        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                // Показываем окно подтверждения
                showInfoAlert("Вы действительно хотите закрыть тренировку?");
            }
        });

    }

    public void turnBack(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void showInfoAlert(String text) {
        AlertDialog.Builder builder = new AlertDialog.Builder(FirstExercise.this);
        builder.setTitle("Выход из тренировки")
                .setMessage(text)
                .setCancelable(true)
                .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(FirstExercise.this, MainActivity.class);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("Нет", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).show();
    }

    private void changeButtonColor(Button button, String colorHex) {
        button.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(colorHex)));
    }
}