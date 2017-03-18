#!/bin/bash
# Sanitizes the filename by replacing - with _ in the current directory for .bin files

echo "Sanitizing filenames..."
echo "Renaming files in current folder by replacing - with _"
echo "Make sure you have a backup, just in case"
echo "Starting..."
echo ""

for i in *.bin; do
    if [ "$i" != "${i//-/_}" ]
    then
        mv "$i" "${i//-/_}"
        echo "Changed: $i -----> ${i//-/_}"
    else
        echo "$i is already sanitized!"
    fi
done

echo ""
echo "Completed Successfully"
echo "Check the filenames to make sure the converstion was correct."