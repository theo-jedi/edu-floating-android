package com.theost.displayapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;
import com.theost.displayapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.showToastButton.setOnClickListener(v -> showToast());
        binding.showSnackbarButton.setOnClickListener(v -> showSnackbar());
        binding.showDialogButton.setOnClickListener(v -> showDialog());
    }

    private void showToast() {
        Toast toast1 = Toast.makeText(this, "My Text", Toast.LENGTH_SHORT);
        Toast toast2 = Toast.makeText(this, R.string.app_name, Toast.LENGTH_SHORT);

        toast1.show();
        toast2.show();
    }

    private void showSnackbar() {
        Snackbar snackbar = Snackbar.make(this, binding.getRoot(),"My Text", Snackbar.LENGTH_INDEFINITE);
        snackbar.setAction("CANCEL", v -> System.out.println("Snackbar - CANCEL"));
        //snackbar.setAnchorView(binding.showToastButton);
        snackbar.show();
    }

    private void showDialog() {
        AlertDialog dialog1 = new AlertDialog.Builder(this)
                .setTitle("My Dialog")
                .setMessage("Rate my app, pleeeease take 5!!")
                .setPositiveButton("YES", (dialogInterface, which) -> System.out.println("Dialog - YES"))
                .setNegativeButton("NO", (dialogInterface, which) -> System.out.println("Dialog - NO"))
                .setIcon(R.drawable.ic_heart)
                .create();

        AlertDialog dialog2 = new AlertDialog.Builder(this)
                .setTitle("Enter password")
                .setView(R.layout.dialog_input)
                .setPositiveButton("OK", (dialogInterface, which) -> System.out.println("Dialog - YES"))
                .setNeutralButton("CANCEL", (dialogInterface, which) -> System.out.println("Dialog - NO"))
                .setIcon(R.drawable.ic_heart)
                .create();

        dialog2.show();
    }

}