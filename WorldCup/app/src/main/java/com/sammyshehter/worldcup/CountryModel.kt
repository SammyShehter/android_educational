package com.sammyshehter.worldcup

class CountryModel {
    var name: String = ""
    var cupWins: String = ""
    var flagImg: Int = 0

    constructor(name: String, cupWins: String, flagImg: Int) {
        this.name = name
        this.cupWins = cupWins
        this.flagImg = flagImg
    }
}