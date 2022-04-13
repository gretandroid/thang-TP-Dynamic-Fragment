package com.example.tpdynamicfragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tpdynamicfragment.model.Person;

import java.util.List;

public class PersonRecyclerViewAdapter extends RecyclerView.Adapter<PersonRecyclerViewAdapter.PersonViewHolder> {

    List<Person> personList;

    public PersonRecyclerViewAdapter(List<Person> personList) {
        this.personList = personList;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View root = layoutInflater.inflate(R.layout.row, parent, false);

        return new PersonViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {
        holder.nomTextView.setText(personList.get(position).getNom());
        holder.prenomTextView.setText(personList.get(position).getPrenom());
        holder.dateTextView.setText(personList.get(position).getDateNaissance());
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    public class PersonViewHolder extends RecyclerView.ViewHolder {
        final TextView nomTextView;
        final TextView prenomTextView;
        final TextView dateTextView;

        public PersonViewHolder(View root) {
            super(root);
            nomTextView = root.findViewById(R.id.nomTextView);
            prenomTextView = root.findViewById(R.id.prenomTextView);
            dateTextView = root.findViewById(R.id.dateTextView);
        }
    }
}
