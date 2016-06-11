$(document).ready(function() {
    initApp();
    $('a[name="create"]').click(trainingCreateClick);
});

// Firebase config.
var config = {
    apiKey: "AIzaSyCQ4JFDMk3bYTxh9IeCpqLowjuYRldn9sw",
    authDomain: "dextra-run.firebaseapp.com",
    databaseURL: "https://dextra-run.firebaseio.com",
    storageBucket: "dextra-run.appspot.com"
};

// Initialize the Firebase.
var app = firebase.initializeApp(config);
var auth = app.auth();
var database = app.database;

// Verify if user is signed in
initApp = function() {
    auth.onAuthStateChanged(function(user) {
        if (user) {
            // User is signed in.
            setUserInfo(user);
        } else {
            // User is signed out.
            window.location.replace('login.html');
        }
    }, function(error) {
        console.log(error);
    });
};

trainingCreateClick = function() {
    $('#training-new').toggle();
    return false;
};