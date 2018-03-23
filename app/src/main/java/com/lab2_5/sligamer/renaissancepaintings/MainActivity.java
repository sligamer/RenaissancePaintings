package com.lab2_5.sligamer.renaissancepaintings;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    // gallery of paintings
    private LinearLayout mLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // reference the scrollable layout structure in main layout
        mLinearLayout = (LinearLayout) findViewById(R.id.linearList);

        // fill the scrollable layout structure with paintings
        fillPaintingGallery();
    }

    private void fillPaintingGallery() {
        // populate the linearlayout gallery
        // with paintings and descriptions

        for (int i = 0; i < RenaissanceDatabase.description.length; i++ )
        {
            // store the individual paintings as buttons
            final ImageButton buttonItem = new ImageButton(this);

            Painting painting = new Painting(RenaissanceDatabase.description[i],
                    RenaissanceDatabase.id[i]);

            // use the content description property to store painting data
            buttonItem.setContentDescription(painting.getDescription());

            // load the painting using its unique id
            buttonItem.setImageDrawable(getResources().getDrawable(painting.getId(), null));

            // set an onclick listener for the image button
            buttonItem.setOnClickListener(displayPaintingInformation);

            // add the image button to the scrollable linear list
            mLinearLayout.addView(buttonItem);

        }
    }

    private View.OnClickListener displayPaintingInformation = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // collect the information stored about the painting
            String paintingDescription = (String) v.getContentDescription();

            // make a call to display the information
            displayToast(paintingDescription);
        }
    };

    private void displayToast(String paintingDescription) {
        // show the information about the painting as
        // a toast with a short display life
        Toast.makeText(this, paintingDescription,
        Toast.LENGTH_SHORT).show();
    }
}
