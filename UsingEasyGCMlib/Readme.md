# Using Easy GCM Library

### Reference
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


License
=======

    Copyright 2016 Nishant Srivastava

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
