package supermarket;


public class Produto  {

	private String nome;
	private double preco;
	private int quantidadeEstoque;
	private int id_produto;
	
	public Produto(String nome, double preco, int quantidadeEstoque) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.quantidadeEstoque = quantidadeEstoque;
	}
	public Produto() {
		super();
	}
	
	public Produto(int id_produto, String nome, double preco, int quantidadeEstoque) {
		super();
		this.id_produto = id_produto;
		this.nome = nome;
		this.preco = preco;
		this.quantidadeEstoque = quantidadeEstoque;
	}

	
	public int getId_produto() {
		return id_produto;
	}

	public void setId_produto(int id_produto) {
		this.id_produto = id_produto;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}
	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}	
	
	
	
	public  boolean verificarEstoque(Produto prod)
	{
		boolean verificar = true ;
		
		
		if (prod.getQuantidadeEstoque() <= 0)
		{
			verificar = false;
			System.out.println("Produto sem estoque" + " " + prod.getNome());
		} 
		return verificar;
	}

	
}
