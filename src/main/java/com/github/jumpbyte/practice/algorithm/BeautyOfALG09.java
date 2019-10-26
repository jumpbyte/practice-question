package com.github.jumpbyte.practice.algorithm;

/**
 * 数据结构与算法之美 09节 队列
 * <p>
 * 练习题目
 *
 * @className: BeautyOfALG
 * @author: yuanjinan
 * @create: 2019/10/24
 **/
public class BeautyOfALG09 {


    public class  ArrayQueue{

        private String[] items;
        //指向队尾
        private int tail;
        //指向队头
        private int head;
        //队列长度
        private int count;

        public ArrayQueue(int capacity){
            this.items = new String[capacity];
            this.count = capacity;
        }


        public boolean enqueue(String item){
            if(tail == count){
                //队列已满 入队失败
                return false;
            }
            this.items[tail] = item;
            ++tail;
            return true;
        }

        public String dequeue(){
            //队列已空
            if(head == tail){
                return null;
            }
            String tmp = this.items[head];
            ++ head;

            return tmp;
        }

    }

    //优化队列空间使用
    public class  ArrayQueueV1{

        private String[] items;
        //指向队尾
        private int tail;
        //指向队头
        private int head;
        //队列长度
        private int count;

        public ArrayQueueV1(int capacity){
            this.items = new String[capacity];
            this.count = capacity;
        }


        public boolean enqueue(String item){
            if(tail == count){
                // tail = count head =0 说明队列没有空间了
                if(head == 0 ) {
                    return  false;
                }
                //taill=coun head>0 说明队列还有head-1个空间，但由于tail已到队尾最后一个元素，无法再移动，此时需要进行数据搬移
                for(int i = head ;i<tail; ++i ){
                    this.items[i-head] = this.items[i];
                }
            }
            this.items[tail] = item;
            ++tail;
            return true;
        }

        public String dequeue(){
            //队列已空
            if(head == tail){
                return null;
            }
            String tmp = this.items[head];
            ++ head;

            return tmp;
        }

    }

    //循环队列
    public class CircleQueue{

        private String[] items;
        private int n;
        private int head = 0;
        private int tail = 0;

        public CircleQueue(int capacity){
            this.items = new String[capacity];
            this.n = capacity ;
        }

        public boolean enqueue(String item){
            if((tail +1) % n == head) {
                //队列已满
                return false;
            }
            items[tail] = item ;
            tail = (tail + 1) % n;
            return true;
        }

        public String dequeue(){
            if(head == tail){
                //队列为空
                return null;
            }
            String ret = items[head];
            head = (head + 1) % n;

            return ret;
        }


    }

}
