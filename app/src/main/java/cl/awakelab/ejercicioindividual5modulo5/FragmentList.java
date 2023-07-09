package cl.awakelab.ejercicioindividual5modulo5;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cl.awakelab.ejercicioindividual5modulo5.databinding.FragmentListBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentList#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentList extends Fragment {

    private FragmentListBinding binding;
    List<String> data = getData();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentList() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentList.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentList newInstance(String param1, String param2) {
        FragmentList fragment = new FragmentList();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        
        binding = FragmentListBinding.inflate(getLayoutInflater());
        WordsAdapter adapter = new WordsAdapter();
        // Inflate the layout for this fragment
        adapter.setData(getData());
        binding.recyclerView.setAdapter(adapter);
        initListener();
        return binding.getRoot();

    }

    public void initListener() {
        binding.floatingButton.setOnClickListener(v -> {
            data.add("Palabra " + data.size());
            binding.recyclerView.getAdapter().notifyItemInserted(data.size());
            binding.recyclerView.smoothScrollToPosition(data.size());
        });
    }

    public List<String> getData() {
        List<String> data = new ArrayList<String>();
        for(int i = 0; i < 20; i++) {
            data.add("Palabra " + i);
        }
        return data;
    }

}
