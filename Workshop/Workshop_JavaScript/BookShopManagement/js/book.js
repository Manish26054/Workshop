var addBook=document.getElementById("d1");
addBook.addEventListener("click",addBook());

var removeBook=document.getElementById("d2");
removeBook.addEventListener("click",removeBook());

var editBook=document.getElementById("d3");
editBook.addEventListener("click",editBook());

var bookList=document.getElementById("d4");
bookList.addEventListener("click",bookList());

function addBook() { 
    document.getElementById("box-container").innerHTML="<p>Hiii , input your data<p>"
 }