package no.knubo.frittregnskap


import dispatch._
import json.Js
import json._
import JsHttp._
import JsonHandlers._

object JsonHandlers {
 implicit def jsonHandlers(handlers: Handlers) = new JsonHandlers(handlers)
}

class JsonHandlers(h: Handlers) {
 /**Process response as JsValue in block */
 def >#[T](block: json.Js.JsF[T]) = h >> {
   stm => block(json.Js(stm))
 }
}

object FrittRegnskap {
 def apply(_domainPrefix: String): FrittRegnskap = new FrittRegnskap {
   def domainPrefix = _domainPrefix
 }
}

trait FrittRegnskap {
 def domainPrefix: String

 def request: Request = :/(domainPrefix + ".frittregnskap.no") / "RegnskapServer" / "services"

 def apply[A](r: Request => Handler[A]) = Http(r(request))
}


object Login {
 private val result = 'result ? str

 private def extract(s: String) = s match {
   case "ok" => Ok
   case _ => Failed
 }

 def apply(username: String, password: String) = (r: Request) => (r / ("authenticate.php?action=login&user=" + username + "&password=" + password) ># result) ~> extract
}

sealed trait LoginResult

case object Ok extends LoginResult

case object Failed extends LoginResult

object Backup {
 def tables(r: Request) = r / "backup.php?action=tables_plain" ># Js.list

 def schema(r: Request) = r /"backup.php?action=schema_plain" as_str

 def data(table : String) = (r:Request) => (r / ("backup.php?action=dump_plain&table="+table) as_str)
}

