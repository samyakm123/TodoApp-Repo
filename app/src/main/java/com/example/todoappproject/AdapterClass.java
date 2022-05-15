package com.example.todoappproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todoappproject.DB.AppDatabase;
import com.example.todoappproject.DB.Task;

import org.w3c.dom.Text;

import java.util.List;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.AdapterViewHolder> {

    private Context context;
    public List<Task> data;
    public AdapterClass(Context context){
        this.context = context;
    }

    public void setData(List<Task> data){
        this.data = data;
    }

    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_layout, parent, false);
        return new AdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolder holder, int position) {
        holder.todoTitle.setText(this.data.get(position).title);
        holder.todoDescription.setText(this.data.get(position).description);


    }

    @Override
    public int getItemCount() {
        return this.data.size();
    }

    public class AdapterViewHolder extends RecyclerView.ViewHolder{
        TextView todoTitle;
        TextView todoDescription;
        public AdapterViewHolder(View View) {
            super(View);
            todoTitle = itemView.findViewById(R.id.todoTitle);
            todoDescription = itemView.findViewById(R.id.todoDescription);
        }
    }
}
