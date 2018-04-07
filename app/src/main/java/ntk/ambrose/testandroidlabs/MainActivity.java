package ntk.ambrose.testandroidlabs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class MainActivity extends AppCompatActivity implements Animation.AnimationListener {

    Animation animRotate;
    ImageView imagePokeball;
    Button btViewPokemon;
    Button btQuiz;
    ArrayList<String> quiz;
    Bundle quizPackage;

    public void createListQuiz(){
        quiz=new ArrayList<>();
        quizPackage=new Bundle();
        try {
            InputStream inputStream = getAssets().open("quiz.xml");
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(inputStream);
            Element element =document.getDocumentElement();
            element.normalize();
            NodeList nodeList = document.getElementsByTagName("question");
            Node node;
            for(int i=0;i<nodeList.getLength();i++){
                node = nodeList.item(i);
                if(node.getNodeType()==Node.ELEMENT_NODE){
                    Element subElement = (Element)node;
                    quiz.add(getNodeValue("id",subElement)+"|"+
                            getNodeValue("info",subElement)+"|"+
                            getNodeValue("ansA",subElement)+"|"+
                            getNodeValue("ansB",subElement)+"|"+
                            getNodeValue("ansC",subElement)+"|"+
                            getNodeValue("ansD",subElement)+"|"+
                            getNodeValue("correct",subElement));
                }
            }
            inputStream.close();

            for(int i=0;i<quiz.size();i++) {
                String q = quiz.get(i);
                String[] components = q.split("|");
                quizPackage.putStringArray(components[0], components);
            }
            quizPackage.putInt("length",quiz.size());
            quizPackage.putInt("currentIndex",0);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static String getNodeValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = nodeList.item(0);
        return node.getNodeValue();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        imagePokeball = findViewById(R.id.imgPokeball);
        animRotate= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_anim);
        animRotate.setRepeatMode(Animation.INFINITE);

        imagePokeball.setAnimation(animRotate);
        animRotate.setAnimationListener(this);

        btViewPokemon=findViewById(R.id.btShowAll);
        btQuiz=findViewById(R.id.btSearch);
        btViewPokemon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ShowListPokemonActivity.class);
                startActivity(intent);

            }
        });

        btQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,QuizActivity.class);
                intent.putExtra("data",quizPackage);

            }
        });

    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
