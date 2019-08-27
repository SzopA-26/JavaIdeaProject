package sample;
import java.util.ArrayList;

public class ListToDo {
    private ArrayList<ToDo> listToDo;

    public ListToDo() {
        listToDo = new ArrayList<>();
    }

    public void addToDo(ToDo toDo) {
        boolean assign = false;
        for (int i=0;i<getSize();i++) {
            if (toDo.date().isBefore(listToDo.get(i).date())) {
                listToDo.add(i,toDo);
                assign = true;
                break;
            } else if (toDo.date().isEqual(listToDo.get(i).date())) {
                if (toDo.getHour() < listToDo.get(i).getHour()) {
                    listToDo.add(i,toDo);
                    assign = true;
                    break;
                } else if (toDo.getHour() == listToDo.get(i).getHour() &&
                        toDo.getMinute() < listToDo.get(i).getMinute() ) {
                    listToDo.add(i,toDo);
                    assign = true;
                    break;
                }
            }
        } if (!assign) {
            listToDo.add(toDo);
        }
    }

    public ArrayList<ToDo> getArray() {
        return listToDo;
    }

    public int getSize() {
        return listToDo.size();
    }

}
