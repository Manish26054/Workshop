var i = 0;
function countNumbers() {
    if(i < 100000) {
        i = i + 2;
        postMessage(i);
    }
    setTimeout("countNumbers()", 1000);
}
countNumbers();