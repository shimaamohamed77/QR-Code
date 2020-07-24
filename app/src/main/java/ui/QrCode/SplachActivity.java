package ui.QrCode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplachActivity extends AppCompatActivity
{
    private Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splach);

        initThread();
    }

    private void initThread()
    {
        thread = new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    sleep(1500);
                    startActivity(new Intent(getApplicationContext() , MainActivity.class));
                    finish();
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }
}