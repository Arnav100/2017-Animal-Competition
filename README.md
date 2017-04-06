*** Note: This is a work in progress. Programmers are never "done". ***

### ANIMAL/LAMINA AUTONOMOUS SELECTION SHEET
There are 26 different on-board autonomous routines when combined with Red/Blue
options and ReplayCode. The autonomous dial numbers with the (##r) distinction
indicate that the ReplayCode toggle switch is a valid option, otherwise it is
ignored. Although the code may or may not ignore some states of the toggle
switches, the drive-team MUST intentionally select a dial and then BOTH toggle
switches every time they are on the field. Finally, only the autonomous routines
are dipicted within the diagrams below, the ReplayCode paths are not shown.

### GENERAL ASSUMPTIONS:
* Animal/Lamina: Robot is in working order and placed in starting position.
* Auto Dial: Drive-team selects 00 to 10 before the robot is placed on the field.
* Red/Blue Toggle Switch: Drive-team ALWAYS selects their alliance color.
* ReplayCode Toggle Switch: Determines if ReplayCode will run after routine ends.
* Animal/Lamina's front is on the same side as the intake subsystem.

### 00-10 AUTONOMOUS DIAL SETTINGS AND DIAGRAMS:

```
KEY:
[^] = Animal/Lamina (with directional arrow indicating robot's front)
b = boiler on blue side
g = gear gadget command
h = fuel hopper on boiler side
i = intake command
r = boiler on red side
s = shoot command
u = unload command
```

```
/**
 * Auto Dial (00): Do nothing.
 * Red/Blue: Ignored.
 * ReplayCode: Ignored.
 *
 *              [?]
 *     _____________________
 */

 /**
 * Auto Dial (01): Drive forward across line.
 * Red/Blue: Ignored.
 * ReplayCode: Ignored.
 *
 *                     ^
 *                     |
 *                     |
 *                     |
 *                    [^]
 *     _____________________
 */

 /**
 * Auto Dial (02r): Place gear on left side.
 * Red/Blue: Red Ignored. Blue Accepted.
 * ReplayCode: Run ReplayCode if ON and Blue selected.
 *
 *           g
 *          /
 *         |
 *         |
 *        [v]
 *   b _____________________
 */

 /**
 * Auto Dial (03r): Place gear in the middle.
 * Red/Blue: Determines direction of ReplayCode.
 * ReplayCode: Run ReplayCode if ON.
 *
 *               g
 *               |
 *               |
 *              [v]
 *   b _____________________ r
 */

 /**
 * Auto Dial (04r): Place gear on right side.
 * Red/Blue: Red Accepted. Blue Ignored.
 * ReplayCode: Run ReplayCode if ON and Red selected.
 *
 *                   g
 *                    \
 *                     |
 *                     |
 *                    [v]
 *     _____________________ r
 */

/**
 * Auto Dial (05r): Intake fuel dropped from alliance parters then shoot.
 * Red/Blue: Determines direction of ReplayCode.
 * ReplayCode: Run ReplayCode if ON.
 *
 *             i
 *          [>]----------->s
 *     _____________________ r
 *
 *                 i
 *     s<-----------[<]
 *   b _____________________
 */

/**
 * Auto Dial (06r): Drive short and shoot.
 * Red/Blue: Determines direction of ReplayCode.
 * ReplayCode: Run ReplayCode if ON.
 *
 *     s<-[<]         [>]->s
 *   b _____________________ r
 */

 /**
 * Auto Dial (07): Go to hopper, intake, then shoot.
 * Red/Blue: Determines direction.
 * ReplayCode: Ignored.
 *
 *     h                   h
 *   i |\                 /| i
 *     |  \             /  |
 *     |    \         /    |
 *     s     [v]   [v]     s
 *   b _____________________ r
 */

 /**
 * Auto Dial (08): Go to hopper, intake, then shoot.
 * Red/Blue: Determines direction.
 * ReplayCode: Ignored.
 *
 *     h___             ___h
 *   i |   |           |   | i
 *     |   |           |   |
 *     s  [^]         [^]  s
 *   b _____________________ r
 */

 /**
 * Auto Dial (09r): Place gear in the middle while unloading fuel for others.
 * Red/Blue: Determines direction of ReplayCode.
 * ReplayCode: Run ReplayCode if ON.
 *
 *               g
 *               | u
 *               |
 *              [v]
 *   b _____________________ r
 */

/**
 * Auto Dial (10): Always runs ReplayCode.
 * Red/Blue: Determines direction of ReplayCode.
 * ReplayCode: Ignored.
 *
 *              [?]
 *   b _____________________ r
 */
```
