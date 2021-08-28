package com.example.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity
{
    // xml items
    EditText etItem;
    Button btnSave;

    /**
     * onCreate
     * initializes the activity
     * sets the results of the intent based on user input
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        // grab view objects from activity_edit by id
        etItem = findViewById(R.id.etItem);
        btnSave = findViewById(R.id.btnSave);

        getSupportActionBar().setTitle("Edit item");

        // get data passed from main activity
        String itemText = getIntent().getStringExtra(MainActivity.KEY_ITEM_TEXT);

        etItem.setText(itemText);

        // when save button is clicked, update changes
        btnSave.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String itemText = etItem.getText().toString();
                int itemPosition = getIntent().getExtras().getInt(MainActivity.KEY_ITEM_POSITION);

                // create an intent which will contain the results
                Intent intent = new Intent();

                // pass the data (results of editing)
                intent.putExtra(MainActivity.KEY_ITEM_TEXT, itemText);
                intent.putExtra(MainActivity.KEY_ITEM_POSITION, itemPosition);

                // set the result of the intent
                setResult(RESULT_OK, intent);

                // finish activity, close the screen and go back
                finish();
            }
        });
    }
}