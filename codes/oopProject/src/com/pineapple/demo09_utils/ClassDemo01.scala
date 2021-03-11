package com.pineapple.demo09_utils

import java.text.SimpleDateFormat
import java.util.Date

/**
 * 案例：定义日期工具类
 */
object ClassDemo01 {

    object DataUtils {
        var sdf: SimpleDateFormat = _

        def date2String(date: Date, template: String): String = {
            sdf = new SimpleDateFormat(template)
            sdf.format(date)
        }

        def string2Date(dateString: String, template: String): Date = {
            sdf = new SimpleDateFormat(template)
            sdf.parse(dateString)
        }
    }

    def main(args: Array[String]): Unit = {
        println(DataUtils.date2String(new Date(), "yyyy-MM-dd"))
        println(DataUtils.string2Date("1314年5月21日", "yyyy年MM月dd日"))
    }
}