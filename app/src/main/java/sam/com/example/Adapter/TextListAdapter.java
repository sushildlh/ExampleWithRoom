package sam.com.example.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import sam.com.example.R;

public class TextListAdapter extends RecyclerView.Adapter<TextListAdapter.TextViewHolder> {
    
    private Context context;
    private List<Double> resultData;
    
    public TextListAdapter(Context context, List<Double> resultData) {
        this.context = context;
        this.resultData = resultData;
    }
    
    
    @Override
    public TextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_text_item_layout, parent, false);
        TextViewHolder viewHolder = new TextViewHolder(view);
        return viewHolder;
    }
    
    @Override
    public void onBindViewHolder(TextViewHolder holder, int position) {
        holder.mTitle.setText(resultData.get(position) + "");
    }
    
    
    @Override
    public int getItemCount() {
        return resultData.size();
    }
    
    
    public class TextViewHolder extends RecyclerView.ViewHolder {
        
        public TextView mTitle;
        public LinearLayout mLayout;
        
        public TextViewHolder(View view) {
            super(view);
            mTitle = itemView.findViewById(R.id.title);
            mLayout = itemView.findViewById(R.id.layout);
        }
    }
}
