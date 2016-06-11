// Firebase config.
var config = {
    'authDomain': 'dextra-run.firebaseapp.com',
    'apiKey': 'AIzaSyCQ4JFDMk3bYTxh9IeCpqLowjuYRldn9sw',
};

// Initialize the FirebaseUI Widget using Firebase.
var app = firebase.initializeApp(config);
var auth = app.auth();

// Verify if user is signed in
initApp = function() {
    auth.onAuthStateChanged(function(user) {
        if (user) {
            // User is signed in.
            var displayName = user.displayName;
            var email = user.email;
            var emailVerified = user.emailVerified;
            var photoURL = user.photoURL;
            var uid = user.uid;
            var providerData = user.providerData;
            user.getToken().then(function(accessToken) {
                document.getElementById('quickstart-sign-in-status').textContent = 'Signed in';
                document.getElementById('quickstart-sign-in').textContent = 'Sign out';
                document.getElementById('quickstart-account-details').textContent = JSON.stringify({
                    displayName: displayName,
                    email: email,
                    emailVerified: emailVerified,
                    photoURL: photoURL,
                    uid: uid,
                    accessToken: accessToken,
                    providerData: providerData
                }, null, '  ');
            });
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