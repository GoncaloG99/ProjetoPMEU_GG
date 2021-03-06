package ipvc.estg.projetopmeu_gg.adapters

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ipvc.estg.projetopmeu_gg.CellClickListener
import ipvc.estg.projetopmeu_gg.R
import ipvc.estg.projetopmeu_gg.entities.Nota

class NotaAdapter internal constructor(
    context: Context,
    private val cellClickListener: CellClickListener

) : RecyclerView.Adapter<NotaAdapter.NotaViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var notas = emptyList<Nota>()
    var selectedNota: Nota? = null
    private var selectedItem: TextView? = null

    class NotaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val notaItemView: TextView = itemView.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotaViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return NotaViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NotaViewHolder, position: Int) {
        val current = notas[position]
        holder.notaItemView.text = current.id.toString() + " - " + current.titulo + " - " + current.descricao

        holder.itemView.setOnClickListener {
            if(selectedItem!=null){
                selectedItem!!.setBackgroundColor(Color.WHITE);
            }
            selectedNota = current
            holder.notaItemView.setBackgroundColor(Color.CYAN);
            selectedItem = holder.notaItemView;
            cellClickListener.onCellClickListener(current)
        }
    }

    internal fun setNotas(notas: List<Nota>) {
        this.notas = notas
        notifyDataSetChanged()
    }

    override fun getItemCount() = notas.size
}