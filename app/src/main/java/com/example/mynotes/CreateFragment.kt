package com.example.mynotes

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import kotlin.concurrent.fixedRateTimer
import kotlin.random.Random

class CreateFragment:Fragment(R.layout.create_note_frag) {
    lateinit var createViewModel:CreateViewModel
    lateinit var titleEt:EditText
    lateinit var desEt:EditText
    lateinit var createviewmodelfactory:CraeteViewModelProvider
    lateinit var notesRepo: NotesRepo
    lateinit var notesDao: NotesDao
    val TAGE = "Createfragmenttag"
  //  lateinit var createFragment: CreateFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  createViewModel = ViewModelProvider(requireActivity()).get(CreateViewModel::class.java)

    }
   /* override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.create_note_frag,container)
            }*/

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAGE, "Hi from create")
        notesDao = Dbclass.getInstance(requireActivity())?.getNoteDao()!!
        notesRepo = NotesRepo(notesDao)
        createviewmodelfactory = CraeteViewModelProvider(notesRepo = notesRepo )
        createViewModel = createviewmodelfactory.create(CreateViewModel::class.java)
        titleEt = view.findViewById(R.id.title)
        desEt = view.findViewById(R.id.des)
        var btn = view.findViewById<Button>(R.id.addItem)
        btn.setOnClickListener {
            var titleval = titleEt.text.toString()
            var desVal = desEt.text.toString()
            val id = (0..100).random()

            createViewModel.addNote(Note( id,titleval, desVal))
            replacefrag()
          //  showNotes()

        }
    }
    fun replacefrag(){
        fragmentManager?.beginTransaction()?.replace(R.id.ll,HomeFragment())?.commit()
    }
       /* fun showNotes(){
            Log.d("hi",createViewModel.getNotes().toString())
        }*/
    }
