package br.com.sala.banheiro;

public class Principal {

	public static void main(String[] args) {
		
		Banheiro banheiro = new Banheiro();
		
		Thread convidado1 = new Thread(new TarefaNumero2(banheiro), "Pablo");
		Thread convidado2 = new Thread(new TarefaNumero1(banheiro), "Pedro");
		Thread convidado3 = new Thread(new TarefaNumero2(banheiro), "Foxy");
		Thread convidado4 = new Thread(new TarefaNumero1(banheiro), "Ranny");
		Thread limpeza = new Thread(new TarefaLimpeza(banheiro), "Aninha");
		limpeza.setDaemon(true);
		limpeza.setPriority(10);


		
		convidado1.start();
		convidado2.start();
		limpeza.start();
		convidado3.start();
		convidado4.start();
		
		
	}
}
