package supermarket;

public class Pagamento {

	private int tipoPagamento;


	public Pagamento() {
		super();
	}


	public Pagamento(int tipoPagamento) {
		super();
		this.tipoPagamento = tipoPagamento;
	}


	public int getTipoPagamento() {
		return tipoPagamento;
	}


	public void setTipoPagamento(int tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}



	public void selecionarTipoPagamento(int pag) {
		


		if (pag == 1) { System.out.println("Pagamento em dinheiro");

		}else if(pag==2){ System.out.println("Pagamento em cheque");
		}
		else if (pag == 3) { System.out.println("Pagamento em cartão");

		}else{System.out.println("opçaõ inválida");}
		
		tipoPagamento = pag;
	}
	
	public void realizarPagamento(Pagamento pag) {
		
		System.out.println("Pagamento foi realizado com sucesso" + "" + "\nPagamento tipo:" + "" + pag.tipoPagamento);
	}
}
