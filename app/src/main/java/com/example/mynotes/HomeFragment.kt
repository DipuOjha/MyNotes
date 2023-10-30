package com.example.mynotes

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment: Fragment(R.layout.home_frag) {
    lateinit var recview:RecyclerView
     lateinit var adapterForList : Adapterforre
     lateinit var homeViewModel: HomeViewModel
     lateinit var viewModelFactory : HomeViewModelProvider
     lateinit var repo: NotesRepo
     lateinit var dao: NotesDao
     val TAG ="Homefragmenttag"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

         dao = Dbclass.getInstance(requireActivity())?.getNoteDao()!!
         repo = NotesRepo(dao)

         viewModelFactory = HomeViewModelProvider(repo)
         homeViewModel = viewModelFactory.create(HomeViewModel::class.java)
         adapterForList = Adapterforre()
    }
    //lateinit var adapterforrec:
    /* override fun onCreateView(
         inflater: LayoutInflater,
         container: ViewGroup?,
         savedInstanceState: Bundle?
     ): View? {
         return super.onCreateView(inflater, container, savedInstanceState)
         return inflater.inflate(R.layout.home_frag,container)

     }*/
   /* override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }*/

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG,"Hi from home")
       // var btninfrag = view.findViewById<Button>(R.id.addBtn)
      //  btninfrag.visibility = View.INVISIBLE
         recview = view.findViewById<RecyclerView>(R.id.recview)


       //display()
        setUp()
       // var btn = view.findViewById<Button>(R.id.addBtn)
       /* btn.setOnClickListener {
            fragmentManager?.beginTransaction()?.replace(R.id.ll,CreateFragment())?.commit()
        }*/
    }
    fun setUp(){
        recview.layoutManager = GridLayoutManager(requireActivity(),2)
       // display()
        recview.adapter = adapterForList

        display()
       // adapterForList.notifyDataSetChanged()
        //  recview.adapter =
    }
    fun display(){
        homeViewModel.getNotes().observe(viewLifecycleOwner, Observer {
            Log.d(TAG,it.size.toString())
            adapterForList.setList(it as ArrayList<Note>)
        })


    }
}