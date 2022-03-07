import core.Ladders;
import core.Snakes;
import core.players;
import service.chance;

import java.util.*;

public class Main{
    public static Map<Integer,Integer> map1=new HashMap<>(7);
    public static Map<Integer,Integer> map2=new HashMap<>(8);

    public static void main(String[] args){
        map1.put(59,1);
        map1.put(37,16);
        map1.put(94,26);
        map1.put(91,73);
        map1.put(69,32);
        map1.put(99,80);
        map2.put(4,14);
        map2.put(10,31);
        map2.put(28,84);
        map2.put(18,39);
        map2.put(51,67);
        map2.put(71,90);
        map2.put(75,95);
        map2.put(62,81);
        Snakes Slist=new Snakes(map1);
        Ladders Llist=new Ladders(map2);
        Scanner sc=new Scanner(System.in);
        int n;
        System.out.println("Enter number of players: ");
        n=sc.nextInt();
        List<players> lp=new ArrayList<>(n);
        for(int i=0;i<n;i++){
            System.out.println("Enter name of "+(i+1)+"th player");
            String name=sc.next();
            players p1=new players(name,0);
            lp.add(p1);
        }
        chance ch=new chance(Slist,Llist);
        Stack<String> pq =ch.FinalPos(lp);
        System.out.println("The order of finishing is: ");
        System.out.println(pq);
    }
}
