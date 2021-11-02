package br.com.alura.boardgamestore.extensions

import android.widget.ImageView
import coil.load

fun ImageView.tryImageLoad(url: String? = null){
    load(url) {
        fallback(br.com.alura.boardgamestore.R.drawable.error)
        error(br.com.alura.boardgamestore.R.drawable.error)
        placeholder(br.com.alura.boardgamestore.R.drawable.placeholder)
    }
}