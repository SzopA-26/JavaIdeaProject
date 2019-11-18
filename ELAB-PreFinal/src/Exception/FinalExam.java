package Exception;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class FinalExam {
    public void methodA(int value) {
        if (value > 100){
            throw new ArithmeticException("Exception => methodA value > 100"); }
    }

    public void methodB(String s){
        if (s.length() > 10){
            throw new StringIndexOutOfBoundsException("Exception => string length > 10");
        }
    }

    public void methodC(String filename) throws FileNotFoundException {
        if (!filename.contains(".")){
            throw new FileNotFoundException("Exception => missing file type");
        }
    }

    public void methodD(Object obj){
        if (obj == null) {
        throw new NullPointerException("Exception => null object"); }
    }

    public void methodE(int index) throws IndexOutOfBoundsException{
        ArrayList<Integer> arr = new ArrayList<>();
        arr.get(index);
    }
}
