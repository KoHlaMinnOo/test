package com.example.app1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app1.databinding.FragmentMemberBinding
import kotlinx.android.synthetic.main.fragment_member.*


class MemberFragment : Fragment(),RecyclerAdapter.onItemClickListener {


    private val list=ArrayList<RecyclerListItem>()
    private val adapter=RecyclerAdapter(list,this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        list+=RecyclerListItem("A+","khmo","male","10/4/1996","123")
        list+=RecyclerListItem("O+","df","male","10/4/1996","123")
        list+=RecyclerListItem("AB-","khdsfsmo","male","10/4/1996","123")
        list+=RecyclerListItem("B+","khmo","male","10/4/1996","123")
        list+=RecyclerListItem("B-","df","male","10/4/1996","123")
        list+=RecyclerListItem("O-","khdsfsmo","male","10/4/1996","123")
        list+=RecyclerListItem("A-","khmo","male","10/4/1996","123")
        list+=RecyclerListItem("O+","df","male","10/4/1996","123")
        list+=RecyclerListItem("O+","khdsfsmo","male","10/4/1996","123")



        val binding:FragmentMemberBinding=DataBindingUtil.inflate(
            inflater,R.layout.fragment_member,container,false
        )
        binding.recyclerView.adapter=adapter
        binding.recyclerView.layoutManager=LinearLayoutManager(context)
        binding.recyclerView.setHasFixedSize(true)
        return binding.root
    }
    override fun onItemClick(position: Int) {
        Toast.makeText(context, "Item $position click", Toast.LENGTH_SHORT).show()
    }
}