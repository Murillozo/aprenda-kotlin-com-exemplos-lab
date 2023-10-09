enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {
    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
}

fun main() {
    // Cenário de teste: Criando alguns objetos
    val usuario1 = Usuario("João")
    val usuario2 = Usuario("Maria")

    val conteudo1 = ConteudoEducacional("HTML", 90)
    val conteudo2 = ConteudoEducacional("CSS", 60)
    val conteudo3 = ConteudoEducacional("JavaScript", 120)

    val formacaoWeb = Formacao("Desenvolvimento Web", listOf(conteudo1, conteudo2, conteudo3))

    // Matriculando usuários na formação
    formacaoWeb.matricular(usuario1)
    formacaoWeb.matricular(usuario2)

    // Exibindo informações
    println("Formação: ${formacaoWeb.nome}")
    println("Conteúdos:")
    for (conteudo in formacaoWeb.conteudos) {
        println("${conteudo.nome} - ${conteudo.duracao} minutos")
    }
    println("Inscritos:")
    for (inscrito in formacaoWeb.inscritos) {
        println(inscrito.nome)
    }
}
