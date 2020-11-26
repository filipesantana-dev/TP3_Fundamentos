package com.example.tp3_fundamentos

data class Question (
        val id: Int,
        val question: String,
        val optionOne: String,
        val optionTwo: String,
        val optionThree: String,
        val optionFour: String?,
        val optionFive: String?,
        val optionOneScore: Int,
        val optionTwoScore: Int,
        val optionThreeScore: Int,
        val optionFourScore: Int?,
        val optionFiveScore: Int?
)