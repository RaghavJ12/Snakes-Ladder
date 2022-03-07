package service;

import core.players;

import java.util.List;
import java.util.Map;
import java.util.Stack;

abstract class turn{
    abstract public int roll();
    abstract public Stack<String> FinalPos(List<players> lp);
    abstract public int check(int pos, Map<Integer, Integer> smap);
}
