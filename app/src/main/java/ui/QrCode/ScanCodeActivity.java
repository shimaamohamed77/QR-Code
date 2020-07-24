package ui.QrCode;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.google.zxing.Result;

import java.util.HashMap;


public class ScanCodeActivity extends AppCompatActivity
{
    private CodeScanner code_scanner;
    private CodeScannerView scanner_view;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_code);

        initViews();
        getScanner();

    }

    private void initViews()
    {
        scanner_view = findViewById(R.id.code_scanner_view);
    }

    private void getScanner()
    {
        code_scanner = new CodeScanner(getApplicationContext() , scanner_view);
        code_scanner.setDecodeCallback(new DecodeCallback()
        {
            @Override
            public void onDecoded(@NonNull final Result result)
            {
                runOnUiThread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        Intent intent = new Intent(getApplicationContext() , MainActivity.class);
                        intent.putExtra("result" , result.getText());
                        startActivity(intent);
                    }
                });
            }
        });

        scanner_view.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                code_scanner.startPreview();
            }
        });
    }

    @Override
    protected void onStart()
    {
        super.onStart();

        code_scanner.startPreview();
    }

}