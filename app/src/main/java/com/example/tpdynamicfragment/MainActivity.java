package com.example.tpdynamicfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

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
    public void onSelected(View source, int selectedIndex) {
        Toast.makeText(this, "Selected index : " + selectedIndex, Toast.LENGTH_SHORT).show();
        if (!editFragment.isVisible()) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame, editFragment)
                    .addToBackStack(null)
                    .commit();

            if (editFragment instanceof Communication) {
                ((Communication) editFragment).onSelected(source, selectedIndex);
            }
        }
    }
}