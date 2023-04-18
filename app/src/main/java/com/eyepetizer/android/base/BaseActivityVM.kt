package com.eyepetizer.android.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.eyepetizer.android.extension.showToast
import com.eyepetizer.android.ui.common.ui.BaseActivity

abstract class BaseActivityVM<AT : BaseActivity, VB : ViewDataBinding, VM : BaseViewModel<AT>>(
    private val layout: Int,
    private val clazz: Class<VM>
) :
    BaseActivity() {

    /**
     * 提供Activity对象
     */
    protected abstract fun setActivity(): AT

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dataBinding: VB = DataBindingUtil.setContentView(this, layout)
        val viewModel: VM = ViewModelProvider(this)[clazz]
        viewModel.activity = setActivity()
        onCreate(dataBinding, viewModel)
    }

    /**
     * 初始化界面
     *
     * @param dataBinding 界面绑定对象
     * @param viewModel 数据绑定对象
     */
    protected abstract fun onCreate(dataBinding: VB, viewModel: VM)

    /**
     * 显示提示  Toast
     * @param CharSequence 提示信息
     */
    fun showToast(CharSequence: String) {
        this.runOnUiThread {
            CharSequence.showToast()
            //Toast.makeText(this, CharSequence, Toast.LENGTH_SHORT).show()
        }
    }
}