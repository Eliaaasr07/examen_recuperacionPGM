package com.example.consesionariorodriguez;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class AutosAdapter extends RecyclerView.Adapter<AutosAdapter.AutosViewHolder> {

    private List<Auto> listaAutos;

    public AutosAdapter(List<Auto> listaAutos) {
        this.listaAutos = listaAutos;
    }

    @NonNull
    @Override
    public AutosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_auto, parent, false);
        return new AutosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AutosViewHolder holder, int position) {
        Auto auto = listaAutos.get(position);
        holder.textViewMarca.setText(auto.getMarca());
        holder.textViewModelo.setText(auto.getModelo());
        holder.textViewAno.setText(auto.getAño());
        holder.textViewNumMotor.setText(auto.getNumero_de_motor());
        holder.textViewNumChasis.setText(auto.getNumero_de_chasis());
    }

    @Override
    public int getItemCount() {
        return listaAutos.size();
    }

    class AutosViewHolder extends RecyclerView.ViewHolder {

        TextView textViewMarca, textViewModelo, textViewAno, textViewNumMotor, textViewNumChasis;

        public AutosViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewMarca = itemView.findViewById(R.id.textViewMarca);
            textViewModelo = itemView.findViewById(R.id.textViewModelo);
            textViewAno = itemView.findViewById(R.id.textViewAno);
            textViewNumMotor = itemView.findViewById(R.id.textViewNumMotor);
            textViewNumChasis = itemView.findViewById(R.id.textViewNumChasis);
        }
    }
}
