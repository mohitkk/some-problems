package Testing;

import java.util.HashMap;
import java.util.Map;

public class MinHeapAndMap<D> {
    
    Node<D>[] index;
    Map<Node<D>, Integer> map;
    int count;
    int max;

    MinHeapAndMap(final int max) {
        this.max = max;
        this.count = 0;
        this.map = new HashMap<Node<D>, Integer>();
        this.index = new Node[10];
    }
    public static void main(final String args[]) {
        final int[] input1 = {3,1,4,5,6,11,-1,-5,-10};
        final String[] input2 = { "a", "b", "c", "d", "e", "f", "g", "h", "i" };
        final MinHeapAndMap heap = new MinHeapAndMap(400);
        for (int i = 0; i < input1.length; i++) {
            heap.addNode(heap.new Node(input2[i], input1[i]));
        }
        System.out.println(heap.map);
        for (final Object each : heap.index) {
            System.out.println(each);
        }
        final MinHeapAndMap.Node min = heap.getMinimum();
        System.out.println("Minimum " + min);
        System.out.println(heap.map);

        heap.decrease(heap.index[7], -100);
        System.out.println();
        System.out.println(heap.map);
        System.out.println();
        System.out.println(heap.contains(heap.index[7]));
        System.out.println(heap.contains(min));
    }

    private void addNode(final Node node) {
        checkSize();
        index[count] = node;
        map.put(node, count);
        satisfyHeapProperty(node, count, "add");
        count++;
        maintainSize();
    }

    private void checkSize() {
        if (getCapacity() == 0) {
            throw new RuntimeException("no new element can be added.");
        }
    }

    public boolean contains(final Node e) {
        return map.containsKey(e);
    }

    public int getCapacity() {
        return max - count;
    }
    private void maintainSize() {
        if (count > index.length / 2) {
            final Node[] temp = new Node[2 * index.length];
            for (int i = 0; i < index.length; i++) {
                temp[i] = index[i];
            }
            index = temp;
        }
    }
    private void satisfyHeapProperty(final Node node, final int position, final String operation) {
        if (operation.equals("add") || operation.equals("decrease")) {
            final int parentPosition = (position - 1) / 2;
            final Node parent = index[parentPosition];
            if (parentPosition < 0) {
                return;
            } else if (node.getValue() < parent.getValue()) {
                index[parentPosition] = node;
                map.put(node, parentPosition);
                index[position] = parent;
                map.put(parent, position);
                satisfyHeapProperty(node, parentPosition, operation);
            }
        } else if (operation.equals("remove") || operation.equals("increase")) {
            final int leftChildPosition = 2 * position + 1;
            final int rightChildPosition = 2 * position + 2;
            int positionToSwapped = -1;
            Node nodeToBeSwapped = null;
            Node leftChild = null;
            Node rightChild = null;
            if (leftChildPosition < index.length) {
                leftChild = index[leftChildPosition];
            }
            if (rightChildPosition < index.length) {
                rightChild = index[rightChildPosition];
            }
            if (leftChild != null && rightChild != null) {
                positionToSwapped = leftChild.getValue() <= rightChild.getValue() ? leftChildPosition
                        : rightChildPosition;
                nodeToBeSwapped = leftChild;
            } else if (leftChild == null && rightChild != null) {
                positionToSwapped = rightChildPosition;
                nodeToBeSwapped = rightChild;
            } else if (leftChild != null && rightChild == null) {
                positionToSwapped = leftChildPosition;
                nodeToBeSwapped = leftChild;
            }
            if (nodeToBeSwapped != null && positionToSwapped >= 0 && node.getValue() > nodeToBeSwapped.getValue()) {
                index[position] = nodeToBeSwapped;
                index[positionToSwapped] = node;
                map.put(node, positionToSwapped);
                map.put(nodeToBeSwapped, position);
                satisfyHeapProperty(node, positionToSwapped, operation);
            }
        }
    }

    public Node getMinimum() {
        final Node last = index[count - 1];
        index[count - 1] = null;
        final Node result = index[0];
        index[0] = last;
        satisfyHeapProperty(last, 0, "remove");
        map.remove(result);
        count--;
        return result;
    }

    public void decrease(final Node e, final long val) {
        if (map.containsKey(e)) {
            final int pos = map.get(e);
            final Node ele = index[pos];
            ele.setValue(val);
            satisfyHeapProperty(ele, pos, "decrease");
        }
    }

    private class Node<D> {

        private D data;
        private long value;

        Node(final D data, final long value) {
            this.data = data;
            this.value = value;
        }

        public D getData() {
            return data;
        }

        public void setData(final D data) {
            this.data = data;
        }

        public long getValue() {
            return value;
        }

        public void setValue(final long value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node [data=" + data + ", value=" + value + "]";
        }

    }
}
