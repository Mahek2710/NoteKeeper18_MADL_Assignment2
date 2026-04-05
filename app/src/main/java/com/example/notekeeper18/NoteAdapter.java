package com.example.notekeeper18;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {

    List<String> notes;

    public NoteAdapter(List<String> notes) {
        this.notes = notes;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;

        public ViewHolder(View view) {
            super(view);
            title = view.findViewById(android.R.id.text1);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(android.R.layout.simple_list_item_1, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText(notes.get(position));
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }
}