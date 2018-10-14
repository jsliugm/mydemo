package com.DataStructure;

/**
 * @author Administrator
 * 
 */
public class Graph {
	int vNodeNum;
	VertexNode[] nodes;

	public int getvNodeNum() {
		return vNodeNum;
	}

	public void setvNodeNum(int vNodeNum) {
		this.vNodeNum = vNodeNum;
	}

	public VertexNode[] getNodes() {
		return nodes;
	}

	public void setNodes(VertexNode[] nodes) {
		this.nodes = nodes;
	}

	public Graph(int num) {
		nodes = new VertexNode[num];
		int n =0;
		for (VertexNode node : nodes) {
			node = new VertexNode("v"+n);
			n++;
		}
	}

	public void addEdgeNode(VertexNode vNode, EdgeNode eNode) throws Exception {
		if (vNode == null) {
			throw new Exception("顶点不能为空");
		}
		if (eNode == null) {
			throw new Exception("边不能为空");
		}
		if (vNode.getFirstedge() == null) {
			vNode.setFirstedge(eNode);
		} else {
			EdgeNode edge = vNode.getFirstedge();
			while (edge != null) {
				edge = edge.getNext();
			}
			edge.setNext(eNode);
		}
	}

	public static void main(String[] args) throws Exception {
		Graph g = new Graph(10);
		VertexNode vn = new VertexNode("v0");
		EdgeNode en = new EdgeNode(1, 10);
		g.addEdgeNode(vn, en);

		VertexNode[] nodes = g.getNodes();
		for (VertexNode n : nodes) {
			System.out.print(n.getData() + " ");
			for (EdgeNode ed = n.getFirstedge(); ed != null; ed = ed.next) {
				System.out.print(ed.getAdjvex());
			}
		}

	}
}

/** 边表节点 */
class EdgeNode {
	/** 邻接点域，存储该顶点对应的下标 */
	int adjvex;
	/** 用于存储权值，对于非网图可以不需要 */
	int weight;
	/** 链域，指向下一个邻接点 */
	EdgeNode next;

	public EdgeNode(int adjvex, int weight) {
		this.adjvex = adjvex;
		this.weight = weight;
	}

	public int getAdjvex() {
		return adjvex;
	}

	public void setAdjvex(int adjvex) {
		this.adjvex = adjvex;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public EdgeNode getNext() {
		return next;
	}

	public void setNext(EdgeNode next) {
		this.next = next;
	}

}

/** 顶点表节点 */
class VertexNode {
	/** 顶点域，存储顶点信息 */
	String data;
	/** 边表头指针 */
	EdgeNode firstedge;

	public VertexNode(String data) {
		this.data = data;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public EdgeNode getFirstedge() {
		return firstedge;
	}

	public void setFirstedge(EdgeNode firstedge) {
		this.firstedge = firstedge;
	}

}