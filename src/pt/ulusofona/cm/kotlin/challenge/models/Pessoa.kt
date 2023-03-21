package pt.ulusofona.cm.kotlin.challenge.models
import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.time.LocalDateTime
import java.util.*
import kotlin.collections.ArrayList

class Pessoa (val nome: String, val dataDeNascimento: Date) : Movimentavel {
    var veiculos: ArrayList<Veiculo> = ArrayList()
    var carta: Carta? = null
    var posicao: Posicao = Posicao(0,0)
    var dataDeNascimentoAux : LocalDateTime = LocalDateTime.of(dataDeNascimento.year, dataDeNascimento.month, dataDeNascimento.day, dataDeNascimento.hours, dataDeNascimento.minutes)
    fun comprarVeiculo(veiculo : Veiculo){
        veiculos.add(veiculo)
        veiculo.dataDeAquisicao = Date()
    }

    fun pesquisarVeiculo(identificador : String) : Veiculo?{
        for (i in veiculos){
            if(identificador == i.identificador){
                return i
            }
        }
        return null
    }

    fun venderVeiculo(identificador : String , comprador : Pessoa){
        for (i in veiculos){
            if(identificador == i.identificador){
                veiculos.remove(i)
                comprador.comprarVeiculo(i)
            }
        }
    }

    fun moverVeiculoPara(identificador : String , x: Int, y: Int){
        for (i in veiculos){
            if(identificador == i.identificador){
                i.moverPara(x, y)
            }
        }
    }

    override fun moverPara(x: Int, y: Int) {
        this.posicao.alterarPosicaoPara(x,y)
    }

    fun temCarta() : Boolean{
        return carta != null
    }

    fun eMaiorDeIdade() : Boolean{
        if((LocalDateTime.now().year - dataDeNascimento.year) == 18){
            return if((LocalDateTime.now().month == dataDeNascimentoAux.month)){
                (LocalDateTime.now().dayOfMonth == dataDeNascimentoAux.dayOfMonth) || (LocalDateTime.now().dayOfMonth > dataDeNascimentoAux.dayOfMonth)
            }else (LocalDateTime.now().month > dataDeNascimentoAux.month)
        }else if((LocalDateTime.now().year - dataDeNascimento.year) > 18){
            return true
        }
        return false
    }
    fun tirarCarta(){
        if(carta != null && eMaiorDeIdade() ) {
            carta = Carta()
        }
    }

    override fun toString(): String {
        return "Pessoa | $nome | ${this.dataDeNascimento.day}-${this.dataDeNascimento.month}-${this.dataDeNascimento.year} |  ${this.posicao} | x:${this.posicao.x} | y:${this.posicao.y}"
    }
}