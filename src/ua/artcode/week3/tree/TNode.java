package ua.artcode.week3.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by serhii on 23.09.17.
 */
public class TNode<T> {

    private T value;
    private List<TNode<T>> children;

    public TNode(T value) {
        this.value = value;
        this.children = new ArrayList<>();
    }

    public TNode(T value, List<TNode<T>> children) {
        this.value = value;
        this.children = children;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public List<TNode<T>> getChildren() {
        return children;
    }

    public void setChildren(List<TNode<T>> children) {
        this.children = children;
    }

    public TNode<T> addChildren(TNode<T> child){
        this.children.add(child);
        return this;
    }
}
