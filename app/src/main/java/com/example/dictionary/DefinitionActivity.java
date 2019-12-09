package com.example.dictionary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.dictionary.Model.Word;
import com.google.gson.Gson;

public class DefinitionActivity extends AppCompatActivity {

    private TextView word_text;
    private TextView pos_text;
    private TextView definition_text;

    private Word word;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_definition);

        word_text = findViewById(R.id.word_text);
        pos_text = findViewById(R.id.pos_text);
        definition_text = findViewById(R.id.definition_text);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            Gson gson = new Gson();
            String wordAsString = bundle.getString("word");
            word = gson.fromJson(wordAsString, Word.class);
        }

        word_text.setText(word.getWord());
        pos_text.setText(word.getPos());
        definition_text.setText(word.getDefinition());
    }
}
