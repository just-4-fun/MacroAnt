package core


object Main extends App {
	import core.AImpls._
	42.ask()// should print "ok" (not 42)
}

object AImpls {
	import ant.Ant
	@Ant implicit class A(val v: Int) extends AnyVal { def ask() = println(v)}
}
