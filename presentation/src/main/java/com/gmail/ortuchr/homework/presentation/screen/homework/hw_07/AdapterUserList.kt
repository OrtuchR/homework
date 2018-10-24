package com.gmail.ortuchr.homework.presentation.screen.homework.hw_07

import android.graphics.drawable.Drawable
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.gmail.ortuchr.homework.R

class AdapterUserList(var onItemClick: (User) -> Unit) :
        RecyclerView.Adapter<AdapterUserList.MyViewHolder>() {

    var userListDataSet: List<User> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): MyViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.item_recycle_user_list, viewGroup, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int = userListDataSet.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val user = userListDataSet[position]
        holder.textName.text = user.name
        holder.textSurname.text = user.surname
        Glide.with(holder.userPicture.context).load(user.url)
                .listener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                        return false
                    }
                    override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                        holder.progressBar.visibility = ProgressBar.GONE
                        return false
                    }

                })
                .apply(RequestOptions.circleCropTransform()).into(holder.userPicture)

        holder.itemView.setOnClickListener {
            onItemClick(user)
        }
    }

    inner class MyViewHolder : RecyclerView.ViewHolder {
        val textName: TextView
        val textSurname: TextView
        val userPicture: ImageView
        val progressBar: ProgressBar

        constructor(view: View) : super(view) {
            textName = view.findViewById(R.id.textViewUserName)
            textSurname = view.findViewById(R.id.textViewUserSurname)
            userPicture = view.findViewById(R.id.imageViewUserPicture)
            progressBar = view.findViewById(R.id.progressBar)
        }
    }

    /*interface OnItemClick {
        fun onClick(user: User);
    }*/
}


