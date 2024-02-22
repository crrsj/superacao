package academia.Dto;

import academia.Model.Pessoa;

public record BuscarPessoas(
		
		Long id,
		String nome, 
		String endereco,
		String telefone,
		String dataNasc,
		String dataMat,
		String dataPag,
		Double valor,
		String status) {
	
	  public BuscarPessoas(Pessoa buscas) {
		  this(
			 
			  buscas.getId(),
			  buscas.getNome(),
			  buscas.getEndereco(),
			  buscas.getTelefone(),
			  buscas.getDataNasc(),
			  buscas.getDataMat(),
			  buscas.getDataPag(),
			  buscas.getValor(),
			  buscas.getStatus());
	  }

}
