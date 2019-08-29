package com.example.pizzarecipes;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PizzaRecipeAdapter extends RecyclerView.Adapter<PizzaRecipeAdapter.PizzaRecipeViewHolder> {

    ArrayList<PizzaRecipeItem> arrayList;
    Context context;

    @NonNull
    @Override
    public PizzaRecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pizzarecycleritem,
                parent, false);
        PizzaRecipeViewHolder pizzaRecipeViewHolder = new PizzaRecipeViewHolder(view);
        return pizzaRecipeViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PizzaRecipeViewHolder holder, int position) {
        PizzaRecipeItem pizzaRecipeItem = arrayList.get(position);

        holder.pizzaImage.setImageResource(pizzaRecipeItem.getImageResource());
        holder.title.setText(pizzaRecipeItem.getTitle());
        holder.description.setText(pizzaRecipeItem.getDescription());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class PizzaRecipeViewHolder extends RecyclerView.ViewHolder implements
            View.OnClickListener    {

        public ImageView pizzaImage;
        public TextView title;
        public TextView description;

        public PizzaRecipeViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            pizzaImage = itemView.findViewById(R.id.pizzaImage);
            title = itemView.findViewById(R.id.pizzaName);
            description = itemView.findViewById(R.id.pizzaRcipesInfo);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();

            PizzaRecipeItem pizzaRecipeItem = arrayList.get(position);


            Intent intent = new Intent(context, RecipeActivity.class);
            intent.putExtra("imageResource", pizzaRecipeItem.getImageResource());
            intent.putExtra("title", pizzaRecipeItem.getTitle());
            intent.putExtra("description", pizzaRecipeItem.getDescription());
            intent.putExtra("recipe", pizzaRecipeItem.getRecipe());
            context.startActivity(intent);

        }
    }

    public PizzaRecipeAdapter(ArrayList<PizzaRecipeItem> arrayList, Context context){
        this.arrayList = arrayList;
        this.context = context;


    }
}
