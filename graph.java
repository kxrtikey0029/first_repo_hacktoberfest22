import java.util.ArrayList;
import java.util.List;

public class graph {

    
    static int[][] graph =
        {
            {1, 2}, {1, 5}, {2, 5}, {2, 4},
            {3, 4}, {2, 3}, {4, 5}
        };

    static List<int[]> cycles = new ArrayList<int[]>();

   
    public static void main(String[] args) {

        for (int i = 0; i < graph.length; i++)
            for (int j = 0; j < graph[i].length; j++)
            {
                findCycles(new int[] {graph[i][j]});
            }

        for (int[] cy : cycles)
        {
            String a = "" + cy[0];

            for (int i = 1; i < cy.length; i++)
            {
                a += "," + cy[i];
            }

            o(a);
        }

    }

    static void findCycles(int[] path)
    {
            int n = path[0];
            int x;
            int[] sub = new int[path.length + 1];

            for (int i = 0; i < graph.length; i++)
                for (int y = 0; y <= 1; y++)
                    if (graph[i][y] == n)
                    
                    {
                        x = graph[i][(y + 1) % 2];
                        if (!visited(x, path))
                        
                        {
                            sub[0] = x;
                            System.arraycopy(path, 0, sub, 1, path.length);
                            
                            findCycles(sub);
                        }
                        else if ((path.length > 2) && (x == path[path.length - 1]))
                        
                        {
                            int[] p = normalize(path);
                            int[] inv = invert(p);
                            if (isNew(p) && isNew(inv))
                            {
                                cycles.add(p);
                            }
                        }
                    }
    }

    
    static Boolean equals(int[] a, int[] b)
    {
        Boolean ret = (a[0] == b[0]) && (a.length == b.length);

        for (int i = 1; ret && (i < a.length); i++)
        {
            if (a[i] != b[i])
            {
                ret = false;
            }
        }

        return ret;
    }

    
    static int[] invert(int[] path)
    {
        int[] p = new int[path.length];

        for (int i = 0; i < path.length; i++)
        {
            p[i] = path[path.length - 1 - i];
        }

        return normalize(p);
    }

    
    static int[] normalize(int[] path)
    {
        int[] p = new int[path.length];
        int x = smallest(path);
        int n;

        System.arraycopy(path, 0, p, 0, path.length);

        while (p[0] != x)
        {
            n = p[0];
            System.arraycopy(p, 1, p, 0, p.length - 1);
            p[p.length - 1] = n;
        }

        return p;
    }

    
    static Boolean isNew(int[] path)
    {
        Boolean ret = true;

        for(int[] p : cycles)
        {
            if (equals(p, path))
            {
                ret = false;
                break;
            }
        }

        return ret;
    }

    static void o(String s)
    {
        System.out.println(s);
    }
    
       static int smallest(int[] path)
    {
        int min = path[0];

        for (int p : path)
        {
            if (p < min)
            {
                min = p;
            }
        }

        return min;
    }

   
    static Boolean visited(int n, int[] path)
    {
        Boolean ret = false;

        for (int p : path)
        {
            if (p == n)
            {
                ret = true;
                break;
            }
        }

        return ret;
    }

}
