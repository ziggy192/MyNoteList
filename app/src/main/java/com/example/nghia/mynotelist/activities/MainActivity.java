package com.example.nghia.mynotelist.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.nghia.mynotelist.R;
import com.example.nghia.mynotelist.models.Note;

public class MainActivity extends AppCompatActivity {

    public static final String POSITION_KEY = "position";
    private static final String TAG = MainActivity.class.toString();
    private ListView lvNotes;
    private Button btnAdd;
    private ArrayAdapter<Note> noteArrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getReferences();
        setupUI();
        addListeners();


    }

    private void addListeners() {
        lvNotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                goToDetail(position);
            }
        });

        lvNotes.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                Note.notes.remove(i);
                noteArrayAdapter.notifyDataSetChanged();
                return true;
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Note.notes.add(new Note());
                goToDetail(Note.notes.size()-1);
            }
        });
    }

    private void goToDetail(int position) {
        Intent intent = new Intent(MainActivity.this, NoteDetailActivity.class);
        intent.putExtra(POSITION_KEY, position);
        startActivity(intent);

    }

    private void setupUI() {
        noteArrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,Note.notes  );
        lvNotes.setAdapter(noteArrayAdapter);
    }

    @Override
    protected void onRestart() {
        Log.d(TAG, "onRestart");
        noteArrayAdapter.notifyDataSetChanged();

        super.onRestart();

    }

    private void getReferences() {
        lvNotes = (ListView) findViewById(R.id.lv_note_names);
        btnAdd = (Button) findViewById(R.id.btn_add);
    }
}
