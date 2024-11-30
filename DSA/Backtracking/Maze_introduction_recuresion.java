package Backtracking;

import java.util.*;

public class Maze_introduction_recuresion {
    public static void main(String[] args) {
//        Maze("",3,3);
//        System.out.println(Maze_with_3_directions("",3,3));
        boolean[][] board = {
            {true, true, true},
            {true, true, true},
            {true, true, true}
        };
//        Maze_with_obstacle("", board, 0,0);
        Maze_with_allPaths("", board, 0,0);
    }

    static void Maze(String p, int r, int c){
        if(r==1 && c==1){
            System.out.println(p);
            return;
        }

        if(r>1){
            Maze(p+"D",r-1,c);
        }
        if(c>1){
            Maze(p+"R",r,c-1);
        }
    }

    static List<String> Maze_with_3_directions(String p, int r, int c){
        if(r==1 && c==1){
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        List<String> ans = new ArrayList<>();
        if(r>1 && c>1) {
            ans.addAll(Maze_with_3_directions(p+"D",r-1,c-1));
        }
        if(r>1){
            ans.addAll(Maze_with_3_directions(p+"V",r-1,c));
        }
        if(c>1){
            ans.addAll(Maze_with_3_directions(p+"H",r,c-1));
        }
        return ans;
    }

    static void Maze_with_obstacle(String p, boolean[][] maze, int r, int c){
        if(r== maze.length-1 && c==maze[0].length-1){
            System.out.println(p);
            return;
        }

        if(!maze[r][c]){
            return;
        }

        if(r < maze.length-1){
            Maze_with_obstacle(p+"D",maze,r+1,c);
        }
        if(c < maze[0].length-1){
            Maze_with_obstacle(p+"R",maze,r,c+1);
        }
    }

    static void Maze_with_allPaths(String p, boolean[][] maze, int r, int c){
        if(r== maze.length-1 && c==maze[0].length-1){
            System.out.println(p);
            return;
        }
        if(!maze[r][c]){
            return;
        }
        maze[r][c] = false;

        if(r < maze.length-1){
            Maze_with_allPaths(p+"D",maze,r+1,c);
        }
        if(c < maze[0].length-1){
            Maze_with_allPaths(p+"R",maze,r,c+1);
        }

        if(r>0){
            Maze_with_allPaths(p+"U",maze,r-1,c);
        }
        if(c>0){
            Maze_with_allPaths(p+"L",maze,r,c-1);
        }

        maze[r][c] = true;
    }
}
