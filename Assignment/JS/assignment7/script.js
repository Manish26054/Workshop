function validateForm() {
    let fname = document.querySelector("#fname").value;
    if (fname === "" || fname.length < 3 || fname.length > 40) {
      document.querySelector("#fname").innerHTML = "<br> First name is invalid";
      return false;
    }
  
    let lname = document.querySelector("#lname").value;
    if (lname === "" || lname.length < 3 || lname.length > 40) {
      document.querySelector(".error").innerHTML += "<br> Last name is invalid";
      return false;
    }
  
    let email = document.querySelector("#email").value;
    pattern = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/; //regular expression
    if (!pattern.test(email)) {
      document.querySelector(".error").innerHTML += "<br>email is invalid";
      return false;
    }
  }
  