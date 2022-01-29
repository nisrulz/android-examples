# CameraX

The CameraX is a Jetpack support library in android, support Lollipop (Android 5.0 (API level 21)) and above.

### CameraX API

+ [Preview](https://developer.android.com/training/camerax/preview) - A view to display the camera feed. Provided by the `camera-view` dependency.
+ [Image Capture](https://developer.android.com/training/camerax/take-photo) - Capture high quality images.
+ [Camera Selector](https://developer.android.com/reference/androidx/camera/core/CameraSelector) - Select Lens and configure filter.

### Required Understanding

+ Capturing an image or video comes under the restricted actions, and hence user has to grant the permission explicitly. More about [permissions in Android](https://developer.android.com/guide/topics/permissions/overview).
+ There are more actions like storing the image in the storage comes under the similar category of dangerous permissions.

### Reference

+ [Docs](https://developer.android.com/reference/android/hardware/camera2/package-summary.html)

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
