package br.com.alura.boardgamestore.ui.dialog

import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import br.com.alura.boardgamestore.databinding.ImageFormBinding
import br.com.alura.boardgamestore.extensions.tryImageLoad

class ImageFormDialog(private val context: Context) {

    fun showImage(
        defaultURL: String? = null,
        whenImageLoads: (imagem: String) -> Unit
    )  {
        ImageFormBinding
            .inflate(LayoutInflater.from(context)).apply {

                defaultURL?.let {
                    imageFormImageview.tryImageLoad(it)
                    imageFormUrl.setText(it)
                }

                imageFormLoadButton.setOnClickListener {
                    val url = imageFormUrl.text.toString()
                    imageFormImageview.tryImageLoad(url)
                }

                AlertDialog.Builder(context)
                    .setView(root)
                    .setPositiveButton("Confirmar") { _, _ ->
                        val url = imageFormUrl.text.toString()
                        whenImageLoads(url)
                    }
                    .setNegativeButton("Cancelar") { _, _ ->

                    }
                    .show()
            }




    }

}