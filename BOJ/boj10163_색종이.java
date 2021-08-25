package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj10163_색종이 {
	static int[][] paper = new int[1001][1001];
	static int[] sizeArr;
	static int x;
	static int y;
	static int width;
	static int height;
	static int size = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N= Integer.parseInt(br.readLine());
		if(N == 1) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			width = Integer.parseInt(st.nextToken());
			height = Integer.parseInt(st.nextToken());
			System.out.println(width*height);
		}
		else if(N<=10) {
			for(int tc=1;tc<=N;tc++) {		
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				width = Integer.parseInt(st.nextToken());
				height = Integer.parseInt(st.nextToken());
				sizeArr = new int[101];	
				
				if(width == 1 && height == 1) {
					makePaper(x,y,width,height,tc);
					for(int i=0;i<101;i++) {
						for(int j=0;j<101;j++) {
							if(paper[i][j] > 0) {
								sizeArr[paper[i][j]]++;
							}
						}
					}
				}
				else {
					makePaper(x,y,width,height,tc);
					for(int i=0;i<101;i++) {
						for(int j=0;j<101;j++) {
							if(paper[i][j] > 0) {
								sizeArr[paper[i][j]]++;
							}
						}
					}
					
				}				
			}
			for(int i=1;i<=N;i++) {
				System.out.println(sizeArr[i]);
			}
			
		}
		else {
			for(int tc=1;tc<=N;tc++) {		
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				width = Integer.parseInt(st.nextToken());
				height = Integer.parseInt(st.nextToken());
				
				sizeArr = new int[1001];	
				makePaper(x,y,width,height,tc);
				
				for(int i=0;i<1001;i++) {
					for(int j=0;j<1001;j++) {
						if(paper[i][j] > 0) {
							sizeArr[paper[i][j]]++;
						}
					}
				}		
			}
			for(int i=1;i<=N;i++) {
				System.out.println(sizeArr[i]);
			}
		}
		
	}
	public static void makePaper(int x, int y , int width, int height, int count) {
		for(int i=x;i<x+width;i++) {
			for(int j=y;j<y+height;j++) {
				paper[i][j] = count;
			}
		}
	}
	
}
