package Test;

import Modelo.Cliente;
import Modelo.Pedido;
import Modelo.PedidoItem;
import Modelo.Produto;
import Modelo.Status;
import java.math.BigDecimal;
import org.junit.Assert;
import org.junit.Test;

public class NovoPedidoTest {
    
    private Pedido pedido;
    
    @Test
    public void testAceitar() {
        this.montaCenario();
        this.pedido.aceitar();
        
        Assert.assertEquals(Status.Aceito, this.pedido.getStatus());
    }
    
    @Test(expected = IllegalStateException.class)
    public void testPagar() {
        this.montaCenario();
        this.pedido.pagar();
    }
    
    @Test
    public void testCancelar() {
        this.montaCenario();
        this.pedido.cancelar();
        
        Assert.assertEquals(Status.Cancelado, this.pedido.getStatus());
    }   
    
    private void montaCenario() {
        Cliente cliente = new Cliente();
        cliente.setNome("UECE");
        cliente.setCnpj("49.887.826/0001-03");
        cliente.setCidade("Fortaleza");
        
        
        Produto produto = new Produto();
        produto.setNome("Livro");
        produto.setPreco(50.0);
        
        
        this.pedido = new Pedido();
        this.pedido.setNumero("123");
        this.pedido.setCliente(cliente);
                
        PedidoItem item = new PedidoItem();
        item.setProduto(produto);
        item.setQuantidade(2);
        item.setPedido(this.pedido);   
    }
    
}
