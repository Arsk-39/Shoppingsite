/**
 * 
 */
function setMaxValue() {
  var countInput = document.getElementById('countInput');
  countInput.value = countInput.max;
  countInput.setAttribute('data-prev-value', countInput.value); // 現在の値を一時的に保存
  countInput.addEventListener('input', restoreValue); // 値が変更されたら元の値に戻す
}

function restoreValue() {
  var countInput = document.getElementById('countInput');
  countInput.value = countInput.getAttribute('data-prev-value'); // 元の値に戻す
  countInput.removeEventListener('input', restoreValue); // イベントリスナーを削除
}
