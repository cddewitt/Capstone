package bsu.edu.cdoit.characterstrengthbuilder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class LovelyThinkingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lovely_thinking);
        TextView view = (TextView) findViewById(R.id.tbxLovely);
        if (view != null) {
            view.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

}
