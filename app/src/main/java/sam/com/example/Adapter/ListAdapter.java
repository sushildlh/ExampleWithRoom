package sam.com.example.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;
import sam.com.example.Activity.DetailsActivity;
import sam.com.example.Models.ResultData;
import sam.com.example.R;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    
    private Context context;
    private ArrayList<ResultData> resultData;
    
    public ListAdapter(Context context, ArrayList<ResultData> resultData) {
        this.context = context;
        this.resultData = resultData;
    }
    
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item_layout, parent, false);
        
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }
    
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ResultData data = resultData.get(position);
        holder.mTitle.setText("\u2022 " + data.getName());
        holder.mSubTitle.setText(data.getTag());
        holder.mLayout.setOnClickListener(view -> callAnotherActivity(data));
        
    }
    
    private void callAnotherActivity(ResultData data) {
        context.startActivity(new Intent(context, DetailsActivity.class).putExtra("data", (Parcelable) data));
    }
    
    @Override
    public int getItemCount() {
        return resultData.size();
    }
    
    
    public class ViewHolder extends RecyclerView.ViewHolder {
        
        public TextView mTitle;
        public TextView mSubTitle;
        public LinearLayout mLayout;
        
        public ViewHolder(View view) {
            super(view);
            mTitle = itemView.findViewById(R.id.title);
            mSubTitle = itemView.findViewById(R.id.sub);
            mLayout = itemView.findViewById(R.id.layout);
        }
    }
}
