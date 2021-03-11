package com.pineapple.demo01_trait

object ClassDemo02 {

    trait MessageSender {

        def send(mes: String)
    }

    trait MessageReceiver {

        def receive()
    }

    class MessageWorker extends MessageSender with MessageReceiver {

        override def send(mes: String): Unit = println(s"发送消息：$mes")

        override def receive(): Unit = println("消息已收到，我很好，谢谢")
    }

    def main(args: Array[String]): Unit = {
        val mw = new MessageWorker
        mw.send("Hello, how are you")
        mw.receive()
    }
}