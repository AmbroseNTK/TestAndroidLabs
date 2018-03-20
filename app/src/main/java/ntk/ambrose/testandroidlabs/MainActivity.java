package ntk.ambrose.testandroidlabs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
    Button btBackspace;
    Button btNeg;

    TextView tvResult;
    TextView tvPreNum;
    TextView tvOperator;

    View.OnClickListener clickOnNumber;
    View.OnClickListener clickOperator;

    String currentOperator="";
    String preOperator="";
    double result=0;
    double previousValue=0;
    int operandOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult=findViewById(R.id.tvResult);
        tvPreNum=findViewById(R.id.tvPreNum);
        tvOperator=findViewById(R.id.tvOperator);

        operandOrder=0;

        setupButton();
        setupEvent();



        btFloat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResult.setText(tvResult.getText().toString()+".");
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
        btNeg=findViewById(R.id.btNeg);
        btBackspace=findViewById(R.id.btBackspace);

    }

    public void setupEvent(){
        clickOnNumber=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResult.setText(tvResult.getText().toString()+ ((Button)view).getText().toString());

            }
        };

        clickOperator=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    currentOperator=((Button)view).getText().toString();
                    tvOperator.setText(currentOperator);
                   if(operandOrder==0){
                       previousValue = Double.parseDouble(tvResult.getText().toString());
                       operandOrder++;
                       tvPreNum.setText(String.valueOf(previousValue));
                       tvResult.setText("");
                   }
                   else if(operandOrder==1){

                       switch (preOperator){
                           case "+":
                               result = previousValue + Double.parseDouble(tvResult.getText().toString());
                               break;
                           case "-":
                               result = previousValue - Double.parseDouble(tvResult.getText().toString());
                               break;
                           case "*":
                               result = previousValue * Double.parseDouble(tvResult.getText().toString());
                               break;
                           case "/":
                               result = previousValue / Double.parseDouble(tvResult.getText().toString());
                               break;
                       }
                       tvPreNum.setText(String.valueOf(result));
                       tvResult.setText("");
                       operandOrder=0;
                   }
                   preOperator=currentOperator;
                }
                catch(Exception ex){
                    previousValue=0;
                    currentOperator="";
                    preOperator="";
                    result=0;
                    tvResult.setText("");
                    tvPreNum.setText("");
                    tvOperator.setText("");
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

        btAns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (currentOperator){
                    case "+":
                        result = previousValue + Double.parseDouble(tvResult.getText().toString());
                        break;
                    case "-":
                        result = previousValue - Double.parseDouble(tvResult.getText().toString());
                        break;
                    case "*":
                        result = previousValue * Double.parseDouble(tvResult.getText().toString());
                        break;
                    case "/":
                        result = previousValue / Double.parseDouble(tvResult.getText().toString());
                        break;
                }
                operandOrder=0;
                tvResult.setText(String.valueOf(result));
                tvPreNum.setText(tvResult.getText());
                tvOperator.setText("");
                previousValue=result;
            }
        });
        btDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                previousValue=0;
                currentOperator="";
                preOperator="";
                result=0;
                tvResult.setText("");
                tvPreNum.setText("");
                tvOperator.setText("");
            }
        });
        btNeg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tvResult.getText().toString().equals("")) {
                    tvResult.setText("-");
                } else {
                    tvResult.setText("-" + tvResult.getText().toString());
                }
            }
        });
        btBackspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!tvResult.getText().toString().equals("")) {
                    tvResult.setText(tvResult.getText().toString().substring(0,tvResult.getText().toString().length()-1));
                }
            }
        });
    }
}
