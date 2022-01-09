#!/usr/bin/env bash

# Copyright 2022 Nishant Srivastava
# 
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
# 
#    http://www.apache.org/licenses/LICENSE-2.0
# 
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
# ______________________________________________________________________
#  Call as
#  ./test_build_install.sh
# ______________________________________________________________________

# Iterate over each child directory inside the current directory
echo "-- Build & Install Test for:"
# Iterate over each sub-directory inside the current directory
for DIR in ./*;
do
	# Check if gradlew exists inside the $DIR directory
	# If it does then it is an Gradle project
	if [ -f "$DIR/gradlew" ]; then
		# Navigate into the sub directory
		cd "$DIR"
		echo "    ⏩ ============================================"
		echo "    ⏩ Build + Install..."
		# Run command inside the sub-directory i.e Gradle project
		./gradlew clean installDebug | egrep 'FAILED|WARNING' 

		# Print the name of the sub directory when done
		echo "$DIR" | awk -F'/' '{print $2}' | xargs -I{} echo "     -------✅  {} ✔️"

		# Go back to parent directory
		cd ../
		echo "    ⏱  Waiting..."
		sleep 1
	fi
done

# Delete all generated build folders, because they will eat up a lot of space on the disc
./delete_build_folder.sh

# Uninstall all installed apps from the connected device
# Break down of each command
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
