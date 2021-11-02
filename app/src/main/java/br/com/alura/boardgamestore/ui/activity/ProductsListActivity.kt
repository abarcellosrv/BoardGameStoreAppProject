package br.com.alura.boardgamestore.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.MenuInflater
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.boardgamestore.dao.ProductsDao
import br.com.alura.boardgamestore.databinding.ProductsListActivityBinding
import br.com.alura.boardgamestore.ui.recyclerview.adapter.ProductsListAdapter
import android.R
import android.view.Menu
import android.R.menu


class ProductsListActivity : AppCompatActivity() {

    private val dao = ProductsDao()
    private val adapter = ProductsListAdapter(context = this, products = dao.searchAll())
    private val binding by lazy {
        ProductsListActivityBinding.inflate(layoutInflater)
    }

    

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setRecyclerView()
        setFab()
    }

    override fun onResume() {
        super.onResume()
        adapter.updateList(dao.searchAll())
    }

    private fun setFab() {
        val fab = binding.productListFab
        fab.setOnClickListener {
            goToProductForm()
        }
    }

    private fun goToProductForm() {
        val intent = Intent(this, ProductForm::class.java)
        startActivity(intent)
    }

    private fun setRecyclerView() {
        val recyclerView = binding.productsListRecyclerview
        recyclerView.adapter = adapter
    }

}


