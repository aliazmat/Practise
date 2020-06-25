package doc.home.firstapp.ui;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.View;

import doc.home.firstapp.R;
import doc.home.firstapp.ui.fragment.FragmentOne;
import doc.home.firstapp.ui.fragment.FragmentTwo;

public class FragmentActivity extends AppCompatActivity implements FragmentTwo.FragmentContract {

    FragmentOne frgOne;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        frgOne = new FragmentOne();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container_one,frgOne);
        fragmentTransaction.add(R.id.container_two,new FragmentTwo("This is my Contrainer"));
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

    private void addnewInstanseOfFragmentTwo(String args){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container_two,new FragmentTwo(args));

        frgOne.updateLabel("My Custom Label "+args);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }
   int counter = 1;
    @Override
    public void doOnClick(String args) {
        addnewInstanseOfFragmentTwo(args+counter);
        counter++;
    }
}