package com.example.auburnhacks;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CompaniesAdapter extends RecyclerView.Adapter<CompaniesAdapter.CompaniesViewHolder>{

    private Context context;
    private List<Companies> cList;

    public CompaniesAdapter(Context context, List<Companies> cList) {
        this.context = context;
        this.cList = cList;
    }

    @NonNull
    @Override
    public CompaniesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.list_layout,null);
        CompaniesViewHolder holder = new CompaniesViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CompaniesViewHolder holder, int position) {
        Companies company = cList.get(position);
        holder.textViewCName.setText(company.getCompName());
        holder.textViewJobType.setText(company.getJobType());
        holder.textViewJobLoc.setText(company.getLocation());
        holder.textViewWorkAuth.setText(company.getWorkAuth());
    }

    @Override
    public int getItemCount() {
        return cList.size();
    }

    class CompaniesViewHolder extends RecyclerView.ViewHolder{

        TextView textViewCName, textViewJobType, textViewJobLoc, textViewWorkAuth;

        public CompaniesViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewCName = (TextView) itemView.findViewById(R.id.compNameLL);
            textViewJobType = (TextView)itemView.findViewById(R.id.jobTypeLL);
            textViewJobLoc = (TextView) itemView.findViewById(R.id.jobLocLL);
            textViewWorkAuth = (TextView)itemView.findViewById(R.id.workAuthLL);
        }
    }

}
