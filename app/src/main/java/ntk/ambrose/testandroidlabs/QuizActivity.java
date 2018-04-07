package ntk.ambrose.testandroidlabs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;

/**
 * Created by nguye on 4/4/2018.
 */

public class QuizActivity extends AppCompatActivity {

    RadioButton rbAnsA,rbAnsB,rbAnsC,rbAnsD;
    TextView tvQuestion;
    Button btPrevious,btNext;
    int currentInd=0;
    int length=0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pokemon_quiz);
        rbAnsA=findViewById(R.id.ansA);
        rbAnsB=findViewById(R.id.ansB);
        rbAnsC=findViewById(R.id.ansC);
        rbAnsD=findViewById(R.id.ansD);
        tvQuestion=findViewById(R.id.tvQuestion);
        btNext=findViewById(R.id.btNext);
        btPrevious=findViewById(R.id.btPrevious);

        Bundle bundle = getIntent().getBundleExtra("data");
        currentInd = bundle.getInt("currentIndex");
        length=bundle.getInt("length");
        final String[] components = bundle.getStringArray(String.valueOf(currentInd));
        tvQuestion.setText(components[1]);
        rbAnsA.setText(components[2]);
        rbAnsB.setText(components[3]);
        rbAnsC.setText(components[4]);
        rbAnsD.setText(components[5]);

        CompoundButton.OnCheckedChangeListener onCheckedChangeListener =new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){

                }
            }
        };

        rbAnsA.setOnCheckedChangeListener(onCheckedChangeListener);
        rbAnsB.setOnCheckedChangeListener(onCheckedChangeListener);
        rbAnsC.setOnCheckedChangeListener(onCheckedChangeListener);
        rbAnsD.setOnCheckedChangeListener(onCheckedChangeListener);
    }

}
