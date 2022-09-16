package com.example.classwork_8.presentation

import com.example.classwork_8.common.base.BaseViewModel
import com.example.classwork_8.common.utils.State
import com.example.classwork_8.data.remote.dto.OutfitDto
import com.example.classwork_8.domain.usecase.GetOutfitsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getOutfitsUseCase: GetOutfitsUseCase
) : BaseViewModel() {

    private val _outfitsFlow = MutableStateFlow(State<List<OutfitDto>>())
    val outfitsFlow get() = _outfitsFlow.asStateFlow()

    suspend fun getOutfits() {
        handleResponse(getOutfitsUseCase(), _outfitsFlow.value).collect {
            _outfitsFlow.emit(it)
        }
    }

}