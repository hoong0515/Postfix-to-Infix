class DList {
    public DNode first;
    public DNode last;
    public DList() {
        this.first = null;
        this.last = null;
    }
    public void insertAtFront(Object x) {
        if (this.first == null) {
            this.first = new DNode(x);
            this.last = this.first;
        } else {
            this.first.prev = new DNode(x);
            this.first.prev.next = this.first;
            this.first = this.first.prev;
        }
    }
    public void insertAtEnd(Object x) {
        if (this.last == null) {
            this.last = new DNode(x);
            this.first = this.last;
        } else {
            this.last.next = new DNode(x);
            this.last.next.prev = this.last;
            this.last = this.last.next;
        }
    }
    public Object deleteFromFront() {
        Object rtn;
        if (this.first == null) {
            return null;
        } else if(this.first == this.last) {
            rtn = this.first.data;
            this.first = null;
            this.last = null;
            return rtn;
        } else {
            rtn = this.first.data;
            this.first = this.first.next;
            if(this.first == null) {
                this.last = null;
            } else {
                this.first.prev = null;
            }
            return rtn;
        }
    }
    public Object deleteFromEnd() {
        Object rtn;
        if (this.last == null) {
            return null;
        } else if(this.first == this.last) {
            rtn = this.last.data;
            this.first = null;
            this.last = null;
            return rtn;
        } else {
            rtn = last.data;
            this.last = this.last.prev;
            if(this.last == null) {
                this.first = null;
            } else {
                this.last.next = null;
            }
            
            return rtn;
        }
    }
    public DIter getIter() {
        return new DIter(this);
    }

    public void getStringDList(DList lst) {
        DIter itr = getIter();
        DList tempLst1;
        while(!itr.atEnd()) {
            if(itr.getValue() instanceof DList) {
                tempLst1 = (DList)itr.getValue();
                tempLst1.getStringDList(lst);
            } else {
                lst.insertAtEnd(itr.getValue());
                //System.out.print(itr.getValue());
            }

            itr.next();
        }

    }

}