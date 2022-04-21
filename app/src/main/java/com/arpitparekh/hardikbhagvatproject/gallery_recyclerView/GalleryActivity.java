package com.arpitparekh.hardikbhagvatproject.gallery_recyclerView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;

import com.arpitparekh.hardikbhagvatproject.R;
import com.arpitparekh.hardikbhagvatproject.databinding.ActivityGalleryBinding;

import java.util.ArrayList;

public class GalleryActivity extends AppCompatActivity {

    private ActivityGalleryBinding binding;
    private ArrayList<Gallery> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGalleryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.recyclerViewGallery.setLayoutManager(new GridLayoutManager(this,2));

        list = new ArrayList<>();

//        list.add(new Gallery("https://i.picsum.photos/id/237/536/354.jpg?hmac=i0yVXW1ORpyCZpQ-CknuyV-jbtU7_x9EBQVhvT5aRr0"));
//        list.add(new Gallery("https://i.picsum.photos/id/866/536/354.jpg?hmac=tGofDTV7tl2rprappPzKFiZ9vDh5MKj39oa2D--gqhA"));
//        list.add(new Gallery("https://i.picsum.photos/id/1084/536/354.jpg?grayscale&hmac=Ux7nzg19e1q35mlUVZjhCLxqkR30cC-CarVg-nlIf60"));
//        list.add(new Gallery("https://i.picsum.photos/id/1060/536/354.jpg?blur=2&hmac=0zJLs1ar00sBbW5Ahd_4zA6pgZqCVavwuHToO6VtcYY"));
//        list.add(new Gallery("https://i.picsum.photos/id/385/536/354.jpg?hmac=vT4PTVhGnZlAi6cVad5HuX3kIw-wvhGrRTMKgh3LxkM"));

        list.add(new Gallery(R.drawable.one));
        list.add(new Gallery(R.drawable.two));
        list.add(new Gallery(R.drawable.three));
        list.add(new Gallery(R.drawable.four));
        list.add(new Gallery(R.drawable.five));

        GalleryAdapter adapter = new GalleryAdapter(list);

        binding.recyclerViewGallery.setAdapter(adapter);



    }
}