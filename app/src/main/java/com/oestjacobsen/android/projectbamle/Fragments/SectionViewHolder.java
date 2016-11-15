package com.oestjacobsen.android.projectbamle.Fragments;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;

import com.oestjacobsen.android.projectbamle.Model.Task;
import com.oestjacobsen.android.projectbamle.ViewModels.TaskViewModel;
import com.oestjacobsen.android.projectbamle.databinding.TaskItemBinding;


public class SectionViewHolder extends RecyclerView.ViewHolder {
    private final TaskItemBinding mBinding;
    private final TaskViewModel mViewModel;
    private Task mTask;

    public SectionViewHolder(TaskItemBinding binding, Activity activity) {
        super(binding.getRoot());
        mBinding = binding;
        mViewModel = new TaskViewModel(activity);
        mBinding.setViewModel(mViewModel);
    }

    public void bindTask(Task task) {
        mTask = task;
        mViewModel.setTask(mTask);
        mBinding.executePendingBindings();
    }

}
