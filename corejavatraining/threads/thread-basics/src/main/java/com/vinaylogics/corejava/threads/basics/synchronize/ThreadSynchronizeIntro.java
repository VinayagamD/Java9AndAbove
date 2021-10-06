package com.vinaylogics.corejava.threads.basics.synchronize;

public class ThreadSynchronizeIntro {

    public static void main(String[] args) {
        Sender sender = new Sender();
        ThreadSender s1 = new ThreadSender(" Hi ", sender);
        ThreadSender s2 = new ThreadSender( " Bye ", sender);

        // Start two threads of ThreadSend type
        s1.start();
        s2.start();
        // wait for threads to end
        try
        {
            s1.join();
            s2.join();
        }
        catch(Exception e)
        {
            System.out.println("Interrupted");
        }

    }

    public static class Sender {
        public  void send(String message){
            System.out.println("Sending \t" + message);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /*public static class Sender {
        public  synchronized void send(String message){
            System.out.println("Sending \t" + message);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }*/

    /*public static class Sender {
        public  synchronized void send(String message){
            synchronized (this) {
                System.out.println("Sending \t" + message);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }*/

    public static class ThreadSender extends Thread {
        private String message;
        private Sender sender;

        public ThreadSender(String message, Sender sender) {
            this.message = message;
            this.sender = sender;
        }

        @Override
        public void run() {
            // Only one thread can send a message
            // at a time.
            synchronized(sender)
            {
                // synchronizing the snd object
                sender.send(message);
            }
        }
    }

    /*public static class ThreadSender extends Thread {
        private String message;
        private Sender sender;

        public ThreadSender(String message, Sender sender) {
            this.message = message;
            this.sender = sender;
        }

        @Override
        public void run() {
            // Only one thread can send a message
            // at a time.

                // synchronizing the snd object
                sender.send(message);

        }
    }*/


}
