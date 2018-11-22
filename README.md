# Android_MineCra

# 어플리케이션 소개
 
 컴퓨터 기본 게임인 지뢰찾기를 안드로이드로 구현
 
 
 1.지뢰찾기 설명
 
 
  지뢰 찾기(Minesweeper)는 혼자서 하는 컴퓨터 게임이다. 
 
  여기서 영어 낱말 "Minesweeper"(마인스위퍼)는 지뢰를 찾아 제거하는 사람이나 배를 가리킨다.

  이 게임의 목적은 지뢰를 피해서 지뢰밭의 모든 단추를 여는 것이다.
 
  기본적인 지뢰찾기 룰과 동일
  
 
 2.지뢰찾기 규칙 참고
 
  위키백과 : https://ko.wikipedia.org/wiki/%EC%A7%80%EB%A2%B0_%EC%B0%BE%EA%B8%B0#%EA%B7%9C%EC%B9%99
 

# 개발환경 관계

  안드로이드에서 개발하여 데이터 저장이 필요하지 않으므로 파이어베이스는 연결하지 않았다.

# 구체적인 코드 설명

>  MainActivity.java

    OnClickListener, public void onClick(View v) : 지뢰찾으려고 클릭하는경우 처리 함수

    OnGlobalLayoutListener, public void onGlobalLayout() : 첫 화면 초기화 함수

    private void initGame() : 게임판 새로 생성해주고 크기, 행/열수 정하고 지뢰를 심어두는 함수

    public void stopGame() : 게임종료와 걸린시간을 출력해주는 함수

    private void stopTimer() : 타이머 초기화 함수

    onPause : 타이머 중지, onResume : 타이머 재시작

    public void setMarkerMode(View v) : 지뢰열기 모드와 지뢰마크하기 모드를 변경
    
    public void openSetup(View v) : 환경설정 다이알로그를 호출




>  MineButton.java

    public class MineButton extends ImageButton 지뢰버튼집합 전체

    private static Vector<MineButton> sBtnV = new Vector<MineButton>(); 벡터로 생성된 지뢰버튼을 관리

    private static int sCellCount; // 전체 셀 갯수, 지뢰갯수, 마크된셀갯수, 찾아진지뢰갯수, 열려진셀갯수 등을 static변수로 관리

    private static int sMineCount = 0;

    private static int sMarkedCount;

    private static int sFoundMineCount;

    private static int sOpenedCellCount;

    public enum State { OPENED, MARKED, CLOSED, WRONG_MARKED }; // 각 셀의 상태


    int mCol, mRow; // 각 셀은 자신의 위치(행,열번호)와 값(주변 8개 셀중 지뢰의 갯수), 상태(위 네가지 중 하나)의 멤버변수 포함

    State mState;

    int mValue;

    public static void initAllMines(int totMineCnt) : 랜덤 지뢰 생성 

    public boolean clickMine() : 각 셀이 클릭되었을 때 클릭모드와 현재 셀 상태에 따른 처리

    private void setState(State state) :셀 상태 변화 

    private boolean openNearCells() : 주변 셀 중 지뢰가 다 마크되었다면 나머지 셀들을 자동으로 열어준다

    private void openNullCells() : 주변에 지뢰가 하나도 없는 Null셀을 열면 주변의 이어진 Null셀을 전부 열어준다.

    private void openRemainingCells() : 지뢰를 다 찾았으면 나머지 닫힌 셀을 전부 열어준다

    public static void resetAllMines() : 지뢰판 초기화


>  SetupDialog.java

    public class SetupDialog extends Dialog // 환경설정용 다이알로그

xml file 은 레이아웃이므로 개발자마다 다를 수 있으니 구체적인 설명은 생략하겠습니다.
  
# Youtube 주소

 https://youtu.be/gFfH-rmx7rc
 
 어플리케이션 실행 동영상 첨부




