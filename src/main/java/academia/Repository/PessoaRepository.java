package academia.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import academia.Dto.BuscarPessoas;
import academia.Model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
	@Query(value = "select p from Pessoa p where upper(trim(p.nome)) like %?1% ") 
	List<BuscarPessoas> buscarPorNome(String name);
}
