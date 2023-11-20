# Introduce
This is a command line program, you can use it draw line and rectangle shapes.

# Run environment
My machine is using JDK20, but I only use JDK 8 feature. So, JDK8 is ok.

# How to run it in your IDE?
main method in Main.java is the entrance point. You can run from this

# Commands you can use:
1. C 20 4
> Create a canvas with width 20 and height 4.
2. L 1 2 6 2
> Draw a line from point(1,2) to point(6,2).
> Only support vertical/horizontal line , so make sure x1==x2, or y1==y2.
3. R 16 1 20 3
> Create a rectangle from left-top point(16,1) to right-bottom point(20,3).
4. Q
> Quit this program.

# Note
> This program is base on command line. So,there is no third-part jar(You can run anywhere merely have JDK8 or JRE8).
> The test code is only simulate unit testing by print out result.
