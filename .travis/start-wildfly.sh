#!/usr/bin/env bash

curl -L -s -o wildfly.zip https://download.jboss.org/wildfly/22.0.0.Alpha1/wildfly-preview-22.0.0.Alpha1.zip
unzip -q wildfly.zip
mv wildfly-preview-22.0.0.Alpha1 wildfly
LAUNCH_JBOSS_IN_BACKGROUND=1 JBOSS_PIDFILE=wildfly.pid ./wildfly/bin/standalone.sh > wildfly.log 2>&1 &
timeout 30 tail -F wildfly.log || true
