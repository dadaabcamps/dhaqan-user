package com.drcdadaab.dhaqanuser;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    TextView textViewDhaqanTitle, textViewDhaqanContent, textViewDhaqanAuthor;
    String recievedTitle, recievedContent, recievedAuthor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        textViewDhaqanTitle=(TextView) findViewById(R.id.textViewDhaqanTitle);
        textViewDhaqanContent=(TextView) findViewById(R.id.textViewDhaqanContent);
        textViewDhaqanAuthor=(TextView) findViewById(R.id.textViewDhaqanAuthor);

        Intent i =getIntent();
        recievedTitle=i.getStringExtra("titleKey");
        recievedContent=i.getStringExtra("contentKey");
        recievedAuthor=i.getStringExtra("authorKey");

        textViewDhaqanTitle.setText(recievedTitle);
        textViewDhaqanContent.setText(recievedContent);
        textViewDhaqanAuthor.setText(recievedAuthor);

        getSupportActionBar().setTitle(recievedTitle);
    }

}
