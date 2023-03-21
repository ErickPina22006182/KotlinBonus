package pt.ulusofona.cm.kotlin.challenge.exceptions

class PessoaSemCartaException(var mensagem : String = "Nome da Pessoa não tem carta para conduzir o veículo indicado") : Exception(mensagem)