public class ThreadStartExample {
    public static void main(String[] args) {
        PrintThread1 a = new PrintThread1("*");
        PrintThread1 b = new PrintThread1("-");

       a.setDaemon(true);
       b.setDaemon(true);

       a.start();
       b.start();




    }

}
