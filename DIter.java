class DIter {
    public DNode cur;
    public DList lst;
    public DIter(DList x) {
        this.lst = x;
        this.cur = lst.first;
    }
    public boolean atEnd() {
        return this.cur == null;
    }
    public Object getValue() {
        if(this.atEnd()) {
            return null;
        } else {
            return this.cur.data;
        }
    }
    public boolean setValue(Object x) {
        if(this.atEnd()) {
            return false;
        } else {
            this.cur.data = x;
            return true;
        }
    }
    public Object delete() {
        Object rtn;
        if(this.atEnd()) {
            return null;
        } else {
            rtn = this.cur.data;
            this.cur.prev.next = this.cur.next;
            this.cur.next.prev = this.cur.prev;
            this.cur = this.cur.next;
            return rtn;
        }
    }
    public void insertBefore(Object x) {
        if(this.atEnd()) {
            lst.insertAtEnd(x);
        } else if(this.cur.prev == null) {
            this.cur.prev = new DNode(x, null, this.cur);
            this.lst.first = this.cur.prev;
        } else {
            this.cur.prev = new DNode(x, this.cur.prev, this.cur);
            this.cur.prev.prev.next = this.cur.prev;
        }

    }
    public boolean insertAfter(Object x) {
        if(this.atEnd()) {
            return false;
        } else if(this.cur.next == null) {
            this.cur.next = new DNode(x, this.cur, null);
            this.lst.last = this.cur.next;
            return true;
        } else {
            this.cur.next = new DNode(x, this.cur, this.cur.next);
            this.cur.next.next.prev = this.cur.next;
            return true;
        }

    }
    public void prev() {
        if(this.cur == null || this.cur.prev == null) {
            return;
        } else if(atEnd()) {
            this.cur = lst.last;
        } else {
            this.cur = this.cur.prev;
        }
    }
    public void next() {
        if(this.atEnd()) {
            return;
        } else {
            this.cur = this.cur.next;
        }
    }
}