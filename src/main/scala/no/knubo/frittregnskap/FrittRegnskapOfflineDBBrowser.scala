package no.knubo.frittregnskap


object FrittRegnskapOfflineDBBrowser {

  def main(args: Array[String]) {

   val frittRegnskap = FrittRegnskap("demo")

   println(frittRegnskap(Login("demo", "demo")))

   def tables = frittRegnskap(Backup.tables);
   def schema = frittRegnskap(Backup.schema);

  // println(tables)
  // println(schema)
   //println(frittRegnskap(Backup data "person"))


  }


}