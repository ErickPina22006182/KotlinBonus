package pt.ulusofona.cm.kotlin.challenge.exceptions

class AlterarPosicaoException(var mensagem : String = "Não é possível se mover para esta posição") : Exception(mensagem)