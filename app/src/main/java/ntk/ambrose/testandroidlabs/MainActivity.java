package ntk.ambrose.testandroidlabs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etNum1;
    EditText etNum2;
    Spinner spinOp;
    Button btCalc;
    TextView tvResult;
    String[] opratorList={"+","-","*","/"};
    int selection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNum1=(EditText)findViewById(R.id.etNumber1);
        etNum2=(EditText)findViewById(R.id.etNumber2);
        spinOp=(Spinner)findViewById(R.id.spinOp);
        btCalc=(Button)findViewById(R.id.btCalc);
        tvResult=(TextView)findViewById(R.id.tvResult);
        setupSpinner(spinOp);
        btCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selection==-1){
                    Toast.makeText(getBaseContext(),"Please select operator",Toast.LENGTH_SHORT).show();
                }
                else{
                    try {
                        double num1 = Double.parseDouble(etNum1.getText().toString());
                        double num2 = Double.parseDouble(etNum2.getText().toString());
                        double result = 0;
                        switch (opratorList[selection]) {
                            case "+":
                                result = num1 + num2;
                                break;
                            case "-":
                                result = num1 - num2;
                                break;
                            case "*":
                                result = num1 * num2;
                                break;
                            case "/":
                                result = num1 / num2;
                                break;

                        }
                        tvResult.setText("Result = "+ result);
                    }
                    catch(Exception ex){
                        Toast.makeText(getBaseContext(),ex.getMessage(),Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

    }

    public void setupSpinner(Spinner spinner){
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,opratorList);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selection =i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                selection=-1;
            }
        });
    }
}
