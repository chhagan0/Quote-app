package com.example.quotify

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel


   private val quotetext:TextView
    get() = findViewById(R.id.quoteText)

    private val quoteauthor:TextView
    get() = findViewById(R.id.authortext)
lateinit var toolbar: Toolbar

lateinit var heart: heart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       onOptionsItemSelected()


        mainViewModel= ViewModelProvider(this, MainViewModelFactory(application))[MainViewModel::class.java]
        setQuote(mainViewModel.getQuote())


    }

    fun setQuote(quote: Quote){
        quotetext.text=quote.text
        quoteauthor.text=quote.author
    }

    fun onPrevious(view: View) {
        setQuote(mainViewModel.previousQuote())

    }

    fun onNext(view: View) {
        setQuote(mainViewModel.nextQuote())

    }
    fun onShare(view: View) {
        val intent=Intent(Intent.ACTION_SEND)
        intent.setType("text/plan")
         intent.putExtra(Intent.EXTRA_TEXT,mainViewModel.getQuote().text)
        startActivity(intent)
    }
}