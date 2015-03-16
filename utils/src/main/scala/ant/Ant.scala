package ant

import scala.annotation.StaticAnnotation
import scala.language.experimental.macros
import scala.reflect.macros.blackbox.Context

class Ant extends StaticAnnotation {
	def macroTransform(annottees: Any*): Unit = macro AntImpl.impl
}

object AntImpl {
	def impl(c: Context)(annottees: c.Tree*): c.Tree = {
		import c.universe._
		c.typecheck(annottees.head) // this line causes compilation error
		q"""implicit class A(val v: Int) extends AnyVal { def ask() = println("ok") }"""
	}
}