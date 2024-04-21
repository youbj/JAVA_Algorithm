class Solution {
    private final int MOD= 1000000007;
    private int [] tiles;
    public int solution(int n) {
        int answer = 0;
        tiles = new int[n+1];
        tiles[0] = 1;
        tiles[1] = 1;
        for(int idx=2;idx<=n;idx++){
            tiles[idx] = (tiles[idx-2]+tiles[idx-1])%MOD;
        }
        answer = tiles[n];
        return answer;
    }
}