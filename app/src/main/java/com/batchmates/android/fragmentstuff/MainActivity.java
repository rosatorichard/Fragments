package com.batchmates.android.fragmentstuff;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements RefFragment.OnFragmentInteractionListener,BlueFragment.OnFragmentInteractionListener,YellowFrag.OnFragmentInteractionListener{

    private final static String RED_TAG="Red Frag";
    private final static String BLUE_TAG="Blue Frag";
    private static final String YELLOW_TAG = "Yellow Frag";
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=(TextView)findViewById(R.id.tvUpdate);

    }

    public void yellow(View view) {

        YellowFrag yellowFrag=new YellowFrag().newInstance("Richard Rosato", textView.getText().toString());

        getSupportFragmentManager().beginTransaction().replace(R.id.firstFrag,yellowFrag,YELLOW_TAG).addToBackStack(YELLOW_TAG).commit();

    }

    public void red(View view) {

        RefFragment fragment=new RefFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.firstFrag,fragment,RED_TAG).addToBackStack(RED_TAG).commit();
    }

    public void blue(View view) {

        BlueFragment blueFragment=new BlueFragment();
        Bundle bundle =new Bundle();
        bundle.putString("key","This is new blue valure");
        blueFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().add(R.id.secondFrag,blueFragment,BLUE_TAG).addToBackStack(BLUE_TAG).commit();
    }

    @Override
    public void onFragmentInteraction(String str) {


        textView.setText(str);

    }

    @Override
    public void onBlueFragmentInteraction(String str) {

        textView.setText(str);
    }

    @Override
    public void onYellowFragmentInteraction(String str) {

        textView.setText(str);
    }

    public void delete(View view) {

        Fragment frag =getSupportFragmentManager().findFragmentByTag(YELLOW_TAG);

        getSupportFragmentManager().beginTransaction().remove(frag).commit();
        //pop it off the stack
        //getSupportFragmentManager().popBackStack();


    }
}
