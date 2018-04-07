package ntk.ambrose.testandroidlabs;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

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
        setContentView(R.layout.pokelist_activity);

        tvSearch=findViewById(R.id.etSearchName);
        btSearch=findViewById(R.id.btSearch);
        lvPokemon=findViewById(R.id.lvPokemon);

        createListPokemon();

        lvPokemon.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intentInfo = new Intent(ShowListPokemonActivity.this,PokemonInfoActivity.class);
                Bundle bundle = new Bundle();


                PokemonData data = (PokemonData)(lvPokemon.getItemAtPosition(i));
                bundle.putString("id",String.valueOf(data.getPokemonID()));
                bundle.putString("name",data.getPokemonName());
                bundle.putString("description",data.getPokemonDescription());
                intentInfo.putExtra("data",bundle);
                startActivity(intentInfo);
            }
        });

    }

    public void createListPokemon(){

        ArrayList<PokemonData> pokemonData=new ArrayList<>();
        try {
            InputStream inputStream = getAssets().open("PokeData.xml");
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(inputStream);
            Element element =document.getDocumentElement();
            element.normalize();
            NodeList nodeList = document.getElementsByTagName("pokemon");
            Node node;
            for(int i=0;i<nodeList.getLength();i++){
                node = nodeList.item(i);
                if(node.getNodeType()==Node.ELEMENT_NODE){
                    Element subElement = (Element)node;
                    pokemonData.add(new PokemonData(Integer.parseInt(
                            getNodeValue("id",subElement)),
                            getNodeValue("name",subElement),
                            getNodeValue("description",subElement)));
                }
            }
            inputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        PokemonListAdapter pokemonListAdapter=new PokemonListAdapter(this,pokemonData.toArray(new PokemonData[pokemonData.size()]));
        lvPokemon.setAdapter(pokemonListAdapter);

    }

    private static String getNodeValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = nodeList.item(0);
        return node.getNodeValue();
    }

}
