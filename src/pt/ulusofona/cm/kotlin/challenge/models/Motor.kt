package pt.ulusofona.cm.kotlin.challenge.models
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoDesligadoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoLigadoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Ligavel

class Motor (var cavalos: Int, val cilindrada: Int) : Ligavel {
    var ligado = false

    override fun ligar() {
        if(!ligado) {
            ligado = true
        }else {
            throw VeiculoLigadoException()
        }
    }

    override fun desligar() {
        if(ligado) {
            ligado = false
        }else {
            throw VeiculoDesligadoException()
        }
    }

    override fun estaLigado(): Boolean {
        return ligado
    }

    override fun toString(): String {
        return "Motor | $cavalos | $cilindrada"
    }
}
