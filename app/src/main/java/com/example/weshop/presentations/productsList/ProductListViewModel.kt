package com.example.weshop.presentations.productsList

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weshop.data.WeShopRepository
import com.example.weshop.data.di.MainDispatcher
import com.example.weshop.data.remote.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
    @MainDispatcher private val dispatcher: CoroutineDispatcher,
    private val weShopRepository: WeShopRepository
): ViewModel() {
    private val _state = mutableStateOf(ProductListScreenState(
        products = listOf(),
        categories = listOf(),
        isLoading = true
    ))
    val state get() = _state
    private val exception = CoroutineExceptionHandler{_,exception->
        _state.value = _state.value.copy(
            products = listOf(),
            categories = listOf(),
            isLoading = false,
            error = exception.localizedMessage
        )
    }
    init {
        viewModelScope.launch(dispatcher + exception) {
            val products = getProducts()
            val categories = getCategories()
            _state.value = _state.value.copy(
                products = products,
                categories = categories,
                isLoading = false
            )
        }
    }
    private suspend fun getProducts(): List<Product>{
        return weShopRepository.getProducts()
    }
    private suspend fun getCategories(): List<String>{
        return weShopRepository.getCategories()
    }
}