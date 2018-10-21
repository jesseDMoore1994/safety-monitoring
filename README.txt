This is a JAX-WS java project to simulate sensor data from doors and windows.

Problem description:
Two servers:
   doors:
       [
           entry door,
           VIP door
       ]
   windows:
       [
           window 0,
           window 1
       ]

door states:
    open
    closed and not locked
    closed and locked
window states:
    open
    half open
    closed and not locked
    closed and locked

Interfaces that are available to the client:
window server
    input:
        window number
    output:
        if window number exists, return status.
Door server
    input:
        door name
    output:
        if door name exists, return status.


To build (Linux):
    open a command prompt and navigate to this directory.
    run './gradlew build'

To build (Windows):
    open a command prompt and navigate to this directory.
    run 'gradlew.bat build'

To test (Linux):
    open a command prompt and navigate to this directory.
    run './gradlew test'

To test (Windows):
    open a command prompt and navigate to this directory.
    run 'gradlew.bat test'

To launch the server (Linux):
    open a command prompt and navigate to this directory.
    build the project. (If not already built.)
    'java -cp build/libs/safety-monitoring-1.0.0.jar safety_monitoring.ServerLauncher'

To launch the server (Windows):
    open a command prompt and navigate to this directory.
    build the project. (If not already built.)
    'java -cp build/libs/safety-monitoring-1.0.0.jar safety_monitoring.ServerLauncher'

To use the client (Linux):
    open a command prompt and navigate to this directory.
    build the project. (If not already built.)
    'java -cp build/libs/safety-monitoring-1.0.0.jar safety_monitoring.SafetyMonitoringClient [ "Window" | "Door" ] [ "VIP Door" | "Receptionist Door" | 0 | 1 ]'

To use the client (Windows):
    open a command prompt and navigate to this directory.
    build the project. (If not already built.)
    'java -cp build/libs/safety-monitoring-1.0.0.jar safety_monitoring.SafetyMonitoringClient [ "Window" | "Door" ] [ "VIP Door" | "Receptionist Door" | 0 | 1 ]'
