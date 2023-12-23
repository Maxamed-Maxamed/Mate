package com.example.hydrate_mate.Models

interface HydrateStore {


    fun findAll(userId: Int): List<HydrateGoal>

    // Create a new goal
    fun createGoal(goalAmountInMilliliters: Int, userId: Int): HydrateGoal

    // Read all active goals for a user
    fun getActiveGoals(userId: Int): List<HydrateGoal>

    // Update a goal (e.g., mark it as achieved)
    fun updateGoal(id: Int, isAchieved: Boolean)

    // Delete a goal
    fun deleteGoal(id: Int)



}




