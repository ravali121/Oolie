package com.example.student.oolie;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.webianks.library.scroll_choice.ScrollChoice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SignupActivity extends AppCompatActivity {

    final Context context = this;
    TextView grad_level;
    Spinner spinner;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> arrayList;
    List<String> x = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        grad_level = (TextView) findViewById(R.id.grad_level);
        grad_level.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                LayoutInflater li = LayoutInflater.from(context);
                View promptView = li.inflate(R.layout.grad_choice, null);
                spinner = (Spinner) promptView.findViewById(R.id.spinner);

                adapter = new ArrayAdapter<String>(SignupActivity.this, android.R.layout.simple_spinner_item,
                        getResources().getStringArray(R.array.grad_levels));
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
                 alertDialogBuilder.setTitle("");
                alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (!spinner.getSelectedItem().toString().equalsIgnoreCase("Graduation Year…")) {
                            grad_level.setText(spinner.getSelectedItem().toString());
                            Toast.makeText(SignupActivity.this,
                                    spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                            dialog.cancel();
                        }
                    }
                });
                alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();

                    }
                });
                alertDialogBuilder.setView(promptView);
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });

    }


}
