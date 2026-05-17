import java.util.*;

class Node {
    int x, y, g, h, f;
    Node parent;

    Node(int x, int y, int g, int h, Node p) {
        this.x = x;
        this.y = y;
        this.g = g;
        this.h = h;
        this.f = g + h;
        parent = p;
    }
}

public class AStar {

    static int[][] maze = {
        {0,0,0},
        {1,0,1},
        {0,0,0}
    };

    static int goalX = 2, goalY = 2;

    static int heuristic(int x, int y) {
        return Math.abs(x-goalX) + Math.abs(y-goalY);
    }

    static void aStar(int sx, int sy) {

        PriorityQueue<Node> pq =
            new PriorityQueue<>((a,b) -> a.f - b.f);

        boolean[][] visited = new boolean[3][3];

        pq.add(new Node(sx, sy, 0,
                heuristic(sx, sy), null));

        int[][] dir = {
            {-1,0},{1,0},{0,-1},{0,1}
        };

        while(!pq.isEmpty()) {

            Node cur = pq.poll();

            if(visited[cur.x][cur.y])
                continue;

            visited[cur.x][cur.y] = true;

            System.out.println(
                "Node (" + cur.x + "," + cur.y + ")" +
                " h=" + cur.h +
                " f=" + cur.f
            );

            if(cur.x == goalX && cur.y == goalY) {

                System.out.println("Goal Reached");

                while(cur != null) {
                    System.out.print(
                        "(" + cur.x + "," + cur.y + ") "
                    );
                    cur = cur.parent;
                }

                return;
            }

            for(int[] d : dir) {

                int nx = cur.x + d[0];
                int ny = cur.y + d[1];

                if(nx>=0 && ny>=0 &&
                   nx<3 && ny<3 &&
                   maze[nx][ny]==0 &&
                   !visited[nx][ny]) {

                    int h = heuristic(nx, ny);

                    System.out.println(
                        "  Neighbor (" + nx + "," + ny +
                        ") h=" + h
                    );

                    pq.add(new Node(
                        nx, ny,
                        cur.g+1,
                        h,
                        cur
                    ));
                }
            }
        }

        System.out.println("No Path Found");
    }

    public static void main(String[] args) {
        aStar(0,0);
    }
}