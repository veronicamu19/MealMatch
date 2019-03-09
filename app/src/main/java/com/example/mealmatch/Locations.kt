package com.example.mealmatch

enum class Locations() {
    BDH {
        override fun getTitle() = "Busch Dining Hall"
    },
    LDH {
        override fun getTitle() = "Livingston Dining Hall"
    },
    BDC {
        override fun getTitle() = "Brower Dining Commons"
    },
    NDH {
        override fun getTitle() = "Nielson Dining Hall"
    },
    HENRYS {
        override fun getTitle() = "Henry's Diner"
    },
    WOODYS {
        override fun getTitle() = "Woody's"
    },
    KILMERS {
        override fun getTitle() = "Kilmer's Market"
    },
    ROCK {
        override fun getTitle() = "Rock Cafe"
    },
    HARVEST {
        override fun getTitle() = "Harvest"
    },
    COOKCAFE {
        override fun getTitle() = "Cook Cafe"
    };

    abstract fun getTitle(): String
}