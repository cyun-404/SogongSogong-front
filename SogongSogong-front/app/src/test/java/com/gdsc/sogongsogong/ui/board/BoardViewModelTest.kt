package com.gdsc.sogongsogong.ui.board

import com.gdsc.sogongsogong.FakeDispatcherProvider
import com.gdsc.sogongsogong.di.dispatcher.DispatcherProvider
import com.gdsc.sogongsogong.repository.datasource.PostRemoteDataSource
import io.kotest.core.spec.Spec
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.setMain
import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test

@ExperimentalCoroutinesApi
@DelicateCoroutinesApi
class BoardViewModelTest : BehaviorSpec() {

    private val postRemoteDataSource = mockk<PostRemoteDataSource>()

    private val dispatcherProvider = FakeDispatcherProvider()

    private val boardViewModel = BoardViewModel(dispatcherProvider, postRemoteDataSource)

    override fun beforeSpec(spec: Spec) {
        Dispatchers.setMain(dispatcherProvider.main)
    }

    init {
        Given("게시판 화면에서") {

            When("게시글을 선택하면") {
                // TODO:
                boardViewModel.emitRecyclerViewClickEvent()

                Then("해당 아이디의 게시글을 불러온다.") {
                    // TODO
                    "a" shouldBe "a"
                }
            }
        }
    }
}