package com.example.mealmatch

enum class Locations() {
    BDH {
        override fun getTitle() = "Busch Dining Hall"
        override fun getCampus() = "Busch"
    },
    LDH {
        override fun getTitle() = "Livingston Dining Hall"
        override fun getCampus() = "Livingston"
    },
    BDC {
        override fun getTitle() = "Brower Dining Commons"
        override fun getCampus() = "College Ave"
    },
    NDH {
        override fun getTitle() = "Nielson Dining Hall"
        override fun getCampus() = "Cook/Douglass"
    },
    HENRYS {
        override fun getTitle() = "Henry's Diner"
        override fun getCampus() = "Livingston"
    },
    WOODYS {
        override fun getTitle() = "Woody's"
        override fun getCampus() = "Busch"
    },
    KILMERS {
        override fun getTitle() = "Kilmer's Market"
        override fun getCampus() = "Livingston"
    },
    ROCK {
        override fun getTitle() = "Rock Cafe"
        override fun getCampus() = "Livingston"
    },
    SBARROS {
        override fun getTitle() = "Sbarro's"
        override fun getCampus() = "Livingston"
    },
    HARVEST {
        override fun getTitle() = "Harvest"
        override fun getCampus() = "Cook/Douglass"
    },
    COOKCAFE {
        override fun getTitle() = "Cook Cafe"
        override fun getCampus() = "Cook/Douglass"
    };

    abstract fun getTitle(): String
    abstract fun getCampus(): String
}