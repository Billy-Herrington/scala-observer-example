import scala.collection.mutable.ListBuffer

trait Observable[T] {
  this: T =>
  val observers: ListBuffer[Observer[T]] = ListBuffer()
  def addObserver(observer: Observer[T]): Unit = observers.addOne(observer)
  def removeObserver(observer: Observer[T]): Unit = observers.remove(observers.indexOf(observer))
  def notifyObservers(): Unit = observers.foreach {
    el => el.notifyObs(this)
  }
}
