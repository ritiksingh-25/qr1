package com.example.qrgenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.WriterException;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class MainActivity extends AppCompatActivity {
  EditText grValue;
  Button scanbtn;
  Button generatebtn;
  ImageView img;
  Button ex,cl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        grValue=findViewById(R.id.text);
        scanbtn=findViewById(R.id.scan);
        generatebtn=findViewById(R.id.generate);
        img=findViewById(R.id.imageView);
        cl=findViewById(R.id.clear);
        ex=findViewById(R.id.exit1);

        generatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = grValue.getText().toString();
                QRGEncoder qrgEncoder = new QRGEncoder(data, null, QRGContents.Type.TEXT, 1000);
                Bitmap bits=qrgEncoder.getBitmap();
                img.setImageBitmap(bits);
            }
        });

        scanbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),QR_Scanner.class));
            }
        });
        cl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grValue.setText("");
                img.setImageBitmap(null);
            }
        });
        ex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}