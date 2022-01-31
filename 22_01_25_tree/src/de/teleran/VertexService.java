package de.teleran;

// TODO implement 2 methods
public class VertexService {

    public int countHeight(Vertex root) {
        if (root == null)
            return -1;

        int leftSubtreeHeight = countHeight(root.getLeftChild());
        int rightSubtreeHeight = countHeight(root.getRightChild());

        return 1 + Math.max(leftSubtreeHeight, rightSubtreeHeight);
    }

    public int countVertices(Vertex root) {
        if (root == null)
            return 0;

        int leftSubtreeVertexNumber = countVertices(root.getLeftChild());
        int rightSubtreeVertexNumber = countVertices(root.getRightChild());

        return leftSubtreeVertexNumber + rightSubtreeVertexNumber + 1;
    }
}
