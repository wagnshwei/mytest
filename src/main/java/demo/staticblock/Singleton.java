package demo.staticblock;

/**
 线程安全：
    利用Java类加载机制的一次性加载特性来保证线程安全。
    无需显式的同步机制，避免了锁带来的性能开销。
 懒加载：
    单例对象只有在首次调用 getInstance() 方法时才会被创建。
    实现了真正的懒加载，提高了资源利用率。
 简洁性：
    代码结构简单，易于理解和维护。
    没有复杂的同步机制或双重检查锁定等技术。
 避免反射攻击：
    可以在构造方法中添加检查，防止通过反射机制创建多个实例
 */
public class Singleton {

    // 私有构造方法，防止外部直接实例化
    private Singleton() {
        // 防止反射攻击
        if (SingletonHolder.instance != null) {
            throw new IllegalStateException("Singleton instance already exists!");
        }
    }

    // 静态内部类，持有单例对象
    private static class SingletonHolder {
        private static final Singleton instance = new Singleton();
    }

    // 提供一个公共的静态方法来获取单例对象
    public static Singleton getInstance() {
        return SingletonHolder.instance;
    }

    // 示例方法，展示单例类的功能
    public void doSomething() {
        System.out.println("Doing something...");
    }
}
