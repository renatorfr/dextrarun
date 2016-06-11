// Firebase config.
var config = {
    'authDomain': 'dextra-run.firebaseapp.com',
    'apiKey': 'AIzaSyCQ4JFDMk3bYTxh9IeCpqLowjuYRldn9sw',
};

// Initialize the Firebase.
var app = firebase.initializeApp(config);
var auth = app.auth();

// Verify if user is signed in
initApp = function() {
    auth.onAuthStateChanged(function(user) {
        if (user) {
            // User is signed in.
            window.location.replace('pages/home.html');
        } else {
            // User is signed out.
            window.location.replace('pages/login.html');
        }
    }, function(error) {
        console.log(error);
    });
};

window.onload = function() {
    initApp()
};