package academia.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import academia.Dto.BuscarPessoas;
import academia.Dto.CadastrarPessoa;
import academia.Model.Pessoa;
import academia.Repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository repository;

	public CadastrarPessoa cadastrar(CadastrarPessoa cadastrar) {
		var pessoa  = new Pessoa(cadastrar);
		var cadastro =  repository.save(pessoa);
		return new CadastrarPessoa(cadastro);
	}
	
	public List<BuscarPessoas> buscar(){		
		var busca = repository.findAll().stream().map(BuscarPessoas::new).toList();
		return busca;
		
		
	}
	public BuscarPessoas buscarId(Long id) {
		var buscaId  = repository.findById(id).get();
		return new BuscarPessoas(buscaId);
	}
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public List<BuscarPessoas> buscarPorNome(@RequestParam(name = "name")String name) {
		List<BuscarPessoas>pessoa = repository.buscarPorNome(name.trim().toUpperCase());
		return pessoa;
    }
}
