package com.example.android.tipcalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    double disViewValue = 0.15;
    double disView2Value = 0.20;
    double disView3Value = 0.25;
    double priceEditValue = 0.00;
    double tipValue;
    double totalValue = 0.00;

    EditText priceEdit;
    TextView disView;
    TextView disView2;
    TextView disView3;
    TextView totalView;
    EditText tipEdit;
    Button disButton;
    Button disButton2;
    Button disButton3;

    DecimalFormat formatter = new DecimalFormat("###,###,###.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        priceEdit = (EditText) findViewById(R.id.priceEdit);
        tipEdit = (EditText) findViewById(R.id.tipEdit);
        disView = (TextView) findViewById(R.id.disView);
        disView2 = (TextView) findViewById(R.id.disView2);
        disView3 = (TextView) findViewById(R.id.disView3);
        totalView = (TextView) findViewById(R.id.totalView);
        disButton = (Button) findViewById(R.id.disButton);
        disButton2 = (Button) findViewById(R.id.disButton2);
        disButton3 = (Button) findViewById(R.id.disButton3);

        priceEdit.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(7, 2)});
        tipEdit.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(6, 2)});

        //priceEditValue = (Double.valueOf(priceEdit.getText().toString()));
        //DecimalFormat formatter = new DecimalFormat("#,###");
        //String formatDisView = formatter.format(priceEditValue*disViewValue);

        disView.setText(String.format("%.2f", (priceEditValue * disViewValue)));
        disView2.setText(String.format("%.2f", (priceEditValue * disView2Value)));
        disView3.setText(String.format("%.2f", (priceEditValue * disView3Value)));

        priceEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                priceEdit.setHint("");

            }
        });


        priceEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                String priceField = priceEdit.getText().toString().trim();

                if (!priceField.isEmpty()) {


                    priceEditValue = (Double.valueOf(priceEdit.getText().toString()));

                    disView.setText(String.format("%.2f", (priceEditValue * disViewValue)));
                    disView2.setText(String.format("%.2f", (priceEditValue * disView2Value)));
                    disView3.setText(String.format("%.2f", (priceEditValue * disView3Value)));
                } else {
                    priceEditValue = 0;
                    tipEdit.setText("");
                    totalView.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {


            }


        });

        tipEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                totalView.setText(String.format("%.2f",priceEditValue+tipValue));

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                 String tipField = tipEdit.getText().toString().trim();

                if(!tipField.isEmpty()) {
                  tipValue = Double.valueOf(tipEdit.getText().toString());
                  totalView.setText(String.format("%.2f", priceEditValue + tipValue));
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

                //totalView.setText(String.format("%.2f",priceEditValue+tipValue));

            }
        });

        //15% button
        disButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tipEdit.setText(disView.getText().toString());

            }
        });
        //20% button
        disButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tipEdit.setText(disView2.getText().toString());

            }
        });
        //25% button
        disButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tipEdit.setText(disView3.getText().toString());

            }
        });


    }

    public static String removeCommas(String text) {

        text = text.replace(",", "");

        return text;
    }


}

class DecimalDigitsInputFilter implements InputFilter {

    Pattern mPattern;

    public DecimalDigitsInputFilter(int digitsBeforeZero, int digitsAfterZero) {


        mPattern = Pattern.compile("([0-9]{0,3})+" +
                "((\\.[0-9]{0," + (digitsAfterZero - 1) + "})?)||((\\.)?)");

    }

    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {

        Matcher matcher = mPattern.matcher(dest);
        if (!matcher.matches())
            return "";
        return null;
    }

}
