package com.example.nutracker.ui.main

import com.example.nutracker.network.NutrackerService
import com.example.nutracker.persistence.NutrackerDao
import javax.inject.Inject

class MainRepository @Inject constructor(
    nuTrackerService: NutrackerService,
    nutrackerDao: NutrackerDao
)