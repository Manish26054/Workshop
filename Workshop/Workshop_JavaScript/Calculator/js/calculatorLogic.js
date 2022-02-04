function getHistory(){
    return document.getElementById("history-value").innerText;
}

function printHistory(num){
    document.getElementById("history-value").innerText=num;
}

function getOutput(){
   return document.getElementById("output-number").innerText;
}

function printOutput(num){

    if(num==""){
        document.getElementById("output-number").innerText=num;
    }
    else{
    document.getElementById("output-number").innerText=getFormattedNumber(num);
    }
}
function squareRoot(){
    var number =getOutput();
    console.log(number);
    document.getElementById("output-number").innerHTML=Math.sqrt(number);
}
var button = document.getElementById("squareroot");
button.addEventListener('click',squareRoot);

function square(){
    var number =getOutput();
    console.log(number);
    document.getElementById("output-number").innerHTML=Math.pow(number,2);
}
var button = document.getElementById("square");
button.addEventListener('click',square);

function cube(){
    var number =getOutput();
    console.log(number);
    document.getElementById("output-number").innerHTML=Math.pow(number,3);
}
var button = document.getElementById("cube");
button.addEventListener('click',cube);

function cubeRoot(){
    var number =getOutput();
    console.log(number);
    document.getElementById("output-number").innerHTML=Math.cbrt(number);
}
var button = document.getElementById("cuberoot");
button.addEventListener('click',cubeRoot);

function getFormattedNumber(num){
    if(num=="-"){
        return "";
    }
    var n = Number(num);
    var value =n.toLocaleString("en");
    return value;
}
function reverseNumberFormat(num){
    return Number(num.replace(/,/g,''));
}

var operator = document.getElementsByClassName("operator");
for(var i=0;i<operator.length;i++){
    operator[i].addEventListener('click',function(){
        if(this.id=="clear"){
            printHistory("");
            printOutput("");
        }
        else if(this.id=="backspace"){
            var output=reverseNumberFormat(getOutput()).toString();
            if(output){
                output=output.substr(0,output.length-1);
                printOutput(output);
            }
        }
        else{
            var output=getOutput();
            var history= getHistory();
            if(output=="" && history!=""){
                if(isNaN(history[history.length-1])){
                    history=history.substr(0,history.length-1);
                }
            }
            if(output!="" || history!=""){
                output=output==""?output:reverseNumberFormat(output);
                history=history+output;
                if(this.id=="="){
                    var result=eval(history);
                    printOutput(result);
                    printHistory("");
                }
                else{
                    history=history+this.id;
                    printHistory(history);
                    printOutput("");
                }
            }
        }
    });
}

var number = document.getElementsByClassName("number");
for(var i=0;i<number.length;i++){
    number[i].addEventListener('click',function(){
        var output =reverseNumberFormat (getOutput());
        if(output!=NaN){    
            output=output+this.id;
            printOutput(output);
        }
    });
}   
