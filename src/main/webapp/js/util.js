// /!\NOT MODIFIED/!\
//[1][createText]------------------------------------------------------------
function createText(x, y, data, type){
					
						var texteSpan = document.createElement('span');
						texteSpan.className = "texte";
						numId++;
						texteSpan.id = "id_dynamic"+numId;
					
						switch (type) {
								case "circle":
									texteSpan.style.left = x-30;
									texteSpan.style.top = y-40;
									texteSpan.style.width = "75";
								break;
								case "rect":
									texteSpan.style.left = x-30;
									texteSpan.style.top = y-30;
									texteSpan.style.width = "100";
								break;
								case "path":
									texteSpan.style.left = x+35;
									texteSpan.style.top = y-15;
									texteSpan.style.width = "65";
								break;
								case "path_incline":
									texteSpan.style.left = x+60;
									texteSpan.style.top = y-40;
									texteSpan.style.width = "65";
								break;
								case "path_decline":
									texteSpan.style.left = x+35;
									texteSpan.style.top = y+25;
									texteSpan.style.width = "65";
								break;
								
						}
						information = document.createTextNode(data);
						texteSpan.appendChild(information);
						document.getElementById("G6R4").appendChild(texteSpan);
					return 	numId;
				}
//[2][calculPositionForPath]------------------------------------------------------------
function calculPositionForPath(x, y, ax, ay){
	
	xVal = 0;
	yVal = 0;

		// décliné
		if(ay > y){
			if(ax > x){
				xVal = x + (ax - x) / 2 - 20;
			}
			else if(x > ax) {
				xVal = ax + (x - ax) / 2;
			} else {
				xVal = x - 20;
			}
			yVal = y + (ay - y) / 2;	
		}
		// incliné
		else if(y > ay){
			if(ax > x) {
				xVal = x + (ax - x) / 2;
			}
			else if(x > ax){
				xVal = ax + (x - ax) / 2;
			} else {
				xVal = x;
			}
			yVal = ay + (y - ay) / 2;
		// droite	
		}else {
			if(ax > x) {
				xVal = x + (ax - x) / 2;
			}
			else if(x > ax){
				xVal = ax + (x - ax) / 2;
			}
			yVal = ay 
		}
	
	tab = new Array();
	tab[0] = xVal- 20;
	tab[1] = yVal- 20;
	return tab;
}
//[3][dragTextOfPath]------------------------------------------------------------
function dragTextOfPath(idText, path){
			
			val1 = document.getElementById("id_dynamic"+idText).offsetLeft;
			val2 = document.getElementById("id_dynamic"+idText).offsetTop;
			
			tab = calculPositionForPath(path[0][1], path[0][2], path[1][1],path[1][2]);
			
			document.getElementById("id_dynamic"+idText).style.left = tab[0]; ;
			document.getElementById("id_dynamic"+idText).style.top = tab[1];
}
//[4][dragTextOfElement]-----------------------------------------------------------
function dragTextOfElement(idText, x, y){
			
			val1 = document.getElementById("id_dynamic"+idText).offsetLeft;
			val2 = document.getElementById("id_dynamic"+idText).offsetTop;
		
			document.getElementById("id_dynamic"+idText).style.left = val1 + x;
			document.getElementById("id_dynamic"+idText).style.top = val2 + y;
}
	
//[5][moveup]------------------------------------------------------------
function move(dx, dy) {
	  this.update(dx - (this.dx || 0), dy - (this.dy || 0));
	  this.dx = dx;
	  this.dy = dy;
 }
function up() {
	  this.dx = this.dy = 0;
}
//[6][]------------------------------------------------------------