function changeImage()
{
    element=document.getElementById('myimage')
    if (element.src.match("bulbon"))
    {
        element.src="pic_bulboff.gif";
    }
    else
    {
        element.src="pic_bulbon.gif";
    }
}
function changeColor(){
    x = document.getElementById("changecolor")
    x.style.color = "#ff0000"
}