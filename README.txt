This is a JAX-WS java project to simulate sensor data from doors and windows.

Problem description:
Two rooms:
    receptionist room
        doors:
            [
                entry door,
                VIP door
            ]
        windows:
            []
    VIP room
        doors:
            [
                VIP door
            ]
        windows:
            [
                window 1,
                window 2
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
        room and window number
    output:
        if room is valid and window is in room, return status.
Door server
    input:
        room and door name
    output:
        if room is valid and door is in room, return status.
