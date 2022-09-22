class Singleton private constructor() {
    companion object { val INSTANCE by lazy { Singleton() }}
}

class Bean(val singleton: Singleton = Singleton.INSTANCE)

class Service(
  val eagerSingleton: Singleton         = Singleton.INSTANCE,
  val lazySingleton: Lazy<Singleton>    = lazy { Singleton.INSTANCE },
  val bean: Bean                        = Bean(),
  val beanProvider: () -> Bean          = { Bean() },
) {
    fun injectableMethod(param: String, methodBean: Bean = Bean()) {
        param
        methodBean
        eagerSingleton
        lazySingleton
        bean
        beanProvider
    }
}

fun app(service: Service = Service()) {
    service.injectableMethod("Hello")
}

fun main() {
    app()
}
