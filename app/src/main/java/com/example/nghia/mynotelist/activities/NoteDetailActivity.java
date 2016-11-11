package com.example.nghia.mynotelist.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.nghia.mynotelist.R;
import com.example.nghia.mynotelist.models.Note;

import static com.example.nghia.mynotelist.activities.MainActivity.POSITION_KEY;

public class NoteDetailActivity extends AppCompatActivity {

    private EditText et_detail;
    private Button btn_save;
    private Note currentNote;
    private int notePosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_detail);
        getReferences();
        setupUI();
        addListeners();

    }

    private void setupUI() {
        et_detail.setText(currentNote.getContent());
        et_detail.setSelection(et_detail.getText().length());
    }

    private void addListeners() {
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!et_detail.getText().toString().trim().isEmpty()) {
                    currentNote.setContent(et_detail.getText().toString());
                } else {
                    Note.notes.remove(notePosition);
                }
                finish();
            }
        });
    }

    private void getReferences() {
        et_detail = (EditText) findViewById(R.id.et_detail);
        btn_save = (Button) findViewById(R.id.btn_save);


        Intent intent = getIntent();
        notePosition = intent.getIntExtra(POSITION_KEY, -1);

        if (notePosition != -1) {
            currentNote = Note.notes.get(notePosition);
        }
    }
}
