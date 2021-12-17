package com.example.cliprestproyect.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.cliprestproyect.R
import com.example.cliprestproyect.data.model.Results
import com.example.cliprestproyect.ui.view.OnClickInterface
import com.squareup.picasso.Picasso

class UserAdapter(val context : Context, var results: List<Results>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    val onClickIterface : OnClickInterface = context as OnClickInterface;

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context);
        return UserViewHolder(layoutInflater.inflate(R.layout.row_user, parent, false));
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.render(results[position]);
        holder.card_user.setOnClickListener {
            onClickIterface.onClickUserRowCallback(results[position]);
        }
    }

    override fun getItemCount(): Int {
        if (results.isNullOrEmpty()) {
            return 0;
        }
        return results.size;
    }

    fun updateAdapater(newData : List<Results>){
        results = newData;
        notifyDataSetChanged();
    }

    class UserViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        lateinit var card_user : CardView;
        lateinit var name_user: TextView;
        lateinit var last_user: TextView;
        lateinit var img_user: ImageView;

        fun render(result: Results) {
            card_user = view.findViewById(R.id.card_user);
            name_user = view.findViewById(R.id.name_user);
            last_user = view.findViewById(R.id.last_user);
            img_user = view.findViewById(R.id.img_user);

            name_user.text = result.name.first;
            last_user.text = result.name.last;
            Picasso.get().load(result.picture.thumbnail).into(img_user);

        }

    }

}