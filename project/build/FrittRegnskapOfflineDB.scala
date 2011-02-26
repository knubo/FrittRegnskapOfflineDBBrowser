import sbt._

class FrittRegnskapOfflineDB(info: ProjectInfo) extends DefaultProject(info) with IdeaProject {
  lazy val hi = task{
    println("Hello World"); None
  }

  val scalaSwing = "org.scala-lang" % "scala-swing" % "2.8.1" withSources ()
  val dispatch = "net.databinder" %% "dispatch-http" % "0.7.8" withSources ()
  val json = "net.databinder" %% "dispatch-json" % "0.7.8" withSources ()
  val dispatchJson = "net.databinder" %% "dispatch-http-json" % "0.7.8" withSources ()

  val h2 = "com.h2database" % "h2" % "1.2.147"
}
