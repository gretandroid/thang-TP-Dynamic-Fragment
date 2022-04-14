package com.example.tpdynamicfragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.tpdynamicfragment.model.Person;
import com.example.tpdynamicfragment.model.PersonDao;

public class EditPersonFragment extends Fragment implements Communication {

    int editingPersonIndex = -1;

    // UI refrences
    EditText nomEditText;
    EditText prenomEditText;
    EditText dateEditText;
    Button button;

    // medium
    Communication parentContext;

    public EditPersonFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_edit_person, container, false);
        nomEditText = root.findViewById(R.id.nomEditText);
        prenomEditText = root.findViewById(R.id.prenomEditText);
        dateEditText = root.findViewById(R.id.dateEditText);
        button = root.findViewById(R.id.button);

        // register un listener
        button.setOnClickListener((v) -> {
            onReceived(v,
                    editingPersonIndex,
                    nomEditText.getText().toString(),
                    prenomEditText.getText().toString(),
                    dateEditText.getText().toString());
        });

        return root;
    }

    @Override
    public void onSend(View source, int selectedIndex) {
        editingPersonIndex = selectedIndex;
    }

    @Override
    public void onReceived(View source, int selectedIndex, String nom, String prenom, String date) {
        if (parentContext != null) {
            // update person
            Person editingPerson = PersonDao.getPersons().get(selectedIndex);
            editingPerson.setNom(nom);
            editingPerson.setPrenom(prenom);
            editingPerson.setDateNaissance(date);

            parentContext.onReceived(source, selectedIndex, nom, prenom, date);
            // another moyen to back
//            requireActivity().onBackPressed();
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof Communication) {
            parentContext = (Communication) context;
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        // init UI with value
        Person editingPerson = PersonDao.getPersons().get(editingPersonIndex);
        if (editingPerson != null) {
            nomEditText.setText(editingPerson.getNom());
            prenomEditText.setText(editingPerson.getPrenom());
            dateEditText.setText(editingPerson.getDateNaissance());
        }
    }
}