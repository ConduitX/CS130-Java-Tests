package edu.csus.csc130.fall2020.assignment5;

import java.util.*;
import java.lang.Math;

/*
 * Jahsuni Jones
 * CSC 130 
 * 12/9/20
*/
public class GraphProperties {
	
	public int vertex = 0;
	public int edges = 0;
	private List<Integer>[] list;

	
	public GraphProperties(Graph graph) {
		
		this.vertex = graph.V();
		this.edges = graph.E();
		
		this.list = graph.adj;
		
	}

	/**
	 * The girth of a graph is the length of its shortest cycle. If a graph is
	 * acyclic, then its girth is infinite (return -1).
	 * 
	 * Hint : Run BFS from each vertex. The shortest cycle containing s is a
	 * shortest path from s to some vertex v, plus the edge from v back to s.
	 * 
	 */
	public int grith() {
		//BFS Algorithm
		
		boolean visited[] = new boolean[vertex];  //check if visited
		
		int parent[] = new int[vertex];  //Track parents
		
		int cycleLen = 0;
		
		int minCycle = -1;  //assume graph is acyclic
		
		for (int i=0; i<vertex; i++)  //For each Vertex
		{
			cycleLen = 1;   //Initialize cycleLen to 1 for start
			
			Queue<Integer> queue = new LinkedList<Integer>();
			
			//restart parents and visited arrays
			Arrays.fill(parent, -1);
			Arrays.fill(visited, false);
			visited[i] = true;
			
			queue.add(i);
			
			while(!queue.isEmpty()) 
			{
				int u = queue.poll();  //Dequeue and explore vertex
				
				for (int j=0; j<list[u].size(); j++)
				{
					
					int v = list[u].get(j);
					
					//if not visited, add to queue and set parent to dequeued vertex
					//increase cycleLen
					if (!visited[v])
					{
						visited[v] = true;
						queue.add(v);
						parent[v] = u;
						cycleLen++;
					}
					
					//if visited already and vertex is not parent
					else if (parent[u] != v)
					{
						if (cycleLen == 0) //if no cycle, continue
						{
							continue;
						}
						else if (minCycle == -1 && cycleLen != 0)  //first cycle
						{
							minCycle = cycleLen;
						}
						else
						{
							minCycle = Math.min(minCycle, cycleLen);   //get minimum of two cycles
						}
					}
				}
			}			
		}
		return minCycle;
		//throw new UnsupportedOperationException();
	}
	


}
