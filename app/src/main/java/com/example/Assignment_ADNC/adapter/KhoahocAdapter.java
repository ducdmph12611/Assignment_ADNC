package com.example.Assignment_ADNC.adapter;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Assignment_ADNC.DAO.KhoahocDAO;
import com.example.Assignment_ADNC.R;
import com.example.Assignment_ADNC.model.Khoahoc;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class KhoahocAdapter extends RecyclerView.Adapter<KhoahocAdapter.ViewHolder> {
    List<Khoahoc> list;
    Context context;
    KhoahocDAO khoahocDAO;
    private static OnCallBackChi mListener;

    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    public KhoahocAdapter(List<Khoahoc> list, Context context){
        this.list = list;
        this.context = context;
        khoahocDAO = new KhoahocDAO(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_khoahoc,parent,false);
        khoahocDAO= new KhoahocDAO(context);
        return new KhoahocAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tenKhoahoc.setText(list.get(position).tenKhoahoc);
        holder.tenGiaovien.setText(list.get(position).tenGiaovien);
        final Khoahoc khoahoc = list.get(position);
        final String a = khoahoc.maKhoahoc;
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                khoahocDAO.delete(a);
                list.clear();
                list.addAll(khoahocDAO.getAll());
                list.remove(khoahoc);
                notifyDataSetChanged();
            }
        });
        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(khoahoc);
            }
        });
    }

    public void showDialog(final Khoahoc giaoDich){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.edit_khoahoc,null);
        final EditText tenKhoahoc = view.findViewById(R.id.edtTenKhoahoc);
        final EditText tenGiaovien = view.findViewById(R.id.edtTenGiangVien);
        final EditText soBuoihoc = view.findViewById(R.id.edtSoBuoiHoc);
        final TextView ngaybatdau = view.findViewById(R.id.tvNgaybatdau);
        final TextView ngayKT = view.findViewById(R.id.tvNgayKetthuc);
        final TextView ngaythi = view.findViewById(R.id.tvNgaythi);
        ImageView dateBD = view.findViewById(R.id.dateBatdau);
        ImageView dateKT = view.findViewById(R.id.dateKetthuc);
        ImageView dateThu = view.findViewById(R.id.dateThi);
        tenKhoahoc.setText(giaoDich.tenKhoahoc);
        soBuoihoc.setText(giaoDich.soBuoihoc);
        tenGiaovien.setText(giaoDich.tenGiaovien);
        String date = GetDay();
        ngaybatdau.setText(sdf.format(giaoDich.ngayBatdau));
        ngayKT.setText(sdf.format(giaoDich.ngayKetthuc));
        ngaythi.setText(sdf.format(giaoDich.ngaythi));
        dateBD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int myear = c.get(Calendar.YEAR);
                int mmonth = c.get(Calendar.MONTH);
                int mday = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        if (month<9){
                            ngaybatdau.setText(dayOfMonth + "-" + "0" + (month+1) + "-" + year);
                        }else {
                            ngaybatdau.setText(dayOfMonth + "-" + (month + 1) + "-" + year);
                        }
                    }
                }, myear, mmonth, mday);
                datePickerDialog.show();
            }
        });
        dateKT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int myear = c.get(Calendar.YEAR);
                int mmonth = c.get(Calendar.MONTH);
                int mday = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        if (month<9){
                            ngayKT.setText(dayOfMonth + "-" + "0" + (month+1) + "-" + year);
                        }else {
                            ngayKT.setText(dayOfMonth + "-" + (month + 1) + "-" + year);
                        }
                    }
                }, myear, mmonth, mday);
                datePickerDialog.show();
            }
        });
        dateThu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int myear = c.get(Calendar.YEAR);
                int mmonth = c.get(Calendar.MONTH);
                int mday = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        if (month<9){
                            ngaythi.setText(dayOfMonth + "-" + "0" + (month+1) + "-" + year);
                        }else {
                            ngaythi.setText(dayOfMonth + "-" + (month + 1) + "-" + year);
                        }
                    }
                }, myear, mmonth, mday);
                datePickerDialog.show();
            }
        });
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    String maGD1 = giaoDich.maKhoahoc;
                    String tenKhoahoc1 = tenKhoahoc.getText().toString();
                    String soBuoihoc1 = soBuoihoc.getText().toString();
                    String tenGiangvien1 = tenGiaovien.getText().toString();
                    Date ngayBD1 = sdf.parse(ngaybatdau.getText().toString());
                    Date ngayKT1 = sdf.parse(ngayKT.getText().toString());
                    Date ngayThi1 = sdf.parse(ngaythi.getText().toString());
                    if (khoahocDAO.update(new Khoahoc(maGD1, tenKhoahoc1, soBuoihoc1, tenGiangvien1, ngayBD1, ngayKT1, ngayThi1))==true){
                        Toast.makeText(context, "Sửa thành công!", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(context, "Sửa thất bại!"+ maGD1, Toast.LENGTH_SHORT).show();
                    }
                    list = new KhoahocDAO(context).getAll();
                    notifyDataSetChanged();
                }catch (Exception e){

                }
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setView(view);
        builder.show();
    }


    private String GetDay(){
        long time = System.currentTimeMillis();
        String day = sdf.format(time);
        return day;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addData(List<Khoahoc> list) {
        if (list != null) {
            this.list = list;
            notifyItemInserted(list.size() - 1);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView tenKhoahoc, tenGiaovien;
        public ImageView edit, delete;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tenKhoahoc = itemView.findViewById(R.id.txtTenKhoaHoc);
            tenGiaovien = itemView.findViewById(R.id.txtTenGiaoVien);
            edit = itemView.findViewById(R.id.btnEditKhoahoc);
            delete = itemView.findViewById(R.id.btnDeleteKhoahoc);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            int position = getLayoutPosition();
            if (getAdapterPosition() == RecyclerView.NO_POSITION) return;
            Khoahoc gd = list.get(position);
            final Dialog dialog = new Dialog(context);
            dialog.setContentView(R.layout.show_dialog);
            TextView tenKH, soBuoi, tenGV, ngayBD, ngayKT, ngayThi;
            ImageView i;
            tenKH = dialog.findViewById(R.id.txtShowtenKhoahoc);
            tenGV = dialog.findViewById(R.id.txtShowTenGiaoVien);
            soBuoi = dialog.findViewById(R.id.txtShowbuoihoc);
            ngayBD = dialog.findViewById(R.id.txtShowBD);
            ngayKT = dialog.findViewById(R.id.txtShowKT);
            ngayThi = dialog.findViewById(R.id.txtShowThi);
            i = dialog.findViewById(R.id.btnExit);
            tenKH.setText(gd.tenKhoahoc);
            tenGV.setText(gd.tenGiaovien);
            soBuoi.setText(gd.soBuoihoc);
            ngayBD.setText(sdf.format(gd.ngayBatdau));
            ngayKT.setText(sdf.format(gd.ngayKetthuc));
            ngayThi.setText(sdf.format(gd.ngaythi));
            i.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
            dialog.show();

        }
    }
    public interface OnCallBackChi{
        void onItemListener(int position);
    }

}
