package com.pineapple.demo03_pattern

object ClassDemo03 {

    trait Handler {

        /**
         *
         * @param data : 用户发起的具体支付数据
         */
        def handle(data: String): Unit = {
            println("具体的处理数据...")
            println(data)
        }
    }

    trait DataValidHandler extends Handler {

        override def handle(data: String): Unit = {
            println("验证数据...")
            super.handle(data)
        }
    }

    trait SignatureValidHandler extends Handler {

        override def handle(data: String): Unit = {
            println("验证签名...")
            super.handle(data)
        }
    }

    /**
     * 叠加特质
     */
    class Payment extends DataValidHandler with SignatureValidHandler {

        def pay(data: String): Unit = {
            println("用户发起支付请求")
            super.handle(data) // 构成调用链
        }
    }

    def main(args: Array[String]): Unit = {
        val p = new Payment
        p.pay("张三给凤姐转账1000元")
    }
}