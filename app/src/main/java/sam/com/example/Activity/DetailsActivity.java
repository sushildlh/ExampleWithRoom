package sam.com.example.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import sam.com.example.Models.ResultData;
import sam.com.example.R;

public class DetailsActivity extends Activity {
    
    private TextView mContent;
    private ArrayList<String> datas = new ArrayList<>();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        
        ResultData data = getIntent().getParcelableExtra("data");
        
        ((TextView) findViewById(R.id.title)).setText(data.getName());
        ((TextView) findViewById(R.id.sub)).setText(data.getTag());
        
        mContent = findViewById(R.id.content);
        
        
        String content = "";
        if (data.getCriteria() != null) {
            for (int i = 0; i < data.getCriteria().size(); i++) {
                String line = "";
                if (i != data.getCriteria().size() - 1)
                    line += data.getCriteria().get(i).getText() + "\n\nand\n\n";
                else {
                    line += data.getCriteria().get(i).getText();
                }
                datas.add(line);
                content += line;
            }
        }
        
        
        Pattern p = Pattern.compile("[$][0-9]+");
        Matcher matcher = p.matcher(content);
        
        SpannableString ss = new SpannableString(content);
        while (matcher.find()) {
            String name = matcher.group();
            ClickableSpan clickableSpan = new ClickableSpan() {
                @Override
                public void onClick(View textView) {
                    int position = 0;
                    for (String s : datas) {
                        if (s.contains(name))
                            startActivity(new Intent(DetailsActivity.this, NextActivity.class).putExtra("data", data.getCriteria().get(position).getVariable()));
                        position++;
                    }
                }
                
                @Override
                public void updateDrawState(TextPaint ds) {
                    super.updateDrawState(ds);
                    ds.setUnderlineText(true);
                }
            };
            ss.setSpan(clickableSpan, matcher.start(), matcher.end(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        
        mContent.setText(ss);
        mContent.setMovementMethod(LinkMovementMethod.getInstance());
        
        
    }
}
