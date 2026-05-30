// main.js

// 1. JavaScript Basics & Setup
console.log("Welcome to the Community Portal");

window.onload = function () {
    alert("Page fully loaded");
};

// 2. Syntax, Data Types, Operators

const eventName = "Music Night";
const eventDate = "2026-06-15";

let availableSeats = 50;

let eventInfo =
    `Event: ${eventName} | Date: ${eventDate} | Seats: ${availableSeats}`;

console.log(eventInfo);

availableSeats++;

console.log("Updated Seats:", availableSeats);

// 3. Conditionals, Loops, Error Handling

const events = [
    {
        id: 1,
        name: "Music Night",
        category: "Music",
        seats: 10,
        date: "2026-06-15"
    },

    {
        id: 2,
        name: "Baking Workshop",
        category: "Workshop",
        seats: 0,
        date: "2024-01-01"
    },

    {
        id: 3,
        name: "Football Match",
        category: "Sports",
        seats: 25,
        date: "2026-07-10"
    }
];

// Show valid events
events.forEach(event => {

    if (new Date(event.date) > new Date() && event.seats > 0) {
        console.log("Valid Event:", event.name);
    }

    else {
        console.log("Hidden Event:", event.name);
    }
});

// Registration with try-catch
function registerEvent(eventObj) {

    try {

        if (eventObj.seats <= 0) {
            throw new Error("No seats available");
        }

        eventObj.seats--;

        console.log(`Registered for ${eventObj.name}`);
    }

    catch (error) {
        console.log("Registration Error:", error.message);
    }
}

// 4. Functions, Closures, Higher Order Functions

function addEvent(eventList, newEvent) {
    eventList.push(newEvent);
}

function registerUser(eventName, userName) {
    console.log(`${userName} registered for ${eventName}`);
}

function filterEventsByCategory(category, callback) {

    const filtered =
        events.filter(event => event.category === category);

    callback(filtered);
}

// Closure
function registrationTracker() {

    let totalRegistrations = 0;

    return function () {

        totalRegistrations++;

        return totalRegistrations;
    };
}

const trackMusicRegistration = registrationTracker();

console.log(trackMusicRegistration());
console.log(trackMusicRegistration());

// Callback Example
filterEventsByCategory("Music", function (filteredEvents) {

    console.log("Filtered Events:", filteredEvents);
});

// 5. Objects and Prototypes

class Event {

    constructor(name, category, seats) {

        this.name = name;
        this.category = category;
        this.seats = seats;
    }
}

// Prototype Method
Event.prototype.checkAvailability = function () {

    return this.seats > 0
        ? "Seats Available"
        : "Full";
};

const newEvent = new Event(
    "Dance Show",
    "Music",
    20
);

console.log(newEvent.checkAvailability());

// Object.entries()
Object.entries(newEvent).forEach(([key, value]) => {

    console.log(key, value);
});

// 6. Arrays and Methods

// push()
events.push({
    id: 4,
    name: "Cooking Class",
    category: "Workshop",
    seats: 15,
    date: "2026-08-01"
});

// filter()
const musicEvents =
    events.filter(event => event.category === "Music");

console.log(musicEvents);

// map()
const displayCards =
    events.map(event => `Workshop on ${event.name}`);

console.log(displayCards);

// 7. DOM Manipulation

const container =
    document.querySelector("#eventContainer");

function displayEvents(eventList) {

    container.innerHTML = "";

    eventList.forEach(event => {

        const card = document.createElement("div");

        card.className = "event-card";

        card.innerHTML = `
            <h3>${event.name}</h3>
            <p>Category: ${event.category}</p>
            <p>Seats: ${event.seats}</p>

            <button onclick="handleRegister(${event.id})">
                Register
            </button>
        `;

        container.appendChild(card);
    });
}

displayEvents(events);

// Update UI
function handleRegister(id) {

    const selectedEvent =
        events.find(event => event.id === id);

    registerEvent(selectedEvent);

    displayEvents(events);
}

// 8. Event Handling

// onchange
document
    .querySelector("#categoryFilter")
    .onchange = function () {

        const value = this.value;

        if (value === "All") {

            displayEvents(events);
        }

        else {

            const filtered =
                events.filter(event =>
                    event.category === value
                );

            displayEvents(filtered);
        }
    };

// keydown
document
    .querySelector("#searchBox")
    .addEventListener("keydown", function () {

        const searchText =
            this.value.toLowerCase();

        const filtered =
            events.filter(event =>
                event.name.toLowerCase()
                    .includes(searchText)
            );

        displayEvents(filtered);
    });

// 9. Async JS, Promises, Async/Await

const loading =
    document.querySelector("#loading");

// Fetch with then/catch
loading.style.display = "block";

fetch("https://jsonplaceholder.typicode.com/posts")

    .then(response => response.json())

    .then(data => {

        console.log("Fetched Data:", data);

        loading.style.display = "none";
    })

    .catch(error => {

        console.log(error);

        loading.style.display = "none";
    });

// Async/Await
async function fetchEvents() {

    try {

        loading.style.display = "block";

        const response =
            await fetch(
                "https://jsonplaceholder.typicode.com/posts"
            );

        const data = await response.json();

        console.log("Async Data:", data);

        loading.style.display = "none";
    }

    catch (error) {

        console.log(error);

        loading.style.display = "none";
    }
}

fetchEvents();

// 10. Modern JavaScript Features

function greetUser(name = "Guest") {

    console.log(`Welcome ${name}`);
}

greetUser();

const clonedEvents = [...events];

const firstEvent = events[0];

const {
    name,
    category,
    seats
} = firstEvent;

console.log(name, category, seats);

// 11. Working with Forms

const form =
    document.querySelector("#registrationForm");

form.addEventListener("submit", function (event) {

    event.preventDefault();

    const username =
        form.elements["username"].value;

    const email =
        form.elements["email"].value;

    const selectedEvent =
        form.elements["selectedEvent"].value;

    let valid = true;

    // Clear errors
    document.querySelector("#nameError").innerHTML = "";
    document.querySelector("#emailError").innerHTML = "";

    // Validation
    if (username === "") {

        document.querySelector("#nameError")
            .innerHTML = "Name required";

        valid = false;
    }

    if (email === "") {

        document.querySelector("#emailError")
            .innerHTML = "Email required";

        valid = false;
    }

    if (valid) {

        console.log(username, email, selectedEvent);

        submitRegistration({
            username,
            email,
            selectedEvent
        });
    }
});

// 12. AJAX & Fetch API

function submitRegistration(userData) {

    document.querySelector("#message")
        .innerHTML = "Submitting...";

    setTimeout(() => {

        fetch("https://jsonplaceholder.typicode.com/posts", {

            method: "POST",

            headers: {
                "Content-Type": "application/json"
            },

            body: JSON.stringify(userData)
        })

            .then(response => response.json())

            .then(data => {

                console.log("Server Response:", data);

                document.querySelector("#message")
                    .innerHTML =
                    "Registration Successful";
            })

            .catch(error => {

                console.log(error);

                document.querySelector("#message")
                    .innerHTML =
                    "Registration Failed";
            });

    }, 2000);
}

// 13. Debugging and Testing

console.log("Form Loaded Successfully");

console.log("Events Array:", events);

// 14. jQuery and Frameworks

$('#registerBtn').click(function () {

    $('.event-card').fadeOut(500).fadeIn(500);
});

/*
Benefit of React/Vue:
Reusable components and faster UI updates.
*/