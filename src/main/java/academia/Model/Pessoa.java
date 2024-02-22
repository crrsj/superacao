package academia.Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import academia.Dto.CadastrarPessoa;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pessoas")
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String endereco;
	private String telefone;
	private String dataNasc = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
	private String dataMat = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
	private String dataPag = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
	private Double valor;
	private String status;
	
	public Pessoa(CadastrarPessoa cadastrar) {
		this.id = cadastrar.id();
		this.nome = cadastrar.nome();
		this.endereco = cadastrar.endereco();
		this.telefone = cadastrar.telefone();
		this.dataNasc = cadastrar.dataNasc();
		this.dataMat = cadastrar.dataMat();
		this.dataPag = cadastrar.dataPag();
		this.valor = cadastrar.valor();
		this.status = cadastrar.status();
		
	}
}
