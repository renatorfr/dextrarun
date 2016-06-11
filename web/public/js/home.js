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
var database = firebase.database;

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

window.onload = function() {
    initApp()
};

setUserInfo = function(user) {
    var displayName = user.displayName;
    var email = user.email;
    var photoURL = user.photoURL;

    user.getToken().then(function(accessToken) {
        $('#user-info [name="photo"]').attr('src', photoURL);
        $('#user-info [name="name"]').html(displayName);
        $('#user-info [name="email"]').html(email);
    }, null, '  ');
};