package com.github.jumpbyte.practice.algorithm;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @className: TaskTree
 * @author: yuanjinan
 * @create: 2023/06/07
 **/
public class TaskTree {

    public static class Task {
        public Date start;
        public Date end;
        public List<Task> children;

        public Task(Date start, Date end) {
            this.start = start;
            this.end = end;
            this.children = new ArrayList<>();
        }
    }

    public static void computeParentTimeDFS(Task root) {
        if (root.children.isEmpty()) return;

        Date parentStart = new Date(Long.MAX_VALUE);
        Date parentEnd = new Date(Long.MIN_VALUE);

        for (Task child : root.children) {
            computeParentTimeDFS(child);
            if (child.start.before(parentStart)) {
                parentStart = child.start;
            }
            if (child.end.after(parentEnd)) {
                parentEnd = child.end;
            }
        }

        root.start = parentStart;
        root.end = parentEnd;
    }

    public static void main(String[] args) {
        //构建多叉树
        Task root = new Task(new Date(2020, 1, 1), new Date(2020, 1, 1));
        Task child1 = new Task(new Date(2020, 1, 2), new Date(2020, 1, 5));
        Task child2 = new Task(new Date(2020, 1, 3), new Date(2020, 1, 7));
        Task child3 = new Task(new Date(2020, 1, 1), new Date(2020, 1, 4));
        Task child4 = new Task(new Date(2019, 1, 5), new Date(2020, 1, 8));
        Task child5 = new Task(new Date(2019, 1, 4), new Date(2020, 1, 9));
        root.children.add(child1);
        root.children.add(child2);
        child1.children.add(child3);
        child1.children.add(child4);
        child1.children.add(child5);

        //DFS遍历计算父节点时间
        computeParentTimeDFS(root);

        //打印结果
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(dateFormat.format(root.start)); //Wed Jan 01 01:00:00 GMT+08:00 2020
        System.out.println(dateFormat.format(root.end));   //Fri Jan 03 01:00:00 GMT+08:00 2020
    }
}
