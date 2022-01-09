#!/usr/bin/env bash

# Copyright 2018 Nishant Srivastava
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
#  Dependency: trash cli tool
# 	>> Install: brew install trash
# 
#  Call as
#  ./delete_build_folder.sh
# ______________________________________________________________________

# Delete all generated build folders, because they will eat up a lot of space on the disc
echo "  🗑  Deleting build directories..."

# Find all directories with name "build" inside the current directory, recursively
for FOUND_BUILD_DIR in $(find . -type d -name "build" | grep -v "cookiecutter");
do
	# Run the trash command on found build directory
	trash $FOUND_BUILD_DIR
done

echo "  ✔️  Done."
