package com.example.Assignment_ADNC.fargment;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Assignment_ADNC.DAO.KhoahocDAO;
import com.example.Assignment_ADNC.R;
import com.example.Assignment_ADNC.adapter.KhoahocAdapter;
import com.example.Assignment_ADNC.model.Khoahoc;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */

public class KhoahocFragment extends Fragment {
    List<Khoahoc> list;
    RecyclerView lv;
    FloatingActionButton fb;
    KhoahocDAO khoahocDAO;
    KhoahocAdapter khoahocAdapter;
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    public KhoahocFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_khoahoc, container, false);
        lv = view.findViewById(R.id.lvKhoahoc);
        fb = view.findViewById(R.id.btnAddKhoahoc);
        list = new ArrayList<>();
        khoahocDAO = new KhoahocDAO(getActivity());
        try {
            list = khoahocDAO.getAll();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        khoahocAdapter = new KhoahocAdapter(list, getActivity());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        lv.setLayoutManager(linearLayoutManager);
        lv.setAdapter(khoahocAdapter);

        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                LayoutInflater layoutInflater = getActivity().getLayoutInflater();
                View view1 = layoutInflater.inflate(R.layout.add_khoahoc, null);
                final EditText tenKhoahoc = view1.findViewById(R.id.edtTenKhoahocadd);
                final EditText tenGiaovien = view1.findViewById(R.id.edtTenGiangVienadd);
                final EditText soBuoihoc = view1.findViewById(R.id.edtSoBuoiHocadd);
                final TextView ngaybatdau = view1.findViewById(R.id.tvNgaybatdauadd);
                final TextView ngayKT = view1.findViewById(R.id.tvNgayKetthucadd);
                final TextView ngaythi = view1.findViewById(R.id.tvNgaythiadd);
                ImageView dateBD = view1.findViewById(R.id.dateBatdauadd);
                ImageView dateKT = view1.findViewById(R.id.dateKetthucadd);
                ImageView dateThu = view1.findViewById(R.id.dateThiadd);
                String date = GetDay();
                ngaybatdau.setText(date);
                ngayKT.setText(date);
                ngaythi.setText(date);
                dateBD.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final Calendar c = Calendar.getInstance();
                        int myear = c.get(Calendar.YEAR);
                        int mmonth = c.get(Calendar.MONTH);
                        int mday = c.get(Calendar.DAY_OF_MONTH);
                        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                                if (month < 9) {
                                    ngaybatdau.setText(dayOfMonth + "-" + "0" + (month + 1) + "-" + year);
                                } else {
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
                        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                                if (month < 9) {
                                    ngayKT.setText(dayOfMonth + "-" + "0" + (month + 1) + "-" + year);
                                } else {
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
                        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                                if (month < 9) {
                                    ngaythi.setText(dayOfMonth + "-" + "0" + (month + 1) + "-" + year);
                                } else {
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
                            String tenKhoahoc1 = tenKhoahoc.getText().toString();
                            String soBuoihoc1 = soBuoihoc.getText().toString();
                            String tenGiangvien1 = tenGiaovien.getText().toString();
                            Date ngayBD1 = sdf.parse(ngaybatdau.getText().toString());
                            Date ngayKT1 = sdf.parse(ngayKT.getText().toString());
                            Date ngayThi1 = sdf.parse(ngaythi.getText().toString());
                            if (tenKhoahoc1.trim().isEmpty() && soBuoihoc1.trim().isEmpty() && tenGiangvien1.trim().isEmpty()) {
                                Toast.makeText(getActivity(), "Các trường không được để trống!", Toast.LENGTH_SHORT).show();
                            } else {
                                if (khoahocDAO.insert(new Khoahoc(tenKhoahoc1, soBuoihoc1, tenGiangvien1, ngayBD1, ngayKT1, ngayThi1)) == true) {
                                    list.clear();
                                    list.addAll(khoahocDAO.getAll());
                                    khoahocAdapter.notifyDataSetChanged();
                                    Toast.makeText(getActivity(), "Thêm khóa học thành công", Toast.LENGTH_SHORT).show();
//
//                                lv.scrollToPosition(khoahocDAO.getAll1().size() - 1);
//                                lv.setAdapter(khoahocAdapter);
                                } else {
                                    Toast.makeText(getContext(), "Thêm khóa học thất bại!", Toast.LENGTH_SHORT).show();
                                }
                            }

                        } catch (Exception e) {

                        }
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setView(view1);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
        return view;
    }

    private String GetDay() {
        long time = System.currentTimeMillis();
        String day = sdf.format(time);
        return day;
    }
}
