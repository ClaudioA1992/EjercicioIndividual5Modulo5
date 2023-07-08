package cl.awakelab.ejercicioindividual5modulo5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cl.awakelab.ejercicioindividual5modulo5.databinding.ItemBinding;

public class WordsAdapter extends RecyclerView.Adapter<WordsAdapter.ViewHolder> {

    private List<String> words;

    public class ViewHolder extends RecyclerView.ViewHolder {


        ItemBinding binding;
        public ViewHolder(@NonNull ItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        public void bindMostrarInformacion(String word) {
            binding.textView.setText(word);
        }
    }

    @NonNull
    @Override
    public WordsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBinding binding = ItemBinding.inflate(LayoutInflater.from(parent.getContext()));
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull WordsAdapter.ViewHolder holder, int position) {
        String word = words.get(position);
        holder.bindMostrarInformacion(word);
    }

    @Override
    public int getItemCount() {
        return words.size();
    }

    public void setData(List<String> data) {
        this.words = data;
    }

    public List<String> getData() { return this.words; };

}
