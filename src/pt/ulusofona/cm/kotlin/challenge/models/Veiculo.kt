package pt.ulusofona.cm.kotlin.challenge.models
import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.time.ZoneId
import java.util.*

abstract class Veiculo(val identificador: String) : Movimentavel {
    var dataDeAquisicao: Date = Date()
    val localDate = dataDeAquisicao.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
    val dia = localDate.dayOfMonth
    val mes = localDate.monthValue
    val ano = localDate.year
    var posicao: Posicao = Posicao(0,0)

    fun setPosicao(x:Int, y:Int){
        this.posicao.alterarPosicaoPara(x,y)
    }

    abstract fun requerCarta() : Boolean

    abstract override fun toString(): String
}
