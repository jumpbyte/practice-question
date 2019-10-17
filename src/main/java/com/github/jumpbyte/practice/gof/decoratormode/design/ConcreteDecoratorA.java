package com.github.jumpbyte.practice.gof.decoratormode.design;

/**
 * 装饰A，向组件对象添加其他属性
 * @className: ConcreteDecoratorA
 * @author: yuanjinan
 * @create: 2018/12/26
 **/
public class ConcreteDecoratorA extends Decorator {

    /**
     * 被添加了一个状态属性
     */
    private String addedState;

    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    /**
     * 示例方法
     */
    @Override
    public void operation() {
        //调用父类的方法，可以在调用前后执行一些附加动作
        //在这里进行处理的时候，可以使用添加的状态
        super.operation();
    }

    @Override
    public void anotherOperate() {

    }

    public String getAddedState() {
        return addedState;
    }

    public void setAddedState(String addedState) {
        this.addedState = addedState;
    }
}
