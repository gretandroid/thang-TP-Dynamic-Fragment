package com.example.tpdynamicfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


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
}