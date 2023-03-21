package pt.ulusofona.cm.kotlin.challenge.models

class Carro (identificador : String, var motor: Motor) : Veiculo(identificador){

    override fun requerCarta() : Boolean{
        return true
    }

    override fun moverPara(x: Int, y: Int) {
        setPosicao(x,y)
        motor.desligar()
    }

    override fun toString(): String {
        return "Carro | ${this.identificador} | ${this.dataDeAquisicao.day}-${this.dataDeAquisicao.month}-${this.dataDeAquisicao.year} |  ${this.posicao} | x:${this.posicao.x} | y:${this.posicao.y}"
    }
}
