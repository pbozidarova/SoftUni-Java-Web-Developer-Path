// Write a function that receives a string message and displays it inside a div with an id "notification" for 2 seconds. 
// The div is initially hidden and when the function is called, it must be shown. After 2 seconds, hide the div. 
// In the example below, a notification is shown when you click the button.
// When we click the [GET NOTIFIED] button, a div appears in our upper-right corner. It should disappear in 2 seconds.

function notify(message) {
    let divNotification = document.getElementById('notification');
    divNotification.textContent = message;
    divNotification.style.display = 'block';


    setTimeout(() => {
        divNotification.style.display = 'none';
    }, 2000)
}