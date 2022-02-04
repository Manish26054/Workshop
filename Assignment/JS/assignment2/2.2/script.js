function calculateCI() {
    const p = parseInt(document.querySelector("#princ").value);
    const rt = parseInt(document.querySelector("#rate").value);
    const yr = parseInt(document.querySelector("#year").value);
  
    const result = p * Math.pow([(100 + rt) / 100], yr) - p;
    document.querySelector("h2").innerHTML = result;
  }
  