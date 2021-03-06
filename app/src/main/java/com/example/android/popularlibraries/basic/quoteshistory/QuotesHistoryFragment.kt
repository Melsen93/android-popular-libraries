package com.example.android.popularlibraries.basic.quoteshistory

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android.popularlibraries.basic.listeners.BackButtonListener
import com.example.android.popularlibraries.databinding.QuotesHistoryFragmentBinding
import com.example.android.popularlibraries.di.BaseDaggerFragment
import com.example.android.popularlibraries.extensions.showToast
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class QuotesHistoryFragment : BaseDaggerFragment(), QuotesHistoryView, BackButtonListener {

    @Inject
    lateinit var quotesHistoryPresenterFactory: QuotesHistoryPresenterFactory

    companion object {
        fun newInstance(): Fragment = QuotesHistoryFragment()
    }

    private val binding: QuotesHistoryFragmentBinding by viewBinding(createMethod = CreateMethod.INFLATE)
    private val presenter by moxyPresenter { quotesHistoryPresenterFactory.create() }
    private var adapter: QuoteAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ) =
        binding.root

    override fun init() {
        with(binding) {
            adapter = QuoteAdapter(presenter = presenter)
            quotesRecyclerView.adapter = adapter
            quotesRecyclerView.itemAnimator = DefaultItemAnimator()
            quotesRecyclerView.addItemDecoration(DividerItemDecoration(context,
                LinearLayoutManager.VERTICAL))
        }
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun backPressed() = presenter.backPressed()

    override fun showException(throwable: Throwable) {
        requireContext().showToast(throwable.message)
    }
}