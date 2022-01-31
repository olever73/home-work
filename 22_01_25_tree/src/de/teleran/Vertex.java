package de.teleran;

public class Vertex {

    Vertex leftChild;
    Vertex rightChild;

    public Vertex getLeftChild() {
        return leftChild;
    }

    public Vertex getRightChild() {
        return rightChild;
    }

    public Vertex(Vertex leftChild, Vertex rightChild) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

}

