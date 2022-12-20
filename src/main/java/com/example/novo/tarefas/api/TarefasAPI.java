package com.example.novo.tarefas.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.novo.tarefas.dto.TarefaDto;
import com.example.novo.tarefas.facade.TarefasFacade;

@Controller
@RequestMapping(value = "/tarefas", method = RequestMethod.GET, produces="application/json")
public class TarefasAPI {
	@Autowired
	private TarefasFacade tarefasFacade;
	
	@PostMapping
	@ResponseBody
	public TarefaDto criar(@RequestBody TarefaDto tarefaDto) {
		return tarefasFacade.criar(tarefaDto);
	}
	
	@PutMapping("/{tarefaId}")
	@ResponseBody
	public TarefaDto atualizar(@PathVariable("tarefaId") Long tarefaId,
							   @RequestBody TarefaDto tarefaDto) {
		return tarefasFacade.atualizar(tarefaDto, tarefaId);
	}
	
	@GetMapping
	@ResponseBody
	public List<TarefaDto> getAll(){
		return tarefasFacade.getAll();
	}
	
	@DeleteMapping("/{tarefaId}")
	@ResponseBody
	public String deletar(@PathVariable("tarefaId")Long tarefaId) {
		return tarefasFacade.delete(tarefaId);
	}
	
}
