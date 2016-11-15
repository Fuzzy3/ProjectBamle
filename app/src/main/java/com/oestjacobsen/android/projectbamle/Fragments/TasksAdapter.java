package com.oestjacobsen.android.projectbamle.Fragments;

import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.oestjacobsen.android.projectbamle.Model.Task;
import com.oestjacobsen.android.projectbamle.R;
import com.oestjacobsen.android.projectbamle.ViewModels.TaskViewModel;
import com.oestjacobsen.android.projectbamle.databinding.TaskItemBinding;

import java.util.List;



public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.ViewHolder> {
    private List<Task> mTasks;
    private Activity mActivity;

    public TasksAdapter(Activity activity, List<Task> tasks) {
        mTasks = tasks;
        mActivity = activity;
    }

    @Override
    public TasksAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        TaskItemBinding binding =
                DataBindingUtil.inflate(inflater, R.layout.task_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(binding);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(TasksAdapter.ViewHolder holder, int position) {
        Task task = mTasks.get(position);
        holder.bindTask(task);
    }

    @Override
    public int getItemCount() {
        return mTasks.size();
    }

    //Holder class
    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TaskItemBinding mBinding;
        private final TaskViewModel mViewModel;
        private Task mTask;

        public ViewHolder(TaskItemBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
            mViewModel = new TaskViewModel(mActivity);
            mBinding.setViewModel(mViewModel);
        }

        public void bindTask(Task task) {
            mTask = task;
            mViewModel.setTask(mTask);
            mBinding.executePendingBindings();
        }

    }
}
