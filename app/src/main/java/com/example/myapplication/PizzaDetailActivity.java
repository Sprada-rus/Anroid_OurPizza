package com.example.myapplication;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

public class PizzaDetailActivity extends AppCompatActivity {

    public static String EXTRA_PIZZA_ID = "pizzaId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        ActionBar bar = getSupportActionBar();
        bar.setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        int pizzaId = (Integer) intent.getExtras().getInt(EXTRA_PIZZA_ID, 0);
        String name = Pizza.pizzas[pizzaId].getName();
        TextView textView = (TextView) findViewById(R.id.text_detail);
        textView.setText(name);

        int img = Pizza.pizzas[pizzaId].getImgId();
        ImageView imageView = (ImageView) findViewById(R.id.img_detail);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, img));
        imageView.setContentDescription(name);
    }
}