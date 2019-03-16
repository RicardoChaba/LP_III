public class PrintThread1 extends Thread {

	    String nome;

	    public PrintThread1(String nome) {
	        this.nome = nome;
	    }

	    public void run(){

	        for (int i = 0; i < 100; i++) {
	            try {
	                sleep((long) (Math.random()*100));
	            } catch (InterruptedException e) {

	            }

	            System.out.print(nome);
	        }

	    }

	}
	

