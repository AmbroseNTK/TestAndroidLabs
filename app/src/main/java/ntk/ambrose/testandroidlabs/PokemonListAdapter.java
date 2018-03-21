package ntk.ambrose.testandroidlabs;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by nguye on 3/21/2018.
 */

public class PokemonListAdapter extends ArrayAdapter<PokemonData> {
    private Context context;
    private PokemonData[] pokemonData;
    public PokemonListAdapter(Context context, PokemonData[] pokemonData) {
        super(context, -1, pokemonData);
        this.context = context;
        this.pokemonData = pokemonData;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.listpokemon_layout,parent,false);
        TextView tvPokemonInfo =row.findViewById(R.id.tvPokemonName);
        ImageView imgPokemon = row.findViewById(R.id.imgPokemon);

        tvPokemonInfo.setText(pokemonData[position].getPokemonID()+"\n"+pokemonData[position].getPokemonName());
        return row;
    }
}
