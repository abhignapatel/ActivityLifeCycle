package com.jaydonga.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

public class BarCodeScanner extends AppCompatActivity {

    Button button;
    TextView textView;
    ImageView imageView;
    Bitmap bitmap;
    BarcodeDetector barcodeDetector;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_code_scanner);

        button = findViewById(R.id.scancode);
        textView = findViewById(R.id.scanResult);
        imageView = findViewById(R.id.scanImage);

        bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.qrcode);
        imageView.setImageBitmap(bitmap);

        barcodeDetector = new BarcodeDetector.Builder(this)
            .setBarcodeFormats(Barcode.QR_CODE)
            .build();

        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {

                Frame frame = new Frame.Builder().setBitmap(bitmap).build();
                SparseArray<Barcode> barcodes = barcodeDetector.detect(frame);

                // Check if at least one barcode was detected
                if (barcodes.size() > 0) {
                    // Display the QR code's message
                    textView.setText("QR CODE Data: " + barcodes.valueAt(0).displayValue);
                    //Display QR code image to ImageView
                } else {
                    textView.setText("No QR Code found!");
                    textView.setTextColor(Color.RED);
                }
            }
        });

    }
}
