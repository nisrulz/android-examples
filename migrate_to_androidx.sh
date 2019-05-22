#!/bin/bash
# Written by Nishant Srivastava

#  Call as
#  ./migrate_to_androidx.sh

# Copy the migration python script to each subfolder first
for d in */; do cp androidx_migration.py "$d"; done

# Iterate over each child directory inside the current directory
echo ""
for dir in */;
do
	echo ""
	echo ">>>> Migrating to AndroidX - " $dir
	(cd $dir && ./gradlew clean && python androidx_migration.py && rm androidx_migration.py)
	echo ""
	echo ">>>> Migration done for - " $dir
done