#!/usr/bin/env bash

echo "Uninstall all installed apps from the connected device"
# Break down of the long command
# adb shell 'pm list packages -u'  = Get all packages
# grep github.nisrulz              = Filter out the packages that contain github.nisrulz
# cut -c 9-						   = Remove the first 9 chars, which correspond to package:
# rev 							   = Reverse the string
# cut -c 2-						   = Remove the first 2 chars, which correspond to ^M
# rev 							   = Reverse the string
for pkg in $(adb shell 'pm list packages -u' | grep github.nisrulz | cut -c 9- | rev | cut -c 2- | rev); do
	echo "-- Removing $pkg"
	adb uninstall $pkg
done
