package ntk.ambrose.testandroidlabs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class PokemonInfoActivity extends AppCompatActivity{

    TextView tvName;
    TextView tvDescription;
    ImageView ivPokemon;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pokemon_info_activity);

        tvName=findViewById(R.id.tvName);
        tvDescription=findViewById(R.id.tvDescription);
        ivPokemon=findViewById(R.id.ivPokemon);

        Bundle bundle = getIntent().getBundleExtra("data");
        tvName.setText(bundle.getString("name"));
        tvDescription.setText(bundle.getString("description"));

        int idRes=getBaseContext().getResources().getIdentifier("pk"+bundle.getString("id"),"drawable",getBaseContext().getPackageName());
        ivPokemon.setImageResource(idRes);


    }
}
