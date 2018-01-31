package com.example.rahul.scanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ButtonActivity extends AppCompatActivity {
private ZXingScannerView scannerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
    }

    public void scanCoad(View view) {
        scannerView = new ZXingScannerView(this);
        scannerView.setResultHandler(new ZXingScannerView.ResultHandler() {
            @Override
            public void handleResult(Result result) {
                String resultCoad = result.getText();
                Toast.makeText(ButtonActivity.this,resultCoad,Toast.LENGTH_SHORT).show();
                setContentView(R.layout.activity_button);
                scannerView.stopCamera();

            }
        });
        setContentView(scannerView);
        scannerView.startCamera();

    }

    public void onPush(){
        super.onPause();
        scannerView.stopCamera();
    }

}
