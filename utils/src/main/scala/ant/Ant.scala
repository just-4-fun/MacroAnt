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
		c.internal.enclosingOwner.asType.toType // this line is Ok
		// Any commented line below causes the same compilation error
//		c.internal.enclosingOwner.asType.toType.decls
//		c.mirror.staticModule(c.internal.enclosingOwner.fullName + ".A".toString)
//		c.typecheck(annottees.head)

		q"""implicit class A(val v: Int) extends AnyVal { def ask() = println("ok") }"""
	}
}