package io.github.tdhd.scalac.plugin

import scala.concurrent.Future
import scala.io.Source

object TestCode {

  def testPrint = {
    while (true) {
      println("Hello Scala World")
    }
  }

  val html = Source.fromURL("http://google.com")
  val s = html.mkString
  println(s)

  def downloadFile(token: String, fileToDownload: String) {
    try {
      val src = scala.io.Source.fromURL("http://randomwebsite.com/docs?t=" + token + "&p=tsr%2F" + fileToDownload)
      val out = new java.io.FileWriter("src/test/resources/testingUpload1.txt")
      out.write(src.mkString)
      out.close
    } catch {
      case e: java.io.IOException => "error occured"
    }
  }


  object ScalaJSExample {
    def main(args: Array[String]): Unit = {
      val xs = Seq(1, 2, 3)
      println(xs)
      val ys = Seq(4, 5, 6)
      println(ys)
      val zs = for {
        x <- xs
        y <- ys
      } yield x * y
      println(zs)
    }
  }

  val musicElem = scala.xml.XML.loadFile("/tmp/music.xml")
  (musicElem \ "artist").foreach { artist =>
    println((artist \ "@name").text + "\n")
    val albums = (artist \ "album").foreach { album =>
      println("  " + (album \ "@title").text + "\n")
      val songs = (album \ "song").foreach { song =>
        println("    " + (song \ "@title").text)
      }
      println
    }
  }

  implicit class Test(a: Int) {
    def doStuff = a + 1
  }

  val x = 1.doStuff
  val m = Map(1 -> "a", 2 -> "b", 4 -> "b")
  m.groupBy(_._2).mapValues(_.map(_._1))
  while (true) {
    println(1 * 2 * 3 * 4 * 5 * 6)
  }

  import scala.concurrent.ExecutionContext.Implicits.global
  Future(1/0).recover {
    case ex: Throwable => throw new Exception("test")
  }.map ( x => x )
}
