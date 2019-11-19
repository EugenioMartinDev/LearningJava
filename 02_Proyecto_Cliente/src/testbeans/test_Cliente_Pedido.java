package testbeans;

import beans.Cliente;
import beans.Pedido;

public class test_Cliente_Pedido {

	public static void main(String[] args) {


		Cliente cliente01 = new Cliente("juan", "j_001", "Juan", "Martínez", "Madrid");		
		Cliente cliente02 = new Cliente("maria", "m_001", "María", "Suárez", "Barcelona");
		
		Pedido pedido01 = new Pedido(1, "primerPedido", 25_005.37, true, cliente01);		
		Pedido pedido02 = new Pedido(2, "segundorPedido", 38_005.44, true, cliente01);
		Pedido pedido03 = new Pedido(3, "tercerPedido", 15_028.29, false, cliente02);
		
		
		System.out.println("Cliente 01 : " + cliente01);
		System.out.println("Cliente 02 : " + cliente02);

		System.out.println("Pedido 01 : " + pedido01);
		System.out.println("Pedido 02 : " + pedido02);
		System.out.println("Pedido 03 : " + pedido03);
		
		System.out.println();
		
		Cliente clienteProvisional = Cliente.dameCliente();	
		System.out.println("Cliente Provisional :  " + clienteProvisional);		
		
		Cliente[] clientesProvisionales = Cliente.dameClientes();
		
		System.out.println();
		
		System.out.println("Clientes Provisionales :  ");
		if (clientesProvisionales != null)
		for (int i=0; i<clientesProvisionales.length;i++)
			System.out.println("\t" + clientesProvisionales[i]);
		else
			System.out.println("\tNo existen");
		
		System.out.println();
				
		Pedido pedidoProvisional = Pedido.damePedido();
		System.out.println("Pedido Provisional :  " + pedidoProvisional);
		
		System.out.println();
		
		Pedido[] pedidosProvisionales = Pedido.damePedidos();
				
		System.out.println("Pedido Provisionales :  ");
		if (pedidosProvisionales != null)
			for (Pedido elemento : pedidosProvisionales)		
				System.out.println("\t" + elemento);
		else
			System.out.println("\tNo existen");
		
		
		System.out.println();
		
		System.out.println("Pedido 01 tiene un importe de : " + pedido01.getImporte() + " y con un iva de 3% se incrementa a : " + pedido01.totalImporte(3));
				
		System.out.println();
		
		System.out.println("Pedido 03 tiene un importe de : " + pedido03.getImporte() + " y con un iva de 3% se incrementa a : " + pedido03.totalImporte(5));
		
		
		
	}

}
