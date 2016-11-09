package com.oestjacobsen.android.projectbamle.Fragments;

import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.oestjacobsen.android.projectbamle.Model.Note;
import com.oestjacobsen.android.projectbamle.R;
import com.oestjacobsen.android.projectbamle.ViewModels.NoteViewModel;
import com.oestjacobsen.android.projectbamle.databinding.NoteItemBinding;

import java.util.List;



public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {
    private List<Note> mNotes;
    private Activity mActivity;

    public NotesAdapter(Activity activity, List<Note> notes) {
        mNotes = notes;
        mActivity = activity;
    }

    @Override
    public NotesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        NoteItemBinding binding =
                DataBindingUtil.inflate(inflater, R.layout.note_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(binding);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(NotesAdapter.ViewHolder holder, int position) {
        Note note = mNotes.get(position);
        holder.bindNote(note);
    }

    @Override
    public int getItemCount() {
        return mNotes.size();
    }

    //Holder class
    public class ViewHolder extends RecyclerView.ViewHolder {
        private final NoteItemBinding mBinding;
        private final NoteViewModel mViewModel;
        private Note mNote;

        public ViewHolder(NoteItemBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
            mViewModel = new NoteViewModel(mActivity);
            mBinding.setViewModel(mViewModel);
        }

        public void bindNote(Note note) {
            mNote = note;
            mViewModel.setNote(mNote);
            mBinding.executePendingBindings();
        }

        public void onClick(View v) {
            Toast.makeText(mBinding.getRoot().getContext(), mNote.getName() + " PRESSED!!", Toast.LENGTH_SHORT).show();
        }

    }
}
