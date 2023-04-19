package com.example.weshop.presentations.productDetails

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weshop.data.WeShopRepository
import com.example.weshop.data.di.MainDispatcher
import com.example.weshop.data.remote.Product
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

class ProductDetailsViewModel @Inject constructor(
    @MainDispatcher private val dispatcher: CoroutineDispatcher,
    private val weShopRepository: WeShopRepository,
    stateHandle: SavedStateHandle
) :ViewModel(){
    private val _state = mutableStateOf(
        ProductDetailScreenState(
            isLoading = true
        ))
    val state get()= _state
    private val exception = CoroutineExceptionHandler{_,exception->
        _state.value = _state.value.copy(
            isLoading = false,
            error = exception.localizedMessage
        )
    }
    init {
        val id = stateHandle.get<Int?>("product_id")?:0
        viewModelScope.launch(dispatcher + exception) {
            val product = getProduct(id)
            _state.value = _state.value.copy(
                product  = product,
                isLoading = false
            )
        }
    }
    private suspend fun getProduct(id:Int): Product{
        return weShopRepository.getProduct(id)
    }
}