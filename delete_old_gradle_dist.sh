#!/bin/bash
# Written by Nishant Srivastava

#  Call as
#  ./delete_old_gradle_dist.sh

echo "Keep which version of gradle distribution?"
read version

echo "# Deleting all other gradle dist except $version"
echo ""
find */.gradle/* -type d -not -path "*/$version/*" -not -name "$version" -not -name "buildOutputCleanup" | xargs rm -rf
echo ""
echo ">>>> Done."