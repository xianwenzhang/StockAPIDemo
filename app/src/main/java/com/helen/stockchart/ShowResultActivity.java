package com.helen.stockchart;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class ShowResultActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_result);
        String text = getIntent().getStringExtra("text");
        TextView tv_text = (TextView) findViewById(R.id.tv_text);
        tv_text.setText(text);
        TextView tv_finish = (TextView) findViewById(R.id.tv_finish);
        tv_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
