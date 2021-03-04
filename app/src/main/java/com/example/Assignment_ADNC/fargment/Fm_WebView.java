package com.example.Assignment_ADNC.fargment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.fragment.app.Fragment;

import com.example.Assignment_ADNC.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fm_WebView extends Fragment {
    String link;
    WebView webView;

    public Fm_WebView() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_fm__web_view, container, false);
        webView = inflate.findViewById(R.id.webview);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            link = bundle.getString("link", null);
        }
        webView.loadUrl(link);
        webView.setWebViewClient(new WebViewClient());
        return inflate;
    }
}
