open class ArmaDeFuego(private val nombre: String, var municion: Int,
                  private val municionARestar: Int, private val tipoDeMunicion: String,
                  private val danio: Int, private val radio: String)
{
    open fun dispara(): Int{
            municion = municion-municionARestar
            return municion
        }
    open fun recarga(): Int{
        municion = 20
        return municion
    }
}
class Pistola(val nom: String ="Pistola", var municpist: Int = 15,
              val municpistARestar: Int = 1, val tipoDeMunicion: String ="Bla",
               val danio: Int = 3,  val radio: String ="Bla"):
    ArmaDeFuego(nom,municpist,municpistARestar,tipoDeMunicion, danio, radio)
{
    override fun dispara(): Int{
        municpist = municpist-municpistARestar
        return municpist
    }
    override fun recarga(): Int{
        municpist = 15
        return municpist
    }
    }
class Rifle(val name: String ="Rifle", var municrif: Int = 6,
              val municrifARestar: Int = 2, val tipoDeMunicion: String ="Bla",
              val danio: Int = 5,  val radio: String = "Bla"):
    ArmaDeFuego(name,municrif,municrifARestar,tipoDeMunicion, danio, radio)
{
    override fun dispara(): Int{
        municrif = municrif-municrifARestar
        return municrif
    }
    override fun recarga(): Int{
        municrif = 6
        return municrif
    }
    }
class Bazooka(val nomb: String ="Bazooka", var municbaz: Int = 8,
              val municbazARestar: Int = 3, val tipoDeMunicion: String ="Bla",
              val danio: Int = 10,  val radio: String ="Bla"):
    ArmaDeFuego(nomb,municbaz,municbazARestar,tipoDeMunicion, danio, radio)
{
        override fun dispara():Int{
            municbaz = municbaz-municbazARestar
            return municbaz
        }
        override fun recarga():Int{
            municbaz = 8
            return municbaz
        }
    }
fun main() {
    var lista: MutableMap<Int,ArmaDeFuego> = mutableMapOf()
    for (i in 0..5){
        var contador: Int = (1..3).random()
        var arma = ArmaDeFuego("",0,0,"",0,"")
        when(contador){
            1 -> arma = Pistola()
            2 -> arma = Rifle()
            3 -> arma = Bazooka()
        }
        lista.put(key= i,value= arma)
    }
    //Lo imprimo con sus direcciones de memoria para diferenciarlas cuando se repiten los tipos
    println(lista)
    //Aquí se disparan 6 armas pero escogidas al azar dentro del map
    for(i in 0..5) {
        var contador: Int = (0..5).random()
        println(lista.get(contador))
        println(lista.get(contador)?.dispara())
    }
    println()
    //Recargo todas
    for (i in 0..5){
        lista.get(i)?.recarga()
    }
    println()
    println("Recargadas armas")
    println()
    //Aquí recorro el map y disparo una cada vez
    for (i in 0..5) {
        println(lista.get(i))
        println(lista.get(i)?.dispara())
    }
}