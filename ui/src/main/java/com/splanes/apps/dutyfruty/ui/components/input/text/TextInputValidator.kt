package com.splanes.apps.dutyfruty.ui.components.input.text

import android.util.Patterns

interface TextInputValidator {
    val error: String
    fun isValid(input: String): Boolean

    data class Mandatory(override val error: String) : TextInputValidator {
        private val regex = Regex("^.*(\\w)+.*$")
        override fun isValid(input: String): Boolean = regex.matches(input)
    }

    data class Email(override val error: String) : TextInputValidator {
        private val regex = Patterns.EMAIL_ADDRESS.pattern().toRegex()
        override fun isValid(input: String): Boolean = regex.matches(input)
    }

    data class Password(override val error: String) : TextInputValidator {
        private val regex = Regex("^.*(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}.*$")
        override fun isValid(input: String): Boolean = regex.matches(input)
    }

    companion object
}
