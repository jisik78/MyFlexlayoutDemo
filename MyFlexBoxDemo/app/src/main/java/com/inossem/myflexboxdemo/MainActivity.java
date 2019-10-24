package com.inossem.myflexboxdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_1).setOnClickListener(this);
        findViewById(R.id.btn_2).setOnClickListener(this);
        findViewById(R.id.btn_3).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent intent = null;
        switch (v.getId()) {

            case R.id.btn_1:
                intent = new Intent(MainActivity.this, TagViewActivity.class);

                break;

            case R.id.btn_2:
                intent = new Intent(MainActivity.this, AdjustListActivity.class);
                break;

            case R.id.btn_3:
                intent = new Intent(MainActivity.this, NormalLayoutActivity.class);
                break;

        }
        if (intent != null) {
            startActivity(intent);
        }

    }
}
