package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtInputName, edtInputWeight, edtInputHeight, edtBMI, edtResult;
    Button btnProcess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        onClick();
    }

    private void addControls() {
        edtInputName = findViewById(R.id.edtInputName);
        edtInputHeight = findViewById(R.id.edtHeight);
        edtInputWeight = findViewById(R.id.edtWeight);
        edtBMI = findViewById(R.id.edtBMI);
        edtResult = findViewById(R.id.edtResult);
        btnProcess = findViewById(R.id.btnBMI);
    }

    private void onClick() {
        btnProcess.setOnClickListener(v->{
            processBMI();
        });

    }

    private void processBMI() {
        try{
            double H=Double.parseDouble(edtInputHeight.getText().toString());
            double W=Double.parseDouble(edtInputWeight.getText().toString());
            double BMI=W/Math.pow(H/100,2);
            if( H > 0 && W > 0) {
                edtBMI.setText(BMI+"");
                if(BMI<18)
                    edtResult.setText(edtInputName.getText().toString() +" à bạn rất gầy, gắng ăn uống nhiều nhé");
                else  if(BMI<=24.9)
                    edtResult.setText("Chúc mừng " + edtInputName.getText().toString() +" thể trạng bạn bình thường");
                else  if(BMI<=29.9)
                    edtResult.setText(edtInputName.getText().toString() +" à bạn béo phì cấp độ 1 rồi đấy, ăn hạn chế lại nhé");
                else if (BMI<=34.9)
                    edtResult.setText(edtInputName.getText().toString() +" à bạn béo phì cấp độ 2 rồi đấy, ăn ít thôi, lo tập thể dục đi");
                else
                    edtResult.setText(edtInputName.getText().toString() +" à bạn béo phì cấp độ 3 rồi đấy, chắc hết nước cứu vãn rồi, huhu bạn sắp đăng xuất rồi đấy");
            } else {
                Toast.makeText(MainActivity.this, "Chiều cao và cân nặng phải > 0", Toast.LENGTH_LONG).show();
            }

        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "Không để trống", Toast.LENGTH_LONG).show();
        }
    }
}