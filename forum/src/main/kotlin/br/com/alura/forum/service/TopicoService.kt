package br.com.alura.forum.service

import br.com.alura.forum.model.Curso
import br.com.alura.forum.model.NovoTopicoDTO
import br.com.alura.forum.model.Topico
import br.com.alura.forum.model.Usuario
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import java.util.*
import kotlin.collections.ArrayList

@Service
class TopicoService(
    private var topicos: List<Topico> = ArrayList(),
    private val cursoService: CursoService

    ) {

    init {
        val topico = Topico(
            id= 1,
            titulo = "Duvida Kotlin1",
            mensagem = "Variaveis Kotlin1",
            curso= Curso(
                id=1,
                nome="Kotlin",
                categoria= "Programacao"),
            autor = Usuario(
                id=1, nome= "Ana da Silva",
                email = "ana@email.com"
            )
        )

        val topico2 = Topico(
            id= 2,
            titulo = "Duvida Kotlin2",
            mensagem = "Variaveis Kotlin2",
            curso= Curso(
                id=1,
                nome="Kotlin",
                categoria= "Programacao"),
            autor = Usuario(
                id=1, nome= "Ana da Silva",
                email = "ana@email.com"
            )
        )

        val topico3 = Topico(
            id= 3,
            titulo = "Duvida Kotlin3",
            mensagem = "Variaveis Kotlin3",
            curso= Curso(
                id=1,
                nome="Kotlin",
                categoria= "Programacao"),
            autor = Usuario(
                id=1, nome= "Ana da Silva",
                email = "ana@email.com"
            )
        )
    topicos = Arrays.asList(topico, topico2, topico3)

    }

    fun listar(): List<Topico>{
            return topicos
        }

    fun buscarPorId(id: Long): Topico {
        return topicos.stream().filter { t ->
            t.id == id
        }.findFirst().get()
    }

    fun cadastrar(dto: NovoTopicoDTO) {
        topicos.plus(Topico(
            titulo = dto.titulo,
            mensagem = dto.mensagem,
            curso = cursoService.buscarPorId(dto.idCurso)
            autor = autorService.buscarPorId(dto.idAutor)

        ))
    }


}