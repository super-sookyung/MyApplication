package com.example.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

public class AddNoteActivity extends AppCompatActivity {
    public static final String EXTRA_ID =
            "com.codinginflow.architectureexample.EXTRA_ID";
    public static final String EXTRA_TITLE =
            "com.codinginflow.architectureexample.EXTRA_TITLE";
    public static final String EXTRA_DESCRIPTION =
            "com.codinginflow.architectureexample.EXTRA_DESCRIPTION";
//    public static final String EXTRA_PRIORITY =
//            "com.codinginflow.architectureexample.EXTRA_PRIORITY";

    private EditText editTextTitle;
    private EditText editTextDescription;
    private NumberPicker numberPickerPriority;
    private TextView cancel;
    private TextView add_note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        editTextTitle = findViewById(R.id.edit_text_title);
        editTextDescription = findViewById(R.id.edit_text_description);
        final Button mon = (Button)findViewById( R.id.mon );
        final Button tue = (Button)findViewById( R.id.tue );
        final Button wed = (Button)findViewById( R.id.wed );
        final Button thu = (Button)findViewById( R.id.thu );
        final Button fri = (Button)findViewById( R.id.fri );
        final Button sat = (Button)findViewById( R.id.sat );
        final Button sun = (Button)findViewById( R.id.sun );
        cancel = (TextView)findViewById( R.id.cancel_note );
        add_note = (TextView)findViewById( R.id.add_note );


//        numberPickerPriority = findViewById(R.id.number_picker_priority);

//        numberPickerPriority.setMinValue(1);
//        numberPickerPriority.setMaxValue(10);

//        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);

        Intent intent = getIntent();

        if (intent.hasExtra(EXTRA_ID)) {
            setTitle("Edit Note");
            editTextTitle.setText(intent.getStringExtra(EXTRA_TITLE));
            editTextDescription.setText(intent.getStringExtra(EXTRA_DESCRIPTION));
//            numberPickerPriority.setValue(intent.getIntExtra(EXTRA_PRIORITY, 1));
        } else {
            setTitle("Add Note");
        }





        mon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mon.setSelected(true);
            }
        });
        tue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tue.setSelected(true);
            }
        });
        wed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wed.setSelected(true);
            }
        });
        thu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thu.setSelected(true);
            }
        });
        fri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fri.setSelected(true);
            }
        });
        sat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sat.setSelected(true);
            }
        });
        sun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sun.setSelected(true);
            }
        });

        cancel.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddNoteActivity.this, MainActivity.class);
                startActivity(intent);
            }
        } );

        add_note.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNote();
            }
        } );



    }

    private void saveNote() {
        String title = editTextTitle.getText().toString();
        String description = editTextDescription.getText().toString();
//        int priority = numberPickerPriority.getValue();

        if (title.trim().isEmpty() || description.trim().isEmpty()) {
            Toast.makeText(this, "Please insert a title and description", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent data = new Intent();
        data.putExtra(EXTRA_TITLE, title);
        data.putExtra(EXTRA_DESCRIPTION, description);
//        data.putExtra(EXTRA_PRIORITY, priority);

        int id = getIntent().getIntExtra(EXTRA_ID, -1);
        if (id != -1) {
            data.putExtra(EXTRA_ID, id);
        }

        setResult(RESULT_OK, data);
        finish();
    }


//    public boolean onCreate(TextView view){
//        LayoutInflater layoutInflater = getLayoutInflater();
//        View inflate;
//        inflate = (View) layoutInflater.inflate( add_note, view );
//        return true;
//    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater menuInflater = getMenuInflater();
//        menuInflater.inflate(R.menu.add_note_menu, menu);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.save_note:
//                saveNote();
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }

    public void onClick(TextView view){
        TextView add_note = (TextView)findViewById( R.id.add_note );
        TextView btn_cancel= (TextView) findViewById( R.id.cancel_note ) ;
        add_note.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNote();
            }
        });
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddNoteActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }

//    @Override
//    public void onClick(TextView view) {
//        TextView btn_cancel= (TextView) findViewById( R.id.cancel_note ) ;
//        btn_cancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(AddNoteActivity.this, MainActivity.class);
//                startActivity(intent);
//
//            }
//        });
//    }

}

