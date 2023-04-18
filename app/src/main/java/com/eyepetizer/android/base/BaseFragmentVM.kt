package com.eyepetizer.android.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.eyepetizer.android.extension.showToast
import com.eyepetizer.android.ui.common.ui.BaseActivity

abstract class BaseFragmentVM<AT : BaseActivity, VB : ViewDataBinding, VM : BaseViewModel<AT>>(
    private val layout: Int,
    private val clazz: Class<VM>
) :
    Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val dataBinding: VB = DataBindingUtil.inflate(inflater, layout, container, false)
        val viewModel: VM = ViewModelProvider(requireActivity())[clazz]
        onCreateView(dataBinding, viewModel)
        return dataBinding.root
    }

    /**
     * 初始化界面
     *
     * @param dataBinding 界面绑定对象
     * @param viewModel 数据绑定对象
     */
    protected abstract fun onCreateView(dataBinding: VB, viewModel: VM)

    /**
     * 显示提示  Toast
     * @param CharSequence 提示信息
     */
    fun showToast(CharSequence: String) {
        requireActivity().runOnUiThread {
            CharSequence.showToast()
           // Toast.makeText(requireActivity(), CharSequence, Toast.LENGTH_SHORT).show()
        }
    }
}