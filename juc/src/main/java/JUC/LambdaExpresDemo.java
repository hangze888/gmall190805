package JUC;

@FunctionalInterface
interface Foo {
    public void sayHello();
}

//1.拷贝小括号，写死右箭头，落地大括号
//2.添加注解@FunctionalInterface注明为函数式接口
//3.default再接口中可以有多个
//4.接口可以new
public class LambdaExpresDemo {
    public static void main(String[] args) {
        Foo foo = new Foo() {
            @Override
            public void sayHello() {
                System.out.println("....hello");
            }
        };

        foo.sayHello();

        Foo foo2 = ()->{System.out.println("....helloLambda");};
        foo2.sayHello();
    }
}
