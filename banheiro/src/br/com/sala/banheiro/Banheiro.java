package br.com.sala.banheiro;

public class Banheiro {
	
	private boolean ehSujo = true;
	
	public void fazNumero1() {
		String nome = Thread.currentThread().getName();
		
		System.out.println(nome + " batendo na porta");
		
		synchronized (this) {
			System.out.println(nome + " entrando no banheiro");
			
			while(ehSujo) {
				esperaLaFora(nome);
			}
			
			System.out.println(nome + " fazendo coisa rapida");
			
			threadSleep(2000);
			
			this.ehSujo = true;
			System.out.println(nome + " dando descarga");
			System.out.println(nome + " lavando mao");
			System.out.println(nome + " saindo");
		}	
	}

	public void fazNumero2() {
		String nome = Thread.currentThread().getName();
		
		System.out.println(nome + " batendo na porta");
		
		synchronized (this) {
			System.out.println(nome + " entrando no banheiro");
			while(ehSujo) {
				esperaLaFora(nome);
			}
			System.out.println(nome + " fazendo coisa demorada");
			threadSleep(5000);			
			this.ehSujo = true;
			System.out.println(nome + " dando descarga");
			System.out.println(nome + " lavando mao");
			System.out.println(nome + " saindo");
		}
	}
	
	public void limpa() {
		String nome = Thread.currentThread().getName();
		
		System.out.println(nome + " batendo na porta");
		
		synchronized (this) {	
			System.out.println(nome + " entrando no banheiro");
			
			if(!ehSujo) {
				System.out.println(nome + " não está sujo, vou sair");
				return;
			} else {
				System.out.println(nome + " limpando o banheiro");
				this.ehSujo = false;
			}		
			
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(nome + " saindo");
			this.notifyAll();
		}
	}


	private void esperaLaFora(String nome) {
		System.out.println(nome + " Banheiro tá sujo");
		try {
			this.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void threadSleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
} 
