package DisjointSets;
import java.util.*;

public class disjointSets{
    ArrayList<Integer> rank = new ArrayList<>();
    ArrayList<Integer> parent =  new ArrayList<>();

    public disjointSets(int n){
        for(int i = 0; i <= n ; i++){
            rank.add(0);
            parent.add(i);
        }
    }

    private int getParent(int node){
        if(node == parent.get(node)){
            return node;
        }

        int ultimateParent = getParent(parent.get(node));
        parent.set(node, ultimateParent);
        return parent.get(node);
    }

    private void unionByRank(int nodeU , int nodeV){
        int parentU = getParent(nodeU);
        int parentV = getParent(nodeV);

        if(parentU == parentV){
            return;
        }

        if(rank.get(parentU) < rank.get(parentV)){
            parent.set(parentU, parentV);
        }
        else if(rank.get(parentV) < rank.get(parentU)){
            parent.set(parentV, parentU);
        }
        else{
            parent.set(parentV, parentU);
            int rankU = rank.get(parentU);
            rank.set(parentU, rankU+1);
        }
    }
    public static void main (String[] args) {
        disjointSets ds = new disjointSets(7);
        ds.unionByRank(1, 2);
        ds.unionByRank(2, 3);
        ds.unionByRank(4, 5);
        ds.unionByRank(6, 7);
        ds.unionByRank(5, 6);

        // if 3 and 7 same or not
        if(ds.getParent(3) == ds.getParent(7)) {
            System.out.println("Same");
        }
        else
            System.out.println("Not Same");

        ds.unionByRank(3, 7);
        if(ds.getParent(3) == ds.getParent(7)) {
            System.out.println("Same");
        }
        else
            System.out.println("Not Same");
    }
}




