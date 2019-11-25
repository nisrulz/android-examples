# Android Examples Bootstrapping Template

A [cookiecutter](https://github.com/cookiecutter/cookiecutter) :cookie: template for bootstrapping new Android Example projects for this repo!

## Usage

Install cookiecutter (via homebrew on mac/linux):

```bash
brew install cookiecutter
```

Navigate to `android-examples` directory:

```bash
cd android-examples
```

Run cookiecutter tool by passing in the template directory as argument:

```bash
cookiecutter cookiecutter-android-example/
```

You'll be prompted for various configuration options - see [`cookiecutter.json`](/cookiecutter.json) for the full list. 

To accept the configuration option you see in brackets, simply hit Enter

> Note: Make sure you have the `dependencies.gradle` file at the root of **android-examples** directory, since the template creates an android project that references that file for dependency versioning.