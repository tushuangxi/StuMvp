package com.config.pad.content.ui.crash;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.config.pad.content.R;


public class CrashInfoActivity extends AppCompatActivity {

    private static final String EXTRA_CONTENT = "content";
    TextView textView;

    public static void newInstance(Context context, String content) {
        Intent intent = new Intent(context.getApplicationContext(), CrashInfoActivity.class);
        intent.putExtra(EXTRA_CONTENT, content);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_crash_info);
        textView = findViewById(R.id.textView);
        if (getIntent() != null) {
            String content = getIntent().getStringExtra(EXTRA_CONTENT);
            textView.setText(content);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                goBack();
                break;
            default:
                break;
        }
        return true;
    }

    /**
     * 返回
     */
    private void goBack() {
        finish();
    }

}
