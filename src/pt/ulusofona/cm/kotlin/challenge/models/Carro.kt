package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoDesligadoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoLigadoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Ligavel

class Carro (identificador : String, var motor: Motor) : Veiculo(identificador), Ligavel{
    var ligado = false

    override fun requerCarta() : Boolean{
        return true
    }

    override fun moverPara(x: Int, y: Int) {
        if(x != this.posicao.x && y != this.posicao.y){
            if(motor.ligado) {
                this.posicao.alterarPosicaoPara(x,y)
                motor.desligar()
            }
        }else{
            throw AlterarPosicaoException()
        }
    }

    override fun ligar() {
        if(!motor.ligado) {
            motor.ligado = true
        }else {
            throw VeiculoLigadoException()
        }
    }

    override fun desligar() {
        if(motor.ligado) {
            motor.ligado = false
        }else {
            throw VeiculoDesligadoException()
        }
    }

    override fun estaLigado(): Boolean {
        return motor.estaLigado()
    }

    override fun toString(): String {
        return "Carro | ${this.identificador} | ${this.dia.toString().padStart(2,'0')}-${this.mes.toString().padStart(2,'0')}-${this.ano} | ${this.posicao}"
    }
}
