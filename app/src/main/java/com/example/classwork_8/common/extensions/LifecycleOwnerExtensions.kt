package com.example.classwork_8.common.extensions

import android.app.Activity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

fun LifecycleOwner.asynchronously(
    context: CoroutineContext = EmptyCoroutineContext,
    action: suspend (CoroutineScope) -> Unit
) {
    when (this) {
        is Activity -> {
            lifecycleScope.launch(context) {
                action(this)
            }
        }
        is Fragment -> {
            viewLifecycleOwner.lifecycleScope.launch(context) {
                repeatOnLifecycle(Lifecycle.State.STARTED) {
                    action(this)
                }
            }
        }
    }
}