package com.github.jumpbyte.practice.gof.decoratormode.design;

/**
 * 装饰器接口，维持一个指向组件对象的接口对象，并定义一个与组件接口一致的接口
 * @className: Decorator
 * @author: yuanjinan
 * @create: 2018/12/26
 **/
public abstract class Decorator extends Component {

    private Component component;

    public Decorator(Component component){
        this.component = component;
    }

    /**
     * 示例方法
     */
    @Override
    public void operation() {
        ///ddd
        this.component.operation();
    }

    public abstract void anotherOperate();
}
