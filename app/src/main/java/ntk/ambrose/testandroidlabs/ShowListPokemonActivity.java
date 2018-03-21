package ntk.ambrose.testandroidlabs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by nguye on 3/21/2018.
 */

public class ShowListPokemonActivity extends AppCompatActivity {

    TextView tvSearch;
    Button btSearch;
    ListView lvPokemon;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        tvSearch=findViewById(R.id.etSearchName);
        btSearch=findViewById(R.id.btSearch);
        lvPokemon=findViewById(R.id.lvPokemon);

        createListPokemon();

    }

    public void createListPokemon(){
        PokemonData[] pokelist={
                new PokemonData(0,"Poke 1",""),
                new PokemonData(1,"Poke 2",""),
                new PokemonData(2,"Poke 3","")};

        PokemonListAdapter pokemonListAdapter=new PokemonListAdapter(this,pokelist);
        lvPokemon.setAdapter(pokemonListAdapter);

    }

}
