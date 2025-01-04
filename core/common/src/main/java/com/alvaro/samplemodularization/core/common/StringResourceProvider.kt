package com.alvaro.samplemodularization.core.common

import androidx.annotation.StringRes

interface StringResourceProvider {

    fun getString(@StringRes stringResId: Int): String
}