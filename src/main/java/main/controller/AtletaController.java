package main.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.model.atleta.Atleta;
import main.model.atleta.AtletaDTO;
import main.model.atleta.TipoDeVolei;
import main.repository.AtletaRepository;

@RestController
@RequestMapping("/api/atleta")
@EnableJpaRepositories(basePackages = "main.repository")
public class AtletaController {
	@Autowired 
	private AtletaRepository repository;
	
	@PostMapping("/cadastrar")
	public ResponseEntity<String> addAtleta(@RequestBody AtletaDTO data){
		Atleta atleta = new Atleta(data.nome().toLowerCase(),data.idade(),data.escola().toLowerCase(),data.tipoDeVolei());
		repository.save(atleta);
		return ResponseEntity.ok("Atleta Cadastrado!");
	}
	@PostMapping("/deletar/{id}")
	public ResponseEntity deleteAtleta(@PathVariable Long id) {
		repository.deleteById(id);
		return ResponseEntity.ok("Atleta Deletado com sucesso!");
	}
	@PostMapping("/atualizar/{id}")
	public ResponseEntity updateAtleta(@PathVariable Long id, @RequestBody AtletaDTO data) {
		Atleta atleta = repository.findById(id).get();
		atleta.setEscola(data.escola().toLowerCase());
		atleta.setIdade(data.idade());
		atleta.setNome(data.nome().toLowerCase());
		atleta.setTipoDeVolei(data.tipoDeVolei());
		
		repository.save(atleta);
		return ResponseEntity.ok("Dados do atleta atualizados!");
	}
	@GetMapping("/listar")
	public List<Atleta> listarAtleta() {
		List<Atleta> atletas = repository.findAll();
		System.out.println(atletas);
		return atletas;
	}
	@GetMapping("/listar/{nome}")
	public ResponseEntity listByNome(@PathVariable String nome) {
		return ResponseEntity.ok(repository.findByNome(nome.toLowerCase()));
	}
	@GetMapping("listar/idade/{idade}")
	public ResponseEntity listByIdade(@PathVariable int idade) {
		return ResponseEntity.ok(repository.findByIdade(idade));
	}
	@GetMapping("listar/escola/{escola}")
	public ResponseEntity listByEscola(@PathVariable String escola) {
		return ResponseEntity.ok(repository.findByEscola(escola.toLowerCase()));
	}
	@GetMapping("/listar/tipo/{tipoDeVolei}")
	public ResponseEntity listByTipoDeVolei(@PathVariable TipoDeVolei tipoDeVolei) {
		return ResponseEntity.ok(repository.findByTipoDeVolei(tipoDeVolei));
	}
}
