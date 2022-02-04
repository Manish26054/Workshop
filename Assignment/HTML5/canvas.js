function draw(){
    var canvas=document.getElementById('canvas');
    if(canvas.getContext){
        var ctx =canvas.getContext('2d');
        ctx.fillStyle="yellow";

        ctx.beginPath();

        ctx.arc(75,75,50,0,Math.PI*2,true);
        ctx.fill();
        ctx.moveTo(40,75);
        ctx.arc(75,75,35,0,Math.PI,false);
        ctx.moveTo(65,65);
        ctx.strokeStyle="black";
        ctx.stroke();
        ctx.closePath();

        ctx.beginPath();
        ctx.strokeStyle="black";
        ctx.fillStyle="black";

        ctx.arc(60,65,5,0,Math.PI*2,true);
        ctx.fill();

        ctx.moveTo(95,65);
        ctx.arc(90,65,5,0,Math.PI*2,true);
        ctx.fill();
        ctx.stroke();
        ctx.closePath();
    }
}