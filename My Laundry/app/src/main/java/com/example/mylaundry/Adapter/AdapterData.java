package com.example.mylaundry.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mylaundry.Model.DataModel;
import com.example.mylaundry.R;

import java.util.List;

public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData>{
    private Context ctx;
    private List<DataModel> listData;

    public AdapterData(Context ctx, List<DataModel> listData) {
        this.ctx = ctx;
        this.listData = listData;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from ( parent.getContext () ).inflate ( R.layout.card_item,parent,
                false );
        HolderData holder = new HolderData ( layout );
        return  holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        DataModel dm = listData.get(position);

        holder.tvId.setText(String.valueOf( dm.getId()) );
        holder.tvNama.setText ( dm.getNama () );
        holder.tvAlamat.setText ( dm.getAlamat () );
        holder.tvTelepon.setText ( dm.getTelepon () );

    }

    @Override
    public int getItemCount() {
        return listData.size ();
    }

    public  class HolderData extends RecyclerView.ViewHolder {

        TextView tvId,tvNama, tvAlamat, tvTelepon;

        public HolderData(@NonNull View itemView) {
            super ( itemView );

            tvId = itemView.findViewById ( R.id.tv_id );
            tvNama = itemView.findViewById ( R.id.tv_nama);
            tvAlamat = itemView.findViewById ( R.id.tv_alamat);
            tvTelepon = itemView.findViewById ( R.id.tv_telepon);
        }
    }
}
