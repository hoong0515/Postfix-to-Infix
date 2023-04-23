import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

class As2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        DList operand = new DList();
        DList tempDList;
        DList tempDList2;
        DList output = new DList();
        Object temp;
        int c = 0;
        while(true) {
            c = br.read();
            if(c < 0) break;
            switch(c) {
                case 42:
                case 47:
                case 43:
                case 45:
                    tempDList = new DList();
                    tempDList.insertAtFront((Character)(char)41);
                    temp = operand.deleteFromEnd();
                    if(temp instanceof DList) {
                        tempDList2 = (DList)temp;
                        tempDList.first.prev = tempDList2.last;
                        tempDList2.last.next = tempDList.first;
                        tempDList.first = tempDList2.first;
                    } else {
                        tempDList.insertAtFront(temp);
                    }
                    tempDList.insertAtFront((Character)(char)c);
                    temp = operand.deleteFromEnd();
                    if(temp instanceof DList) {
                        tempDList2 = (DList)temp;
                        tempDList.first.prev = tempDList2.last;
                        tempDList2.last.next = tempDList.first;
                        tempDList.first = tempDList2.first;
                    } else {
                        tempDList.insertAtFront(temp);
                    }
                    tempDList.insertAtFront((Character)(char)40);
                    operand.insertAtEnd(tempDList);
                    break;
                default:
                    break;
                
            }
            if(((c > 64) && (c < 91)) || ((c > 96) && (c < 123))) {
                operand.insertAtEnd((Character)(char)c);
            }
        }
        File f = new File("output.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(f));
        operand.getStringDList(output);
        DIter outputIter = output.getIter();
        while(!outputIter.atEnd()) {
            //System.out.print((char)outputIter.getValue());
            bw.write((char)outputIter.getValue());
            outputIter.next();
        }

        bw.close();

        br.close();
    }
}