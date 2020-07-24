package ui.QrCode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        clickButton();
        getViews();

    }

    private void initViews()
    {
        button = findViewById(R.id.btn_scan);
        textView = findViewById(R.id.txt_view);
    }

    private void clickButton()
    {
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(getApplicationContext() , ScanCodeActivity.class));
            }
        });
    }

    private void getViews()
    {
        String intent = getIntent().getStringExtra("result");
        textView.setText(intent);
    }
}