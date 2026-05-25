package com.kumar.peoplehub.viewmodel

import com.kumar.peoplehub.model.User
import com.kumar.peoplehub.repository.UserRepository
import com.kumar.peoplehub.ui.list.UsersViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

@OptIn(ExperimentalCoroutinesApi::class)
class UsersViewModelTest {
    private val dispatcher = StandardTestDispatcher()

    private lateinit var repository: UserRepository

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        repository = mock()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `users loaded successfully`() = runTest {
        val users = listOf(
            User(
                id = 1,
                name = "John",
                company = "ABC",
                username = "john",
                email = "john@test.com",
                address = "Address",
                zip = "123456",
                state = "State",
                country = "Country",
                phone = "999999999",
                image = ""
            )
        )

        whenever(repository.getUsers()).thenReturn(users)
        val viewModel = UsersViewModel(repository)
        dispatcher.scheduler.advanceUntilIdle()
        assertEquals(1, viewModel.users.value.size)
    }
}