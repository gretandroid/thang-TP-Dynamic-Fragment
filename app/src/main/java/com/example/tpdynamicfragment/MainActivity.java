package com.example.tpdynamicfragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Communication {

    EditPersonFragment editFragment;
    PersonFragment listFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editFragment = new EditPersonFragment();
        listFragment = new PersonFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frame, listFragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onSend(View source, int selectedIndex) {
        Toast.makeText(this, "Selected index : " + selectedIndex, Toast.LENGTH_SHORT).show();
        if (!editFragment.isVisible()) {
            editFragment.onSend(source, selectedIndex);

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame, editFragment)
                    .addToBackStack(null)
                    .commit();

        }
    }

    @Override
    public void onReceived(View source, int selectedIndex, String nom, String prenom, String date) {
        Toast.makeText(this, "Modified info : " + nom + "," + prenom + "," + date, Toast.LENGTH_SHORT).show();
        if (!listFragment.isVisible()) {
            listFragment.onReceived(source, selectedIndex, nom, prenom, date);

            // replace fragment
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame, listFragment)
                    .addToBackStack(null)
                    .commit();
        }
    }
}