// Firebase config.
var config = {
    'authDomain': 'dextra-run.firebaseapp.com',
    'apiKey': 'AIzaSyCQ4JFDMk3bYTxh9IeCpqLowjuYRldn9sw',
};

// FirebaseUI config.
var uiConfig = {
    'signInSuccessUrl': 'home.html',
    'signInOptions': [firebase.auth.GoogleAuthProvider.PROVIDER_ID],

    // Terms of service url.
    //'tosUrl': '<your-tos-url>',
};

// Initialize the FirebaseUI Widget using Firebase.
var app = firebase.initializeApp(config);
var auth = app.auth();
var ui = new firebaseui.auth.AuthUI(auth);

// The start method will wait until the DOM is loaded.
ui.start('#firebaseui-auth-container', uiConfig);

// Verify if user is signed in
initApp = function() {
    auth.onAuthStateChanged(function(user) {
        if (user) {
            // User is signed in.
            window.location.replace('home.html');
        }
    }, function(error) {
        console.log(error);
    });
};

window.onload = function() {
    initApp()
};