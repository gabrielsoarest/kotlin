package br.com.alura.forum.service

import br.com.alura.forum.dto.NovoTopicoForm
import br.com.alura.forum.dto.TopicoView
import br.com.alura.forum.mapper.TopicoFormMapper
import br.com.alura.forum.mapper.TopicoViewMapper
import br.com.alura.forum.model.*
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors
import kotlin.collections.ArrayList

@Service
class TopicoService(
    private var topicos: List<Topico> = ArrayList(),

    private val topicoViewMapper: TopicoViewMapper,
    private val topicoFormMapper: TopicoFormMapper

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

    fun listar(): List<TopicoView>{
            return topicos.stream().map {
                    t -> topicoViewMapper.map(t)
             }.collect(Collectors.toList())
        }

    fun buscarPorId(id: Long): TopicoView {
        val topico= topicos.stream().filter { t ->
            t.id == id
        }.findFirst().get()
        return  topicoViewMapper.map(topico)
    }

    fun cadastrar(form: NovoTopicoForm) {
       val topico = topicoFormMapper.map(form)
        topico.id = topicos.size.toLong() + 1
        topicos = topicos.plus(topico)


    }
}