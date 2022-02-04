let text = "";
var heading = "<h1>List of Students</h1><hr style='border-top: dashed;'><br>";
function addToList() {
  text += document.querySelector("input[type=text]").value + "<br>";
  document.querySelector("input[type=text]").value = "";
}
function showList() {
  document.querySelector("#list").innerHTML = heading + text;
}

