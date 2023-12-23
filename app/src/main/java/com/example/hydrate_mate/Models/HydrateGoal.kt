package com.example.hydrate_mate.Models

class HydrateGoal (
    val id: Int, // Unique identifier for the goal
    val goalAmountInMilliliters: Int, // Amount of water to be consumed in milliliters
    val userId: Int, // User ID associated with the goal
    var isAchieved: Boolean // Indicates if the goal has been achieved
)
