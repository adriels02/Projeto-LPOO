package cadastroCliente;

import java.util.ArrayList;
public class ArmazenarCadastroCliente {
	
ArrayList<Cliente> clientes = new ArrayList<>();
public boolean salvar(Cliente cliente) {
	if (cliente != null) {
		clientes.add(cliente);
		return true;
	} else {
		return false;
	}
}
public ArrayList<Cliente> mostrarTodosClientes(){
	return clientes;
}
}
