import java.util.*;

class Solution {
    static class Music{
    String genre;
    int play;
    int idx;
    
        public Music(String genre, int play, int idx){
            this.genre = genre;
            this.play = play;
            this.idx = idx;
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> map = new HashMap<>();
        
        //장르맵을 하나 만든다.
        for(int i = 0; i < genres.length; i++){
            if(!map.containsKey(genres[i])){
               map.put(genres[i], plays[i]); 
            }else{
                map.put(genres[i], map.get(genres[i])+plays[i]);
            }
        }
        
        //장르 선정
        ArrayList<String> genres_ordered = new ArrayList<>();
        while(map.size()!= 0){
            int max = -1;
            String max_key = "";
            
            for(String key : map.keySet()){
                int tmp_cnt = map.get(key);
                //총합이 더 큰거로 바꿔치기 한다.
                if(tmp_cnt > max){
                    max = tmp_cnt;
                    max_key = key;
                }
            }
            genres_ordered.add(max_key);
            map.remove(max_key);
        }
        
        ArrayList<Music> result = new ArrayList<>();
        for(String g : genres_ordered){
            ArrayList<Music> list = new ArrayList<>();
            for(int i = 0; i < genres.length; i++){
                if(genres[i].equals(g)){
                    list.add(new Music(g, plays[i], i));
                }
            }
            Collections.sort(list, (o1, o2) -> o2.play - o1.play);
            result.add(list.get(0));
            if(list.size() > 1){
                result.add(list.get(1));
            }
        }
        
        int[] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            answer[i] = result.get(i).idx;
        }
        return answer;
    }
}