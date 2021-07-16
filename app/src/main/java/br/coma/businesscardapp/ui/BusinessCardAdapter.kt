package br.coma.businesscardapp.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.graphics.toColor
import androidx.core.graphics.toColorLong
import androidx.recyclerview.widget.ListAdapter as ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import br.coma.businesscardapp.R
import br.coma.businesscardapp.data.BusinessCard
import br.coma.businesscardapp.databinding.ItemBusinessCardBinding

class BusinessCardAdapter
    : ListAdapter<BusinessCard, BusinessCardAdapter.ViewHolder>(DiffCallback()) {
        var listennerShare: (View) -> Unit = {}


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBusinessCardBinding.inflate(inflater,parent,false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemBusinessCardBinding
    ):RecyclerView.ViewHolder(binding.root){
        fun bind (item: BusinessCard){
            binding.cardViewTvNome.text = item.name
            binding.cardViewTvPhone.text = item.phone
            binding.cardViewTvCompanyName.text = item.company
            binding.cardViewTvEmail.text = item.company
            binding.itemCardViewBusinessCard.setCardBackgroundColor(Color.parseColor(item.background))
            binding.itemCardViewBusinessCard.setOnClickListener{
                listennerShare(it)
            }
        }
    }
}

class DiffCallback: DiffUtil.ItemCallback<BusinessCard>(){
    override fun areItemsTheSame(oldItem: BusinessCard, newItem: BusinessCard) = oldItem == newItem
    override fun areContentsTheSame(oldItem: BusinessCard, newItem: BusinessCard) =
        oldItem.id == newItem.id

}