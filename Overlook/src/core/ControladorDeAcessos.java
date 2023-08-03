package core;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import data.BDException;
import data.ControleAcessoBD;
import data.MySQLConector;

public class ControladorDeAcessos {

	private ControleAcessoBD repositorio;

	public ControladorDeAcessos(ControleAcessoBD repositorio) {
		this.repositorio = repositorio;
	}

	public ControladorDeAcessos() throws CoreException {
		try {
			repositorio = new MySQLConector();
		} catch (BDException mensagem) {
			throw new CoreException(mensagem.getMessage(), mensagem);
		}
	}

	public void RegistroHistoricoDeViagem(int idReserva, String enderecoColeta, String enderecoDestino, int passageiros,
			LocalDate data, LocalTime horario) throws CoreException {

		LocalDate dataAtual = LocalDate.now();

		if (data.isBefore(dataAtual)) {
			throw new CoreException("Data informada é anterior a data atual, informe uma data válida");
		}
		
		LocalDate dataAtualMais1Ano = dataAtual.plusYears(1);
		
		if (data.isAfter(dataAtualMais1Ano)) {
			throw new CoreException("A data informada vai além da agenda do hotel que é 1 ano. Por favor, informe uma data que respeite esse período");
		}
		

		if (enderecoColeta.isBlank()) {
			throw new CoreException("O endereço de coleta está vazio");
		}

		if (enderecoDestino.isBlank()) {
			throw new CoreException("O endereço do Destino está vazio");
		}

		if (passageiros <= 0) {
			throw new CoreException("O número de passageiros é inválido");
		}

		if (passageiros > 12) {
			throw new CoreException("Número de passageiros excede o limite de transporte(12).");
		}

		if (enderecoColeta.equals(enderecoDestino)) {
			throw new CoreException("Os endereços de coleta e destino estão iguais");
		}

		HistoricoTranslado translado = new HistoricoTranslado(idReserva, enderecoColeta, enderecoDestino, passageiros,
				data, horario);

		try {
			repositorio.registroTranslado(translado);
		} catch (BDException mensagem) {
			throw new CoreException(mensagem.getMessage(), mensagem);
		}
	}

	public void registroServicoTranslado(int id, int passageiros) throws CoreException {

		try {
			Translado translado = new Translado(id, passageiros);
			repositorio.registroServico(translado);
		} catch (BDException mensagem) {
			throw new CoreException(mensagem.getMessage(), mensagem);
		}
	}

	public void alterarArrumacao(int numeroQuarto, String estado) throws CoreException {

		if (numeroQuarto == 0) {
			throw new CoreException("Numero do Quarto é inválido");
		}

		Arrumacao arrumacao = new Arrumacao(numeroQuarto, estado);

		try {

			repositorio.alterarArrumacao(arrumacao);

		} catch (BDException mensagem) {
			throw new CoreException(mensagem.getMessage(), mensagem);

		}
	}

	public void registroServicoEstacionamento(int id, int vagas) throws CoreException {

		if (id == 0) {
			throw new CoreException("O número de id é inválido");
		}

		if (vagas == 0) {
			throw new CoreException("O número de veículos é inválido");
		}

		if (vagas > 3) {
			throw new CoreException(
					"O número digitado excedeu o limite de registros de vagas de uma só vez, que são 3 vagas");
		}

		try {
			Estacionamento estacionamento = new Estacionamento(id, vagas);
			repositorio.registroServico(estacionamento);
		} catch (BDException mensagem) {
			throw new CoreException(mensagem.getMessage(), mensagem);
		}
	}

	public void registroRestaurante(int idReserva, String refeicao, int quantidade, LocalDate data, LocalTime time,
			String observacao) throws CoreException {

		if (refeicao.equals("")) {
			throw new CoreException("O Tipo de refeição não foi selecionado");
		}

		if (idReserva == 0) {
			throw new CoreException("O ID da pessoa digitado é inválido. Por favor, digite um número válido.");
		}

		if (quantidade == 0) {
			throw new CoreException("Quantidade da refeição é inválida. por favor, digite um número válido");
		}
		if (quantidade > 10) {
			throw new CoreException(
					"Quantidade limite de refeições simultâneas em uma única reserva foi excedida (10)");
		}

		RestaurantePedidos restaurante = new RestaurantePedidos(data, time, quantidade, idReserva, observacao,
				refeicao);

		try {

			repositorio.registroRestaurante(restaurante);

		} catch (BDException mensagem) {
			throw new CoreException(mensagem.getMessage(), mensagem);
		}

	}

	public void registroServicoRestaurante(int id, String refeicao, int quantidade) throws CoreException {

		try {
			Restaurante restaurante = new Restaurante(id, refeicao, quantidade);
			repositorio.registroServico(restaurante);
		} catch (BDException mensagem) {

			throw new CoreException(mensagem.getMessage(), mensagem);

		}

	}

