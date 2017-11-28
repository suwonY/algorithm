package week_16th_mon;

import java.util.*;
public class Baek1062_fix1 {

	//가르침
	//anta로 시작
	//tica로 끝난다
	//k개의 글자를 가르칠 시간 밖에없다
	//n개의 단어밖에 없음
	static int n, k, ans=0;
	static List<Long> a = new ArrayList<>();
	static List<String> tt = new ArrayList<>();
	static boolean[] c = new boolean[26];
					     //가르친개수    //비교하고있는 애 상태 
	public static void go(int cnt, long start){
		if(cnt>k) return;
		if(cnt==k){
			int max = 0;
			for(long t: a){
				if(t-start==0)
					++max;
			}
			ans = Math.max(max, ans);
			return;
		}
		for(int i=0; i<26; i++){
			if(c[i]) continue;	//확인할 필요없는 애들
			//이미 확인한 애는 다시 확인안해도된다
			if((start & (1<<i)) !=0 ) continue;
			
			go(cnt+1,start|(1<<i));
		}
	}
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		k = in.nextInt();
		if(k<5){
			System.out.println(0);
			return;
		}
		k-=5;	//배워야할 단어 개수는 acnti(5개) 빼고
		for(int i=0; i<n; i++){
			String temp = in.next();
			temp = temp.replaceAll("a", "");
			temp = temp.replaceAll("c", "");
			temp = temp.replaceAll("n", "");
			temp = temp.replaceAll("t", "");
			temp = temp.replaceAll("i", "");
			
			char[] t = temp.toCharArray();
			Arrays.sort(t);
			long al = 0;
			for(int j=0; j<t.length; j++){
				if(!c[t[j]-'a']) c[t[j]-'a']=true;
				int num = t[j]-'a';
				al |= (1<<num);
				
			}
			a.add(al);
			tt.add(Long.toBinaryString(al));
		}
		
		/*for(long t: a){
			System.out.println(t);
		}*/
		for(String t: tt){
			System.out.println(t);
		}
		
		//a n t i c
		c['a'-'a'] = true;
		c['c'-'a'] = true;
		c['n'-'a'] = true;
		c['t'-'a'] = true;
		c['i'-'a'] = true;
		
//		go(0,0);
//		System.out.println(ans);
		in.close();
	}
}