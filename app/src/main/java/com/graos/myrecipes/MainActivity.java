package com.graos.myrecipes;

import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageView myTitleImage;
    private List<Recipes> recipesList;
    private RecyclerView recyclerView;
    private AdapterRecipes adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recipesList = new ArrayList<>();
        myTitleImage = (ImageView) findViewById(R.id.image_title);
        recyclerView = (RecyclerView) findViewById(R.id.my_recyclerView);
        adapter = new AdapterRecipes(this, recipesList);

        RecyclerView.LayoutManager myLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(myLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(10, dpToPx(8), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        // --- add the title image ---
        Glide.with(this)
                .load(R.drawable.recipes_logo)
                .into(myTitleImage);

        createAlbumRecipes();
    }


    // --- create the recipes ---
    private void createAlbumRecipes() {
        int[] drwImg = new int[]{
                R.drawable.cakes,
                R.drawable.chiken,
                R.drawable.meat,
                R.drawable.salad
        };

        Recipes r = new Recipes("Cakes", drwImg[0]);
        recipesList.add(r);

        r = new Recipes("Chicken", drwImg[1]);
        recipesList.add(r);

        r = new Recipes("Meat", drwImg[2]);
        recipesList.add(r);

        r = new Recipes("Salad", drwImg[3]);
        recipesList.add(r);

        adapter.notifyDataSetChanged();
    }


    // --- RecyclerView item decoration - give equal margin around grid item
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}


