package com.example.cdoit.characterstrengthbuilder;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class GritTestActivity extends AppCompatActivity implements View.OnClickListener {

    private RadioGroup item1RadioGroup;
    private RadioGroup item2RadioGroup;
    private RadioGroup item3RadioGroup;
    private RadioGroup item4RadioGroup;
    private RadioGroup item5RadioGroup;
    private RadioGroup item6RadioGroup;
    private RadioGroup item7RadioGroup;
    private RadioGroup item8RadioGroup;
    private RadioGroup item9RadioGroup;
    private RadioGroup item10RadioGroup;
    private RadioGroup item11RadioGroup;
    private RadioGroup item12RadioGroup;

    private double selfControl;
    private double socialIntelligence;
    private double zest;
    private double gratitude;
    private double optimism;
    private double curiosity;
    private double totalScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Grit Test");
        setContentView(R.layout.grit_test);

        ScrollView scrollView = (ScrollView) this.findViewById(R.id.scrollView);

        RelativeLayout relativeLayout = new RelativeLayout(this);

        TextView gritTestTextView = new TextView(this);
        gritTestTextView.setText("Grit Test");
        gritTestTextView.setTextAppearance(this, android.R.style.TextAppearance_Large);
        gritTestTextView.setTextColor(Color.parseColor("#3c2f2f"));
        gritTestTextView.setTextSize(48);
        gritTestTextView.setId(View.generateViewId());
        RelativeLayout.LayoutParams gritTestTextViewParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        gritTestTextViewParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        relativeLayout.addView(gritTestTextView, gritTestTextViewParams);

        TextView item1TextView = new TextView(this);
        item1TextView.setText("I have overcome setbacks to conquer an important challenge.");
        item1TextView.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item1TextView.setTextColor(Color.parseColor("#3c2f2f"));
        item1TextView.setTextSize(20);
        item1TextView.setId(View.generateViewId());
        RelativeLayout.LayoutParams item1TextViewParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        item1TextViewParams.addRule(RelativeLayout.BELOW, gritTestTextView.getId());
        item1TextViewParams.setMargins(10, 20, 10, 0);
        relativeLayout.addView(item1TextView, item1TextViewParams);

        item1RadioGroup = new RadioGroup(this);
        item1RadioGroup.setOrientation(RadioGroup.VERTICAL);

        RadioButton item1Answer1 = new RadioButton(this);
        item1Answer1.setText("Very much like me");
        item1Answer1.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item1Answer1.setTextColor(Color.parseColor("#3c2f2f"));
        item1Answer1.setTextSize(20);
        item1Answer1.setTag(5);
        item1RadioGroup.addView(item1Answer1);

        RadioButton item1Answer2 = new RadioButton(this);
        item1Answer2.setText("Mostly like me");
        item1Answer2.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item1Answer2.setTextColor(Color.parseColor("#3c2f2f"));
        item1Answer2.setTextSize(20);
        item1Answer2.setTag(4);
        item1RadioGroup.addView(item1Answer2);

        RadioButton item1Answer3 = new RadioButton(this);
        item1Answer3.setText("Somewhat like me");
        item1Answer3.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item1Answer3.setTextColor(Color.parseColor("#3c2f2f"));
        item1Answer3.setTextSize(20);
        item1Answer3.setTag(3);
        item1RadioGroup.addView(item1Answer3);

        RadioButton item1Answer4 = new RadioButton(this);
        item1Answer4.setText("Not much like me");
        item1Answer4.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item1Answer4.setTextColor(Color.parseColor("#3c2f2f"));
        item1Answer4.setTextSize(20);
        item1Answer4.setTag(2);
        item1RadioGroup.addView(item1Answer4);

        RadioButton item1Answer5 = new RadioButton(this);
        item1Answer5.setText("Not like me at all");
        item1Answer5.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item1Answer5.setTextColor(Color.parseColor("#3c2f2f"));
        item1Answer5.setTextSize(20);
        item1Answer5.setTag(1);
        item1RadioGroup.addView(item1Answer5);

        item1RadioGroup.setId(View.generateViewId());
        RelativeLayout.LayoutParams item1RadioGroupParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        item1RadioGroupParams.addRule(RelativeLayout.BELOW, item1TextView.getId());
        item1RadioGroupParams.setMargins(10, 10, 10, 0);
        relativeLayout.addView(item1RadioGroup, item1RadioGroupParams);

        TextView item2TextView = new TextView(this);
        item2TextView.setText("New ideas and projects sometimes distract me from previous ones.");
        item2TextView.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item2TextView.setTextColor(Color.parseColor("#3c2f2f"));
        item2TextView.setTextSize(20);
        item2TextView.setId(View.generateViewId());
        RelativeLayout.LayoutParams item2TextViewParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        item2TextViewParams.addRule(RelativeLayout.BELOW, item1RadioGroup.getId());
        item2TextViewParams.setMargins(10, 20, 10, 0);
        relativeLayout.addView(item2TextView, item2TextViewParams);

        item2RadioGroup = new RadioGroup(this);
        item2RadioGroup.setOrientation(RadioGroup.VERTICAL);

        RadioButton item2Answer1 = new RadioButton(this);
        item2Answer1.setText("Very much like me");
        item2Answer1.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item2Answer1.setTextColor(Color.parseColor("#3c2f2f"));
        item2Answer1.setTextSize(20);
        item2Answer1.setTag(1);
        item2RadioGroup.addView(item2Answer1);

        RadioButton item2Answer2 = new RadioButton(this);
        item2Answer2.setText("Mostly like me");
        item2Answer2.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item2Answer2.setTextColor(Color.parseColor("#3c2f2f"));
        item2Answer2.setTextSize(20);
        item2Answer2.setTag(2);
        item2RadioGroup.addView(item2Answer2);

        RadioButton item2Answer3 = new RadioButton(this);
        item2Answer3.setText("Somewhat like me");
        item2Answer3.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item2Answer3.setTextColor(Color.parseColor("#3c2f2f"));
        item2Answer3.setTextSize(20);
        item2Answer3.setTag(3);
        item2RadioGroup.addView(item2Answer3);

        RadioButton item2Answer4 = new RadioButton(this);
        item2Answer4.setText("Not much like me");
        item2Answer4.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item2Answer4.setTextColor(Color.parseColor("#3c2f2f"));
        item2Answer4.setTextSize(20);
        item2Answer4.setTag(4);
        item2RadioGroup.addView(item2Answer4);

        RadioButton item2Answer5 = new RadioButton(this);
        item2Answer5.setText("Not like me at all");
        item2Answer5.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item2Answer5.setTextColor(Color.parseColor("#3c2f2f"));
        item2Answer5.setTextSize(20);
        item2Answer5.setTag(5);
        item2RadioGroup.addView(item2Answer5);

        item2RadioGroup.setId(View.generateViewId());
        RelativeLayout.LayoutParams item2RadioGroupParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        item2RadioGroupParams.addRule(RelativeLayout.BELOW, item2TextView.getId());
        item2RadioGroupParams.setMargins(10, 10, 10, 0);
        relativeLayout.addView(item2RadioGroup, item2RadioGroupParams);

        TextView item3TextView = new TextView(this);
        item3TextView.setText("My interests change from year to year.");
        item3TextView.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item3TextView.setTextColor(Color.parseColor("#3c2f2f"));
        item3TextView.setTextSize(20);
        item3TextView.setId(View.generateViewId());
        RelativeLayout.LayoutParams item3TextViewParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        item3TextViewParams.addRule(RelativeLayout.BELOW, item2RadioGroup.getId());
        item3TextViewParams.setMargins(10, 20, 10, 0);
        relativeLayout.addView(item3TextView, item3TextViewParams);

        item3RadioGroup = new RadioGroup(this);
        item3RadioGroup.setOrientation(RadioGroup.VERTICAL);

        RadioButton item3Answer1 = new RadioButton(this);
        item3Answer1.setText("Very much like me");
        item3Answer1.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item3Answer1.setTextColor(Color.parseColor("#3c2f2f"));
        item3Answer1.setTextSize(20);
        item3Answer1.setTag(1);
        item3RadioGroup.addView(item3Answer1);

        RadioButton item3Answer2 = new RadioButton(this);
        item3Answer2.setText("Mostly like me");
        item3Answer2.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item3Answer2.setTextColor(Color.parseColor("#3c2f2f"));
        item3Answer2.setTextSize(20);
        item3Answer2.setTag(2);
        item3RadioGroup.addView(item3Answer2);

        RadioButton item3Answer3 = new RadioButton(this);
        item3Answer3.setText("Somewhat like me");
        item3Answer3.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item3Answer3.setTextColor(Color.parseColor("#3c2f2f"));
        item3Answer3.setTextSize(20);
        item3Answer3.setTag(3);
        item3RadioGroup.addView(item3Answer3);

        RadioButton item3Answer4 = new RadioButton(this);
        item3Answer4.setText("Not much like me");
        item3Answer4.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item3Answer4.setTextColor(Color.parseColor("#3c2f2f"));
        item3Answer4.setTextSize(20);
        item3Answer4.setTag(4);
        item3RadioGroup.addView(item3Answer4);

        RadioButton item3Answer5 = new RadioButton(this);
        item3Answer5.setText("Not like me at all");
        item3Answer5.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item3Answer5.setTextColor(Color.parseColor("#3c2f2f"));
        item3Answer5.setTextSize(20);
        item3Answer5.setTag(5);
        item3RadioGroup.addView(item3Answer5);

        item3RadioGroup.setId(View.generateViewId());
        RelativeLayout.LayoutParams item3RadioGroupParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        item3RadioGroupParams.addRule(RelativeLayout.BELOW, item3TextView.getId());
        item3RadioGroupParams.setMargins(10, 10, 10, 0);
        relativeLayout.addView(item3RadioGroup, item3RadioGroupParams);

        TextView item4TextView = new TextView(this);
        item4TextView.setText("Setbacks don't discourage me.");
        item4TextView.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item4TextView.setTextColor(Color.parseColor("#3c2f2f"));
        item4TextView.setTextSize(20);
        item4TextView.setId(View.generateViewId());
        RelativeLayout.LayoutParams item4TextViewParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        item4TextViewParams.addRule(RelativeLayout.BELOW, item3RadioGroup.getId());
        item4TextViewParams.setMargins(10, 20, 10, 0);
        relativeLayout.addView(item4TextView, item4TextViewParams);

        item4RadioGroup = new RadioGroup(this);
        item4RadioGroup.setOrientation(RadioGroup.VERTICAL);

        RadioButton item4Answer1 = new RadioButton(this);
        item4Answer1.setText("Very much like me");
        item4Answer1.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item4Answer1.setTextColor(Color.parseColor("#3c2f2f"));
        item4Answer1.setTextSize(20);
        item4Answer1.setTag(5);
        item4RadioGroup.addView(item4Answer1);

        RadioButton item4Answer2 = new RadioButton(this);
        item4Answer2.setText("Mostly like me");
        item4Answer2.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item4Answer2.setTextColor(Color.parseColor("#3c2f2f"));
        item4Answer2.setTextSize(20);
        item4Answer2.setTag(4);
        item4RadioGroup.addView(item4Answer2);

        RadioButton item4Answer3 = new RadioButton(this);
        item4Answer3.setText("Somewhat like me");
        item4Answer3.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item4Answer3.setTextColor(Color.parseColor("#3c2f2f"));
        item4Answer3.setTextSize(20);
        item4Answer3.setTag(3);
        item4RadioGroup.addView(item4Answer3);

        RadioButton item4Answer4 = new RadioButton(this);
        item4Answer4.setText("Not much like me");
        item4Answer4.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item4Answer4.setTextColor(Color.parseColor("#3c2f2f"));
        item4Answer4.setTextSize(20);
        item4Answer4.setTag(2);
        item4RadioGroup.addView(item4Answer4);

        RadioButton item4Answer5 = new RadioButton(this);
        item4Answer5.setText("Not like me at all");
        item4Answer5.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item4Answer5.setTextColor(Color.parseColor("#3c2f2f"));
        item4Answer5.setTextSize(20);
        item4Answer5.setTag(1);
        item4RadioGroup.addView(item4Answer5);

        item4RadioGroup.setId(View.generateViewId());
        RelativeLayout.LayoutParams item4RadioGroupParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        item4RadioGroupParams.addRule(RelativeLayout.BELOW, item4TextView.getId());
        item4RadioGroupParams.setMargins(10, 10, 10, 0);
        relativeLayout.addView(item4RadioGroup, item4RadioGroupParams);

        TextView item5TextView = new TextView(this);
        item5TextView.setText("I have been obsessed with a certain idea or project for a short time but later lost interest.");
        item5TextView.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item5TextView.setTextColor(Color.parseColor("#3c2f2f"));
        item5TextView.setTextSize(20);
        item5TextView.setId(View.generateViewId());
        RelativeLayout.LayoutParams item5TextViewParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        item5TextViewParams.addRule(RelativeLayout.BELOW, item4RadioGroup.getId());
        item5TextViewParams.setMargins(10, 20, 10, 0);
        relativeLayout.addView(item5TextView, item5TextViewParams);

        item5RadioGroup = new RadioGroup(this);
        item5RadioGroup.setOrientation(RadioGroup.VERTICAL);

        RadioButton item5Answer1 = new RadioButton(this);
        item5Answer1.setText("Very much like me");
        item5Answer1.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item5Answer1.setTextColor(Color.parseColor("#3c2f2f"));
        item5Answer1.setTextSize(20);
        item5Answer1.setTag(1);
        item5RadioGroup.addView(item5Answer1);

        RadioButton item5Answer2 = new RadioButton(this);
        item5Answer2.setText("Mostly like me");
        item5Answer2.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item5Answer2.setTextColor(Color.parseColor("#3c2f2f"));
        item5Answer2.setTextSize(20);
        item5Answer2.setTag(2);
        item5RadioGroup.addView(item5Answer2);

        RadioButton item5Answer3 = new RadioButton(this);
        item5Answer3.setText("Somewhat like me");
        item5Answer3.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item5Answer3.setTextColor(Color.parseColor("#3c2f2f"));
        item5Answer3.setTextSize(20);
        item5Answer3.setTag(3);
        item5RadioGroup.addView(item5Answer3);

        RadioButton item5Answer4 = new RadioButton(this);
        item5Answer4.setText("Not much like me");
        item5Answer4.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item5Answer4.setTextColor(Color.parseColor("#3c2f2f"));
        item5Answer4.setTextSize(20);
        item5Answer4.setTag(4);
        item5RadioGroup.addView(item5Answer4);

        RadioButton item5Answer5 = new RadioButton(this);
        item5Answer5.setText("Not like me at all");
        item5Answer5.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item5Answer5.setTextColor(Color.parseColor("#3c2f2f"));
        item5Answer5.setTextSize(20);
        item5Answer5.setTag(5);
        item5RadioGroup.addView(item5Answer5);

        item5RadioGroup.setId(View.generateViewId());
        RelativeLayout.LayoutParams item5RadioGroupParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        item5RadioGroupParams.addRule(RelativeLayout.BELOW, item5TextView.getId());
        item5RadioGroupParams.setMargins(10, 10, 10, 0);
        relativeLayout.addView(item5RadioGroup, item5RadioGroupParams);

        TextView item6TextView = new TextView(this);
        item6TextView.setText("I am a hard worker.");
        item6TextView.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item6TextView.setTextColor(Color.parseColor("#3c2f2f"));
        item6TextView.setTextSize(20);
        item6TextView.setId(View.generateViewId());
        RelativeLayout.LayoutParams item6TextViewParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        item6TextViewParams.addRule(RelativeLayout.BELOW, item5RadioGroup.getId());
        item6TextViewParams.setMargins(10, 20, 10, 0);
        relativeLayout.addView(item6TextView, item6TextViewParams);

        item6RadioGroup = new RadioGroup(this);
        item6RadioGroup.setOrientation(RadioGroup.VERTICAL);

        RadioButton item6Answer1 = new RadioButton(this);
        item6Answer1.setText("Very much like me");
        item6Answer1.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item6Answer1.setTextColor(Color.parseColor("#3c2f2f"));
        item6Answer1.setTextSize(20);
        item6Answer1.setTag(5);
        item6RadioGroup.addView(item6Answer1);

        RadioButton item6Answer2 = new RadioButton(this);
        item6Answer2.setText("Mostly like me");
        item6Answer2.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item6Answer2.setTextColor(Color.parseColor("#3c2f2f"));
        item6Answer2.setTextSize(20);
        item6Answer2.setTag(4);
        item6RadioGroup.addView(item6Answer2);

        RadioButton item6Answer3 = new RadioButton(this);
        item6Answer3.setText("Somewhat like me");
        item6Answer3.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item6Answer3.setTextColor(Color.parseColor("#3c2f2f"));
        item6Answer3.setTextSize(20);
        item6Answer3.setTag(3);
        item6RadioGroup.addView(item6Answer3);

        RadioButton item6Answer4 = new RadioButton(this);
        item6Answer4.setText("Not much like me");
        item6Answer4.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item6Answer4.setTextColor(Color.parseColor("#3c2f2f"));
        item6Answer4.setTextSize(20);
        item6Answer4.setTag(2);
        item6RadioGroup.addView(item6Answer4);

        RadioButton item6Answer5 = new RadioButton(this);
        item6Answer5.setText("Not like me at all");
        item6Answer5.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item6Answer5.setTextColor(Color.parseColor("#3c2f2f"));
        item6Answer5.setTextSize(20);
        item6Answer5.setTag(1);
        item6RadioGroup.addView(item6Answer5);

        item6RadioGroup.setId(View.generateViewId());
        RelativeLayout.LayoutParams item6RadioGroupParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        item6RadioGroupParams.addRule(RelativeLayout.BELOW, item6TextView.getId());
        item6RadioGroupParams.setMargins(10, 10, 10, 0);
        relativeLayout.addView(item6RadioGroup, item6RadioGroupParams);

        TextView item7TextView = new TextView(this);
        item7TextView.setText("I often set a goal but later choose to pursue a different one.");
        item7TextView.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item7TextView.setTextColor(Color.parseColor("#3c2f2f"));
        item7TextView.setTextSize(20);
        item7TextView.setId(View.generateViewId());
        RelativeLayout.LayoutParams item7TextViewParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        item7TextViewParams.addRule(RelativeLayout.BELOW, item6RadioGroup.getId());
        item7TextViewParams.setMargins(10, 20, 10, 0);
        relativeLayout.addView(item7TextView, item7TextViewParams);

        item7RadioGroup = new RadioGroup(this);
        item7RadioGroup.setOrientation(RadioGroup.VERTICAL);

        RadioButton item7Answer1 = new RadioButton(this);
        item7Answer1.setText("Very much like me");
        item7Answer1.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item7Answer1.setTextColor(Color.parseColor("#3c2f2f"));
        item7Answer1.setTextSize(20);
        item7Answer1.setTag(1);
        item7RadioGroup.addView(item7Answer1);

        RadioButton item7Answer2 = new RadioButton(this);
        item7Answer2.setText("Mostly like me");
        item7Answer2.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item7Answer2.setTextColor(Color.parseColor("#3c2f2f"));
        item7Answer2.setTextSize(20);
        item7Answer2.setTag(2);
        item7RadioGroup.addView(item7Answer2);

        RadioButton item7Answer3 = new RadioButton(this);
        item7Answer3.setText("Somewhat like me");
        item7Answer3.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item7Answer3.setTextColor(Color.parseColor("#3c2f2f"));
        item7Answer3.setTextSize(20);
        item7Answer3.setTag(3);
        item7RadioGroup.addView(item7Answer3);

        RadioButton item7Answer4 = new RadioButton(this);
        item7Answer4.setText("Not much like me");
        item7Answer4.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item7Answer4.setTextColor(Color.parseColor("#3c2f2f"));
        item7Answer4.setTextSize(20);
        item7Answer4.setTag(4);
        item7RadioGroup.addView(item7Answer4);

        RadioButton item7Answer5 = new RadioButton(this);
        item7Answer5.setText("Not like me at all");
        item7Answer5.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item7Answer5.setTextColor(Color.parseColor("#3c2f2f"));
        item7Answer5.setTextSize(20);
        item7Answer5.setTag(5);
        item7RadioGroup.addView(item7Answer5);

        item7RadioGroup.setId(View.generateViewId());
        RelativeLayout.LayoutParams item7RadioGroupParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        item7RadioGroupParams.addRule(RelativeLayout.BELOW, item7TextView.getId());
        item7RadioGroupParams.setMargins(10, 10, 10, 0);
        relativeLayout.addView(item7RadioGroup, item7RadioGroupParams);

        TextView item8TextView = new TextView(this);
        item8TextView.setText("I have difficulty maintaining my focus on projects that take more than a few months to complete.");
        item8TextView.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item8TextView.setTextColor(Color.parseColor("#3c2f2f"));
        item8TextView.setTextSize(20);
        item8TextView.setId(View.generateViewId());
        RelativeLayout.LayoutParams item8TextViewParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        item8TextViewParams.addRule(RelativeLayout.BELOW, item7RadioGroup.getId());
        item8TextViewParams.setMargins(10, 20, 10, 0);
        relativeLayout.addView(item8TextView, item8TextViewParams);

        item8RadioGroup = new RadioGroup(this);
        item8RadioGroup.setOrientation(RadioGroup.VERTICAL);

        RadioButton item8Answer1 = new RadioButton(this);
        item8Answer1.setText("Very much like me");
        item8Answer1.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item8Answer1.setTextColor(Color.parseColor("#3c2f2f"));
        item8Answer1.setTextSize(20);
        item8Answer1.setTag(1);
        item8RadioGroup.addView(item8Answer1);

        RadioButton item8Answer2 = new RadioButton(this);
        item8Answer2.setText("Mostly like me");
        item8Answer2.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item8Answer2.setTextColor(Color.parseColor("#3c2f2f"));
        item8Answer2.setTextSize(20);
        item8Answer2.setTag(2);
        item8RadioGroup.addView(item8Answer2);

        RadioButton item8Answer3 = new RadioButton(this);
        item8Answer3.setText("Somewhat like me");
        item8Answer3.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item8Answer3.setTextColor(Color.parseColor("#3c2f2f"));
        item8Answer3.setTextSize(20);
        item8Answer3.setTag(3);
        item8RadioGroup.addView(item8Answer3);

        RadioButton item8Answer4 = new RadioButton(this);
        item8Answer4.setText("Not much like me");
        item8Answer4.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item8Answer4.setTextColor(Color.parseColor("#3c2f2f"));
        item8Answer4.setTextSize(20);
        item8Answer4.setTag(4);
        item8RadioGroup.addView(item8Answer4);

        RadioButton item8Answer5 = new RadioButton(this);
        item8Answer5.setText("Not like me at all");
        item8Answer5.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item8Answer5.setTextColor(Color.parseColor("#3c2f2f"));
        item8Answer5.setTextSize(20);
        item8Answer5.setTag(5);
        item8RadioGroup.addView(item8Answer5);

        item8RadioGroup.setId(View.generateViewId());
        RelativeLayout.LayoutParams item8RadioGroupParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        item8RadioGroupParams.addRule(RelativeLayout.BELOW, item8TextView.getId());
        item8RadioGroupParams.setMargins(10, 10, 10, 0);
        relativeLayout.addView(item8RadioGroup, item8RadioGroupParams);

        TextView item9TextView = new TextView(this);
        item9TextView.setText("I finish whatever I begin.");
        item9TextView.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item9TextView.setTextColor(Color.parseColor("#3c2f2f"));
        item9TextView.setTextSize(20);
        item9TextView.setId(View.generateViewId());
        RelativeLayout.LayoutParams item9TextViewParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        item9TextViewParams.addRule(RelativeLayout.BELOW, item8RadioGroup.getId());
        item9TextViewParams.setMargins(10, 20, 10, 0);
        relativeLayout.addView(item9TextView, item9TextViewParams);

        item9RadioGroup = new RadioGroup(this);
        item9RadioGroup.setOrientation(RadioGroup.VERTICAL);

        RadioButton item9Answer1 = new RadioButton(this);
        item9Answer1.setText("Very much like me");
        item9Answer1.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item9Answer1.setTextColor(Color.parseColor("#3c2f2f"));
        item9Answer1.setTextSize(20);
        item9Answer1.setTag(5);
        item9RadioGroup.addView(item9Answer1);

        RadioButton item9Answer2 = new RadioButton(this);
        item9Answer2.setText("Mostly like me");
        item9Answer2.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item9Answer2.setTextColor(Color.parseColor("#3c2f2f"));
        item9Answer2.setTextSize(20);
        item9Answer2.setTag(4);
        item9RadioGroup.addView(item9Answer2);

        RadioButton item9Answer3 = new RadioButton(this);
        item9Answer3.setText("Somewhat like me");
        item9Answer3.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item9Answer3.setTextColor(Color.parseColor("#3c2f2f"));
        item9Answer3.setTextSize(20);
        item9Answer3.setTag(3);
        item9RadioGroup.addView(item9Answer3);

        RadioButton item9Answer4 = new RadioButton(this);
        item9Answer4.setText("Not much like me");
        item9Answer4.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item9Answer4.setTextColor(Color.parseColor("#3c2f2f"));
        item9Answer4.setTextSize(20);
        item9Answer4.setTag(2);
        item9RadioGroup.addView(item9Answer4);

        RadioButton item9Answer5 = new RadioButton(this);
        item9Answer5.setText("Not like me at all");
        item9Answer5.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item9Answer5.setTextColor(Color.parseColor("#3c2f2f"));
        item9Answer5.setTextSize(20);
        item9Answer5.setTag(1);
        item9RadioGroup.addView(item9Answer5);

        item9RadioGroup.setId(View.generateViewId());
        RelativeLayout.LayoutParams item9RadioGroupParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        item9RadioGroupParams.addRule(RelativeLayout.BELOW, item9TextView.getId());
        item9RadioGroupParams.setMargins(10, 10, 10, 0);
        relativeLayout.addView(item9RadioGroup, item9RadioGroupParams);

        TextView item10TextView = new TextView(this);
        item10TextView.setText("I have achieved a goal that took years of work.");
        item10TextView.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item10TextView.setTextColor(Color.parseColor("#3c2f2f"));
        item10TextView.setTextSize(20);
        item10TextView.setId(View.generateViewId());
        RelativeLayout.LayoutParams item10TextViewParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        item10TextViewParams.addRule(RelativeLayout.BELOW, item9RadioGroup.getId());
        item10TextViewParams.setMargins(10, 20, 10, 0);
        relativeLayout.addView(item10TextView, item10TextViewParams);

        item10RadioGroup = new RadioGroup(this);
        item10RadioGroup.setOrientation(RadioGroup.VERTICAL);

        RadioButton item10Answer1 = new RadioButton(this);
        item10Answer1.setText("Very much like me");
        item10Answer1.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item10Answer1.setTextColor(Color.parseColor("#3c2f2f"));
        item10Answer1.setTextSize(20);
        item10Answer1.setTag(5);
        item10RadioGroup.addView(item10Answer1);

        RadioButton item10Answer2 = new RadioButton(this);
        item10Answer2.setText("Mostly like me");
        item10Answer2.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item10Answer2.setTextColor(Color.parseColor("#3c2f2f"));
        item10Answer2.setTextSize(20);
        item10Answer2.setTag(4);
        item10RadioGroup.addView(item10Answer2);

        RadioButton item10Answer3 = new RadioButton(this);
        item10Answer3.setText("Somewhat like me");
        item10Answer3.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item10Answer3.setTextColor(Color.parseColor("#3c2f2f"));
        item10Answer3.setTextSize(20);
        item10Answer3.setTag(3);
        item10RadioGroup.addView(item10Answer3);

        RadioButton item10Answer4 = new RadioButton(this);
        item10Answer4.setText("Not much like me");
        item10Answer4.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item10Answer4.setTextColor(Color.parseColor("#3c2f2f"));
        item10Answer4.setTextSize(20);
        item10Answer4.setTag(2);
        item10RadioGroup.addView(item10Answer4);

        RadioButton item10Answer5 = new RadioButton(this);
        item10Answer5.setText("Not like me at all");
        item10Answer5.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item10Answer5.setTextColor(Color.parseColor("#3c2f2f"));
        item10Answer5.setTextSize(20);
        item10Answer5.setTag(1);
        item10RadioGroup.addView(item10Answer5);

        item10RadioGroup.setId(View.generateViewId());
        RelativeLayout.LayoutParams item10RadioGroupParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        item10RadioGroupParams.addRule(RelativeLayout.BELOW, item10TextView.getId());
        item10RadioGroupParams.setMargins(10, 10, 10, 0);
        relativeLayout.addView(item10RadioGroup, item10RadioGroupParams);

        TextView item11TextView = new TextView(this);
        item11TextView.setText("I become interested in new pursuits every few months.");
        item11TextView.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item11TextView.setTextColor(Color.parseColor("#3c2f2f"));
        item11TextView.setTextSize(20);
        item11TextView.setId(View.generateViewId());
        RelativeLayout.LayoutParams item11TextViewParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        item11TextViewParams.addRule(RelativeLayout.BELOW, item10RadioGroup.getId());
        item11TextViewParams.setMargins(10, 20, 10, 0);
        relativeLayout.addView(item11TextView, item11TextViewParams);

        item11RadioGroup = new RadioGroup(this);
        item11RadioGroup.setOrientation(RadioGroup.VERTICAL);

        RadioButton item11Answer1 = new RadioButton(this);
        item11Answer1.setText("Very much like me");
        item11Answer1.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item11Answer1.setTextColor(Color.parseColor("#3c2f2f"));
        item11Answer1.setTextSize(20);
        item11Answer1.setTag(1);
        item11RadioGroup.addView(item11Answer1);

        RadioButton item11Answer2 = new RadioButton(this);
        item11Answer2.setText("Mostly like me");
        item11Answer2.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item11Answer2.setTextColor(Color.parseColor("#3c2f2f"));
        item11Answer2.setTextSize(20);
        item11Answer2.setTag(2);
        item11RadioGroup.addView(item11Answer2);

        RadioButton item11Answer3 = new RadioButton(this);
        item11Answer3.setText("Somewhat like me");
        item11Answer3.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item11Answer3.setTextColor(Color.parseColor("#3c2f2f"));
        item11Answer3.setTextSize(20);
        item11Answer3.setTag(3);
        item11RadioGroup.addView(item11Answer3);

        RadioButton item11Answer4 = new RadioButton(this);
        item11Answer4.setText("Not much like me");
        item11Answer4.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item11Answer4.setTextColor(Color.parseColor("#3c2f2f"));
        item11Answer4.setTextSize(20);
        item11Answer4.setTag(4);
        item11RadioGroup.addView(item11Answer4);

        RadioButton item11Answer5 = new RadioButton(this);
        item11Answer5.setText("Not like me at all");
        item11Answer5.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item11Answer5.setTextColor(Color.parseColor("#3c2f2f"));
        item11Answer5.setTextSize(20);
        item11Answer5.setTag(5);
        item11RadioGroup.addView(item11Answer5);

        item11RadioGroup.setId(View.generateViewId());
        RelativeLayout.LayoutParams item11RadioGroupParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        item11RadioGroupParams.addRule(RelativeLayout.BELOW, item11TextView.getId());
        item11RadioGroupParams.setMargins(10, 10, 10, 0);
        relativeLayout.addView(item11RadioGroup, item11RadioGroupParams);

        TextView item12TextView = new TextView(this);
        item12TextView.setText("I am diligent.");
        item12TextView.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item12TextView.setTextColor(Color.parseColor("#3c2f2f"));
        item12TextView.setTextSize(20);
        item12TextView.setId(View.generateViewId());
        RelativeLayout.LayoutParams item12TextViewParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        item12TextViewParams.addRule(RelativeLayout.BELOW, item11RadioGroup.getId());
        item12TextViewParams.setMargins(10, 20, 10, 0);
        relativeLayout.addView(item12TextView, item12TextViewParams);

        item12RadioGroup = new RadioGroup(this);
        item12RadioGroup.setOrientation(RadioGroup.VERTICAL);

        RadioButton item12Answer1 = new RadioButton(this);
        item12Answer1.setText("Very much like me");
        item12Answer1.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item12Answer1.setTextColor(Color.parseColor("#3c2f2f"));
        item12Answer1.setTextSize(20);
        item12Answer1.setTag(5);
        item12RadioGroup.addView(item12Answer1);

        RadioButton item12Answer2 = new RadioButton(this);
        item12Answer2.setText("Mostly like me");
        item12Answer2.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item12Answer2.setTextColor(Color.parseColor("#3c2f2f"));
        item12Answer2.setTextSize(20);
        item12Answer2.setTag(4);
        item12RadioGroup.addView(item12Answer2);

        RadioButton item12Answer3 = new RadioButton(this);
        item12Answer3.setText("Somewhat like me");
        item12Answer3.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item12Answer3.setTextColor(Color.parseColor("#3c2f2f"));
        item12Answer3.setTextSize(20);
        item12Answer3.setTag(3);
        item12RadioGroup.addView(item12Answer3);

        RadioButton item12Answer4 = new RadioButton(this);
        item12Answer4.setText("Not much like me");
        item12Answer4.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item12Answer4.setTextColor(Color.parseColor("#3c2f2f"));
        item12Answer4.setTextSize(20);
        item12Answer4.setTag(2);
        item12RadioGroup.addView(item12Answer4);

        RadioButton item12Answer5 = new RadioButton(this);
        item12Answer5.setText("Not like me at all");
        item12Answer5.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item12Answer5.setTextColor(Color.parseColor("#3c2f2f"));
        item12Answer5.setTextSize(20);
        item12Answer5.setTag(1);
        item12RadioGroup.addView(item12Answer5);

        item12RadioGroup.setId(View.generateViewId());
        RelativeLayout.LayoutParams item12RadioGroupParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        item12RadioGroupParams.addRule(RelativeLayout.BELOW, item12TextView.getId());
        item12RadioGroupParams.setMargins(10, 10, 10, 0);
        relativeLayout.addView(item12RadioGroup, item12RadioGroupParams);

        Button submitGritTestResponsesButton = new Button(this);
        submitGritTestResponsesButton.setText("Submit Responses");
        submitGritTestResponsesButton.setOnClickListener(this);
        submitGritTestResponsesButton.setId(View.generateViewId());
        RelativeLayout.LayoutParams submitGritTestResponsesButtonParams = new RelativeLayout.LayoutParams(200, RelativeLayout.LayoutParams.WRAP_CONTENT);
        submitGritTestResponsesButtonParams.addRule(RelativeLayout.BELOW, item12RadioGroup.getId());
        item12RadioGroupParams.setMargins(0, 20, 10, 10);
        relativeLayout.addView(submitGritTestResponsesButton, submitGritTestResponsesButtonParams);

        scrollView.addView(relativeLayout);
    }

    @Override
    public void onClick(View v) {
        Log.v("Submit Grit Test", "in click");

        selfControl = 0;
        socialIntelligence = 0;
        zest = 0;
        gratitude = 0;
        optimism = 0;
        curiosity = 0;
        totalScore = 0;

        if (item1RadioGroup.getCheckedRadioButtonId() != -1) {
            int item1CheckedId = item1RadioGroup.getCheckedRadioButtonId();
            RadioButton checkedRadioButton = (RadioButton) item1RadioGroup.findViewById(item1CheckedId);
            int checkedRadioButtonIndex = item1RadioGroup.indexOfChild(checkedRadioButton);
            RadioButton selectedRadioButton = (RadioButton) item1RadioGroup.getChildAt(checkedRadioButtonIndex);
            int correspondingValue = Integer.parseInt(selectedRadioButton.getTag().toString());
            selfControl += correspondingValue;
            totalScore += correspondingValue;
        }
        if (item2RadioGroup.getCheckedRadioButtonId() != -1) {
            int item2CheckedId = item2RadioGroup.getCheckedRadioButtonId();
            RadioButton checkedRadioButton = (RadioButton) item2RadioGroup.findViewById(item2CheckedId);
            int checkedRadioButtonIndex = item2RadioGroup.indexOfChild(checkedRadioButton);
            RadioButton selectedRadioButton = (RadioButton) item2RadioGroup.getChildAt(checkedRadioButtonIndex);
            int correspondingValue = Integer.parseInt(selectedRadioButton.getTag().toString());
            selfControl += correspondingValue;
            totalScore += correspondingValue;
        }
        if (item3RadioGroup.getCheckedRadioButtonId() != -1) {
            int item3CheckedId = item3RadioGroup.getCheckedRadioButtonId();
            RadioButton checkedRadioButton = (RadioButton) item3RadioGroup.findViewById(item3CheckedId);
            int checkedRadioButtonIndex = item3RadioGroup.indexOfChild(checkedRadioButton);
            RadioButton selectedRadioButton = (RadioButton) item3RadioGroup.getChildAt(checkedRadioButtonIndex);
            int correspondingValue = Integer.parseInt(selectedRadioButton.getTag().toString());
            socialIntelligence += correspondingValue;
            totalScore += correspondingValue;
        }
        if (item4RadioGroup.getCheckedRadioButtonId() != -1) {
            int item4CheckedId = item4RadioGroup.getCheckedRadioButtonId();
            RadioButton checkedRadioButton = (RadioButton) item4RadioGroup.findViewById(item4CheckedId);
            int checkedRadioButtonIndex = item4RadioGroup.indexOfChild(checkedRadioButton);
            RadioButton selectedRadioButton = (RadioButton) item4RadioGroup.getChildAt(checkedRadioButtonIndex);
            int correspondingValue = Integer.parseInt(selectedRadioButton.getTag().toString());
            socialIntelligence += correspondingValue;
            totalScore += correspondingValue;
        }
        if (item5RadioGroup.getCheckedRadioButtonId() != -1) {
            int item5CheckedId = item5RadioGroup.getCheckedRadioButtonId();
            RadioButton checkedRadioButton = (RadioButton) item5RadioGroup.findViewById(item5CheckedId);
            int checkedRadioButtonIndex = item5RadioGroup.indexOfChild(checkedRadioButton);
            RadioButton selectedRadioButton = (RadioButton) item5RadioGroup.getChildAt(checkedRadioButtonIndex);
            int correspondingValue = Integer.parseInt(selectedRadioButton.getTag().toString());
            zest += correspondingValue;
            totalScore += correspondingValue;
        }
        if (item6RadioGroup.getCheckedRadioButtonId() != -1) {
            int item6CheckedId = item6RadioGroup.getCheckedRadioButtonId();
            RadioButton checkedRadioButton = (RadioButton) item6RadioGroup.findViewById(item6CheckedId);
            int checkedRadioButtonIndex = item6RadioGroup.indexOfChild(checkedRadioButton);
            RadioButton selectedRadioButton = (RadioButton) item6RadioGroup.getChildAt(checkedRadioButtonIndex);
            int correspondingValue = Integer.parseInt(selectedRadioButton.getTag().toString());
            zest += correspondingValue;
            totalScore += correspondingValue;
        }
        if (item7RadioGroup.getCheckedRadioButtonId() != -1) {
            int item7CheckedId = item7RadioGroup.getCheckedRadioButtonId();
            RadioButton checkedRadioButton = (RadioButton) item7RadioGroup.findViewById(item7CheckedId);
            int checkedRadioButtonIndex = item7RadioGroup.indexOfChild(checkedRadioButton);
            RadioButton selectedRadioButton = (RadioButton) item7RadioGroup.getChildAt(checkedRadioButtonIndex);
            int correspondingValue = Integer.parseInt(selectedRadioButton.getTag().toString());
            gratitude += correspondingValue;
            totalScore += correspondingValue;
        }
        if (item8RadioGroup.getCheckedRadioButtonId() != -1) {
            int item8CheckedId = item8RadioGroup.getCheckedRadioButtonId();
            RadioButton checkedRadioButton = (RadioButton) item8RadioGroup.findViewById(item8CheckedId);
            int checkedRadioButtonIndex = item8RadioGroup.indexOfChild(checkedRadioButton);
            RadioButton selectedRadioButton = (RadioButton) item8RadioGroup.getChildAt(checkedRadioButtonIndex);
            int correspondingValue = Integer.parseInt(selectedRadioButton.getTag().toString());
            gratitude += correspondingValue;
            totalScore += correspondingValue;
        }
        if (item9RadioGroup.getCheckedRadioButtonId() != -1) {
            int item9CheckedId = item9RadioGroup.getCheckedRadioButtonId();
            RadioButton checkedRadioButton = (RadioButton) item9RadioGroup.findViewById(item9CheckedId);
            int checkedRadioButtonIndex = item9RadioGroup.indexOfChild(checkedRadioButton);
            RadioButton selectedRadioButton = (RadioButton) item9RadioGroup.getChildAt(checkedRadioButtonIndex);
            int correspondingValue = Integer.parseInt(selectedRadioButton.getTag().toString());
            optimism += correspondingValue;
            totalScore += correspondingValue;
        }
        if (item10RadioGroup.getCheckedRadioButtonId() != -1) {
            int item10CheckedId = item10RadioGroup.getCheckedRadioButtonId();
            RadioButton checkedRadioButton = (RadioButton) item10RadioGroup.findViewById(item10CheckedId);
            int checkedRadioButtonIndex = item10RadioGroup.indexOfChild(checkedRadioButton);
            RadioButton selectedRadioButton = (RadioButton) item10RadioGroup.getChildAt(checkedRadioButtonIndex);
            int correspondingValue = Integer.parseInt(selectedRadioButton.getTag().toString());
            optimism += correspondingValue;
            totalScore += correspondingValue;
        }
        if (item11RadioGroup.getCheckedRadioButtonId() != -1) {
            int item11CheckedId = item11RadioGroup.getCheckedRadioButtonId();
            RadioButton checkedRadioButton = (RadioButton) item11RadioGroup.findViewById(item11CheckedId);
            int checkedRadioButtonIndex = item11RadioGroup.indexOfChild(checkedRadioButton);
            RadioButton selectedRadioButton = (RadioButton) item11RadioGroup.getChildAt(checkedRadioButtonIndex);
            int correspondingValue = Integer.parseInt(selectedRadioButton.getTag().toString());
            curiosity += correspondingValue;
            totalScore += correspondingValue;
        }
        if (item12RadioGroup.getCheckedRadioButtonId() != -1) {
            int item12CheckedId = item12RadioGroup.getCheckedRadioButtonId();
            RadioButton checkedRadioButton = (RadioButton) item12RadioGroup.findViewById(item12CheckedId);
            int checkedRadioButtonIndex = item12RadioGroup.indexOfChild(checkedRadioButton);
            RadioButton selectedRadioButton = (RadioButton) item12RadioGroup.getChildAt(checkedRadioButtonIndex);
            int correspondingValue = Integer.parseInt(selectedRadioButton.getTag().toString());
            curiosity += correspondingValue;
            totalScore += correspondingValue;
        }

        selfControl = selfControl / 2.0;
        socialIntelligence = socialIntelligence / 2.0;
        zest = zest / 2.0;
        gratitude = gratitude / 2.0;
        optimism = optimism / 2.0;
        curiosity = curiosity / 2.0;
        totalScore = totalScore / 12.0;

        long row = insertGritScoreData();
        if (row != -1) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            Toast toast = Toast.makeText(this, "Grit Test responses successfully saved!", Toast.LENGTH_LONG);
            toast.show();
        } else {
            Toast toast = Toast.makeText(this, "Unable to save Grit Test responses.", Toast.LENGTH_LONG);
            toast.show();
        }
    }

    private long insertGritScoreData() {
        DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext());
        SQLiteDatabase database = databaseHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(DatabaseContract.GritScores.COLUMN_DATE_SCORED, System.currentTimeMillis());
        contentValues.put(DatabaseContract.GritScores.COLUMN_SELF_CONTROL, selfControl);
        contentValues.put(DatabaseContract.GritScores.COLUMN_SOCIAL_INTELLIGENCE, socialIntelligence);
        contentValues.put(DatabaseContract.GritScores.COLUMN_ZEST, zest);
        contentValues.put(DatabaseContract.GritScores.COLUMN_GRATITUDE, gratitude);
        contentValues.put(DatabaseContract.GritScores.COLUMN_OPTIMISM, optimism);
        contentValues.put(DatabaseContract.GritScores.COLUMN_CURIOSITY, curiosity);
        contentValues.put(DatabaseContract.GritScores.COLUMN_TOTAL_SCORE, totalScore);

        return database.insert(DatabaseContract.GritScores.TABLENAME, null, contentValues);
    }

}
