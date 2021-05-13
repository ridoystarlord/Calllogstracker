package com.ridoy.calllogstracker.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ridoy.calllogstracker.Models.CallLogModel;
import com.ridoy.calllogstracker.R;
import com.ridoy.calllogstracker.databinding.LayoutCallLogBinding;

import java.util.ArrayList;

public class CallLogAdapter extends RecyclerView.Adapter<CallLogAdapter.CallViewHolder> {

    Context context;
    ArrayList<CallLogModel> callLogModelslist;

    public CallLogAdapter(Context context, ArrayList<CallLogModel> callLogModelslist) {
        this.context = context;
        this.callLogModelslist = callLogModelslist;
    }

    @NonNull
    @Override
    public CallViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.layout_call_log, parent, false);
        return new CallViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CallViewHolder holder, int position) {

        CallLogModel currentLog = callLogModelslist.get(position);
        holder.binding.layoutCallLogPhNo.setText(currentLog.getPhNumber());
        holder.binding.layoutCallLogContactName.setText(currentLog.getContactName());
        holder.binding.layoutCallLogType.setText(currentLog.getCallType());
        holder.binding.layoutCallLogDate.setText(currentLog.getCallDate());
        holder.binding.layoutCallLogTime.setText(currentLog.getCallTime());
        holder.binding.layoutCallLogDuration.setText(currentLog.getCallDuration());

    }

    @Override
    public int getItemCount() {
        return callLogModelslist==null ? 0 : callLogModelslist.size();
    }

    public class CallViewHolder extends RecyclerView.ViewHolder {
        LayoutCallLogBinding binding;
        public CallViewHolder(@NonNull View itemView) {
            super(itemView);
            binding=LayoutCallLogBinding.bind(itemView);
        }
    }
}
