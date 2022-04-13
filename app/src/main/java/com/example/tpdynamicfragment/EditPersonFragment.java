package com.example.tpdynamicfragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.tpdynamicfragment.model.Person;
import com.example.tpdynamicfragment.model.PersonDao;

public class EditPersonFragment extends Fragment implements Communication {

    EditText nomEditText;
    EditText prenomEditText;
    EditText dateEditText;

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
        return root;
    }

    @Override
    public void onSelected(View source, int selectedIndex) {
        Person editingPerson = PersonDao.getPersons().get(selectedIndex);
        nomEditText.setText(editingPerson.getNom());
        prenomEditText.setText(editingPerson.getPrenom());
        dateEditText.setText(editingPerson.getDateNaissance());
    }
}