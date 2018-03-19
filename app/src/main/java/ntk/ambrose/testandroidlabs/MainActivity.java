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

public class MainActivity extends AppCompatActivity {
    EditText N1,N2;
    Button BT;
    TextView KQ;
    Spinner Spin;
    String Arr[] ={"+","-","*","/"};
    int vitri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        TaoSpin();
        BT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KQ.setText(String.valueOf(Tinh()));
            }
        });
    }
    void Anhxa ()

    {

        N1=findViewById(R.id.etName1);

        N2=findViewById(R.id.etName2);

        BT=findViewById(R.id.btKq);

        KQ=findViewById(R.id.tvKq);

        Spin=findViewById(R.id.spinner);

    }
    void TaoSpin()
    {
        ArrayAdapter <String>adapter=new ArrayAdapter<String>
                (this,android.R.layout.simple_spinner_item,Arr);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        Spin.setAdapter(adapter);
        Spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                vitri =position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
               vitri=-1;
            }
        });
    }
    double Tinh()
    {
        double x1= Double.parseDouble(N1.getText().toString());
        double x2= Double.parseDouble(N2.getText().toString());
        double z=0;
        switch (vitri)
        {
            case 0: z=x1+x2;break;
            case 1: z=x1-x2;break;
            case 2: z=x1*x2;break;
            case 3: z=x1/x2;break;
        }
        return z;
    }
}
