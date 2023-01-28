package com.example.youtube.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.viewbinding.ViewBinding
import com.example.youtube.R

typealias Inflate<VB> = (LayoutInflater, ViewGroup?, Boolean) -> VB

abstract class BaseFragment<VB : ViewBinding, VM : BaseViewModel, T>
    (val inflate: Inflate<VB>) : Fragment() {

    private var _binding: VB? = null
    private val binding get() = _binding!!

    private var _controller: NavController? = null
    protected val controller get() = _controller!!

    protected abstract val viewModel: VM

    protected fun binding(): VB {
        return binding
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflate.invoke(layoutInflater, container,false)
        val navHostFragment =  requireActivity().supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        _controller = navHostFragment.navController
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initViewModel()

    }
    abstract fun initView()
    abstract fun initViewModel()
}