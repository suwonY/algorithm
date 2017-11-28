package week_12th_mon;

import java.util.*;
public class Baek2515_2nd {
	/*전시장
	 * 
	 * 그림들은 높이가 다르다
	 * 세로길이가 S이상인 그림만 관람객이 관심을 보이고 사게 된다
	 * 보이는 세로부분이 S이상인 그림만 판매가 가능하다
	 * 그림 높이와 가격이 주어질 때 가격의 합이 최대가 되게 만들기
	 * 
	 * dp같으니깐 점화식을 생각해보자
	 d[n]가 n개의 그림으로 남길 수 있는 최대의 이익
	 d[n] = max(d[n-1] , d[k] + c[n])
	 (k는 내가 보이게 내 앞에 서있을 수잇는 친구)
	 Treemap은 중복값이 안되서 런타임에러난다 아놔...
	 * */
	static int n,s;//그림의 개수 , 범위
	static long[] d = new long[20000001];
	static Map<Integer,Integer> m = new TreeMap<>();
	static List<Pic> a = new ArrayList<>();
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		s = in.nextInt();
		for(int i=0; i<n; i++){
			int h = in.nextInt();
			int c = in.nextInt();
			m.put(h, c);
		}
		
		a.add(new Pic(0,0));
		for(int h : m.keySet())
			a.add(new Pic(h,m.get(h)));
		
		for(int i=1,j=0; i<=n; i++){
			//내 앞에꺼중에 내가 보일 수 있는 애를 찾는다
			while(a.get(j+1).h<=a.get(i).h-s) ++j;
			d[i] = Math.max(d[i-1], d[j]+a.get(i).c);
		}
		
		System.out.println(d[n]);
		in.close();
	}
	public static class Pic{
		int h, c;
		public Pic(int h, int c){
			this.h = h;
			this.c = c;
		}
	}
}