function find() {
    var companyName = "Cybage Software Pvt Ltd";
    var char = document.querySelector("input[type=text]").value;
    var Character = char.toLowerCase();
    var cName = companyName.toLowerCase();
    const cybName = companyName.substring(0, 15);
    if (cName.includes(Character)) {
      document.querySelector("#search").innerHTML =
        "Character " +
        char +
        " found at position " +
        companyName.indexOf(char) +
        "<br> " +
        companyName +
        " is popularly known as " +
        cybName +
        "<br>" +
        cName +
        "<br>" +
        cName.toUpperCase();
    } else {
      document.querySelector("#search").innerHTML =
        "Character " + char + " not found";
    }
  }
  