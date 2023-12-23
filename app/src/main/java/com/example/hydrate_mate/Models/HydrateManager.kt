package com.example.hydrate_mate.Models

// HydrateManager.kt
import timber.log.Timber

class HydrateManager : HydrateStore {
    val hydrateArray = ArrayList<HydrateGoal>()
    private val goals = mutableListOf<HydrateGoal>()
    private var lastGoalId = 0



    fun logAll() {
        Timber.v("** Hydrate Goals List **")
        hydrateArray.forEach { Timber.v("HYDRATE GOAL ${it}") }
    }


    // Implement the findAll method to retrieve all hydration goals for a specific user
    /**
     * The function `findAll` returns a list of `HydrateGoal` objects filtered by the provided
     * `userId`.
     *
     * @param userId The `userId` parameter is an integer that represents the unique identifier of a
     * user.
     * @return a list of `HydrateGoal` objects.
     */
    override fun findAll(userId: Int): List<HydrateGoal> {
        return goals.filter { it.userId == userId }
    }


    // Create a new hydration goal

    /**
     * The function creates a new hydration goal with a specified amount and user ID, adds it to a list
     * of goals, and returns the created goal.
     *
     * @param goalAmountInMilliliters The goal amount in milliliters is the target amount of water that
     * the user wants to consume. It represents the desired daily water intake for the user.
     * @param userId The `userId` parameter is an integer that represents the unique identifier of the
     * user for whom the goal is being created.
     * @return a newly created `HydrateGoal` object.
     */
    override fun createGoal(goalAmountInMilliliters: Int, userId: Int): HydrateGoal {
        val newGoal = HydrateGoal(++lastGoalId, goalAmountInMilliliters, userId, isAchieved = false)
        goals.add(newGoal)
        return newGoal
    }

    /**
     * The function `getActiveGoals` returns a list of active hydration goals for a given user.
     *
     * @param userId The `userId` parameter is an integer that represents the unique identifier of a
     * user. It is used to filter the hydration goals and retrieve only the active goals for that
     * specific user.
     * @return a list of active hydration goals for a specific user.
     */
    // Read all active hydration goals for a user
    override fun getActiveGoals(userId: Int): List<HydrateGoal> {
        return goals.filter { it.userId == userId && !it.isAchieved }
    }

    // Update a hydration goal (e.g., mark it as achieved)
    /**
     * The function updates the achievement status of a goal with the given ID.
     *
     * @param id The id parameter is an integer that represents the unique identifier of the goal that
     * needs to be updated.
     * @param isAchieved A boolean value indicating whether the goal has been achieved or not.
     */
    override fun updateGoal(id: Int, isAchieved: Boolean) {
        val goal = goals.find { it.id == id }
        goal?.isAchieved = isAchieved
    }

    // Delete a hydration goal
    override fun deleteGoal(id: Int) {
        val goal = goals.find { it.id == id }
        goals.remove(goal)
    }







}
