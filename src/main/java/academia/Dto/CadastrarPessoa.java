package academia.Dto;

import academia.Model.Pessoa;

public record CadastrarPessoa(
		
		Long id,
		String nome, 
		String endereco,
		String telefone,
		String dataNasc,
		String dataMat,
		String dataPag,
		Double valor,
		String status) {

	public CadastrarPessoa(Pessoa cadastro) {
		this(cadastro.getId(),
		cadastro.getNome(),
		cadastro.getEndereco(),
		cadastro.getTelefone(),
		cadastro.getDataNasc(),
		cadastro.getDataMat(),
		cadastro.getDataPag(),
		cadastro.getValor(),
		cadastro.getStatus());
	}

}
