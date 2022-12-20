package com.example.novo.tarefas.facade;

import com.example.novo.tarefas.dto.TarefaDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TarefasFacade {
	private static final Map<Long, TarefaDto> tarefas = new HashMap<>();
	
	public TarefaDto criar(TarefaDto tarefaDto) {
		Long proximoId = tarefas.keySet().size()+1L;
		tarefaDto.setId(proximoId);
		tarefas.put(proximoId, tarefaDto);
		return tarefaDto;
	}
	
	public TarefaDto atualizar(TarefaDto tarefaDto, long tarefaId) {
		tarefas.put(tarefaId, tarefaDto);
		return tarefaDto;
	}
	
	public TarefaDto getById(Long tarefaId) {
		return tarefas.get(tarefaId);
	}
	
	public List<TarefaDto> getAll(){
		return new ArrayList<>(tarefas.values());
	}
	
	public String delete(Long tarefaId) {
		tarefas.remove(tarefaId);
		return "DELETED";
	}
}
