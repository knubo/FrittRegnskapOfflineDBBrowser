import sbt._

class FrittRegnskapOfflineDB(info: ProjectInfo) extends DefaultProject(info) with IdeaProject {
  lazy val hi = task{
    println("Hello World"); None
  }

  val derby = "org.apache.derby" % "derby" % "10.4.1.3"
  val scalaSwing = "org.scala-lang" % "scala-swing" % "2.8.1" withSources ()
  val dispatch = "net.databinder" %% "dispatch-http" % "0.7.8" withSources ()
  val dispatchJson = "net.databinder" %% "dispatch-http-json" % "0.7.8" withSources ()
}