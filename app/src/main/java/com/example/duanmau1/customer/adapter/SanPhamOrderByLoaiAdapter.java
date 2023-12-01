package com.example.duanmau1.customer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duanmau1.R;
import com.example.duanmau1.model.LoaiMoHinh;
import com.example.duanmau1.model.MoHinh;

import java.util.List;

public class SanPhamOrderByLoaiAdapter extends RecyclerView.Adapter<SanPhamOrderByLoaiAdapter.SanPhamOrderByLoaiViewHolder> {
    Context context;
    List<LoaiMoHinh> loaiMoHinhList;
    List<List<MoHinh>> listsListMoHinh;

    public SanPhamOrderByLoaiAdapter(Context context, List<LoaiMoHinh> loaiMoHinhList, List<List<MoHinh>> listsListMoHinh) {
        this.context = context;
        this.loaiMoHinhList = loaiMoHinhList;
        this.listsListMoHinh = listsListMoHinh;
    }

    @NonNull
    @Override
    public SanPhamOrderByLoaiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_san_pham_order_by_loai, parent, false);
        return new SanPhamOrderByLoaiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SanPhamOrderByLoaiViewHolder holder, int position) {
        LoaiMoHinh loaiMoHinh = loaiMoHinhList.get(position);
        holder.tvNameLoai.setText(loaiMoHinh.getTenLoai());
        List<MoHinh> moHinhList = listsListMoHinh.get(position);
        LinearLayoutManager manager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        SanPhamUserAdapter sanPhamUserAdapter = new SanPhamUserAdapter(context, moHinhList);
        holder.recSpByLoai.setAdapter(sanPhamUserAdapter);
        holder.recSpByLoai.setLayoutManager(manager);
    }

    @Override
    public int getItemCount() {
        return loaiMoHinhList.size();
    }

    public class SanPhamOrderByLoaiViewHolder extends RecyclerView.ViewHolder {
        TextView tvNameLoai, tvXemTatCa;
        RecyclerView recSpByLoai;
        public SanPhamOrderByLoaiViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNameLoai = itemView.findViewById(R.id.tv_loaiItemSpByLoai);
            tvXemTatCa = itemView.findViewById(R.id.tv_xemTatCa);
            recSpByLoai = itemView.findViewById(R.id.rec_sanPhamItemSpOrderByLoai);
        }
    }
}
