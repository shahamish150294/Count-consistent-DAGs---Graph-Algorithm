import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;


public class Input {
	protected int v;
	protected LinkedList<Integer> adjacency[];
	protected LinkedList<Integer> revadjacency[];
	
	Input(int v) {
		this.v = v;
		this.adjacency = new LinkedList[v];
		this.revadjacency = new LinkedList[v];
	}
	
	protected void scan_matrix(String filePath) {
		
		FileReader f;
		BufferedReader read;
		String readeachline;
		int i = 0;
		char[] charArray;
		try {
			f = new FileReader(filePath);
			read = new BufferedReader(f);
			while ((readeachline = read.readLine()) != null) {
				charArray = readeachline.replaceAll("\\s", "").toCharArray();
				for (int j = 0; j < charArray.length; j++) {
					if (charArray[j] == '1')
						this.addEdge(j, i);
				}
				i++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	private void addEdge(int child, int parent) {
		if (adjacency[parent] == null)
			adjacency[parent] = new LinkedList<Integer>();
		adjacency[parent].add(child);

		if (revadjacency[child] == null)
			revadjacency[child] = new LinkedList<Integer>();
		revadjacency[child].add(parent);
	}
	
	public void scan_text(String file_path) {
		try {
		
			FileReader f = new FileReader(file_path);
			BufferedReader read = new BufferedReader(f);

			String readeachline;
			int child = 0;
			int parent = 0;
			int start;
			int end;
			while ((readeachline = read.readLine()) != null) {
				start = readeachline.indexOf("GO:");
				end = readeachline.lastIndexOf("GO:");
				if (start == -1 || end == -1) {
					continue;
				}
				child = Integer.parseInt(readeachline.substring(
						readeachline.indexOf("GO:") + 3,
						readeachline.lastIndexOf("GO:")).trim());
				parent = Integer.parseInt(readeachline.substring(readeachline
						.lastIndexOf("GO:") + 3));
				this.addEdge(child, parent);
			}
			read.close();

		} catch (IOException ie) {
			System.out.println(ie);
		}
	}
	
	
}
