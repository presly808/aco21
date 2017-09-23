package ua.artcode.week3.tree;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * Created by serhii on 23.09.17.
 */
public class Test {

    public static void main(String[] args) {
        TNode<Integer> tNode =
                new TNode<>(10, Arrays.asList(
                        new TNode<>(20, Arrays.asList(
                                new TNode<>(30, null))),
                        new TNode<>(20, null)));


        TNode<Integer> root =
                new TNode<>(10)
                        .addChildren(new TNode<>(20)
                                .addChildren(new TNode<>(40)))
                        .addChildren(new TNode<>(30)
                                .addChildren(new TNode<>(50)));

//        System.out.println(toStr(root,"\t"));
        System.out.println(toStr2(root));
    }


    public static String toStr(TNode<Integer> root, String tabs) {
        if(root == null){
            return "";
        }

        // for each -> iterator
        List<TNode<Integer>> children = root.getChildren();
        if(children == null){
            return root.getValue() + "";
        }

        String res = "";
        for (TNode<Integer> child : children) {
            res += toStr(child,tabs + "\t");
        }


        return tabs + root.getValue() + "\n" + res;
    }

    public static String toStr2(TNode<Integer> root) {
        Queue<TNode<Integer>> queue = new ArrayDeque<>();

        queue.add(root);
        String str = "\t";
        String res = "";

        while (!queue.isEmpty()){
            // remove
            TNode<Integer> curr = queue.remove();
            //action
            res += curr.getValue() + "-";
            //next step
            queue.addAll(curr.getChildren());
        }

        return res;

    }
}
