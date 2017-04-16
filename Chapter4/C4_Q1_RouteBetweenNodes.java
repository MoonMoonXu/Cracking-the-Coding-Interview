import java.util.Queue;
import java.util.LinkedList;
public class C4_Q1_RouteBetweenNodes 
{
	//DFS using recursion
	boolean dfs(Graph g, Node node1, Node node2)
	{
		if(node1 == null) return false;
		if(node1 == node2) return true;
		
		node1.state = "Visited";
		
		for(Node n : node1.getAdjacent())
		{
			if(n.state == "Unvisited")
				if (dfs(g, n, node2))
					node1.state = "Unvisited";
		}	
		node1.state = "Unvisited";
		return false;
	}
	
	//BFS using queue
	//BFS is better than DFS in this case because DFS may traverse one adjacent node very deeply
	
	boolean bfs(Graph g, Node node1, Node node2)
	{
		Queue<Node> queue = new LinkedList<Node>();
		node1.state = "Visiting";
		queue.offer(node1);
		
		while(!queue.isEmpty())
		{
			Node curr = queue.poll();
			for(Node adjac : curr.getAdjacent())
			{
				if(adjac.state == "Unvisited")
				{
					if(adjac == node2) return true;
					else
					{
						adjac.state = "Visiting";
						queue.offer(adjac);
					}
				}
			}
			curr.state = "Unvisited";
		}
		return false;
	}
	
}
