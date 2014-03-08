#!/bin/bash
PACKAGE=org.dom
DEBUG_APK=./bin/questionnaire-debug.apk
MAIN_ACTIVITY=MainActivity
LOG_DIR="./log/"
BUILD_LOG=${LOG_DIR}/build_debug_latest.log
LOGCAT_LOG=${LOG_DIR}/$(date "+%Y%m%d")-logcat.log
BUILD_SUCCESS="BUILD SUCCESSFUL"
rm -f $(find . -type f -name \.DS_Store)
rm -f $(find ./gen/ -type f)
rm -fr ./bin/
mkdir -p ${LOG_DIR}
echo -ne "Building application ... "
ant debug | nkf -w > ${BUILD_LOG}
STATUS=$(tail ${BUILD_LOG} | grep "${BUILD_SUCCESS}")
if [ "x${STATUS}" != "x${BUILD_SUCCESS}" ]; then
  echo "[FAILED]"
  echo "Try \`cat ${BUILD_LOG}' for more info."
  exit 1
fi
echo "[OK]"
echo -ne "Installing application ... "
adb uninstall ${PACKAGE} > /dev/null
adb install ${DEBUG_APK} > /dev/null 2>&1
echo "[OK]"
echo -ne "Starting application ... "
adb shell am start -a android.intent.action.MAIN -n ${PACKAGE}/.${MAIN_ACTIVITY} > /dev/null
echo "[OK]"
echo "Start logging"
echo "Type \`tail -f ${LOGCAT_LOG}' for surveillance of log."
adb logcat -v time E >> ${LOGCAT_LOG}

