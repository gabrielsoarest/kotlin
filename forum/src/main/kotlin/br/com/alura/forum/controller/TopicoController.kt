package br.com.alura.forum.controller

import br.com.alura.forum.model.Curso
import br.com.alura.forum.model.NovoTopicoDTO
import br.com.alura.forum.model.Topico
import br.com.alura.forum.model.Usuario
import br.com.alura.forum.service.TopicoService
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/topicos")
class TopicoController(
    private val service: TopicoService
    ) {

    @GetMapping
    fun listar(): List<Topico>{
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id:Long):Topico{
        return service.buscarPorId(id)
    }
    @PostMapping
    fun cadastrar(@RequestBody dto: NovoTopicoDTO){
        service.cadastrar(dto)
    }

}