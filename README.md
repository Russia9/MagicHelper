# MagicHelper [![Build Status](https://travis-ci.com/Russia9/MagicHelper.svg?branch=master)](https://travis-ci.com/Russia9/MagicHelper) [![Codacy Badge](https://api.codacy.com/project/badge/Grade/d7d05b76675242248ce2d6009be97010)](https://app.codacy.com/app/Russia9/MagicHelper?utm_source=github.com&utm_medium=referral&utm_content=Russia9/MagicHelper&utm_campaign=Badge_Grade_Dashboard) [![License: GPL v3](https://img.shields.io/badge/License-GPLv3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)
An optional assistant to Minecraft Magic servers or single
### Disclaimers
Many servers will regard this as a cheat. The authors are not
responsible for any use and do not recommend using it in multiplayer.

## Requirements
 - `Java 1.8`

## Installation
Download jar from releases page, run and enjoy:) <br>
**It's better to start jar from from console**:
```Shell
$ java -jar MagicHelper.jar
```
If you want to get debug output, run with command
```Shell
$ java -jar MagicHelper.jar Debug=true
```
If you want to get debug and trace output, run with command
```Shell
$ java -jar MagicHelper.jar Trace=true
```

## Controls
1. **Autoclicker** `DONE`
   - Mouse button 1 `DONE`
     - On/Off - Middle mouse button
   - Custom button `DONE`
     - On - Middle mouse button + Needed button
     - Off -  Middle mouse button
2. **Button Clamping** `DONE`
   - Custom button `DONE`
      - On - F7 + Needed button
3. **Auto mining** `TODO`
   - Horizontal mining `TODO`
     - On - RAlt + W
     - Off - Middle mouse button
   - Vertical mining
     - On - RAlt + D
     - Off - Middle mouse button
   - Smart mining
     - On - RAlt + S
     - Off - Middle mouse button

## Used libraries
 - [`JNativeHook`](https://github.com/kwhat/jnativehook) - Listening key combinations
 - [`log4j2`](https://github.com/apache/logging-log4j2) - Logging
 - [`Apache Commons`](https://github.com/apache/commons-lang) - Detecting OS
 
