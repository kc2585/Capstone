// 카테고리 버튼
const divs = document.querySelectorAll(".w");

// 분야 설명 테이블
const tables = document.querySelectorAll(".y");

for (var i = 0; i < divs.length; i++) {
  const div = divs[i];
  div.addEventListener("click", function () {
    for (var j = 0; j < divs.length; j++) {
      divs[j].className = "w";
      tables[j].className = "dot-list v1 y non_table";
    }
    const num = this.getAttribute("id");
    div.className = "on w";
    tables[num].className = "dot-list v1 y on_table";
  });
}
