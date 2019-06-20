#!/bin/bash
# Written by Nishant Srivastava

#  Call as
#  ./migrate_to_androidx.sh

# Copy the migration python script to each subfolder first
for d in */; do cp androidx_migration.py "$d"; done

# Iterate over each sub-directory inside the current directory
for DIR in ./*;
do
	# Check if build directory exists inside the $DIR directory
	# If it does then it is an Gradle project
	if [ -d "$DIR/build/" ]; then
		echo ""
		echo ">>>> Migrating to AndroidX - " "$DIR"
		# Run command inside the sub-directory i.e Gradle project
		(cd $dir && ./gradlew clean && python androidx_migration.py && rm androidx_migration.py)
		echo ""
		echo ">>>> Done."
	fi
done