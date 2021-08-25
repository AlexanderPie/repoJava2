package lesson4.concurrency.part1;

public class PrintABCApp {

    private volatile char currentLetter = 'A';

    private final Object monitor = new Object();

    public static void main(String[] args) {
        PrintABCApp waitNotifyApp = new PrintABCApp();
        new Thread(() -> {
            waitNotifyApp.printA();
        }).start();
        new Thread(() -> {
            waitNotifyApp.printB();
        }).start();
        new Thread(() -> {
            waitNotifyApp.printC();
        }).start();
    }

    public void printA() {
        synchronized (monitor) {
            for (int i = 0; i < 5; i++) {
                try {
                    while (currentLetter != 'A') {
//                        monitor.wait();
                        monitor.wait(5000);
                    }
                    System.out.print("A");
                    currentLetter = 'B';
                    monitor.notify();
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void printB() {
        synchronized (monitor) {
            for (int i = 0; i < 5; i++) {
                try {
                    while (currentLetter != 'B') {
//                        monitor.wait();
                        monitor.wait(5000);
                    }
                    System.out.print("B");
                    currentLetter = 'C';
                    monitor.notify();
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void printC() {
        synchronized (monitor) {
            for (int i = 0; i < 5; i++) {
                try {
                    while (currentLetter != 'C') {
//                        monitor.wait();
                        monitor.wait(5000);
                    }
                    System.out.print("C");
                    currentLetter = 'A';
                    monitor.notify();
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
