package academia.Dto;

import academia.Model.Pessoa;

public record AtualizarPessoa(	
		
		Long id,
		String nome, 
		String endereco,
		String telefone,
		String dataNasc,
		String dataMat,
		String dataPag,
		Double valor,
		String status) {

	public AtualizarPessoa(Pessoa p) {
		 this(  p.getId(),
				p.getNome(),
				p.getEndereco(),
				p.getTelefone(),
				p.getDataNasc(),
				p.getDataMat(),
				p.getDataPag(),
				p.getValor(),
				p.getStatus());
	}

}
