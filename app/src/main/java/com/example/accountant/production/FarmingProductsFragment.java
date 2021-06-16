package com.example.accountant.production;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.example.accountant.R;

public class FarmingProductsFragment extends Fragment {
    EditText agro_pdt,maize_pdt,bean_pdt,sim_sim_pdt,g_nuts_pdt;
    Button save_records;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_farming_products, container, false);

        agro_pdt = root.findViewById(R.id.agro_pdt_ID);
        maize_pdt = root.findViewById(R.id.maize_pdt);
        bean_pdt = root.findViewById(R.id.bean_pdt);
        sim_sim_pdt = root.findViewById(R.id.sim_sim_pdt);
        g_nuts_pdt = root.findViewById(R.id.g_nuts_pdt);
        save_records = root.findViewById(R.id.save_record);

        return root;
    }
}
