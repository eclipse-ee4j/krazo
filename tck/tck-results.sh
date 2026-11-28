#!/usr/bin/env bash
#
# Copyright (c) 2026 Eclipse Krazo committers and contributors
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#
# SPDX-License-Identifier: Apache-2.0
#

# Generates tck/target/TCK-Results.md from the Surefire reports of a TCK run, in the format of
# https://eclipse-ee4j.github.io/krazo/certifications/jakarta-mvc/3.0/TCK-Results.html
#
# Usage: tck/tck-results.sh "<runtime name and version>"
#   e.g. tck/tck-results.sh "Eclipse GlassFish 8.0.5"
#
# The TCK zip is downloaded to compute its SHA-256 fingerprint. Set TCK_URL to override its
# default location: https://download.eclipse.org/jakartaee/mvc/<spec>/jakarta-mvc-tck-<tck>.zip

set -euo pipefail

RUNTIME="${1:?Usage: $0 \"<runtime name and version>\"}"

TCK_DIR="$(cd "$(dirname "$0")" && pwd)"
TARGET="$TCK_DIR/target"
REPORT="$TARGET/site/surefire-report.html"
RESULTS="$TARGET/TCK-Results.md"

cd "$TCK_DIR"

if ! ls "$TARGET"/surefire-reports/TEST-*.xml > /dev/null 2>&1; then
    echo "No Surefire reports found in $TARGET/surefire-reports. Run the TCK first." >&2
    exit 1
fi

# Version 2.18.1 of the plugin renders the HTML used by the published TCK results.
# The English locale makes it use '.' as the decimal separator for the test times.
export MAVEN_OPTS="${MAVEN_OPTS:-} -Duser.language=en -Duser.country=US"
mvn -B -q -DversionUpdateCheckSkip -Ddash.skip \
    org.apache.maven.plugins:maven-surefire-report-plugin:2.18.1:report-only -DshowSuccess=true

evaluate() {
    mvn -B -q -DversionUpdateCheckSkip -Ddash.skip \
        org.apache.maven.plugins:maven-help-plugin:3.5.1:evaluate -Dexpression="$1" -DforceStdout
}

KRAZO_VERSION="$(evaluate project.version)"
SPEC_VERSION="$(evaluate spec.version)"
TCK_VERSION="$(evaluate tck.version)"
SPEC="$(echo "$SPEC_VERSION" | cut -d. -f1,2)"

TCK_URL="${TCK_URL:-https://download.eclipse.org/jakartaee/mvc/${SPEC}/jakarta-mvc-tck-${TCK_VERSION}.zip}"
if curl -sfL -o "$TARGET/jakarta-mvc-tck.zip" "$TCK_URL"; then
    if command -v sha256sum > /dev/null; then
        TCK_SHA="$(sha256sum "$TARGET/jakarta-mvc-tck.zip" | cut -d' ' -f1)"
    else
        TCK_SHA="$(shasum -a 256 "$TARGET/jakarta-mvc-tck.zip" | cut -d' ' -f1)"
    fi
else
    echo "WARNING: Could not download $TCK_URL, so the TCK SHA-256 is not available" >&2
    TCK_SHA="not available"
fi

JAVA="${JAVA_HOME:+$JAVA_HOME/bin/}java"
JAVA_RUNTIME="$("$JAVA" -version 2>&1 | grep 'Runtime Environment' | head -1)"
JAVA_VM="$("$JAVA" -version 2>&1 | grep 'VM' | head -1)"
PUBLIC_URL="https://eclipse-ee4j.github.io/krazo/certifications/jakarta-mvc/${SPEC}/TCK-Results.html"

{
cat <<EOF
TCK Results
===========

As required by the
[Eclipse Foundation Technology Compatibility Kit License](https://www.eclipse.org/legal/tck.php),
following is a summary of the TCK results for releases of Jakarta MVC.

# Jakarta MVC ${SPEC} Certification Summary

- Organization Name ("Organization") and, if applicable, URL:
  - [Eclipse Foundation](https://eclipse.org)
- Product Name, Version and download URL (if applicable):
  - [Eclipse Krazo ${KRAZO_VERSION}](https://eclipse-ee4j.github.io/krazo/downloads/${KRAZO_VERSION}.html)
- Specification Name, Version and download URL:
  - [Jakarta MVC ${SPEC}](https://jakarta.ee/specifications/mvc/${SPEC})
- TCK Version, digital SHA-256 fingerprint and download URL:
  - [Jakarta MVC TCK ${TCK_VERSION}](${TCK_URL})
  - SHA-256: \`${TCK_SHA}\`
- Public URL of TCK Results Summary:
  - [${PUBLIC_URL}](${PUBLIC_URL})
- Any Additional Specification Certification Requirements:
  - None
- Java runtime used to run the implementation:
  - ${JAVA_RUNTIME}
- Summary of the information for the certification environment, operating system, cloud, ...:
  - $(uname -a)
  - ${JAVA_VM}
  - ${RUNTIME}

## Test results

EOF
# The report body: from the section with the "Surefire Report" heading up to the page footer
awk '
    !started && /<h2>Surefire Report<a name="Surefire_Report"><\/a><\/h2>/ { started = 1; print previous }
    started && /^    <div class="clear">/ { exit }
    started { print }
    { previous = $0 }
' "$REPORT"
} > "$RESULTS"

echo "TCK results written to $RESULTS"
