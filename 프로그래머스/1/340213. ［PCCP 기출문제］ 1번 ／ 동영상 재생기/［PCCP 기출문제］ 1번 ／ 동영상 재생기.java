class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        // 3가지 기능 : 10초 전으로 이동, 10초 후로 이동, 오프닝 건너뛰기
        // 10초 전 - prev 10초 전으로 이동 + 10초 미만인 경우 영상 처음 위치로 이동
        // 10초 후 - next 10초 후로 이동 + 남은시간 10초 미만인 경우 영상 마지막 위치로 이동 (동영상의 길이와 같음)
        // 오프닝 건너뛰기 - 현재 재생 위치가 오프닝 구간인 경우 자동으로 오프닝이 끝나는 위치로 이동
        
        // video_len : 동영상 길ㅇ
        // pos : 현재 재생 위치
        // op_start : 오프닝 시작 시각
        // op_end : 오프닝 끝나는 시각
        // commands : 사용자 입력 배열
        
        // video length
        int vm = Integer.parseInt(video_len.substring(0,2));
        int vs = Integer.parseInt(video_len.substring(3,5));
        // pos
        int pm = Integer.parseInt(pos.substring(0,2));
        int ps = Integer.parseInt(pos.substring(3,5));
        // op start
        int sm = Integer.parseInt(op_start.substring(0,2));
        int ss = Integer.parseInt(op_start.substring(3,5));
        // op end
        int em = Integer.parseInt(op_end.substring(0,2));
        int es = Integer.parseInt(op_end.substring(3,5));
        
        int startSec = sm * 60 + ss;
        int endSec = em * 60 + es;
        int posSec = pm * 60 + ps;
        
        for(String com : commands){
                System.out.println("원래 값 " + pm + " " + ps);
            // 현재 위치가 오프닝 위치이면 오프닝 끝나는 시각으로 이동
            if (startSec <= posSec && posSec <= endSec) {
                pm = em;
                ps = es;
                System.out.println("오프닝 이슈 " + pm + " " + ps);
            }
            
            switch(com){
                case "next":
                    // 현재 시작 시간에서 +10
                        // 조건 1. 남은 시간이 10초 미만인 경우 영상 마지막 위치로 이동 (동영상 길이)
                    ps += 10;
                    if(ps > 59) {pm += ps / 60; ps %= 60;} 
                    int videoSec = vm * 60 + vs;
                    posSec = pm * 60 + ps;
                    if (videoSec - posSec < 10) { // 10초 미만인 경우
                        pm = vm;
                        ps = vs;
                    }
                    System.out.println("+10 " + pm + " " + ps);
                    break;
                case "prev":
                    // 현재 시작 시간에서 -10
                        // 조건. 현재 위치가 10초 미만이면 영상 처음 위치로 이동
                    ps -= 10;
                    if(ps < 0) {pm-=1; ps+=60;}
                    if(pm < 0) {pm=0; ps=0;}
                    System.out.println("-10 " + pm + " " + ps);
                    break;
            }
            
            startSec = sm * 60 + ss;
            endSec = em * 60 + es;
            posSec = pm * 60 + ps;
            
            // 현재 위치가 오프닝 위치이면 오프닝 끝나는 시각으로 이동
            if (startSec <= posSec && posSec <= endSec) {
                pm = em;
                ps = es;
                System.out.println("오프닝 이슈 " + pm + " " + ps);
            }
        }
        
        answer = String.format("%02d:%02d", pm, ps);
        
        return answer;
    }
}