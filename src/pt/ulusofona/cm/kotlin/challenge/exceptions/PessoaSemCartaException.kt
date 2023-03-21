package pt.ulusofona.cm.kotlin.challenge.exceptions

class PessoaSemCartaException(var mensagem : String = "Pessoa sem carta de condução") : Exception(mensagem)