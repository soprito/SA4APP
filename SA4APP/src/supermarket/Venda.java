package supermarket;

import java.util.ArrayList;



public class  Venda {
	
	 private double vlrTotal;
	 private  ArrayList<Produto> listavenda = new ArrayList<Produto>();
	 private int id_venda;
	
	 

	public Venda() {
		super();
	}

	public Venda(double vlrTotal, ArrayList<Produto> listavenda, int id_venda) {
		super();
		this.vlrTotal = vlrTotal;
		this.listavenda = listavenda;
		this.id_venda = id_venda;
	}
	

	public int getId_venda() {
		return id_venda;
	}

	public void setId_venda(int id_venda) {
		this.id_venda = id_venda;
	}

	public double getVlrTotal() {
		return vlrTotal;
	}

	public void setVlrTotal(double vlrTotal) {
		this.vlrTotal = vlrTotal;
	}

	public ArrayList<Produto> getListavenda() {
		return listavenda;
	}

	public void setListavenda(ArrayList<Produto> listavenda) {
		this.listavenda = listavenda;
	}
	
	public void adicionarItemVenda (Produto prod) {
		listavenda.add(prod);
		vlrTotal = getVlrTotal() + prod.getPreco();
	}
	
	public void visualizarVenda() {
		for(int cont=0; cont < listavenda.size() ;cont++) {
			System.out.println("Produto: " + listavenda.get(cont).getNome() + " - R$" + listavenda.get(cont).getPreco());
		}
	}

	public void concluirVenda(Pagamento pag) {
		
		System.out.println("Total da compra: " + vlrTotal);
		pag.realizarPagamento(pag);
		
	}
	
	

}
