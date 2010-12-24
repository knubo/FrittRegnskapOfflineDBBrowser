import sbt._

class FrittRegnskapOfflineDB(info: ProjectInfo) extends DefaultProject(info) with IdeaProject
{
    lazy val hi = task { println("Hello World"); None }

    val derby = "org.apache.derby" % "derby" % "10.4.1.3"
    val scalaSwing = "org.scala-lang" % "scala-swing" % "2.8.1"

}