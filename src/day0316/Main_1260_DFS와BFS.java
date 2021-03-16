package day0316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1260_DFS와BFS {
	static boolean[][] graph;
	static int N;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken()); // 정점 개수
		int M = Integer.parseInt(st.nextToken()); // 간선 개수
		int V = Integer.parseInt(st.nextToken()); // 탐색 시작 정점 번호
		graph = new boolean[N][N];
		visited = new boolean[N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			graph[from - 1][to - 1] = true;
			graph[to - 1][from - 1] = true;
		}

		visited[V - 1] = true;
		dfs(V - 1);

		System.out.println();
		bfs(V);

	}

	private static void dfs(int current) {
		visited[current] = true;
		System.out.print((current + 1) + " ");

		for (int i = 0; i < N; i++) {
			if (graph[current][i] && !visited[i]) {
				dfs(i);
			}
		}
	}

	private static void bfs(int start) {
		boolean[] visited = new boolean[N];
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start - 1);
		visited[start - 1] = true;
		System.out.print((start) + " ");

		while (!queue.isEmpty()) {
			int curr = queue.poll();

			for (int i = 0; i < N; i++) {
				if (graph[curr][i] && !visited[i]) {
					queue.offer(i);
					visited[i] = true;
					System.out.print((i + 1) + " ");
				}
			}
		}
	}
}
