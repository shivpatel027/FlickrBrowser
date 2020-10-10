package com.timbuchalka.flickerbrowser;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import com.squareup.picasso.Picasso;
import com.timbuchalka.flickrbrowser.R;
import android.widget.ImageView;
import android.widget.TextView;

public class PhotoDetailActivity extends BaseActivity {

    @SuppressLint("StringFormatInvalid")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_detail);

        actionToolbar(true);
        Intent intent = getIntent();
        Photo photo = (Photo) intent.getSerializableExtra(PHOTO_TRANSFER);
        if (photo != null) {
            TextView photoTitle = (TextView) findViewById(R.id.photo_title);
//            Resources resources = getResources();
//            String text = resources.getString(R.string.title_activity_photo_detail,photo.getTitle());
//            photoTitle.setText(text);
            photoTitle.setText("Title: " + photo.getTitle());

            TextView photoTags = (TextView) findViewById(R.id.photo_tags);
//            photoTags.setText(resources.getString(R.string.photo_tags_text,photoTags.getTag()));
            photoTags.setText("Tags: " + photo.getTags());

            TextView photoAuthor = (TextView) findViewById(R.id.photo_author);
            photoAuthor.setText(photo.getAuthor());

            ImageView photoImage = (ImageView) findViewById(R.id.photo_image);
            Picasso.with(this).load(photo.getLink())
                    .error(R.drawable.baseline_photo_black_48dp)
                    .placeholder(R.drawable.baseline_photo_black_48dp)
                    .into(photoImage);
        }
    }
}