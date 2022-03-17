package CollectionsAndConstructors;

import java.util.*;


class ListOperation{
    private List<String> testList;
    ListOperation(String str){
        this.testList = Arrays.asList(str.split(" "));
        System.out.println("Input List: "+ this.testList);
    }
    public List<String> reverse(){
        Collections.reverse(testList);
        return testList;
    }
}

public class ReverseList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        ListOperation listOperation = new ListOperation(str);
        System.out.println("Reversed List: "+listOperation.reverse());

    }
}
