package pt.ulusofona.cm.kotlin.challenge.models
import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.MenorDeIdadeException
import pt.ulusofona.cm.kotlin.challenge.exceptions.PessoaSemCartaException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoNaoEncontradoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*
import kotlin.collections.ArrayList

class Pessoa (val nome: String, val dataDeNascimento: Date) : Movimentavel {
    var veiculos: ArrayList<Veiculo> = ArrayList()
    var carta: Carta? = null
    var posicao: Posicao = Posicao(0,0)
    val instant = dataDeNascimento.toInstant()
    val dataDeNascimentoAux = LocalDateTime.ofInstant(instant, ZoneId.systemDefault())
    fun comprarVeiculo(veiculo : Veiculo){
        veiculos.add(veiculo)
        veiculo.dataDeAquisicao = Date()
    }

    fun pesquisarVeiculo(identificador : String) : Veiculo {
        for (i in veiculos){
            if(identificador == i.identificador){
                return i
            }
        }
        throw VeiculoNaoEncontradoException()
    }

    fun venderVeiculo(identificador : String , comprador : Pessoa){
        for (i in veiculos){
            if(identificador == i.identificador){
                veiculos.remove(i)
                comprador.comprarVeiculo(i)
                return
            }
        }
        throw VeiculoNaoEncontradoException()
    }

    fun moverVeiculoPara(identificador : String , x: Int, y: Int){
        for (i in veiculos){
            if(identificador == i.identificador){
                if(i.requerCarta()) {
                    if (this.temCarta()) {
                        if (x != this.posicao.x || y != this.posicao.y) {
                            i.moverPara(x, y)
                            return
                        } else {
                            throw AlterarPosicaoException()
                        }
                    } else {
                        throw PessoaSemCartaException("${this.nome} não tem carta para conduzir o veículo indicado")
                    }
                }else{
                    if (x != this.posicao.x || y != this.posicao.y) {
                        i.moverPara(x, y)
                        return
                    } else {
                        throw AlterarPosicaoException()
                    }
                }
            }
        }
        throw VeiculoNaoEncontradoException()
    }

    override fun moverPara(x: Int, y: Int) {
        if(x != this.posicao.x || y != this.posicao.y){
            this.posicao.alterarPosicaoPara(x,y)
        }else{
            throw AlterarPosicaoException()
        }
    }

    fun temCarta() : Boolean{
        return carta != null

    }

    fun tirarCarta(){
        if(carta == null) {
            if((LocalDateTime.now().year - dataDeNascimentoAux.year) == 18){
                if((LocalDateTime.now().month == dataDeNascimentoAux.month)){
                    if(LocalDateTime.now().dayOfMonth < dataDeNascimentoAux.dayOfMonth){
                        throw MenorDeIdadeException()
                    }else{
                        carta = Carta()
                    }
                }else {
                    if(LocalDateTime.now().month > dataDeNascimentoAux.month){
                        carta = Carta()
                    }else{
                        throw MenorDeIdadeException()
                    }
                }
            }else if((LocalDateTime.now().year - dataDeNascimentoAux.year) > 18){
                carta = Carta()
            }
            throw MenorDeIdadeException()
        }
    }

    override fun toString(): String {
        return "Pessoa | $nome | ${this.dataDeNascimentoAux.dayOfMonth.toString().padStart(2,'0')}-${this.dataDeNascimentoAux.month.value.toString().padStart(2,'0')}-${this.dataDeNascimentoAux.year} | ${this.posicao}"
    }
}