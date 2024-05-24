package br.com.brunoszczuk.leetcode.easy._2024_05_23

import org.junit.jupiter.api.Test

class `Reformat Date` {

    fun reformatDate(date: String): String {
        val months = hashMapOf(Pair("Jan", "01"),  Pair("Feb", "02"), Pair("Mar", "03"), Pair("Apr", "04"),
            Pair("May", "05"),Pair("Jun", "06"), Pair("Jul","07"), Pair("Aug", "08"), Pair("Sep", "09"), Pair("Oct", "10"),
            Pair("Nov", "11"),Pair( "Dec", "12"))
        val dateSplited = date.split(" ")
        var day = ""
        for (s in dateSplited.first()){
            if (s.isDigit()){
                day+=s
            }
        }
        if (day.length == 1){
            day = "0$day"

        }
        return "${dateSplited[2]}-${months[dateSplited[1]]}-${day}"
    }

    @Test
    fun test(){
        assert(reformatDate("20th Oct 2052") == "2052-10-20")
        assert(reformatDate("6th Jun 1933") == "1933-06-06")
        assert(reformatDate("26th May 1960") == "1960-05-26")
    }
}