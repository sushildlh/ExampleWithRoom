package sam.com.example.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import sam.com.example.Adapter.TextListAdapter;
import sam.com.example.Models.Dollar;
import sam.com.example.R;

public class NextActivity extends Activity {
    
    private LinearLayout mLayout;
    private RecyclerView mList;
    private EditText mEdit;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        
        mLayout = findViewById(R.id.layout);
        mList = findViewById(R.id.list);
        mEdit = findViewById(R.id.edit);
        
        Dollar variable = getIntent().getParcelableExtra("data");
        fillData(variable);
        
    }
    
    private void fillData(Dollar d1) {
        if (d1.getType().equals("indicator")) {
            mList.setVisibility(View.GONE);
            mLayout.setVisibility(View.VISIBLE);
            mEdit.setText(d1.getDefaultValue() + "");
        } else {
            mLayout.setVisibility(View.GONE);
            mList.setVisibility(View.VISIBLE);
            mList.setLayoutManager(new LinearLayoutManager(this));
            mList.setAdapter(new TextListAdapter(this, d1.getValues()));
        }
    }
}
