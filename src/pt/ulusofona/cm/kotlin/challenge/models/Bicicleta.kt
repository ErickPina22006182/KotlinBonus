package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException

class Bicicleta (identificador : String) : Veiculo(identificador) {

    override fun requerCarta() : Boolean{
        return false
    }

    override fun moverPara(x: Int, y: Int) {
        if(x != this.posicao.x || y != this.posicao.y){
            setPosicao(x,y)
        }else{
            throw AlterarPosicaoException()
        }
    }

    override fun toString(): String {
        return "Bicicleta | ${this.identificador} | ${this.dia.toString().padStart(2,'0')}-${this.mes.toString().padStart(2,'0')}-${this.ano} | ${this.posicao}"
    }
}
