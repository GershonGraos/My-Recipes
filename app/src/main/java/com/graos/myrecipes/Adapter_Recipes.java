package com.graos.myrecipes;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Adapter_Recipes extends RecyclerView.Adapter<Adapter_Recipes.MyViewHolder>  {

    Context myContext;
    List<Recipes> recipesList;

    // --- constructor ---
    public Adapter_Recipes(Context myContext, List<Recipes> recipesList) {
        this.myContext = myContext;
        this.recipesList = recipesList;
    }

    // --- connect with the xml objects ---
    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView drw_img;
        TextView title, count;

        public MyViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.title_recipe);
            count = (TextView) itemView.findViewById(R.id.numOf_recipes);
            drw_img = (ImageView) itemView.findViewById(R.id.image_recipe);
        }
    }

    // --- connect the Layout!! with a inflate and returns it ---
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View myInflateLayout = LayoutInflater.from(parent.getContext())
                            .inflate(R.layout.recipes_card, parent,false);

        return new MyViewHolder(myInflateLayout);
    }

    // --- add data for any recipes - enlazar los datos
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Recipes recipe = recipesList.get(position);
        holder.title.setText(recipe.getName());
        holder.count.setText(recipe.getNumOfRecipes()+ " recipes");

        // loading the title image using Glide library
        Glide.with(myContext)
                .load(recipe.getImgDrawable())
                .into(holder.drw_img);
    }

    @Override
    public int getItemCount() {
        return recipesList.size();
    }
}
