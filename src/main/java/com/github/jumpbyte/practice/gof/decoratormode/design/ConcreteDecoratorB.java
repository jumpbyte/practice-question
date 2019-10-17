package com.github.jumpbyte.practice.gof.decoratormode.design;

/**
 * 装饰对象B，向组件对象添加其他行为
 * @className: ConcreteDecoratorA
 * @author: yuanjinan
 * @create: 2018/12/26
 **/
public class ConcreteDecoratorB extends Decorator {

    public ConcreteDecoratorB(Component component) {
        super(component);
    }


    /**
     * 示例方法
     */
    @Override
    public void operation() {
        super.operation();
        addedBehavior();
    }

    /**
     * 需要添加的职责
     */
    private void addedBehavior() {
        //需要添加的职责实现
    }

    @Override
    public void anotherOperate() {

    }
}
