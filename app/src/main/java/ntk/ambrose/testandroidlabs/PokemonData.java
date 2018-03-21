package ntk.ambrose.testandroidlabs;

/**
 * Created by nguye on 3/21/2018.
 */

public class PokemonData {
    private int pokemonID;
    private String pokemonName;
    private String pokemonDescription;

    public PokemonData(){}
    public PokemonData(int id, String name, String pokemonDescription) {
        setPokemonID(id);
        setPokemonName(name);
        setPokemonDescription(pokemonDescription);
    }

    public int getPokemonID() {
        return pokemonID;
    }

    public void setPokemonID(int pokemonID) {
        this.pokemonID = pokemonID;
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public void setPokemonName(String pokemonName) {
        this.pokemonName = pokemonName;
    }

    public String getPokemonDescription() {
        return pokemonDescription;
    }

    public void setPokemonDescription(String pokemonDescription) {
        this.pokemonDescription = pokemonDescription;
    }
}
