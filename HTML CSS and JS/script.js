/** Name: Christopher Padilla
*	Date: 10 July 2019
*	Purpose: JavaScript for Table.html and Counter.html
*/

/**
* 
*	js for Table.html
*
*/ 

var number = 2;
//Add a row right below 
function addRow(){
	
	var square = Math.pow(number, 2);
	var cube = Math.pow(number, 3);
	
	//add 1 row with 3 cells
	let table = document.getElementById('mainTable');
	let r = table.insertRow();
	let c1 = r.insertCell(); 
	let c2 = r.insertCell(); 
	let c3 = r.insertCell();
	
	//values
	c1.innerHTML = number; 
	c2.innerHTML = square;
	c3.innerHTML = cube;
	
	//change 'number' to next value. +1 increment
	number +=1;
	
}
	
//Initial seven rows
function insertInitialRows(){	
	
	for(i=1; i < 8; i++){
		addRow();	
	}
}



/**
* 
*	js for Counter.html
*
*/ 

var rowIndex = 0;
var arrayNum = new Array(10);

//Create a row with ten random array values.
function createTableRow() {
	
	let table = document.getElementById('arrayTable');
	
	let r1 = table.insertRow(); //Add row
	r1.insertCell();            //Cell for index
	table.rows[rowIndex+1].cells[0].innerHTML = rowIndex;  //output for index
	rowIndex += 1; //Update number of rows
	
	//Loop 10 times
	for(i=0; i < arrayNum.length; i++){
		
		r1.insertCell();
		
		arrayNum[i] = Math.floor(Math.random()*5)-2; // Range -2 to 2
		
		//For testing
		console.log("Row:" + rowIndex 
					+ " Array index:" + i
					+ " = " + arrayNum[i])	
		
		//output array values
		table.rows[rowIndex].cells[i+1].innerHTML = arrayNum[i];		
	}		
}	

//Validate input number 
function validate(){
	var input = document.getElementById('textBox').value;
	
	if (input == "" ||input == undefined){  //Empty
		alert("No input detected.");
	}		
	else if(input < 0 || input > (rowIndex-1)){ //Out of range
		alert("Index is out of range");
	}
	else
		counter(parseInt(input));	
}

//Identify and count numbers on a specified row.
function counter(index) {	

	let table = document.getElementById('arrayTable');	
	
	let zero = 0;
	let positive = 0;
	let negative = 0;
	
	
	//Checks zero, positive, negative.
	for(i=1; i < arrayNum.length + 1; i++){
		
		//ZERO
		if (table.rows[index+1].cells[i].innerText == 0){
			table.rows[index+1].cells[i].style.backgroundColor = "#efe1a1"; //light yellow
			zero += 1;
			console.log("cell " + i + " zero" + " count: " + zero);
		}
		//POSITIVE
		else if (table.rows[index+1].cells[i].innerText > 0){
			table.rows[index+1].cells[i].style.backgroundColor = "#a1efef"; //light blue
			positive += 1;
			console.log("cell " + i + " positive" + " count: " + positive);
		}	
		//NEGATIVE
		else if (table.rows[index+1].cells[i].innerText < 0){
			table.rows[index+1].cells[i].style.backgroundColor = "#f38b8b"; //light red
			negative += 1;
			console.log("cell " + i + " negative" + " count: " + negative);
		}
	}
	
	//Output counter result
	document.getElementById("zero").innerHTML = "Zero: " + zero;
	document.getElementById("positive").innerHTML = "Positive: " + positive;
	document.getElementById("negative").innerHTML = "Negative: " + negative;
	
	displayResult();
}

//Display counter result with animation
function displayResult(){
		var result = document.getElementById('center');
		
		result.style.opacity = '1';
		result.style.width = '250px';
	
}