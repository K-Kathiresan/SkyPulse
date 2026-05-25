async function getWeather() {

    const city = document.getElementById("cityInput").value;

    if(city === ""){
        alert("Enter city name");
        return;
    }

    try{

        const response = await fetch(`/weather?city=${city}`);

        if(!response.ok){
            throw new Error("City not found");
        }

        const data = await response.json();

        console.log(data);

        document.getElementById("cityName").innerText =
            data.city;

        document.getElementById("temperature").innerText =
            Math.round(data.temperature) + "°C";

        document.getElementById("description").innerText =
            data.condition;

        document.getElementById("humidity").innerText =
            data.humidity + "%";

        document.getElementById("weatherIcon").src =
            "https:" + data.icon;

        // Temporary dummy values
        document.getElementById("wind").innerText =
            "12 km/h";

        document.getElementById("feelsLike").innerText =
            Math.round(data.temperature + 2) + "°C";

        document.getElementById("visibility").innerText =
            "6 km";

        updateTheme(data.condition);

        updateMessage(data.temperature);

    }
    catch(error){
        alert(error.message);
    }
}
function getCurrentLocationWeather(){

    if(!navigator.geolocation){

        alert("Geolocation is not supported");
        return;
    }

    navigator.geolocation.getCurrentPosition(

        async(position)=>{

            const lat = position.coords.latitude;
            const lon = position.coords.longitude;

            try{

                const response = await fetch(
                    `/weather/location?lat=${lat}&lon=${lon}`
                );

                if(!response.ok){
                    throw new Error("Location weather failed");
                }

                const data = await response.json();

                console.log(data);

                document.getElementById("cityName").innerText =
                    data.city;

                document.getElementById("temperature").innerText =
                    Math.round(data.temperature) + "°C";

                document.getElementById("description").innerText =
                    data.condition;

                document.getElementById("humidity").innerText =
                    data.humidity + "%";

                document.getElementById("weatherIcon").src =
                    "https:" + data.icon;

                document.getElementById("wind").innerText =
                    "12 km/h";

                document.getElementById("feelsLike").innerText =
                    Math.round(data.temperature + 2) + "°C";

                document.getElementById("visibility").innerText =
                    "6 km";

                updateTheme(data.condition);

                updateMessage(data.temperature);

            }
            catch(error){

                alert(error.message);
            }

        },

        ()=>{

            alert("Location access denied");
        }
    );
}

function updateTheme(condition){

    condition = condition.toLowerCase();

    if(condition.includes("rain")){

        document.body.style.background =
            "linear-gradient(-45deg,#0f172a,#1d4ed8,#1e40af,#0f172a)";
    }

    else if(condition.includes("sun")){

        document.body.style.background =
            "linear-gradient(-45deg,#f59e0b,#f97316,#facc15,#fb923c)";
    }

    else if(condition.includes("cloud")){

        document.body.style.background =
            "linear-gradient(-45deg,#4b5563,#6b7280,#374151,#1f2937)";
    }

    else{

        document.body.style.background =
            "linear-gradient(-45deg,#0f172a,#1e3a8a,#2563eb,#0f172a)";
    }
}

function updateMessage(temp){

    let message = "";

    if(temp >= 35){
        message = "High temperature outside. Stay hydrated.";
    }

    else if(temp >= 25){
        message = "Perfect weather for outdoor activities.";
    }

    else{
        message = "Cool climate detected. Enjoy the weather.";
    }

    document.getElementById("smartMessage").innerText = message;
}