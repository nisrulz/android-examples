#!/bin/bash
# Written by Nishant Srivastava

#  Call as
# ./update_gradle_wrapper.sh

echo "Update gradle wrapper to which version?"
read version

# Iterate over each child directory inside the current directory
echo "# Updating to Gradle Wrapper Version: $version"
echo ""
for dir in */;
do
	echo ""
	echo ">>>> Updating directory : " $dir
	(cd "$dir" && ./gradlew clean && ./gradlew wrapper --gradle-version $version --distribution-type all && ./gradlew);
	echo ""
	echo ">>>> Done."
done

# Delete all generated build folders, because they will eat up a lot of space on the disc
echo "# Deleting all build folders"
echo ""
./delete_build_folder.sh 
