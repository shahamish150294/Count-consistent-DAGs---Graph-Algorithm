import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;

public class Algorithm2 extends Input {
	Algorithm2(int v) {
		super(v);
	}

	private ArrayList<String> combnList = new ArrayList<String>();
	private Stack<Integer> topoStack = new Stack<Integer>();
	private Boolean visited[] = new Boolean[v];

	void dfsVisit(int v) {

		visited[v] = true;
		Integer i;

		LinkedList<Integer> linkedList = adjacency[v];
		if (linkedList != null) {
			Iterator<Integer> it = adjacency[v].iterator();
			while (it.hasNext()) {
				i = it.next();
				if (!visited[i])
					dfsVisit(i);
			}
		}

		topoStack.push(new Integer(v));
	}

	void topologicalSorting(int root) throws IOException {

		for (int i = 0; i < v; i++)
			visited[i] = false;

		dfsVisit(root);

		while (!topoStack.empty()) {
			int tempParent = topoStack.pop();
			if (revadjacency[tempParent] == null) {
				combnList.add(" " + tempParent + " ");
			} else {
				ListIterator<Integer> parents = revadjacency[tempParent]
						.listIterator();
				ArrayList<String> tempCombnList = new ArrayList<String>(
						combnList);
				while (parents.hasNext()) {
					String parent = " " + parents.next() + " ";
					// Build Pi
					int m = parent.length();
					char[] pattern_char = parent.toCharArray();
					int pi[] = new int[m];
					pi[0] = -1;
					int k = -1;

					for (int q = 1; q < m - 1; q++) {

						while (k >= 0 && pattern_char[k + 1] != pattern_char[q]) {
							k = pi[k];
						}
						if (pattern_char[k + 1] == pattern_char[q]) {
							k = k + 1;
						}
						pi[q] = k;

					}

					String existingCombn;
					ListIterator<String> combn = tempCombnList.listIterator();
					while (combn.hasNext()) {
						existingCombn = combn.next();
						// Run text through pi
						int n = existingCombn.length();
						char[] text_char = existingCombn.toCharArray();
						int t = -1;
						boolean found = false;
						for (int i = 0; i < n; i++) {
							while (t > -1
									&& pattern_char[t + 1] != text_char[i]) {
								t = pi[t];
							}
							if (pattern_char[t + 1] == text_char[i])
								t = t + 1;
							if (t == (m - 1)) {
								found = true;
								break;
							}

						}
						if (!found) {
							combn.remove();
						}
					}

				}

				for (String combn : tempCombnList) {
					combnList.add(combn + tempParent + " ");
				}

			}
		}

		// print combs

		File file = new File(
				"/Users/janakbhalla/Desktop/B503_Graphs/mini_mfo_2_combn.txt");

		// if file doesnt exists, then create it
		if (!file.exists()) {
			file.createNewFile();
		}

		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		
		bw.write("The number of combinations are " + combnList.size() + "\n\n");

		for (String combn : combnList) {
			bw.write(combn + "\n");
		}
		bw.close();
	}

	public static void main(String[] args) {
		Algorithm2 g = new Algorithm2(2000000);
		/*
		 * g.addEdge(1, 0); g.addEdge(2, 0); g.addEdge(3, 0); g.addEdge(4, 2);
		 * g.addEdge(4, 3); g.addEdge(3, 2); g.addEdge(5, 3);
		 */
		/*Please change the size of the tree/graph depending on the input size. For 
		 * mini-mfo2 set it to 2000000*/
		g.scan_text("/Users/janakbhalla/Desktop/B503_Graphs/mini-mfo2.txt");

		try {
			/*Please change the root of the tree/graph depending on the input. For 
			 * mini-mfo2 set it to 3674*/
			g.topologicalSorting(3674);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
