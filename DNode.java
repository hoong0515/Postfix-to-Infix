class DNode {
    public Object data;
    public DNode prev = null;
    public DNode next = null;

    public DNode(Object x) {
        this.data = x;
    }

    public DNode(Object x, DNode prev, DNode next) {
        this.data = x;
        this.prev = prev;
        this.next = next;
    }
}