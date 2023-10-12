# Android Examples

![Image](img/github_banner.png)

## Featured in

[![AndroidDev Digest](https://img.shields.io/badge/AndroidDev%20Digest-%23100-blue.svg)](https://www.androiddevdigest.com/digest-100/)

### Show some :heart: and star the repo to support the project

[![GitHub stars](https://img.shields.io/github/stars/nisrulz/android-examples.svg?style=social&label=Star)](https://github.com/nisrulz/android-examples) [![GitHub forks](https://img.shields.io/github/forks/nisrulz/android-examples.svg?style=social&label=Fork)](https://github.com/nisrulz/android-examples/fork) [![GitHub watchers](https://img.shields.io/github/watchers/nisrulz/android-examples.svg?style=social&label=Watch)](https://github.com/nisrulz/android-examples) [![GitHub followers](https://img.shields.io/github/followers/nisrulz.svg?style=social&label=Follow)](https://github.com/nisrulz/android-examples)  
[![Twitter Follow](https://img.shields.io/twitter/follow/nisrulz.svg?style=social)](https://twitter.com/nisrulz)

Main repository containing all the example apps demonstrating features/functionality/integrations in android application development

> NOTE: If you are going to download just a single example app (using the download link), make sure you follow the below procedure
>
> 1. Create a folder `android-examples`
> 1. Next download and add the [`dependencies.gradle`](/dependencies.gradle) to this `android-examples` folder
> 1. Now move the example app folder inside the `android-examples` folder
>
> The reason this is required because each single app uses `ext` variables defined and referenced from `dependencies.gradle` file from the parent folder namely `android-examples`.

## Example apps

1. [Custom Drawer](/custom_home_drawer)
1. [DropDown Button](/dropdown_button)
1. [Enable Splash Screen](/enabling_splash_screen)
1. [Firebase Analytics Integration](/analytics_integration)
1. [Firebase Crashlytics Integration](/firebase_crash_reporting)
1. [Google Signin](/google_signin)
1. [Grid Layout](/grid_layout)
1. [Image Editor](/image_editor)
1. [Image from Network](/image_from_network)
1. [Infinite List](/infinite_list)
1. [Load local image](/load_local_image)
1. [Load local json](/load_local_json)
1. [Navigation Drawer](/navigation_drawer)
1. [Persist Key Value](/persist_key_value)
1. [Push Notifications](/push_notifications)
1. [Simple Material App](/simple_material_app)
1. [Sliver App Bar](/sliver_app_bar_example)
1. [Stateful Widget](/stateful_widget)
1. [Stateless counter app](/statless_counter_app)
1. [Stateless Widgets](/stateless_widgets)
1. [Todo list using Provider](/todo_list_using_provider)
1. [Unit Testing](/unit_testing)
1. [Using Alert Dialog](/using_alert_dialog)
1. [Using Bottom Navigation Bar](/using_bottom_nav_bar)
1. [Using Bottom Sheet](/bottom_sheet)
1. [Using Custom Fonts](/using_custom_fonts)
1. [Using EditText](/using_edittext)
1. [Using Gradient](/using_gradient)
1. [Using HTTP GET](/using_http_get)
1. [Using InteractiveViewer](/using_interactiveviewer)
1. [Using Listview](/using_listview)
1. [Using ListwheelScrollView](/using_listwheelscrollview)
1. [Using SnackBar](/using_snackbar)
1. [Using Stepper](/using_stepper)
1. [Using Tabs](/using_tabs)
1. [Using Theme](/using_theme)
1. [View PDF File](/view_pdf_file)

## Example apps from my android libraries

1. [UsingAndroidUtils](https://github.com/nisrulz/android-utils/tree/master/sample)
1. [UsingEasyDeviceInfo](https://github.com/nisrulz/easydeviceinfo/tree/master/app)
1. [UsingOptimusHTTP](https://github.com/nisrulz/OptimusHTTP/tree/master/sample)
1. [UsingPackageHunter](https://github.com/nisrulz/packagehunter/tree/master/app)
1. [UsingQREader](https://github.com/nisrulz/qreader/tree/master/app)
1. [UsingRecyclerViewHelper](https://github.com/nisrulz/recyclerviewhelper/tree/master/app)
1. [UsingScreenshott](https://github.com/nisrulz/screenshott/tree/master/sample)
1. [UsingSensey](https://github.com/nisrulz/sensey/tree/master/sample)
1. [UsingShoutout](https://github.com/nisrulz/ShoutOut/tree/master/sample)
1. [UsingStackedHorizontalProgressbar](https://github.com/nisrulz/stackedhorizontalprogressbar/tree/master/sample)
1. [UsingZentone](https://github.com/nisrulz/zentone/tree/master/app)

## Pull Requests

I welcome and encourage all pull requests. It usually will take me within 24-48 hours to respond to any issue or request. Here are some basic rules to follow to ensure timely addition of your request:

  1. Match coding style (braces, spacing, etc.) This is best achieved using `Reformat Code` feature of Android Studio `CMD`+`Option`+`L` on Mac and `CTRL` + `ALT` + `L` on Linux + Windows .
  2. If its a feature, bugfix, or anything please only change code to what you specify.
  3. Please keep PR titles easy to read and descriptive of changes, this will make them easier to merge :)
  4. Pull requests _must_ be made against `develop` branch. Any other branch (unless specified by the maintainers) will get rejected.
  5. Check for existing [issues](https://github.com/nisrulz/android-examples/issues) first, before filing an issue.
  6. Make sure you follow the set standard as all other projects in this repo do

      + Upgrade your gradle wrapper to the one all other apps are using. Use the below command at root of your project

          ```sh
          ./gradlew wrapper --gradle-version <version_name>
          ```

          i.e `./gradlew wrapper --gradle-version 6.0.1`

      + Use `ext` variables as defined in [`dependencies.gradle`](/dependencies.gradle), in your `build.gradle` files to make sure all apps are in sync with configurations and dependencies. Take a look [here](/DataBinding/app/build.gradle) and [here](/DataBinding/build.gradle)

      + Use the package name of the format `github.nisrulz.*` where `*` is the example you are adding to the repo. I am trying to follow a set standard in the repo, please adhere to that.
  7. Have fun!

  > NOTE: There is a quick bootstrapping **cookiecutter** template to create an Android example project that adheres to all wiring up and standards for this repo. Read how to use use it from links below:
  >
  > + [Standard Example](/cookiecutter-android-example)
  > + [Compose Example](/cookiecutter-android-compose-example)

## Extra

Since the repo is pretty large now , I am sure many folks would like to download only some of the projects. To tackle that follow the steps below:

+ Install `svn` using homebrew (mac/linux)

    ```bash
    brew install svn
    ```

+ Copy the name of the example folder in this repo i.e `AccessingGoogleDrive`
+ Next replace `example_folder` in the below command:

    ```bash
    svn checkout https://github.com/nisrulz/android-examples/trunk/example_folder
    ```

    i.e Consider `AccessingGoogleDrive` is the name of the example's folder, the command becomes:

    ```bash
    svn checkout https://github.com/nisrulz/android-examples/trunk/AccessingGoogleDrive
    ```

+ Done! You should have the specific example all checked out!

## Author & support

This project was created by [Nishant Srivastava](https://github.com/nisrulz/nisrulz.github.io#nishant-srivastava) but hopefully developed and maintained by many others. See the [the list of contributors here](https://github.com/nisrulz/android-examples/graphs/contributors).

If you appreciate my work, consider [buying me](https://www.paypal.me/nisrulz/5usd) a cup of :coffee: to keep me recharged :metal: [[PayPal](https://www.paypal.me/nisrulz/5usd)]

## License

[Apache Version 2.0 | Copyright 2016 Nishant Srivastava](LICENSE)
