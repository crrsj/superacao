package academia.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import academia.Dto.BuscarPessoas;
import academia.Dto.CadastrarPessoa;
import academia.Service.PessoaService;

@RestController
public class PessoaController {
	
	@Autowired
	private PessoaService service;
	
	@PostMapping("cadastrar")
	public ResponseEntity<CadastrarPessoa>cadastrar(@RequestBody CadastrarPessoa pessoa,UriComponentsBuilder uriBuilder){
		var cadastre = service.cadastrar(pessoa);
		var uri = uriBuilder.path("/id").buildAndExpand(cadastre.id()).toUri();
		return ResponseEntity.created(uri).body(cadastre);
	}
    
	@GetMapping("buscaTodos")
	public ResponseEntity<List<BuscarPessoas>>buscarTodos(){
		var busca = service.buscar();
		return ResponseEntity.ok(busca);
		
	}
	@GetMapping("buscarid")
	public ResponseEntity<BuscarPessoas>BuscaPorId(@RequestParam(name = "idpessoa") Long idpessoa){
		var p = service.buscarId(idpessoa);
		return ResponseEntity.ok(p);
	}
	@DeleteMapping("excluir")
	public ResponseEntity<Void>excluirPessoa(@RequestParam(name ="idpessoa")Long idpessoa){
		service.delete(idpessoa);
		return ResponseEntity.noContent().build();
	}
	@GetMapping("buscarPorNome")
	public ResponseEntity<List<BuscarPessoas>>buscarPorNome(String name){
		var busca = service.buscarPorNome(name);
		return ResponseEntity.ok(busca);
	}
}
