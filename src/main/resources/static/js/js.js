$(document).ready(function(){
    var $buttons = $("button.accordion-button");
    $buttons.on("click", function(event){
        $buttons.not(this).addClass("plus");
        $buttons.not(this).removeClass("minus");
        $(this).toggleClass("plus");
        $(this).toggleClass("minus");
    });
});

function change3D(){
    var element = document.getElementById("map2D");
    if(element != null){
        element.style.display = "block";
    }

    element = document.getElementById("list2D");
    if(element != null){
        element.style.display = "block";
    }

    element = document.getElementById("add2D");
    if(element != null){
        element.style.display = "block";
    }

    element = document.getElementById("map3D");
    if(element != null){
        element.style.display = "none";
    }

    element = document.getElementById("list3D");
    if(element != null){
        element.style.display = "none";
    }

    element = document.getElementById("add3D");
    if(element != null){
        element.style.display = "none";
    }
}
function change2D(){

    var element = document.getElementById("map2D");
    if(element != null){
        element.style.display = "none";
    }

    element = document.getElementById("list2D");
    if(element != null){
        element.style.display = "none";
    }

    element = document.getElementById("add2D");
    if(element != null){
        element.style.display = "none";
    }

    element = document.getElementById("map3D");
    if(element != null){
        element.style.display = "block";
    }

    element = document.getElementById("list3D");
    if(element != null){
        element.style.display = "block";
    }

    element = document.getElementById("add3D");
    if(element != null){
        element.style.display = "block";
    }
}

function changeArrow(){
    if(document.getElementById('toggler').checked){
        document.getElementById('arrow').classList.remove('icon-arrow-left');
        document.getElementById('arrow').classList.add('icon-arrow-right');
    }
    else {
        document.getElementById('arrow').classList.remove('icon-arrow-right');
        document.getElementById('arrow').classList.add('icon-arrow-left');
    }
}

function changeSign(){
    $(this).toggleClass('minus');
    $(this).toggleClass('plus');
}

