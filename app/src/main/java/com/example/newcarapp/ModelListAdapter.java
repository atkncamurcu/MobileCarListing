package com.example.newcarapp;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.widget.ImageViewCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newcarapp.Models.Cars;
import com.google.android.material.snackbar.Snackbar;

import java.io.ByteArrayOutputStream;


public class ModelListAdapter extends RecyclerView.Adapter {
    public Cars[] getCars() {
        return cars;
    }

    public void setCars(Cars[] cars) {
        this.cars = cars;
    }

    private Cars[] cars = MyDatas.cars;
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_model_list,parent,false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ListViewHolder) holder).bindView(cars[position]);
    }

    @Override
    public int getItemCount() {
        return cars.length;
    }



    public class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView mItemSerial;
        private TextView mItemModel;
        private TextView mItemYear;
        private TextView mItemFuel;
        private ImageView mItemImage;

        public ListViewHolder(View itemView){
            super(itemView);

            mItemSerial = (TextView) itemView.findViewById(R.id.itemSerial);
            mItemModel = (TextView) itemView.findViewById(R.id.itemModel);
            mItemYear  = (TextView) itemView.findViewById(R.id.itemYear);
            mItemFuel = (TextView) itemView.findViewById(R.id.itemFuel);
            mItemImage = (ImageView) itemView.findViewById(R.id.itemImage);

            itemView.setOnClickListener(this);


        }

        public void bindView(Cars cars){
            mItemSerial.setText(cars.getSerial());
            mItemModel.setText(cars.getModel());
            mItemYear.setText(cars.getYear()+"");
            mItemFuel.setText(cars.getFuel());
            mItemImage.setImageResource(cars.getImageResource());
        }

        @Override
        public void onClick(View view){
            Context context = view.getContext();

            Intent intent = new Intent(context,DetailsActivity.class);
            intent.putExtra("Serial",mItemSerial.getText());
            intent.putExtra("Model",mItemModel.getText());
            intent.putExtra("Year",mItemYear.getText());
            intent.putExtra("Fuel",mItemFuel.getText());
            mItemImage.buildDrawingCache();
            Bundle bundle = new Bundle();
            bundle.putParcelable("image",mItemImage.getDrawingCache());
            intent.putExtras(bundle);



           //Image gönderilecek



            context.startActivity(intent);
        }
    }
}
