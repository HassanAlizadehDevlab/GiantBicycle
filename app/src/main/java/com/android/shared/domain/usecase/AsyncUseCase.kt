package com.android.shared.domain.usecase

interface AsyncUseCase<P, R> {
    fun execute(param: P): R
}