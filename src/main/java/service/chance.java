package service;

import core.Ladders;
import core.Snakes;
import core.players;

import java.util.*;

public class chance extends turn {
    public Snakes snakes;
    public Ladders ladders;

    public chance(Snakes snakes, Ladders ladders) {
        this.snakes = snakes;
        this.ladders = ladders;
    }

    public int roll() {
        return (int) (Math.random() * 6 + 1);
    }

    public Stack<String> FinalPos(List<players> lp) {
        Stack<String> pq = new Stack<>();//denotes those who have finished the game
        while (pq.size()!=lp.size()) { //stopping when all members of lp have finished the game
            for (core.players players : lp) {
                if (players.getPos() < 100) {
                    System.out.println(players.getName() + " is rolling the dice...");
                    int b = roll();
                    System.out.println("Number on dice: " + b);
                    int cp = players.getPos();
                    if (cp + b <= 100) {//so that no player gets number greater than 100
                        players.setPos(cp + b);
                        players.setPos(check(players.getPos(), snakes.smap));
                        players.setPos(check(players.getPos(), ladders.lmap));
                    }
                    System.out.println(players.getName() + " is on " + players.getPos());
                    if (players.getPos() == 100) {
                        pq.add(players.getName());
                    }
                }
            }
        }
        return pq;
    }

    public int check(int pos, Map<Integer, Integer> smap) {
        for (Map.Entry<Integer, Integer> e : smap.entrySet()) {
            if (e.getKey() == pos) {
                if (e.getKey() < e.getValue())
                    System.out.println("Climbed Ladder...");
                else
                    System.out.println("Bitten by Snake...");
                return e.getValue();
            }
        }
        return pos;
    }
}
