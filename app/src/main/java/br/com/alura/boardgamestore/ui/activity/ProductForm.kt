package br.com.alura.boardgamestore.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.boardgamestore.dao.ProductsDao
import br.com.alura.boardgamestore.databinding.ProductFormActivityBinding
import br.com.alura.boardgamestore.extensions.tryImageLoad
import br.com.alura.boardgamestore.model.Product
import br.com.alura.boardgamestore.ui.dialog.ImageFormDialog
import java.math.BigDecimal

class ProductForm : AppCompatActivity() {

    private val binding by lazy {
        ProductFormActivityBinding.inflate(layoutInflater)
    }
    private var url: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        title = "Save Product"
        setSaveButton()
        binding.productFormImage.setOnClickListener {
            ImageFormDialog(this)
                .showImage(url) { image ->
                    url = image
                    binding.productFormImage.tryImageLoad(url)
                }
        }
    }

    private fun setSaveButton() {
        val botaoSalvar = binding.productFormSaveButton
        val dao = ProductsDao()
        botaoSalvar.setOnClickListener {
            val produtoNovo = createProduct()
            dao.addProduct(produtoNovo)
            finish()
        }
    }

    private fun createProduct(): Product {
        val nameText = binding.productFormName
        val name = nameText.text.toString()
        val descriptionText = binding.productFormDescription
        val description = descriptionText.text.toString()
        val priceTextInput = binding.productFormPrice
        val priceText = priceTextInput.text.toString()
        val price = if (priceText.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(priceText)
        }

        return Product(
            name = name,
            description = description,
            price = price,
            image = url,
            numberofPlayers = 1
        )
    }

}