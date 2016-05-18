# Using Easy GCM Library

Sample app using [Easy GCM](https://github.com/inloop/easygcm)

### Setup instructions
+ Download the `google-service.json` file by enabling GCM from [here](https://developers.google.com/cloud-messaging/android/client) and drop it under your `app` module.

+ On your first run of the app, check your logcat for the `REGISTRATION_ID` which is what you will feed in your `gradle.properties` file

+ Specify the below variables in your `gradle.properties` file

```
DATA={"myMessage":"Hello World"}
REGISTRATION_ID=<Registration_ID_without_quotes>
APIKEY=<API_KEY_without_quotes>

```

+ To send a push message

```
./gradlew push
```