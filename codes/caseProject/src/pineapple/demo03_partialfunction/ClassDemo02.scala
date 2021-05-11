package pineapple.demo03_partialfunction

object ClassDemo02 {
    def main(args: Array[String]): Unit = {
        // 1. 定义一个列表，包含1-10的数字
        val list1 = (1 to 10).toList

        val list2 = list1.map {
            // 2. 将1-3的数字都转换为[1-3]
            case x if x >= 1 && x <= 3 => "[1-3]"
            // 3. 将4-8的数字都转换为[4-8]
            case x if x >= 4 && x <= 8 => "[4-8]"
            // 4. 将其他的数字转换为(8-*)
            case _ => "(8-*)"
        }
        // 5. 打印结果
        println(list2)
    }
}