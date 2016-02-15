package com.example.cdoit.characterstrengthbuilder;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class GritTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grit_test);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ScrollView scrollView = (ScrollView) this.findViewById(R.id.scrollView);

        TextView gritTestTextView = new TextView(this);
        gritTestTextView.setText("Grit Test");
        gritTestTextView.setTextAppearance(this, android.R.style.TextAppearance_Large);
        gritTestTextView.setTextColor(Color.parseColor("#3c2f2f"));
        gritTestTextView.setTextSize(48);
        scrollView.addView(gritTestTextView);

        TextView item1TextView = new TextView(this);
        item1TextView.setText("I have overcome setbacks to conquer an important challenge.");
        item1TextView.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item1TextView.setTextColor(Color.parseColor("#3c2f2f"));
        item1TextView.setTextSize(20);
        scrollView.addView(item1TextView);

        RadioGroup item1RadioGroup = new RadioGroup(this);
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

        scrollView.addView(item1RadioGroup);

        TextView item2TextView = new TextView(this);
        item2TextView.setText("New ideas and projects sometimes distract me from previous ones.");
        item2TextView.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item2TextView.setTextColor(Color.parseColor("#3c2f2f"));
        item2TextView.setTextSize(20);
        scrollView.addView(item2TextView);

        RadioGroup item2RadioGroup = new RadioGroup(this);
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

        scrollView.addView(item2RadioGroup);

        TextView item3TextView = new TextView(this);
        item3TextView.setText("My interests change from year to year.");
        item3TextView.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item3TextView.setTextColor(Color.parseColor("#3c2f2f"));
        item3TextView.setTextSize(20);
        scrollView.addView(item3TextView);

        RadioGroup item3RadioGroup = new RadioGroup(this);
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

        scrollView.addView(item3RadioGroup);

        TextView item4TextView = new TextView(this);
        item4TextView.setText("Setbacks don't discourage me.");
        item4TextView.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item4TextView.setTextColor(Color.parseColor("#3c2f2f"));
        item4TextView.setTextSize(20);
        scrollView.addView(item4TextView);

        RadioGroup item4RadioGroup = new RadioGroup(this);
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

        scrollView.addView(item4RadioGroup);

        TextView item5TextView = new TextView(this);
        item5TextView.setText("I have been obsessed with a certain idea or project for a short time but later lost interest.");
        item5TextView.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item5TextView.setTextColor(Color.parseColor("#3c2f2f"));
        item5TextView.setTextSize(20);
        scrollView.addView(item5TextView);

        RadioGroup item5RadioGroup = new RadioGroup(this);
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

        scrollView.addView(item5RadioGroup);

        TextView item6TextView = new TextView(this);
        item6TextView.setText("I am a hard worker.");
        item6TextView.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item6TextView.setTextColor(Color.parseColor("#3c2f2f"));
        item6TextView.setTextSize(20);
        scrollView.addView(item6TextView);

        RadioGroup item6RadioGroup = new RadioGroup(this);
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

        scrollView.addView(item6RadioGroup);

        TextView item7TextView = new TextView(this);
        item7TextView.setText("I often set a goal but later choose to pursue a different one.");
        item7TextView.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item7TextView.setTextColor(Color.parseColor("#3c2f2f"));
        item7TextView.setTextSize(20);
        scrollView.addView(item7TextView);

        RadioGroup item7RadioGroup = new RadioGroup(this);
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

        scrollView.addView(item7RadioGroup);

        TextView item8TextView = new TextView(this);
        item8TextView.setText("I have difficulty maintaining my focus on projects that take more than a few months to complete.");
        item8TextView.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item8TextView.setTextColor(Color.parseColor("#3c2f2f"));
        item8TextView.setTextSize(20);
        scrollView.addView(item8TextView);

        RadioGroup item8RadioGroup = new RadioGroup(this);
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

        scrollView.addView(item8RadioGroup);

        TextView item9TextView = new TextView(this);
        item9TextView.setText("I finish whatever I begin.");
        item9TextView.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item9TextView.setTextColor(Color.parseColor("#3c2f2f"));
        item9TextView.setTextSize(20);
        scrollView.addView(item9TextView);

        RadioGroup item9RadioGroup = new RadioGroup(this);
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

        scrollView.addView(item9RadioGroup);

        TextView item10TextView = new TextView(this);
        item10TextView.setText("I have achieved a goal that took years of work.");
        item10TextView.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item10TextView.setTextColor(Color.parseColor("#3c2f2f"));
        item10TextView.setTextSize(20);
        scrollView.addView(item10TextView);

        RadioGroup item10RadioGroup = new RadioGroup(this);
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

        scrollView.addView(item10RadioGroup);

        TextView item11TextView = new TextView(this);
        item11TextView.setText("I become interested in new pursuits every few months.");
        item11TextView.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item11TextView.setTextColor(Color.parseColor("#3c2f2f"));
        item11TextView.setTextSize(20);
        scrollView.addView(item11TextView);

        RadioGroup item11RadioGroup = new RadioGroup(this);
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

        scrollView.addView(item11RadioGroup);

        TextView item12TextView = new TextView(this);
        item12TextView.setText("I am diligent.");
        item12TextView.setTextAppearance(this, android.R.style.TextAppearance_Small);
        item12TextView.setTextColor(Color.parseColor("#3c2f2f"));
        item12TextView.setTextSize(20);
        scrollView.addView(item12TextView);

        RadioGroup item12RadioGroup = new RadioGroup(this);
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

        scrollView.addView(item12RadioGroup);
    }

}
