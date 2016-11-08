package com.oestjacobsen.android.projectbamle.Fragments;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.oestjacobsen.android.projectbamle.Model.Note;
import com.oestjacobsen.android.projectbamle.R;

import java.util.List;



public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {
    private List<Note> mNotes;
    private Context mContext;

    public NotesAdapter(Context context, List<Note> notes) {
        mContext = context;
        mNotes = notes;
    }

    public Context getContext() {
        return mContext;
    }

    @Override
    public NotesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View noteView = inflater.inflate(R.layout.note_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(noteView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(NotesAdapter.ViewHolder holder, int position) {
        Note note = mNotes.get(position);

        TextView name = holder.mNoteName;
        name.setText(note.getName());
    }

    @Override
    public int getItemCount() {
        return mNotes.size();
    }



    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView mNoteName;


        public ViewHolder(View itemView) {
            super(itemView);
            mNoteName = (TextView) itemView.findViewById(R.id.note_name);
        }


    }
}
