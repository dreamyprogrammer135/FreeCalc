package com.dreamyprogrammer.freecalc;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;


public class MainActivity extends AppCompatActivity {

    private TextView historyText, totalText;
    private String expressionFinal;
    private StringBuilder expression = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
    }

    private void findView() {
        initButton();
        historyText = findViewById(R.id.et_not_modify);
        totalText = findViewById(R.id.et_modify);
    }

    private void initButton() {
        findViewById(R.id.button_1).setOnClickListener(view -> {
            historyText.setText(historyText.getText().toString() + getString(R.string._1));
        });

        findViewById(R.id.button_2).setOnClickListener(view -> {
            historyText.setText(historyText.getText().toString() + getString(R.string._2));
        });
        findViewById(R.id.button_3).setOnClickListener(view -> {
            historyText.setText(historyText.getText().toString() + getString(R.string._3));
        });
        findViewById(R.id.button_4).setOnClickListener(view -> {
            historyText.setText(historyText.getText().toString() + getString(R.string._4));
        });
        findViewById(R.id.button_5).setOnClickListener(view -> {
            historyText.setText(historyText.getText().toString() + getString(R.string._5));
        });
        findViewById(R.id.button_6).setOnClickListener(view -> {
            historyText.setText(historyText.getText().toString() + getString(R.string._6));
        });
        findViewById(R.id.button_7).setOnClickListener(view -> {
            historyText.setText(historyText.getText().toString() + getString(R.string._7));
        });
        findViewById(R.id.button_8).setOnClickListener(view -> {
            historyText.setText(historyText.getText().toString() + getString(R.string._8));
        });
        findViewById(R.id.button_9).setOnClickListener(view -> {
            historyText.setText(historyText.getText().toString() + getString(R.string._9));
        });
        findViewById(R.id.button_0).setOnClickListener(view -> {
            historyText.setText(historyText.getText().toString() + getString(R.string._0));
        });
        findViewById(R.id.button_separator).setOnClickListener(view -> {
            historyText.setText(historyText.getText().toString() + getString(R.string.coma));
        });
        findViewById(R.id.button_plus).setOnClickListener(view -> {
            historyText.setText(historyText.getText().toString() + getString(R.string.plus));
        });
        findViewById(R.id.button_minus).setOnClickListener(view -> {
            historyText.setText(historyText.getText().toString() + getString(R.string.minus));
        });
        findViewById(R.id.button_total).setOnClickListener(view -> {
            expressionFinal = historyText.getText().toString();
            expressionFinal = expressionFinal.replaceAll("%", "/100");
            Context rhino = Context.enter();
            rhino.setOptimizationLevel(-1);
            try {
                Scriptable scriptable = rhino.initStandardObjects();
                totalText.setText(rhino.evaluateString(scriptable, expressionFinal, "javascript", 1, null).toString());
            } catch (Exception e) {
                totalText.setText(R.string.Error);
            }
        });

        findViewById(R.id.button_multiplication).setOnClickListener(view -> {
            historyText.setText(historyText.getText().toString() + getString(R.string.multiplication));
        });
        findViewById(R.id.button_division).setOnClickListener(view -> {
            historyText.setText(historyText.getText().toString() + getString(R.string.division));
        });
        findViewById(R.id.button_parenthesis_right).setOnClickListener(view -> {
            historyText.setText(historyText.getText().toString() + getString(R.string.parenthesis_right));
        });
        findViewById(R.id.button_parenthesis_left).setOnClickListener(view -> {
            historyText.setText(historyText.getText().toString() + getString(R.string.parenthesis_left));
        });
        findViewById(R.id.button_percent).setOnClickListener(view -> {
            historyText.setText(historyText.getText().toString() + getString(R.string.percent));
        });
        findViewById(R.id.button_clean_entry).setOnClickListener(view -> {
            expression.append(historyText.getText().toString());
            if (expression.length() > 0) {
                expression.delete(expression.length() - 1, expression.length());
                historyText.setText(expression);
                expression.delete(0, expression.length());
            }
        });
        findViewById(R.id.button_clean).setOnClickListener(view -> {
            historyText.setText("");
        });
        findViewById(R.id.button_history).setOnClickListener(view -> {
            //TODO Наверное показать историю
        });
        findViewById(R.id.button_settings).setOnClickListener(view -> {
            //TODO открыть настройки
        });


    }

}