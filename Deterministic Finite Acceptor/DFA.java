import java.util.HashSet;
import java.util.HashMap;
import java.util.Scanner;

public class DFA{
    int noStates;
    HashMap<String, State> allStates;
    HashSet<String> finalStates;
    HashSet<String> alphabets;
    String current;

    void start(){
        Scanner sObj = new Scanner(System.in);
        System.out.println("Enter input string: ");
        String[] inputStr = sObj.nextLine().split("");
        if(getOutput(inputStr)) System.out.println("Accepted!");
        else System.out.println("Rejected!");
    }

    boolean getOutput(String[] inputStr){
        for(String ch: inputStr){
            System.out.println(allStates.get(current).transiction.get(ch));

            System.out.println("Testing input: " + ch);
            current = allStates.get(current).transiction.get(ch).name;
        }
        if(finalStates.contains(current)) return true;
        else return false;
    }

    void defineDFA(){
        Scanner sObj = new Scanner(System.in);
        System.out.println("Enter number of states: ");
        noStates = Integer.parseInt(sObj.nextLine());

        System.out.println("Enter state names seperated by space: ");
        String stateList = sObj.nextLine();

        System.out.println("Enter the start state name: ");
        current = sObj.nextLine();

        System.out.println("Enter final state names seperated by space: ");
        finalStates = new HashSet<String>();
        for(String str: sObj.nextLine().split(" ")){
            finalStates.add(str);
        }

        System.out.println("Enter the terminal alphabets seperated by space: ");
        alphabets = new HashSet<String>();
        for(String str: sObj.nextLine().split(" ")){
            alphabets.add(str);
        }

        createStates(stateList);
        defineTransictions();
    }

    void createStates(String stateList){
        this.allStates = new HashMap<String, State>();
        for(String str: stateList.split(" ")){
            allStates.put(str, new State(str));
        }
    }

    void defineTransictions(){
        Scanner sObj = new Scanner(System.in);
        for(String str: allStates.keySet()){
            allStates.get(str).transiction = new HashMap<String, State>();
            for(String alp: alphabets){
                System.out.println(allStates.get(str).name + " on input " + alp + " -> ? ");
                String next = sObj.nextLine();
                allStates.get(str).transiction.put(alp, allStates.get(next));
            }
        }
    }
}

class State{
    String name;
    HashMap<String, State> transiction;

    State(String name){
        this.name = name;
    }
}