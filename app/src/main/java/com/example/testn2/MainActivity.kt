package com.example.testn2

import android.os.Bundle
import android.util.Log.d
import androidx.appcompat.app.AppCompatActivity
import com.example.testn2.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val wordsList = mutableListOf<String>()
    private val anagramList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        listeners()
    }

    private fun listeners() {
        binding.btnSave.setOnClickListener {

            val anagram = binding.etAnagramInput.text.toString()

            addAnagram(anagram)
            binding.etAnagramInput.text?.clear()

        }

        binding.btnOutput.setOnClickListener {

            showAnagrams()
            binding.etAnagramInput.text?.clear()

        }
    }

    private fun addAnagram(anagram: String) {
        wordsList.add(anagram)
        d("anagrams", "$wordsList")
    }

    private fun showAnagrams() {
        binding.anagramOutput.text = groupAnagrams()
        d("anagrams", "$anagramList")
    }

    private fun groupAnagrams(): CharSequence {
        wordsList.forEach { elem1 ->
            wordsList.forEach { elem2 ->
                if (elem1.toSortedSet() == elem2.toSortedSet() && elem1 !in anagramList) {
                    if ((elem1 != elem2)) {
                        anagramList.add(elem1)
                    }
                }
            }
        }


        return anagramList.toString()

//  შემოყვანილი სიტყვებიდან გავიგე რომლები იყო ანაგრამები და მინდოდა(ჰეშკოდით დამედგინა თითოეული დასორტირებული სიტყვის იდენტურობა)
//  თითოეული სიტყვებისთვის ცალკე ლისტი გამეკეთებინა
// რომელიც გამოიძახებოდა ყოველჯერზე და დაამატებდა დაჯგუფებულ ანაგრამულ სიტყვებს უბრალოდ დროში ვერ ჩავეტიე.


//val seperatedListOfAnagrams = mutableListOf<String>()
//        anagramList.forEach { elem1->
//            anagramList.forEach { elem2->
//                if (elem1.toSortedSet().hashCode() == elem2.toSortedSet().hashCode() && elem1 !in seperatedListOfAnagrams){
//                    if ((elem1 != elem2)) {
//                        seperatedListOfAnagrams.add(elem1)
//                    }
//                }
//            }
//        }
//        return seperatedListOfAnagrams.toString()


    }
}