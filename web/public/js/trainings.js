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
        if (!user) {
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

trainingCreateClick = function() {
    $('#training-new').toggle();
}

trainingSave = function() {
    var userId = firebase.auth().currentUser.uid;
    var trainer = $('#training-new input[name="trainer"]').val();
    var name = $('#training-new input[name="name"]').val();
    var steps = {};
    $('#training-new input[name|="step"]').each(function() {
        steps[$(this).data('field')] = $(this).val();
    });

    writeTrainingData(userId, trainer, name, JSON.stringify(steps));
}

writeTrainingData = function(userId, trainer, name, steps) {
    firebase.database().ref('trainings/' + userId).set({
        trainer: trainer,
        name: name,
        steps: steps
    });
}