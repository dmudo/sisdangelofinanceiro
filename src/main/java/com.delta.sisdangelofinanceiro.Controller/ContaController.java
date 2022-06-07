package com.delta.sisdangelofinanceiro.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delta.sisdangelofinanceiro.Model.Conta;
import com.delta.sisdangelofinanceiro.Repository.ContaRepository;

@RestController
@RequestMapping("/conta")
public class ContaController {
	
	@Autowired
	private ContaRepository cr;

	@PostMapping("/")
	public void salvarConta(@RequestBody Conta conta) {
		cr.save(conta);
		System.out.println("Salva Com Sucesso!");	
		
	}

	@GetMapping("/{id}")
	public Conta consultarConta(@PathVariable("id") int id) {
		return cr.findById(id);
	}
	
	@GetMapping("/")
	public Iterable<Conta> consultarContas() {
		return cr.findAll();
	}
	
	@PutMapping("/")
	public void atualizarConta(@RequestBody Conta conta) {
		cr.save(conta);
	}
	
	@DeleteMapping("/")
	public void deletarConta(@RequestBody Conta conta) {
		cr.delete(conta);
	}
	
	
}
