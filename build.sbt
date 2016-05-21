scalaVersion := "2.11.8"
libraryDependencies += "org.scala-lang" % "scala-compiler" % "2.11.8"
scalacOptions in Test += "-Ybrowse:parser"//-Xplugin:target/scala-2.11/scalac-stats_2.11-0.1-SNAPSHOT.jar"
