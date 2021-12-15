object ObserverExample extends App {

  class Message(message: String) {
    def messageTest(): Unit = println(s"Some message method $message")

    override def toString: String = message
  }

  class ObservableMessage(message: String) extends Message(message) with Observable[Message] {
    override def messageTest(): Unit = {
      notifyObservers()
      super.messageTest()
    }
  }

  class MessageObserver extends Observer[Message] {
    override def notifyObs(elem: Message): Unit = println(s"Received message: $elem")
  }

  val message = new ObservableMessage("testObserver")
  val observer = new MessageObserver();
  message.addObserver(observer)
  message.messageTest()
}
