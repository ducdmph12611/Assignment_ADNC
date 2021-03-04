package com.example.Assignment_ADNC.fargment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.Assignment_ADNC.R;
import com.example.Assignment_ADNC.adapter.Adapter_TheLoaiTinTuc;
import com.example.Assignment_ADNC.model.ListRss;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {
    private RecyclerView rcv;
    public static ArrayList<ListRss> list = new ArrayList<>();
    Adapter_TheLoaiTinTuc adapterTheLoaiTinTuc;

    public NewsFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_news, container, false);
        rcv = view.findViewById(R.id.listRss);
        list.clear();
        list.add(new ListRss("VnExpress", "https://vnexpress.net/rss/giao-duc.rss", R.drawable.vnexp));
        list.add(new ListRss("Báo 24H", "https://cdn.24h.com.vn/upload/rss/giaoducduhoc.rss", R.drawable.rss24h));
        list.add(new ListRss("Thanh Niên", "https://vnexpress.net/rss/kinh-doanh.rss", R.drawable.thanhnien));
        list.add(new ListRss("Zing", "https://vnexpress.net/rss/giai-tri.rss", R.drawable.zingnews));


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rcv.setLayoutManager(layoutManager);
        adapterTheLoaiTinTuc = new Adapter_TheLoaiTinTuc(getActivity(), list);
        rcv.setAdapter(adapterTheLoaiTinTuc);

        return view;
    }
}
