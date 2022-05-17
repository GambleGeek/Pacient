package com.ain_2_20_adis_kerimov.architecture;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

public class AddEditNoteActivity extends AppCompatActivity {
    public static final String EXTRA_ID =
            "com.ain_2_20_adis_kerimov.architecture.EXTRA_ID";
    public static final String EXTRA_NAME =
            "com.ain_2_20_adis_kerimov.architecture.EXTRA_NAME";
    public static final String EXTRA_TEL =
            "com.ain_2_20_adis_kerimov.architecture.EXTRA_TEL";

    public static final String EXTRA_EMAIL =
            "com.ain_2_20_adis_kerimov.architecture.EXTRA_EMAIL";
    public static final String EXTRA_SPEC =
            "com.ain_2_20_adis_kerimov.architecture.EXTRA_PRIORITY";

    private EditText editTextName;
    private EditText editTextTel;
    private EditText editTextEmail;
    private EditText editTextSpec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        editTextName = findViewById(R.id.edit_text_title);
        editTextTel = findViewById(R.id.edit_text_description);
        editTextEmail = findViewById(R.id.edit_text_email);
        editTextSpec = findViewById(R.id.edit_text_spec);


        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);

        Intent intent = getIntent();

        if (intent.hasExtra(EXTRA_ID)){
            setTitle("Edit Note");
            editTextName.setText(intent.getStringExtra(EXTRA_NAME));
            editTextTel.setText(intent.getStringExtra(EXTRA_TEL));
            editTextEmail.setText(intent.getStringExtra(EXTRA_EMAIL));
            editTextSpec.setText(intent.getStringExtra(EXTRA_SPEC));
        }else {
            setTitle("Add Note");
        }
    }

    private void saveNote(){
        String name = editTextName.getText().toString();
        String tel = editTextTel.getText().toString();
        String email = editTextEmail.getText().toString();
        String spec = editTextSpec.getText().toString();

        if (name.trim().isEmpty() || tel.trim().isEmpty()){
            Toast.makeText(this, "Please insert a name and tel", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent data = new Intent();
        data.putExtra(EXTRA_NAME, name);
        data.putExtra(EXTRA_TEL, tel);
        data.putExtra(EXTRA_EMAIL, email);
        data.putExtra(EXTRA_SPEC, spec);

        int id = getIntent().getIntExtra(EXTRA_ID, -1);
        if (id != -1){
            data.putExtra(EXTRA_ID, id);
        }

        setResult(RESULT_OK, data);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_note_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_note:
                saveNote();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}