	public void registroReserva(int numeroQuarto, String CPF, LocalDate dataEntrada, LocalDate dataSaida,
			String observacoes) throws CoreException {

		LocalDate dataAtual = LocalDate.now();

		if (dataEntrada.isBefore(dataAtual)) {
			throw new CoreException("A data de entrada é anterior a data atual, informe uma data válida.");

		}
		
		LocalDate dataAtualMais1Ano = null;
		dataAtualMais1Ano = dataAtual.plusYears(1);
		
		if (dataEntrada.isAfter(dataAtualMais1Ano)) {
			throw new CoreException("A data de entrada da reserva não pode ser posterior a 1 ano a partir da data atual. Por favor, "
					+ "verifique a data de entrada e insira uma data válida dentro do limite de 1 ano.");
		}
		
		
		

		if (dataEntrada.isAfter(dataSaida)) {
			throw new CoreException("A data de entrada é posterior a data de saída.");
		}

		if (dataEntrada.equals(dataSaida)) {
			throw new CoreException("As datas informadas são iguais, faça a reserva para passar no mínimo 1 dia no hotal.");
		}

		if (numeroQuarto == 0) {
			throw new CoreException("O número do quarto digitado é invalido.");
		}

		if (CPF.isBlank()) {
			throw new CoreException("O campo CPF está vazio.");
		}

		if (CPF.length() != 11) {
			throw new CoreException("O campo CPF foi preenchido incorretamente.");
		}

		Reserva reserva = new Reserva(numeroQuarto, CPF, dataEntrada, dataSaida, observacoes);

		try {

			repositorio.registroReserva(reserva);

		} catch (BDException mensagem) {

			throw new CoreException(mensagem.getMessage());
		}

	}

	public void mudarPreco(String stringPreco, int id) throws CoreException {

		if (stringPreco.equals("") || stringPreco.equals("0") || stringPreco.isEmpty()) {
			throw new CoreException("O valor colocado no campo preço é inválido");

		}

		char filtro = '.';
		int contador = 0;

		for (int i = 0; i < stringPreco.length(); i++) {
			char currentChar = stringPreco.charAt(i);
			if (currentChar == filtro) {
				contador++;
			}
		}

		if (contador > 1) {
			throw new CoreException(
					"Ops, parece que ocorreu um erro na digitação das casas decimais do preço. Por favor, verifique novamente e certifique-se de usar apenas um ponto nas casas decimais.");
		}

		double valor = Double.parseDouble(stringPreco);

		Precos preco = new Precos(valor, id);

		try {

			repositorio.registroPrecos(preco);

		} catch (BDException exception) {
			throw new CoreException(exception.getMessage());

		}
	}

	public void registroPedidoDeQuarto(String idReserva, String numeroQuarto, String quantidadeRefeicao,
			String refeicao, String observacoes) throws CoreException {

		if (quantidadeRefeicao.isBlank()) {
			throw new CoreException("O campo quantidade de refeições está vazio.");
		}

		if (idReserva.isBlank()) {
			throw new CoreException("O campo Id Reserva está vazio.");

		}

		if (numeroQuarto.isBlank()) {
			throw new CoreException("O campo Número do Quarto está vazio.");

		}

		if (refeicao.isBlank()) {
			throw new CoreException("A opção de refeição não foi selecionada.");
		}

		int numeroDoQuarto = Integer.parseInt(numeroQuarto);
		int numeroReserva = Integer.parseInt(idReserva);
		LocalDateTime datahora = LocalDateTime.now();
		int numeroDeRefeicao = Integer.parseInt(quantidadeRefeicao);

		if (numeroDeRefeicao == 0) {
			throw new CoreException("Quantidade da refeição é inválida. por favor, digite um número válido");
		}

		if (numeroDeRefeicao > 10) {
			throw new CoreException(
					"Quantidade limite de refeições simultâneas em uma única reserva foi excedida (10)");
		}

		try {

			RegistroServicoDeQuarto registro = new RegistroServicoDeQuarto(numeroDoQuarto, numeroReserva,
					numeroDeRefeicao, refeicao, datahora, observacoes);
			repositorio.registroServicoDeQuarto(registro);

		} catch (BDException exception) {
			throw new CoreException(exception.getMessage());

		}

	}

	public void registroServicoDeQuarto(String id, String refeicao, String quantidade) throws CoreException {

		int numeroId = Integer.parseInt(id);
		int numeroQuantidade = Integer.parseInt(quantidade);

		try {
			ServicoDeQuarto servicoQuarto = new ServicoDeQuarto(numeroId, numeroQuantidade, refeicao);
			repositorio.registroServico(servicoQuarto);
		} catch (BDException mensagem) {

			throw new CoreException(mensagem.getMessage());

		}

	}

	public void exclusaoHistoricoTranslado(int id) throws CoreException {

		if (id == 0) {
			throw new CoreException("Clique em uma linha na lista para depois clicar no botão Remover.");

		}

		try {

			repositorio.exclusaoHistoricoTranslado(id);

		} catch (BDException exception) {
			throw new CoreException(exception.getMessage());

		}
	}

	public void exclusaoServico(int id) throws CoreException {

		if (id == 0) {
			throw new CoreException("Clique em uma linha na lista para depois clicar no botão Remover.");

		}

		try {

			repositorio.exclusaoServico(id);

		} catch (BDException exception) {
			throw new CoreException(exception.getMessage());

		}

	}

	public void exclusaoServicoQuarto(int id) throws CoreException {

		if (id == 0) {
			throw new CoreException("Clique em uma linha na lista para depois clicar no botão Remover.");

		}

		try {

			repositorio.exclusaoServicoQuarto(id);

		} catch (BDException exception) {
			throw new CoreException(exception.getMessage());

		}

	}

	public void exclusaoRestaurante(int id) throws CoreException {

		if (id == 0) {
			throw new CoreException("Clique em uma linha na lista para depois clicar no botão Remover.");

		}

		try {

			repositorio.exclusaoRestaurante(id);

		} catch (BDException exception) {
			throw new CoreException(exception.getMessage());

		}

	}

}
