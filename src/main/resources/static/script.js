async function getWeather() {

    const city =
        document.getElementById("cityInput").value;

    const result =
        document.getElementById("result");

    const loading =
        document.getElementById("loading");

    try {

        loading.innerHTML = "Loading...";
        result.innerHTML = "";

        const response = await fetch(
            `http://localhost:8080/weather?city=${city}`
        );

        if (!response.ok) {

            const errorMessage =
                await response.text();

            throw new Error(errorMessage);
        }

        const data = await response.json();
        const condition = data.condition.toLowerCase();

        document.body.className = "";

        if(condition.includes("sun")){

            document.body.classList.add("sunny");
        }
        else if(condition.includes("rain")){

            document.body.classList.add("rainy");
        }
        else if(condition.includes("cloud")){

            document.body.classList.add("cloudy");
        }
        else{

            document.body.classList.add("default-weather");
        }

        loading.innerHTML = "";

        result.innerHTML = `
                    <div class="weather-card">

            <h2>${data.city}</h2>

            <img
                src="https:${data.icon}"
                alt="Weather Icon"
                id="weatherIcon"
            >

            <h3>${data.temperature}°C</h3>

            <p>${data.condition}</p>

            <p>Humidity: ${data.humidity}%</p>

        </div>
`;

    } catch(error) {

        loading.innerHTML = "";

        result.innerHTML = `
            <p>${error.message}</p>
        `;
    }
}