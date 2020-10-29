package proxy;

        import java.lang.reflect.InvocationHandler;
        import java.lang.reflect.Method;
        import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        //1、创建真实对象
        Lenovo lenovo = new Lenovo();

        //2、动态代理增强lenovo对象
        /**
         * 三个参数
         * 1、类加载器：真实对象.getClass().getClassLoader()
         * 2、接口数组：真实对象.getClass().getInterfaces()
         * 3、处理器：new InvocationHandler()
         * */
        SaleComputer proxy_lenovo = (SaleComputer) Proxy.newProxyInstance(lenovo.getClass().getClassLoader(), lenovo.getClass().getInterfaces(), new InvocationHandler() {
            /*
             * 代理逻辑编写的方法：代理对象调用的所有方法都会触发该方法执行
             * 参数：
             * 1、proxy：代理对象
             * 2、method：代理对象调用的方法被封装为的对象
             * 3、args：代理对象调用方法时，传递的实际参数
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                System.out.println("该方法执行了...");    //代理对象每调用一次方法都会触发
//                System.out.println(method.getName());   //sale 和 show
//                System.out.println(args[0]);            //8000.0

                //判断是否是sale方法
                if (method.getName().equals("sale")) {
                    //1、增强参数
                    double money = (double) args[0];
                    money = money * 0.85;
                    System.out.println("专车接送");
                    //使用真实对象调用该方法，此时使用代理对象调用方法结果和真实对象一致
                    Object obj = method.invoke(lenovo, money);
                    System.out.println("免费送货");
                    //2、增强返回值类型
                    return obj + " + 鼠标垫";
                } else {
                    Object obj = method.invoke(lenovo, args);
                    return obj;
                }
            }
        });

        //3、调用方法
        //真实对象调用
        String computer1 = lenovo.sale(8000);  //花了8000.0元买了一台联想电脑...
        System.out.println(computer1);   //联想电脑
        lenovo.show();                  //展示电脑

        //代理对象调用
        String computer2 = proxy_lenovo.sale(8000);  //花了6800.0元买了一台联想电脑...
        System.out.println(computer2);   //联想电脑 + 鼠标垫
        proxy_lenovo.show();            //展示电脑
    }
}
