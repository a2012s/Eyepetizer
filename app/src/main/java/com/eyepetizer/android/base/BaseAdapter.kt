package com.eyepetizer.android.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.chad.library.adapter.base.BaseQuickAdapter
import com.zhpan.bannerview.BaseViewHolder
//
//abstract class BaseAdapter<T, VB : ViewBinding>(data: MutableList<T>) :
//    BaseQuickAdapter<T, BaseAdapter.ViewHolder<VB>>(0, data) {
//
//    abstract fun createViewBinding(inflater: LayoutInflater, parent: ViewGroup): VB
//
//    override fun onCreateDefViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<VB> {
//        val viewBinding = createViewBinding(LayoutInflater.from(parent.context), parent)
//        return ViewHolder(viewBinding, viewBinding.root)
//    }
//
//    class ViewHolder<VB : ViewBinding>(val dataBinding: VB, view: View) : BaseViewHolder(view)
//}