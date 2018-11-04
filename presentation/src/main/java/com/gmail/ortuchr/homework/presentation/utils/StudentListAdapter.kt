package com.gmail.ortuchr.homework.presentation.utils

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
import com.gmail.ortuchr.domain.entity.hw11.Student
import com.gmail.ortuchr.homework.R

class StudentListAdapter(var onItemClick: (Student) -> Unit) :
        RecyclerView.Adapter<StudentListAdapter.MyViewHolder>() {

    var studentListDataSet: List<Student> = emptyList()

    fun setData(data: List<Student>) {
        studentListDataSet = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): MyViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.item_recycle_student_list, viewGroup, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int = studentListDataSet.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val student = studentListDataSet[position]
        holder.textName.text = student.name
        holder.textAge.text = student.age.toString()
        Glide.with(holder.userPicture.context).load(student.url)
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
            onItemClick(student)
        }
    }

    inner class MyViewHolder : RecyclerView.ViewHolder {
        val textName: TextView
        val textAge: TextView
        val userPicture: ImageView
        val progressBar: ProgressBar

        constructor(view: View) : super(view) {
            textName = view.findViewById(R.id.textViewName)
            textAge = view.findViewById(R.id.textViewAge)
            userPicture = view.findViewById(R.id.imageViewUrl)
            progressBar = view.findViewById(R.id.progressBar)
        }
    }
}