package supermarket;

import DAO.ProdutoDAO;

import java.util.ArrayList;
import java.util.Scanner;

import DAO.PagamentoDAO;
import DAO.VendaDAO;

import supermarket.Produto;

public class Principal  {


	public static void main(String[] args) {

		int opcao = 0;
		int opcaoV=0;
		int opcaoP=0;
		int opcaoPg=0;
		Scanner ler = new Scanner(System.in);

		System.out.println("Menu"+"\n1 - Venda" + "\n2 - Produtos" + "\n3 - Pagamentos" + "\n4 - Sair");
		opcao = ler.nextInt();

		switch(opcao) {
		case 1:
			Venda venda1 = new Venda();
			VendaDAO vendadao = new VendaDAO();
			System.out.println("1 - Adicionar produto à venda" + "\n2 - Visualizar a venda total"+
					"\n3  -Concluir Venda" + "\n4-Voltar ao menu principal");
			opcaoV = ler.nextInt();
			switch(opcaoV) {
			case 1:
				System.out.println("Digite o ID do produto");


			}
		case 2:

			Produto prod1 = new Produto();
			ProdutoDAO produtodao = new ProdutoDAO();
			Produto prod2 = new Produto();
			ProdutoDAO produtodao2 = new ProdutoDAO();
			
			ArrayList<Produto> listaprodutos = new ArrayList<>();
			System.out.println("1-Cadastrar Produto" +	  
					"2-\nAlterar Produto" + "3-\nExcluir Produto "  + "\n4-Visualizar Produtos"+"\n5-Voltar ao menu principal");
			opcaoP = ler.nextInt();
			switch(opcaoP) {
			case 1:
				System.out.println("Digite o ID do produto");
				prod1.setId_produto(ler.nextInt());
				System.out.println("Digite o nome do produto");
				prod1.setNome(ler.next());
				System.out.println("Digite o preço do produto");
				prod1.setPreco(ler.nextDouble());
				System.out.println("Digite a quantidade de estoque");
				prod1.setQuantidadeEstoque(ler.nextInt());
				produtodao.create(prod1);


				System.out.println("Digite o ID do produto");
				prod2.setId_produto(ler.nextInt());
				System.out.println("Digite o nome do produto");
				prod2.setNome(ler.next());
				System.out.println("Digite o preço do produto");
				prod2.setPreco(ler.nextDouble());
				System.out.println("Digite a quantidade de estoque");
				prod2.setQuantidadeEstoque(ler.nextInt());
				produtodao2.create(prod2);
				
			case 2:
				System.out.println("Digite o ID do produto");
				prod1.setId_produto(ler.nextInt());
				System.out.println("Digite o nome do produto");
				prod1.setNome(ler.next());
				System.out.println("Digite o preço do produto");
				prod1.setPreco(ler.nextDouble());
				System.out.println("Digite a quantidade de estoque");
				prod1.setQuantidadeEstoque(ler.nextInt());
				produtodao.update(prod1);


				System.out.println("Digite o ID do produto");
				prod2.setId_produto(ler.nextInt());
				System.out.println("Digite o nome do produto");
				prod2.setNome(ler.next());
				System.out.println("Digite o preço do produto");
				prod2.setPreco(ler.nextDouble());
				System.out.println("Digite a quantidade de estoque");
				prod2.setQuantidadeEstoque(ler.nextInt());
				produtodao2.update(prod2);
				
			case 3:
				System.out.println("Digite o ID do produto");
				prod1.setId_produto(ler.nextInt());
				produtodao.delete(prod1);
				System.out.println("Digite o ID do produto");
				produtodao2.delete(prod2);
			case 4:
				return;
				
			}
		case 3:
			
			Pagamento pg1 = new Pagamento();
			PagamentoDAO pagamentodao = new PagamentoDAO();
			System.out.println("1-Cadastrar Pagamento" + "\n2-Alterar Pagamento" + "\n3-Excluir Pagamento" + "\n4-Visualizar Pagamento"
		+"\n5-Voltar ao menu principal");
			opcaoP = ler.nextInt();
			 switch(opcaoPg) {
			 case 1:
			
				 System.out.println("1 - Pagamento dinheiro" + "\n 2- Cheque" + "3-\n Cartão");
				 pg1.selecionarTipoPagamento(ler.nextInt());
				 pagamentodao.create(pg1);
			 case 2 :
				 System.out.println("1 - Pagamento dinheiro" + "\n 2- Cheque" + "3-\n Cartão");
				 pg1.selecionarTipoPagamento(ler.nextInt());
				 pagamentodao.update(pg1);
			 case 3 :
				 System.out.println("1 - Pagamento dinheiro" + "\n 2- Cheque" + "3-\n Cartão");
				 pg1.selecionarTipoPagamento(ler.nextInt());
				 pagamentodao.delete(pg1);
			 case 4:
				 return;
			 }
			
			
		}






	}

}
