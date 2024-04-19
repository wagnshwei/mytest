import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class TaskOne {

    public static void main(String[] args) {
        // 定义线程数量
        final int threadCount = 5;
        // 初始化CyclicBarrier
        CyclicBarrier barrier = new CyclicBarrier(threadCount, new Runnable() {
            @Override
            public void run() {
                // 当所有线程均到达屏障点时执行
                System.out.println("所有线程均已到达屏障点，可以继续执行后续任务...");
            }
        });

        // 创建并启动线程
        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(new Task(barrier), "线程" + i);
            thread.start();
        }
    }

}

class Task implements Runnable {
    private CyclicBarrier barrier;

    public Task(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " 正在执行任务...");
            // 模拟任务执行
            Thread.sleep((long) (Math.random() * 1000));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        try {
            // 屏障点开放后执行的代码
            System.out.println(Thread.currentThread().getName() + " 屏障点开放，继续执行后续操作...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}