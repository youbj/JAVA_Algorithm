class Solution {
	public int solution(int a, int b, int n) {
        int answer = 0;
        while(n>=a) {
        	int back = (n/a)*b;
        	answer+=back;
        	n=n%a;
        	n+=back;
        }
        return answer;
    }
	}