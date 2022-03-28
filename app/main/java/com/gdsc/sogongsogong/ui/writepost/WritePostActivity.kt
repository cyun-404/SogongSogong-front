package com.gdsc.sogongsogong.ui.writepost

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.gdsc.sogongsogong.NavViewModel
import com.gdsc.sogongsogong.R
import com.gdsc.sogongsogong.databinding.ActivityWritePostBinding
import com.gdsc.sogongsogong.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class WritePostActivity : BaseActivity<ActivityWritePostBinding>(R.layout.activity_write_post) {

    private val navViewModel: NavViewModel by viewModels {defaultViewModelProviderFactory}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setBinding()
        setCoroutine()
    }

    private fun setBinding() {
        binding.navViewModel = navViewModel
    }

    private fun setCoroutine() {
        lifecycleScope.launch {
            collectAddImageButton()
        }
    }

    private suspend fun collectAddImageButton() {
        navViewModel.addImageClickEvent.collect {
            requestGalleryAuthor()
            showGallery()
        }
    }

    private fun requestGalleryAuthor() {
        // TODO: 갤러리 접근권한 요청
    }

    private fun showGallery() {
        if (hasAuthor()) {
            // TODO: 갤러리 화면을 보여준다.
        }
        else {
            // TODO: 갤러리에 접근하지 않는다.
            // TODO: 다이얼로그로 표시
        }
    }

    private fun hasAuthor(): Boolean {
        // TODO: 갤러리 접근 권한을 확인한다.
        return false
    }
}