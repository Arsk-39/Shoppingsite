/**
 * 
 */
// オプション表示用の関数
function showOptions() {
  var sortContainer = document.querySelector('.sort');
  setTimeout(function() {
    sortContainer.classList.toggle('show-options');
  }, 100); // 表示/非表示のトグルまでの遅延時間を指定 (ミリ秒単位)
}
