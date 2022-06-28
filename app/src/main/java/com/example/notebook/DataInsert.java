package com.example.notebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.notebook.databinding.DataInsertBinding;

public class DataInsert extends AppCompatActivity {

    DataInsertBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataInsertBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String type = getIntent().getStringExtra("type");
        if (type.equals("update")) {
            setTitle("update");
            binding.titleET.setText(getIntent().getStringExtra("title"));
            binding.textET.setText(getIntent().getStringExtra("text"));
            int id = getIntent().getIntExtra("id",0);
            binding.add.setText("Update note");
              binding.add.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {
                      Intent intent = new Intent();
                      intent.putExtra("Title", binding.titleET.getText().toString());
                      intent.putExtra("Text", binding.textET.getText().toString());
                      intent.putExtra("id",id);
                      setResult(RESULT_OK, intent);
                      finish();
                  }
              });
        } else {
            setTitle("Add Mode");
            binding.add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("Title", binding.titleET.getText().toString());
                    intent.putExtra("Text", binding.textET.getText().toString());
                    setResult(RESULT_OK, intent);
                    finish();
                }
            });
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(DataInsert.this, MainActivity.class));
    }
}