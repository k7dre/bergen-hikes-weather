const root = document.getElementById("root");
console.log(root);
const table = root.querySelector("table");
const date = new Date();
const dateFormatted = new Intl.DateTimeFormat("nb-NO", {
		weekday: "long", 
		hour:"numeric", minute:"numeric",
		year: "numeric", month: "long", day: "numeric" 	
	}).format();

let data = null;

async function getData(){
	const url = "https://bergen-hikes-weather-1.onrender.com/hikes/weather";

	try{
		const response = await fetch(url);
		if (!response.ok) {
			throw new Error(`Response status: ${response.status}`);
		}
		
		data = await response.json();
		

	} catch (error) {
		console.error(error.message);
	}
	
	return data;
}

function renderTable(data) {
	
	data.forEach(m => {
		const row = table.insertRow(-1);
		const cellName = row.insertCell();
		const cellTemp = row.insertCell();
		const cellWind = row.insertCell();
		const cellRain = row.insertCell();
		
		cellName.textContent = m.mountain;
		cellTemp.textContent = m.temperature;
		cellWind.textContent = m.windSpeed;
		cellRain.textContent = m.precipitation;
	})
}

function renderHeader() {
	root.querySelector("h1").textContent = dateFormatted;
}

getData().then(data => {
	console.log(data);
	renderTable(data);
	renderHeader(data);
});



