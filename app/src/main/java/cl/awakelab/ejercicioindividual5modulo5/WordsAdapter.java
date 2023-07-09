package cl.awakelab.ejercicioindividual5modulo5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cl.awakelab.ejercicioindividual5modulo5.databinding.ItemBinding;

public class WordsAdapter extends RecyclerView.Adapter<WordsAdapter.ViewHolder> {

    private List<String> words;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {

        TextView textView;
        ItemBinding binding;

        public ViewHolder(@NonNull ItemBinding binding, View itemView, Context context) {
            super(binding.getRoot());
            this.binding = binding;
            this.textView = (TextView) itemView.findViewById(R.id.textView);

//            itemView.setOnClickListener(new View.OnClickListener(){
//                @Override
//                public void onClick(View v) {
//                    int pos = getAdapterPosition();
//                    if (pos != RecyclerView.NO_POSITION) {
//                        RvDataItem clickedDataItem = dataItems.get(pos);
//                        Toast.makeText(v.getContext(), "You clicked", clickedDataItem.getName(), Toast.LENGTH_SHORT).show();
//                    }
//                }
//            });

        }

        public ViewHolder(@NonNull ItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        @Override
        public void onClick(View view) {
            int position  =   getAdapterPosition();
            

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
        ItemBinding binding = ItemBinding.bind(holder.itemView);
        holder.itemView.setOnClickListener(v -> {
            binding.textView.setText("Clicked " + word);
        });
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
