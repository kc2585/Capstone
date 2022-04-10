// 카테고리 버튼
const divs = document.querySelectorAll(".w");
const tabs = document.querySelectorAll(".tab-content");
for (var i = 0; i < divs.length; i++) {
  const div = divs[i];
  div.addEventListener("click", function () {
    for (var j = 0; j < divs.length; j++) {
      divs[j].className = "w";
      tabs[j].className = "tab-content";
    }
    const num = this.getAttribute("id");
    div.className = "on w";
    tabs[num - 1].className = "tab-content current";
  });
}

const list = new Array("", "", "", "", "");
list[0] =
  "경영지원관리자, 정부행정관리자, 보험관리자금융관리자, 회계사, 세무사, 상품기획자, 관세사, 병무행정사무원, 관세행정사무원, 공공행정사무원, 법원공무원, 조세행정사무원, 인사·교육·훈련사무원, 총무사무원, 감사사무원, 경영기획사무원, 영업기획·관리·지원사무원, 물류사무원, 무역사무원, 품질관리사무원, 안내·접수원, 자산운용가, 금융상품개발자, 웹기획자, 투자분석가, 사회단체활동가, 아나운서, 경기심판, 항공기객실승무원, 열차객실승무원, 선박객실승무원, 상품중개인 및 경매사";
list[1] =
  "철학연구원, 역사학연구원, 심리학연구원, 정치학연구원, 경제학연구원, 사회학연구원, 언어학연구원, 화학연구원, 생물학연구원, 통신망운영기술자, 통신기기·장비기술자, 모바일앱개발자, 응용소프트웨어개발자, 데이터베이스개발자, 웹운영자, 정보시스템운영자, 빅데이터분석가, IT기술지원전문가, 교통영향평가원, 토목안전·환경·품질기술자, 토목구조설계기술자, 토목감리기술자, 토목시공기술자 및 견적원, 도시계획·설계가, 지적 및 측량기술자, 지리정보시스템전문가, 건설자재시험원, 조선·해양공학기술자, 자동차공학기술자, 항공공학기술자, 건설기계공학기술자 및 연구원, 로봇공학기술자, 기계시험원, 플랜트기계공학기술자, 원자력공학기술자, 변호사, 해양경찰관, 교도관, 전기·전자설비조작원";
list[2] =
  "경찰·소방·교도관리자, 해양경찰관, 경찰관, 소방관, 교도관, 위험관리원, 산업안전원, 비파괴검사원, 위관급 장교, 부사관, 시설·특수경비원, 청원경찰, 특수교육교사, 학습지·교육교구방문강사, 학교 교사, 중·고등학교교사, 보조교사";
list[3] =
  "공연·영화·음반기획자, 광고·홍보·마케팅사무원, 소설가, 잡지기자, 방송기자, 신문기자, 학예사, 국악인, 사진작가 및 사진사, 무용가, 가수, 성악가, 연주가, 작곡가, 지휘자, 조각가, 화가, 영화감독, 방송연출가, 조명기사, 영상·녹화·편집기사, 음향·녹음기사, 촬영기사, 개그맨 및 코미디언, 연극연출가, 광고영상감독, 성우, 연극·뮤지컬배우, 영화배우 및 탤런트, 직업운동선수, 레크리에이션전문가, 스포츠트레이너, 스포츠감독 및 코치";
list[4] =
  "내과의사, 외과의사, 치과의사, 일반의사, 성형외과의사, 산부인과의사, 이비인후과의사, 안과의사, 정신과의사, 소아과의사, 방사선과의사, 한의사, 마취병리과의사, 비뇨기과의사, 피부과의사, 가정의학과의사, 수의사, 약사, 영양사, 임상병리사, 방사선사, 물리치료사, 응급구조사, 안마사, 간호조무사, 보건의료정보관리사";

const tab_1 = list[0].split(", ");
const tab_2 = list[1].split(", ");
const tab_3 = list[2].split(", ");
const tab_4 = list[3].split(", ");
const tab_5 = list[4].split(", ");

const tab_arr = new Array(tab_1, tab_2, tab_3, tab_4, tab_5);

const lists = document.querySelectorAll(".job-list");
for (var i = 0; i < 5; i++) {
  let txt = "";
  for (var j = 0; j < tab_arr[i].length; j++) {
    txt = tab_arr[i][j];
    let tag = document.createElement("p");
    tag.className = "order";
    tag.appendChild(document.createTextNode(txt));
    lists[i].appendChild(tag);
  }
}
