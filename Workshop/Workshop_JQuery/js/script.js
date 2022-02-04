$(document).ready(function() {
    $("#allCakes").click(function(){
         $("figure").show();
    });
    
     $('#miniCake').click(function(){
        $('figure').filter("#mini_Cake").show();
        $('figure').not("#mini_Cake").css("display","none");
    });
    $('#chocolateCake').click(function(){
        $('figure').filter("#choclate_Cake").show();
        $('figure').not("#choclate_Cake").css("display","none");
    });
    $('#cupCake').click(function(){
        $('figure').filter("#cup_Cake").show();
        $('figure').not("#cup_Cake").css("display","none");
    });
    $('#jellyCake').click(function(){
        $('figure').filter("#jelly_Cake").show();
        $('figure').not("#jelly_Cake").css("display","none");
    }) 
    $('#fruitCake').click(function(){
        $('figure').filter("#fruit_Cake").show();
        $('figure').not("#fruit_Cake").css("display","none");
    });

     $("#myInput").on("keyup", function() {
         var value = $(this).val().toLowerCase();
         $("figure").filter(function() {
             $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
             
         });
     });

 
 
 });