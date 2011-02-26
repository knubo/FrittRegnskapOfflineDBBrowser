package no.knubo.frittregnskap

import dispatch.json.JsString


object FrittRegnskapOfflineDBBrowser {

  def main(args: Array[String]) {

    val frittRegnskap = FrittRegnskap("demo")

    println(frittRegnskap(Login("demo", "demo")))

    val tables = frittRegnskap(Backup.tables)
    val schema = frittRegnskap(Backup.schema).replaceAll("ENUM.*\\(.*", "int,")


    val driver = "org.h2.Driver";
    Class.forName(driver);

    val conn = java.sql.DriverManager.getConnection("jdbc:h2:mem:test", "sa", "sa")

    val stmt = conn.createStatement();

    schema.split(";").foreach {
      s => stmt.execute(s);
    }

    tables.foreach {
      table => {

        val tablestr = table.toString().replaceAll("\"", "");

        println("Inserting data for " + tablestr)

        Thread.sleep(1000);

        val inserts = frittRegnskap(Backup data (tablestr));

        inserts.split("\\);").foreach {
          s => if (!s.startsWith("#")) {
            stmt.execute(s + ")")
          }
        }
      }
    }


    conn.close()
  }


}