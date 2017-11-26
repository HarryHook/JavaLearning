package com.skywang.thread;

class Depository {
    private int size;
    private int capacity;

    public Depository(int capacity) {
        this.capacity = capacity;
        this.size = 0;
    }

    public synchronized void produce(int val) {
        try {
            // left 表示“想要生产的数量“
            int left = val;
            while (left > 0) {
                // 库存已满时，等待“消费者”消费产品。
                while (size >= capacity) {
                    wait();
                }
                int inc = (size + left) > capacity ? (capacity - size) : left;
                size += inc;
                left -= inc;

                System.out.printf("%s produce(%3d) --> left=%3d, inc=%3d, size=%3d\n",
                        Thread.currentThread().getName(), val, left, inc, size);
                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void consume(int val) {
        try {
            // left 表示“想要消费的数量“
            int left = val;
            while (left > 0) {
                // 库存为空，等待“生产者”生产产品。
                while (size <= 0) {
                    wait();
                }
                int dec = (size < left) ? size : left;
                size -= dec;
                left -= dec;

                System.out.printf("%s consume(%3d) <--- left=%3d, dec=%3d, size=%3d\n",
                        Thread.currentThread().getName(), val, left, dec, size);
                notifyAll();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        return "capacity:" + capacity + ", actual size:" + size;
    }
}

class Producer {
    private Depository depository;

    public Producer(Depository depository) {
        this.depository = depository;
    }

    public void produce(final int val) {
        new Thread() {
            @Override
            public void run() {
                depository.produce(val);
            }
        }.start();
    }
}

class Customer {
    private Depository depository;

    public Customer(Depository depository) {
        this.depository = depository;
    }

    public void consume(final int val) {
        new Thread() {
            @Override
            public void run() {
                depository.consume(val);
            }
        }.start();
    }
}

public class ProAndCusDemo {

    public static void main(String[] args) {
        Depository depo = new Depository(150);
        Producer pro = new Producer(depo);
        Customer cus = new Customer(depo);

        pro.produce(50);
        pro.produce(100);
        cus.consume(10);
        cus.consume(50);
        cus.consume(20);

    }


}
