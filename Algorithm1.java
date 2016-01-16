import java.io.IOException;
import java.math.BigInteger;
import java.util.LinkedList;

public class Algorithm1 extends Input {

	Algorithm1(int v) {
		super(v);
	}

	private void dfstraversal(int root) throws IOException {
		System.out.println(dfsVisit(root));
	}

	private BigInteger dfsVisit(int tempParent) {
		LinkedList<Integer> linkedList = adjacency[tempParent];
		BigInteger x = new BigInteger("0");
		BigInteger y = new BigInteger("0");
		if (linkedList == null)
			return new BigInteger("1");
		else {

			for (int child : linkedList) {
				y = dfsVisit(child);
				x = x.add(y).add(x.multiply(y));
			}
		}
		return x.add(new BigInteger("1"));
	}

	public static void main(String[] args) {
		Algorithm1 g = new Algorithm1(100);
		/*Please change the size of the tree/graph depending on the input size*/
		g.scan_matrix("/Users/janakbhalla/Desktop/B503_Graphs/tree_100.txt");
		
		try {
			g.dfstraversal(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
