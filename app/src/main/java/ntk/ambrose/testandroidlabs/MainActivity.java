package ntk.ambrose.testandroidlabs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Button> buttonNums;
    int[] listNumID={
            R.id.bt0,
            R.id.bt1,
            R.id.bt2,
            R.id.bt3,
            R.id.bt4,
            R.id.bt5,
            R.id.bt6,
            R.id.bt7,
            R.id.bt8,
            R.id.bt9,
    };
    Button btAdd;
    Button btSub;
    Button btMul;
    Button btDiv;
    Button btFloat;
    Button btMAdd;
    Button btMSub;
    Button btMC;
    Button btAns;
    Button btDel;

    TextView tvResult;

    View.OnClickListener clickOnNumber;
    View.OnClickListener clickOperator;

    String currentOperator="";

    double result=0;
    double previousValue=0;
    boolean hasOperator=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult=findViewById(R.id.tvResult);

        setupButton();
        setupEvent();

        tvResult.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.toString().contains("."))
                    btFloat.setEnabled(false);
                else
                    btFloat.setEnabled(true);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        btFloat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResult.setText(tvResult.getText().toString()+".");
            }
        });

        btDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResult.setText("");
                result = 0;
                previousValue = 0;
            }
        });

        btAns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResult.setText(String.valueOf(result));
            }
        });

    }

    public void setupButton(){
        buttonNums=new ArrayList<>();
        for(int id :listNumID){
            buttonNums.add((Button)findViewById(id));

        }
        btAdd=findViewById(R.id.btAdd);
        btSub=findViewById(R.id.btSub);
        btMul=findViewById(R.id.btMul);
        btDiv=findViewById(R.id.btDiv);
        btMAdd=findViewById(R.id.btMAdd);
        btMSub=findViewById(R.id.btMSub);
        btMC=findViewById(R.id.btMC);
        btFloat=findViewById(R.id.btFloat);
        btAns=findViewById(R.id.btAns);
        btDel=findViewById(R.id.btDel);
    }

    public void setupEvent(){
        clickOnNumber=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResult.setText(tvResult.getText().toString()+ ((Button)view).getText().toString());
                hasOperator=false;
            }
        };

        clickOperator=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if(currentOperator.equals("")){
                        currentOperator = ((Button)view).getText().toString();
                        hasOperator=true;
                        previousValue=Double.parseDouble(tvResult.getText().toString());
                        tvResult.setText("");
                    }
                    else{
                        if(hasOperator) {
                            currentOperator = ((Button) view).getText().toString();
                        }
                        else{
                            double currentValue = Double.parseDouble(tvResult.getText().toString());
                            switch (currentOperator) {
                                case "+":
                                    result = previousValue + currentValue;
                                    break;
                                case "-":
                                    result = previousValue - currentValue;
                                    break;
                                case "*":
                                    result = previousValue * currentValue;
                                    break;
                                case "/":
                                    result = previousValue / currentValue;
                                    break;
                            }
                            previousValue=result;
                            tvResult.setText(String.valueOf(result));
                            currentOperator="";
                            hasOperator=false;
                        }
                    }
                }
                catch(Exception ex){
                    Toast.makeText(getBaseContext(),ex.getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        };

        for(Button button:buttonNums){
            button.setOnClickListener(clickOnNumber);
        }
        btAdd.setOnClickListener(clickOperator);
        btSub.setOnClickListener(clickOperator);
        btMul.setOnClickListener(clickOperator);
        btDiv.setOnClickListener(clickOperator);

    }
}
