package main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.model.atleta.Atleta;
import main.model.atleta.TipoDeVolei;

@Repository
public interface AtletaRepository extends JpaRepository<Atleta, Long> {
	List<Atleta> findByNome(String nome);
	List<Atleta> findByIdade(int idade);
	List<Atleta> findByEscola(String escola);
	List<Atleta> findByTipoDeVolei(TipoDeVolei tipoDeVolei);
}
